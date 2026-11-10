package com.utility;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.pogo.Credentails;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CsvDataReader {

    static File file ;
    static FileReader fileReader;
   static CSVReader csvReader;

    @DataProvider(name="LoginDataProviderCsv")
    public static Iterator<Credentails> DataReader(String fileName) {
        file = new File(System.getProperty("user.dir") + "/testdata/"+fileName);
        String[] readLine;
        List<Credentails> userData=new ArrayList<>();
        Credentails credentails;
        try {
            fileReader = new FileReader(file);
            csvReader = new CSVReader(fileReader);
              csvReader.readNext();

             while ((readLine =csvReader.readNext())!=null)
            {
                 credentails =new Credentails(readLine[0], readLine[1]);
                userData.add(credentails);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return userData.iterator();
    }
}