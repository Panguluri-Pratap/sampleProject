package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class UtilKit {

    static FileInputStream fis;
    static XSSFWorkbook wb;
    static XSSFSheet ws;

    public static HashMap<String,String> getTestDataFromExcel(String testCaseID) throws IOException {

          fis = new FileInputStream("src\\main\\resources\\testdata\\excels\\Book1.xlsx");
          wb=new XSSFWorkbook(fis);
          ws=wb.getSheet("sheet2");

          ArrayList<Row> testcaseRows=getTestCaseRows(ws,testCaseID);

        HashMap<String,String> testDataMap= new HashMap<String,String>();


        for(int i=0;i< testcaseRows.size();i++) {
            int noOfCells=testcaseRows.get(i).getLastCellNum();
            for(int j=0;j<noOfCells;j++){
                testDataMap.put(testcaseRows.get(0).getCell(j).getStringCellValue(),testcaseRows.get(1).getCell(j).getStringCellValue());
            }
        }
        return testDataMap;
    }

    private static ArrayList<Row> getTestCaseRows(XSSFSheet ws, String testCaseID) {
         ArrayList<Row> allRows= new ArrayList<Row>();

         for(int i=0;i<=ws.getLastRowNum();i++){
             if(ws.getRow(i)!=null){
                 allRows.add(ws.getRow(i));
             }
         }
         ArrayList<Row> testcaseRow = new ArrayList<Row>();

         for(int i=0;i<allRows.size();i++){
             if(allRows.get(i).getCell(0).getStringCellValue().equalsIgnoreCase(testCaseID)){
                 testcaseRow.add(allRows.get(i));
             }
         }

        return testcaseRow;
    }
}
