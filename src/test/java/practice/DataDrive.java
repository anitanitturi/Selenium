package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrive {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//it accept fileinputstream argument
		FileInputStream fis=new FileInputStream("C:\\Anita\\datadriven.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		int sheets=workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("TestData")) {
				XSSFSheet sheet=workbook.getSheetAt(i);	
			Iterator<Row> rows=	sheet.rowIterator();
			Row firstrow=rows.next();
			Iterator<Cell> cell=firstrow.cellIterator();
			int k=0;
			int column = 0;
			while(cell.hasNext()) {
				 Cell value=cell.next();
				if (value.getStringCellValue().equalsIgnoreCase("Testcases")) {
					column=k;	
				}
				k++;
			}
			System.out.println(column);
			//once column is identified then scan entire testcases column to identify purchase tc row
			while(rows.hasNext()) {
				Row r=rows.next();
				if(r.getCell(column).getStringCellValue().equalsIgnoreCase("purchase")) {
				Iterator<Cell> c=	r.cellIterator();
				while(c.hasNext()) {
					System.out.println(c.next().getStringCellValue());
				}
				}
			}
			}
			
		}
		
	}

}
