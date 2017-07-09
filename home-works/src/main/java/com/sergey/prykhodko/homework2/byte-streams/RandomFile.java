/**
 * Created by Sergey on 04.07.2017.
 */
import java.io.*;

/**
 * Created by Sergey on 02.07.2017.
 */
public class RandomFile {

    public static void main(String[] args) throws IOException {
        String stream = "bufOS";
        int bytesNumber = 124;

        File file = new File("D:/temp.txt");


        byte[] randomBytes = new byte[bytesNumber];

        for (int i = 0; i < randomBytes.length; i++) {
            randomBytes[i] = (byte) (Math.random() * Byte.MAX_VALUE);
        }
        OutputStream outputStream = null;

        switch (stream) {
            case "bufOS":

                outputStream = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    outputStream.write(randomBytes);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("Written to BufferedOutputStream");
                break;

            case "barOS":

                outputStream = new ByteArrayOutputStream();
                outputStream.write(randomBytes);
                System.out.println("Written to ByteArrayOutputStream");
                break;

            case "FOS":

                outputStream = new FileOutputStream(file);
                outputStream.write(randomBytes);
                System.out.println("Written to FileOutputStream");
                break;

            default:
                System.out.println("No such output stream");
                break;


        }
    }
}

