package com.epam.training.consoleApp;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by Matt on 19.02.2018.
 */
public class Unzipper {

    static void start(String source) {

        File file = new File(source);
        if (!file.exists() || !file.canRead()) {
            System.out.println("File cannot be read");
            return;
        }

        try {
            ZipFile zip = new ZipFile(source);
            Enumeration entries = zip.entries();

            while (entries.hasMoreElements()) {
                ZipEntry entry = (ZipEntry) entries.nextElement();

                if (entry.isDirectory()) {
                    new File(file.getParent(), entry.getName()).mkdirs();
                } else {
                    write(zip.getInputStream(entry),
                            new BufferedOutputStream(new FileOutputStream(
                                    new File(file.getParent(), entry.getName()))));
                }
            }

            zip.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void start(String source, String dest) {

        File file = new File(source);
        if (!file.exists() || !file.canRead()) {
            System.out.println("File cannot be read");
            return;
        }

        try {
            ZipFile zip = new ZipFile(source);
            Enumeration entries = zip.entries();

            while (entries.hasMoreElements()) {
                ZipEntry entry = (ZipEntry) entries.nextElement();

                if (entry.isDirectory()) {
                    new File(dest, entry.getName()).mkdirs();
                } else {
                    write(zip.getInputStream(entry),
                            new BufferedOutputStream(new FileOutputStream(
                                    new File(dest, entry.getName()))));
                }
            }

            zip.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void write(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) >= 0)
            out.write(buffer, 0, len);
        out.close();
        in.close();
    }

}
