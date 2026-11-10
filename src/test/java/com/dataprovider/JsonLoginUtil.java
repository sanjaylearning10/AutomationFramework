package com.dataprovider;

import com.google.gson.Gson;
import com.pogo.Credentails;
import com.pogo.LoginConfig;
import com.utility.CsvDataReader;
import com.utility.ExcelDataReader;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public  class JsonLoginUtil {
    static FileReader fileReader;
    static File file;
    static Gson gson;

    @DataProvider(name="LoginDataprovider")
    public  Iterator<Object[]> LoginData () {
        file = new File(System.getProperty("user.dir") + "/testdata/logindata.json");
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        gson = new Gson();
        LoginConfig config = gson.fromJson(fileReader, LoginConfig.class);

        List<Object[]> returnCred=new ArrayList<>();

        for(Credentails credentails:config.getData())
        {
            returnCred.add(new Object[]{credentails});
        }

        return returnCred.iterator();
    }

    @DataProvider(name="LoginDataProviderCsv")
    public  Iterator<Credentails> LoginDataUsingCsv () {
        return CsvDataReader.DataReader("logindata.csv");
    }
    @DataProvider(name="LoginDataProviderExcel")
    public  Iterator<Credentails> LoginDataUsingExcel () {
        return ExcelDataReader.DataReaderExcel("logindata.xlsx");
    }
}

