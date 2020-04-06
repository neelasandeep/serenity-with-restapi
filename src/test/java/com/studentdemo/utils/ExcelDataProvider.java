package com.studentdemo.utils;


import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelDataProvider {
    XSSFWorkbook workBook;
    XSSFSheet workSheet;
    XSSFRow row;

    Logger logger;
    String line = "";


    public ExcelDataProvider() throws IOException {




        File src = new File(Properties.EXCELLPATH);
        FileInputStream fis = new FileInputStream(src);
        workBook = new XSSFWorkbook(fis);

    }

    public  List<String> getStringData(String sheetnumber) {
        List<String> urlString = new ArrayList<>();
        System.out.println(sheetnumber);
        workSheet = workBook.getSheet(sheetnumber);


        for (int i = 1; i <= workSheet.getLastRowNum() ; i++) {
            row = workSheet.getRow(i);

            for (int j = 0; j < row.getLastCellNum(); j++) {
                line = line.concat(String.valueOf(row.getCell(j)) + "%");


            }
            urlString.add(line);
            System.out.println(line);
            line = "";
        }


        return urlString;
    }
    public static String[] getdata(String sheetNumber) throws IOException {
        List<String> urlString;


        ExcelDataProvider excel = new ExcelDataProvider();

        urlString = excel.getStringData(sheetNumber);

        String[] empData = new String[urlString.size()];
        for (int datalength = 0; datalength < urlString.size(); datalength++) {
            empData[datalength] = urlString.get(datalength);
        }
        return empData;
    }

}

