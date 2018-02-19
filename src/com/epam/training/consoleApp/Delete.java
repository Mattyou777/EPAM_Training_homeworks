package com.epam.training.consoleApp;

import java.io.File;

/**
 * Created by Matt on 19.02.2018.
 */
public class Delete {

    static void start(String source){

        File s = new File(source);
        if (s.exists())
            s.delete();

    }

}
