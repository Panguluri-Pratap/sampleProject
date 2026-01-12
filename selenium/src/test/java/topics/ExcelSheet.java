package topics;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelSheet {
    public static void main(String[] args) throws IOException {

           FileInputStream fis=   new FileInputStream("C:\\Users\\prata\\OneDrive\\Documents\\Book1.xlsx");

              XSSFWorkbook  wb= new XSSFWorkbook(fis);

              XSSFSheet ws= wb.getSheet("Sheet1");

              /*System.out.println(ws.getLastRowNum());

              System.out.println(ws.getPhysicalNumberOfRows());

              XSSFRow row=ws.getRow(3);
              Iterator<Cell> value=row.cellIterator();
              while(value.hasNext()){
                  Cell cell = value.next();
                  System.out.println(cell.toString());
              }

              wb.close();
              fis.close();
              System.out.println(row.getCell(0));

              System.out.println(row.getLastCellNum());

             XSSFCell cellvalue= row.getCell(0);

             CellType name=cellvalue.getCellType();

             System.out.println(name.toString());*/


        // Printing all the data from the Excel sheet

       /* Row row=null;
        Cell cell=null;


       for(int i=0;i<=ws.getLastRowNum();i++){
           row=ws.getRow(i);
           if(row!=null) {
               for (int j = 0; j < row.getLastCellNum(); j++) {
                   cell = row.getCell(j);
                   if(cell!=null) {
                       if (cell.getCellType() == CellType.STRING) {
                           System.out.println(cell.getStringCellValue() + " " + "is a String");
                       } else if (cell.getCellType() == CellType.NUMERIC) {
                           System.out.println(cell.getNumericCellValue() + " " + "is a Number");
                       } else if (cell.getCellType() == CellType.BOOLEAN) {
                           System.out.println(cell.getBooleanCellValue() + " " + "is a Boolean");
                       }
                   }
               }
           }
        }*/
                 ws.getRow(2).createCell(1).setCellValue(100);
                 ws.getRow(1).getCell(1).setCellValue("New FLM");
                 FileOutputStream fos = new  FileOutputStream("C:\\Users\\prata\\OneDrive\\Documents\\Book1.xlsx");
                 wb.write(fos);
                 wb.close();

    }

}
