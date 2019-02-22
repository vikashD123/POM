package DatafromExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadingData {
	
	@DataProvider(name="word")
	public static Object verify() throws Exception{
		
		FileInputStream fis=new FileInputStream("./Data/Data.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet sheet=wb.getSheet("wordpress");
		
		int count=sheet.getPhysicalNumberOfRows();
		
		Object[][]data=new Object[count][2];
		
		for(int i=0;i<count;i++) {
			
			XSSFRow row=sheet.getRow(i);
			
			XSSFCell c1=row.getCell(0);
			
			XSSFCell c2=row.getCell(1);
			
			data[i][0]=c1.getStringCellValue();
			
			data[i][1]=c2.getStringCellValue();
		}
		return data;
	}

}
