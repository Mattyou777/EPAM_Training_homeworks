package com.epam.training.consoleApp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Matt on 24.02.2018.
 */
public class Show {


    static void start(String source, String key){
        Path path = Paths.get(source);
        List<File> list = new LinkedList<File>();
        if (path.toFile().isDirectory()) {
            for (File f : path.toFile().listFiles()) {
                list.add(f);
            }
        }
        else {
            print(path.toFile());
            return;
        }
        if (key.equals("") || key.equals("name")){
            Collections.sort(list);
        }
        else if (key.equals("nameR")){
            Collections.sort(list, Collections.reverseOrder());
        }
        else if (key.equals("time")){
            TimeComparator cp = new TimeComparator();
            Collections.sort(list, cp);
        }
        else if (key.equals("timeR")){
            ReverseTimeComparator cp = new ReverseTimeComparator();
            Collections.sort(list, cp);
        }
        else if (key.equals("size")){
            SizeComparator cp = new SizeComparator();
            Collections.sort(list, cp);
        }
        else if (key.equals("sizeR")){
            ReverseSizeComparator cp = new ReverseSizeComparator();
            Collections.sort(list, cp);
        }
        for (File f : list){
            print(f);
        }

    }

    static void print(File file){

        String dir = "";
        if (file.isDirectory())
            dir="Directory";
        try {
            System.out.println(file.getName() + " " + dir + " " + Files.getAttribute(file.toPath(), "creationTime") + " " + Files.getAttribute(file.toPath(), "size"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
