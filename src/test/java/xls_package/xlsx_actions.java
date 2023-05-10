package xls_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class xlsx_actions {

  
    public static String[][] getExcelData(String sheetName) throws Exception {
	
	FileInputStream FIS = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Dell_Project.xlsx");

	XSSFWorkbook book = new XSSFWorkbook(FIS);	

	XSSFSheet sheet = book.getSheet(sheetName);

	int noOfRows = sheet.getPhysicalNumberOfRows();
	int noOfColumns = sheet.getRow(0).getLastCellNum();
	
	String[][] data= new String[noOfRows-1][noOfColumns];
	for(int i=1; i<noOfRows; i++)
	{
	    for(int j=0; j< noOfColumns; j++)
	    {
		data[i-1][j] = sheet.getRow(i).getCell(j).toString();
	    }
	}
	
		
	book.close();	    
	FIS.close();
//	for(String[] array:data)
//	{
//	    System.out.println(Arrays.toString(array));
//	}
	return data;
    }

}
