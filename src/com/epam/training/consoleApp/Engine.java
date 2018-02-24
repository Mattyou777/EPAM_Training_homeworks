package com.epam.training.consoleApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Matt on 18.02.2018.
 */
class Engine {

    static void startCons()
    {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String s="";
        while (true){
            try {
                s = rd.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scanner sc = new Scanner(s);
            if (sc.hasNext("exit"))
                System.exit(0);
            if (sc.hasNext("help")){
                System.out.println("На данный момент доступны команды:");
                System.out.println("exit - выход");
                System.out.println("copy (полное имя файла) (директория назначения) - копирование файла");
                System.out.println("show (полное имя директории) (ключ) - список файлов в директории");
                System.out.println("rename (полное имя файла) (новое имя файла) - переименование");
                System.out.println("delete (полное имя файла) - удаление");
                System.out.println("zip (полное имя файла/директории) (директория назначения\\название архива[опционально]) - архивирование файла");
                System.out.println("unzip (полное имя файла) (директория назначения[опционально]) - разархивирование файла");

            }
            else if(sc.hasNext("copy")){
                sc.next();
                String source = "";
                String dest = "";
                if (sc.hasNext()){
                    source = sc.next();
                }
                else {
                    System.out.println("Нет аргументов!");
                    continue;
                }
                if (sc.hasNext()){
                    dest = sc.next();
                }
                else {
                    System.out.println("Нет аргумента!");
                    continue;
                }
                Copy.start(source, dest);
            }
            else if(sc.hasNext("rename")){
                sc.next();
                String source = "";
                String dest = "";
                if (sc.hasNext()){
                    source = sc.next();
                }
                else {
                    System.out.println("Нет аргументов!");
                    continue;
                }
                if (sc.hasNext()){
                    dest = sc.next();
                }
                else {
                    System.out.println("Нет аргумента!");
                    continue;
                }
                Rename.start(source, dest);
            }
            else if(sc.hasNext("delete")){
                sc.next();
                String source = "";
                if (sc.hasNext()){
                    source = sc.next();
                }
                else {
                    System.out.println("Нет аргумента!");
                    continue;
                }
                Delete.start(source);
            }
            else if(sc.hasNext("show")){
                sc.next();
                String source = "";
                String key = "";
                if (sc.hasNext()){
                    source = sc.next();
                }
                else {
                    System.out.println("Нет аргументов!");
                    continue;
                }
                if (sc.hasNext()){
                    key = sc.next();
                }
                Show.start(source, key);
            }
            else if(sc.hasNext("zip")){
                sc.next();
                String source = "";
                String dest = "";
                if (sc.hasNext()){
                    source = sc.next();
                }
                else {
                    System.out.println("Нет аргументов!");
                    continue;
                }
                if (sc.hasNext()){
                    dest = sc.next();
                    Zipper.start(source, dest);
                }
                else {
                    Zipper.start(source);
                }
            }
            else if(sc.hasNext("unzip")){
                sc.next();
                String source = "";
                String dest = "";
                if (sc.hasNext()){
                    source = sc.next();
                }
                else {
                    System.out.println("Нет аргументов!");
                    continue;
                }
                if (sc.hasNext()){
                    dest = sc.next();
                    Unzipper.start(source, dest);
                }
                else {
                    Unzipper.start(source);
                }
            }
        }

    }
}
