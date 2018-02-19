package com.epam.training.consoleApp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

/**
 * Created by Matt on 19.02.2018.
 */
class Copy {

    static void start(String source, String dest){
        File s = new File(source);
        if (!s.exists()){
            System.out.println("Исходный файл не найден!");
            return;
        }
        File d = new File(dest,s.getName());
        if (d.exists()){
            System.out.println("Такой файл в указанной директории уже существует. Перезаписать? 1)Да 2)Нет");
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt(1))
                try {
                    Files.copy(s.toPath(),d.toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        else {
            try {
                Files.copy(s.toPath(),d.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
