package com.utility;

import com.enums.Environment;
import org.apache.commons.compress.archivers.StreamingNotSupportedException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtil {
    static File file;
   static FileReader fileReader;
   static Properties properties;
    public static String getApplicationProperty(Environment env, String key)
    {
         file =new File(System.getProperty("user.dir")+"/config/"+env+".Properties");
       // System.out.println(file);
        properties=new Properties();
        try {
             fileReader=new FileReader(file);
            properties.load(fileReader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(key);
    }
}
