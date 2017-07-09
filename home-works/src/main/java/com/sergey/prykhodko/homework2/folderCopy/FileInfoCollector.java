package folderCopy;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;

import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * Created by Sergey on 03.07.2017.
 */
public class FileInfoCollector extends SimpleFileVisitor<Path> {
    private boolean filter;
    private String [] extentionsToFilter;
    private Path targetDirectory;
    private Path beforeStart;

    public FileInfoCollector(Path startDirectory, Path targetDirectory){
        filter = false;
        this.targetDirectory = targetDirectory;
        beforeStart = Paths.get(startDirectory.toString().substring(0, startDirectory.toString().lastIndexOf(92)));

    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attr) throws IOException {

        Path aditionalPath = Paths.get(new File(beforeStart.toString()).toURI().relativize(new File(dir.toString()).toURI()).getPath());
        try {
            Files.copy(dir, Paths.get(targetDirectory.toString() + "/" + aditionalPath.toString()));
            //System.out.println("Directory: " + targetDirectory.toString() + "\\" + aditionalPath.toString() + " created");

        }
        catch (FileAlreadyExistsException e){
            if (!Files.isDirectory(targetDirectory)) {
                throw e;
            }

        }
        return CONTINUE;
    }
    @Override
    public FileVisitResult visitFile(Path file,
                                     BasicFileAttributes attr) throws IOException {

        String fileName = new File(file.toString()).getName();
        String extention = fileName.substring(fileName.indexOf("."));
        Path aditionalPath = Paths.get(new File(beforeStart.toString()).toURI().relativize(new File(file.toString()).toURI()).getPath());
        if (filter){

            for (String s : extentionsToFilter){
                if (extention.equals(s)){
                    return CONTINUE;
                }
            }
        }

        if (extention.equals(".java")) {
            copyJava(file, Paths.get(targetDirectory.toString() + "/" + aditionalPath.toString()));
            return CONTINUE;
        }
        else {

            Files.copy(file, Paths.get(targetDirectory.toString() + "/" + aditionalPath.toString()));
        }
//        System.out.println("(" + attr.size() + "bytes)");
        return CONTINUE;
    }

    private void copyJava(Path file, Path path) throws IOException {
        InputStream in = new BufferedInputStream(new FileInputStream(file.toFile()));
        File newOne = new File(path.toString());
        OutputStream out = new FileOutputStream(newOne);
        int i;
        int b;
        while ((i = in.read()) != -1) {
            switch (i){
                case 47:
                    if ((b = in.read()) == 47) {
                        while (in.read() != 10){}
                        break;
                    }
                    else if (b == 42) {
                        while (in.read() != 47) {}
                        break;
                    }


                default:
                    out.write(i);
                    break;
            }

        }
        in.close();
        out.close();

    }

    public void filter(String... a){
        filter = true;
        extentionsToFilter = new String[a.length];
        for (int i = 0; i < a.length; i++){
            extentionsToFilter[i] = a[i];
        }
    }


    public static void main(String[] args) {
        Path startDir = Paths.get(args[0]);
        FileInfoCollector visitor = new FileInfoCollector(startDir, Paths.get(args[1]));
        visitor.filter(Arrays.copyOfRange(args, 1, args.length));
        try {
            Files.walkFileTree(startDir, visitor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
