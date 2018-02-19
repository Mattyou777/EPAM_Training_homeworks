package com.epam.training.consoleApp;

import java.io.File;

/**
 * Created by Matt on 19.02.2018.
 */
public class Rename {

    static void start(String source, String dest) {
        File s = new File(source);
        if (!s.exists()){
            System.out.println("Исходный файл не найден!");
            return;
        }
        s.renameTo(new File(s.getParent(),dest));
    }
    }
