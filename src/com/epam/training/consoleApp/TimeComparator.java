package com.epam.training.consoleApp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Comparator;

/**
 * Created by Matt on 24.02.2018.
 */
public class TimeComparator implements Comparator<File> {

    @Override
    public int compare(File o1, File o2) {
        try {
            BasicFileAttributes fileAtr1 = Files.readAttributes(o1.toPath(), BasicFileAttributes.class);
            BasicFileAttributes fileAtr2 = Files.readAttributes(o2.toPath(), BasicFileAttributes.class);
            return fileAtr1.creationTime().compareTo(fileAtr2.creationTime());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
