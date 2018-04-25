
package com.mycompany.rtpa1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public interface readwrite {
        String FILE_IN = "C:\\Users\\User\\240898-STIW3054-A172-A1\\RTPA1\\Studentsupervisorlist.xlsx";
        String FILE_OUT = "C:\\Users\\User\\240898-STIW3054-A172-A1\\RTPA1\\data.md";
     
       public static void run()
    {
           Writer w = null;
           boolean lbreak = true;
             
           
        try {
            
            DataFormatter date = new DataFormatter();

            FileInputStream excelFile = new FileInputStream(new File(FILE_IN));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            
            File f = new File(FILE_OUT);
            w = new BufferedWriter(new FileWriter(f));
               
            
          
             w.write("#A171 PRACTICUM");
             w.write("\n");
             w.write("###From 21/02/2018 To 20/08/2018");
             w.write("\n");
            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();
                    String d = date.formatCellValue(currentCell);
                   

                    System.out.print(d +"|");
                  
                    
                    w.write(d +"|"); 

                }
                System.out.println();
                w.write("\n");
                if (lbreak==true){
                    w.write("---|---|---|---|\n");
                    lbreak=false;
                }
                

            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        
        try {                 
            if (w != null) {                     
                w.close();                 
            }             
        } catch (IOException e) {                 
            e.printStackTrace();             
        } 
    }
    
}
