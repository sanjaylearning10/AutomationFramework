package com.utility;

import com.enums.Environment;
import com.google.gson.Gson;
import com.pogo.Config;
import com.pogo.Env;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Enumeration;

public  class JsonUtil {
    static FileReader fileReader;
    static File file;
    static Gson gson;

    public static Env readJson() {
        file = new File(System.getProperty("user.dir") + "/config/config.json");
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        gson = new Gson();
        Config config = gson.fromJson(fileReader, Config.class);
        Env env = config.getEnvironments().get(Environment.QA.toString());
        return env;

    }


}

