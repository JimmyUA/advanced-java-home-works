package ceasar;

import java.io.*;

/**
 * Created by Sergey on 06.07.2017.
 */
public class CeasarCipherFile {

    public static void main(String[] args) {
        String command = args[0];
        String filePath = args[1];
        int key = Integer.parseInt(args[3]);
        String outPutFile = args[2];

        try {
            InputStream in = new BufferedInputStream(new FileInputStream(filePath));
            OutputStream out = new BufferedOutputStream(new FileOutputStream(outPutFile));
            if (command.equals("encode")){
                encode(in, out, key);
            }
            else if (command.equals("decode")) {
                decode(in, out, key);
            }
            else {
                System.out.println("Illegal input");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void encode(InputStream in, OutputStream out, int key) throws IOException {
        byte[] buf = new byte[8194];
        int len = 0;
        while ((len = in.read(buf)) > 0) {
            for (int i = 0; i < buf.length; i++) {
                buf[i] += key;
            }
            out.write(buf);
        }
    }

    private static void decode(InputStream in, OutputStream out, int key) throws IOException {
        byte[] buf = new byte[8194];
        int len = 0;
        while ((len = in.read(buf)) > 0) {
            for (int i = 0; i < buf.length; i++) {
                buf[i] -= key;
            }
            out.write(buf);
        }
    }
}
