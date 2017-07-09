package sequenceShow;

import java.io.*;
import java.util.*;

/**
 * Created by Sergey on 05.07.2017.
 */
public class SequenceShow {


    public static void main(String[] args) {
        String mode = args[0];


        InputStream in = null;
        try {
            Vector<InputStream> streams = getStreams(Arrays.copyOfRange(args, 1, args.length));
            Enumeration<InputStream> streamsEnum= streams.elements();
            in =
                    new SequenceInputStream(streamsEnum);


        if (mode.equals("byte")){
            outputByte(in);
        }
        else if (mode.equals("char")){
            outputChar(in);
        }
        else{
            System.out.println("Illegal input");
        }
            in.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void outputByte(InputStream in) throws IOException {
        PrintStream outByte = new PrintStream(System.out);

        int i = 0;
            while ((i = in.read()) != -1) {

                outByte.print(String.format("0x%02X ", (byte)i));
            }

        outByte.close();
    }

    private static void outputChar(InputStream in) throws IOException {
        PrintStream outChar = new PrintStream(System.out);

        int i = 0;
            while ((i = in.read()) != -1) {
                outChar.print((char)i);
            }
        outChar.close();
    }

    private static Vector<InputStream> getStreams(String[] paths) throws FileNotFoundException {
        Vector<InputStream> streams = new Vector<>();
        for (String s : paths) {
            streams.add(new FileInputStream(s));
        }
        return streams;
    }
}
