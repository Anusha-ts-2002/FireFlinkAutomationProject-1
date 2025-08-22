package ninzaCRMgenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods related to file operations
 * like property file ,excelfile
 * 
 * @author Anusha T S
 */
public class FileUtility {
	
	/**
	 * This method will read data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	
	
	public String readdatafromPropertyfile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	    Properties p = new Properties();
	    p.load(fis);
	    
	    String value = p.getProperty(key);
	    return value;
	
	}
	
	//read data from excel
	/**
	 * This method will read data from excel file and return
	 * @param sheetname
	 * @param rownumber
	 * @param cellnumber
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String readdatafromexcelsheet(String sheetname, int rownumber,int cellnumber) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
	    Workbook wb = WorkbookFactory.create(fis);
	   
//	    Sheet sh = wb.getSheet("Sheet1"); Method chaining
//	    
//	    Row row= sh.getRow(1);
//	    
//        String data = row.getCell(3).toString();
//	    
//	    System.out.println(data);
	    
	    //without method chaining
	    return wb.getSheet(sheetname).getRow(rownumber).getCell(cellnumber).getStringCellValue();
	
	}
	
	//read multiple data from excel
	
	public void readmultipledata(String sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
	    Workbook wb = WorkbookFactory.create(fis);
	    
	    Sheet sh = wb.getSheet(sheetname);
	    Row row = sh.getRow(0);
	    
	    int rowcount= sh.getLastRowNum();
	    
	    for(int i=0;i<=rowcount;i++)
	    {
	    	 String coldata1 =   row.getCell(0).toString();
	    	 String coldata2 =   row.getCell(1).toString();
	    }
	    
	}
	
	
	
	

}
