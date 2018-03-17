import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

import java.util.Iterator;

public class Assignment1 {
    
    
     private static final String FILE_IN = "C:\\Users\\User\\Documents\\NetBeansProjects\\Assignment1\\Studentsupervisorlist.xlsx";
     private static final String FILE_OUT = "C:\\Users\\User\\Documents\\NetBeansProjects\\Assignment1\\data.md";
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
               
            
          

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                 w.write("#A171 PRACTICUM");
                 w.write("\n");
                 w.write("###From 21/02/2018 To 20/08/2018");
                 w.write("\n");
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
    
      public static void main(String[] args) {
        
        run();
      
        
    }

}