package com.sergey.prykhodko.homework2.folderCopy;

import java.io.*;

/**
 * Created by Sergey on 03.07.2017.
 */
public class Copier {
    public static void copy (File sourse, File target) throws IOException {
        if (sourse.isDirectory()) {
            copyDirectory(sourse, target);
        }
        else {
            copyFile(sourse, target);
        }
    }

    private static void copyDirectory(File sourse, File target) throws IOException {
        if (!target.exists()) {
            target.mkdir();
        }

        System.out.println(sourse.list());
        for (String file : sourse.list()) {
            copy(new File(sourse, file), new File(target, "Copy" + file));
        }
    }

    private static void copyFile(File sourse, File target) throws IOException {
        try (
                InputStream in = new FileInputStream(sourse);
        OutputStream out = new FileOutputStream(target)
        ){
            byte[] buf = new byte[8194];
            int length;
            while ((length = in.read(buf)) > 0) {
                out.write(buf, 0, length);
            }
        }
    }
}
