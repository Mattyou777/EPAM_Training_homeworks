package com.epam.training.consoleApp;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Matt on 19.02.2018.
 */
class Zipper {

    static void start(String source){

        File file = new File(source);

        ZipOutputStream out = null;
        try {
            out = new ZipOutputStream(new FileOutputStream(file.getPath() + ".zip"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            doZip(file, out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void start(String source, String dest){

        File file = new File(source);

        ZipOutputStream out = null;
        try {
            out = new ZipOutputStream(new FileOutputStream(dest + ".zip"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            doZip(file, out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void doZip(File dir, ZipOutputStream out) throws IOException {
        if (dir.isFile()){
            out.putNextEntry(new ZipEntry(dir.getName()));
            write(new FileInputStream(dir), out);
        }
        else {
            for (File f : dir.listFiles()) {
                if (f.isDirectory())
                    doZip(f, out);
                else {
                    out.putNextEntry(new ZipEntry(f.getName()));
                    write(new FileInputStream(f), out);
                }
            }
        }
    }

    private static void write(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[in.available()];
        int len;
        while ((len = in.read(buffer)) >= 0)
            out.write(buffer, 0, len);
        in.close();
    }

}
