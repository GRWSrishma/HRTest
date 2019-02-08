package seleniumday1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class TestReadExcel1 {
	
	public static Object[][] testReadExcel() {
		
		File file = new File("src\\test\\resources\\TestData.xlsx");
		Object[][] obj = null;
		try {
			
		InputStream is = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(is);
		XSSFSheet Sheet1 = workbook.getSheet("Sheet1");
		
		obj=new Object[Sheet1.getLastRowNum()][];
		for(int i=1;i<=Sheet1.getLastRowNum();i++)
		{
			obj[i-1]=new Object[Sheet1.getRow(i).getPhysicalNumberOfCells()];
			for(int j=0;j<Sheet1.getRow(i).getPhysicalNumberOfCells();j++)
			{
				
			obj[i-1][j]=Sheet1.getRow(i).getCell(j).getStringCellValue();
			}
			//System.out.println();
		//System.out.println(sheet1.getRow(i).getCell(0).getStringCellValue());
		//System.out.println(sheet1.getRow(i).getCell(1).getStringCellValue());
		}
		workbook.close();
		} 
		catch(FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
	}

}
