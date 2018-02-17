package com.epam.training.cacheSave;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Created by Matt on 17.02.2018.
 */
public class Engine {
    private static String getSourcePath(){
        StringBuilder cachePath = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        String os = "";
        if(System.getProperty("os.name").toLowerCase().indexOf("win")>=0){
            cachePath.append("C:\\Users\\");
            os="win";
        }
        else if(System.getProperty("os.name").toLowerCase().indexOf("nix")>=0 || System.getProperty("os.name").toLowerCase().indexOf("nux")>=0){
            cachePath.append("/home/");
            os="lin";

        }
        else if(System.getProperty("os.name").toLowerCase().indexOf("mac")>=0){
            cachePath.append("Users/");
            os="mac";

        }
        else {
            System.out.println("Укажите папку с кэшем");
            cachePath.append(sc.next());
        }
        if(os.length()>0) {
            cachePath.append(System.getProperty("user.name"));
            System.out.println("Выбирите браузер: 1)Google chrome(only old versions) 2)Firefox 3)Другой");
            switch (sc.nextInt()) {
                case 1: if(os.equals("win"))
                    cachePath.append("\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Cache");
                else if(os.equals("lin"))
                    cachePath.append("/.config/google-chrome/default/cache");
                else
                    cachePath.append("/Library/Application Support/Google/Chrome/Default/Cache");
                    break;
                case 2:
                    if(os.equals("win")) {
                        File path = new File(cachePath.append("\\AppData\\Local\\Mozilla\\Firefox\\Profiles\\").toString());
                        File[] paths = path.listFiles();
                        Pattern p = Pattern.compile(".+\\.default");
                        for (File file : paths) {
                            Matcher m = p.matcher(file.getName());
                            if (m.matches()) {
                                cachePath.append(file.getName() + "\\cache2\\entries");
                                break;
                            }
                        }
                        break;
                    }
                    else if(os.equals("lin")){
                        File path = new File(cachePath.append("/.cache/mozilla/firefox/").toString());
                        File[] paths = path.listFiles();
                        Pattern p = Pattern.compile(".+\\.default");
                        for (File file : paths) {
                            Matcher m = p.matcher(file.getName());
                            if (m.matches()) {
                                cachePath.append(file.getName() + "/cache2/entries");
                                break;
                            }
                        }
                    }
                    else{
                        File path = new File(cachePath.append("/Library/Application Support/Firefox/Profiles/").toString());
                        File[] paths = path.listFiles();
                        Pattern p = Pattern.compile(".+\\.default");
                        for (File file : paths) {
                            Matcher m = p.matcher(file.getName());
                            if (m.matches()) {
                                cachePath.append(file.getName() + "/cache2/entries");
                                break;
                            }
                        }
                    }
                default:
                    System.out.println("Укажите папку с кэшем");
                    cachePath.delete(0,cachePath.length());
                    cachePath.append(sc.next());
                    break;
            }
        }
        return cachePath.toString();
    }

    private static String getDestPath() {
        System.out.println("По умолчанию кэш сохранится в папку Documents/SevedCache. Если желаете изменить укажите путь, нет - нажмите 1");
        Scanner sc = new Scanner(System.in);
        StringBuilder cachePath = new StringBuilder();
        String s = sc.next();
        if (!s.equals("1"))
            cachePath.append(s);
        if (cachePath.length() == 0) {
            if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0) {
                cachePath.append("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\SavedCache");
            } else if (System.getProperty("os.name").toLowerCase().indexOf("nix") >= 0 || System.getProperty("os.name").toLowerCase().indexOf("nux") >= 0) {
                cachePath.append("/home/" + System.getProperty("user.name") + "/documents/savedcache");
            } else if (System.getProperty("os.name").toLowerCase().indexOf("mac") >= 0) {
                cachePath.append("Users/" + System.getProperty("user.name") + "/Documents/SavedCache");
            } else {
                System.out.println("Не удалось найти путь по умолчанию. Укажите путь");
                cachePath.append(sc.next());
            }
        }
        File path = new File(cachePath.toString());
        if (!path.exists()) {
            path.mkdir();
        }
        sc.close();
        return cachePath.toString();
    }

    public static void copyVideo() {
        String source = getSourcePath();
        String dest = getDestPath();
        if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0) {
            dest+="\\Video\\";
        }
        else
            dest+="/video/";
        File pathDest = new File(dest);
        if (!pathDest.exists()) {
            pathDest.mkdir();
        }
        File pathSource = new File(source);
        LinkedList<File> files = new LinkedList<File>();
        for (File file : pathSource.listFiles()){
            if (file.length()>250000)
                files.add(file);
        }
        for(File file : files){
            try {
                BufferedReader fin = new BufferedReader(new FileReader(file));
                if (fin.readLine().contains("mp4")){
                    File newFile = new File(dest + file.getName()+".mp4");
                    Files.copy(file.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void copyMP3() {
        String source = getSourcePath();
        String dest = getDestPath();
        if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0) {
            dest+="\\MP3\\";
        }
        else
            dest+="/mp3/";
        File pathDest = new File(dest);
        if (!pathDest.exists()) {
            pathDest.mkdir();
        }
        File pathSource = new File(source);
        LinkedList<File> files = new LinkedList<File>();
        for (File file : pathSource.listFiles()){
            if (file.length()>20000)
                files.add(file);
        }
        for(File file : files){

            try {
                BufferedReader fin = new BufferedReader(new FileReader(file));
                String s = fin.readLine();
                if (s.length() > 2 && s.substring(0, 3).equals("ID3")) {
                    File newFile = new File(dest + file.getName() + ".mp3");
                    Files.copy(file.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        renameFile(pathDest.listFiles());
    }
    private static void renameFile(File[] files){

        for (File file : files){
            String art="";
            String track = "";
            try{
                AudioFile f = AudioFileIO.read(file);
                Tag tag = f.getTag();
                art = tag.getFirst(FieldKey.ARTIST);
                track = tag.getFirst(FieldKey.TITLE);
            } catch (CannotReadException e) {
                e.printStackTrace();
            } catch (TagException e) {
                e.printStackTrace();
            } catch (ReadOnlyFileException e) {
                e.printStackTrace();
            } catch (InvalidAudioFrameException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            file.renameTo(new File(file.getParent()+ "\\" + art + "-" + track + ".mp3"));
        }

    }
}
