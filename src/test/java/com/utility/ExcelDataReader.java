package com.utility;

import com.pogo.Credentails;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelDataReader {

    public static Iterator<Credentails> DataReaderExcel(String fileName) {
         File file ;
         XSSFWorkbook xssfWorkbook=null;
         XSSFSheet xssfSheet;
         Iterator<Row> rowIterator;
        Row row;
         List<Credentails> credentialsList =null;
         Credentails credentails;


        try {
            file = new File(System.getProperty("user.dir") + "/testdata/"+fileName);
            xssfWorkbook = new XSSFWorkbook(file);
            credentialsList = new ArrayList<Credentails>();
            xssfSheet = xssfWorkbook.getSheet("Login");
            rowIterator = xssfSheet.iterator();
            rowIterator.next();
            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                Cell emailAddressCell = row.getCell(0);
                Cell passwordCell = row.getCell(1);
                credentails = new Credentails(emailAddressCell.toString(), passwordCell.toString());
                credentialsList.add(credentails);

            }
            xssfWorkbook.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        }
            return credentialsList.iterator();
    }

}