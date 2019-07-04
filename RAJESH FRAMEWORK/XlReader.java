package in.keys2javaselenium.newtours1.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class XlReader {
	
	@DataProvider(name="newtours") //1
	public static String[][] storeTestData(Method tc)//3
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		FileInputStream fis = new FileInputStream(".\\TestData\\NewToursData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s1 = wb.getSheet("Sheet1");
		
		String testcaseName = tc.getName(); //4
	
		int arrayRowCount = getGivenTestCaseRowCount(testcaseName);
		int arrayCellCount = getGivenTestCaseCellCount(testcaseName);
		
		String[][] tdata = new String[arrayRowCount][arrayCellCount+1];
		int nridex=0;
		
		int rowCount = s1.getPhysicalNumberOfRows();
	
		for (int rowIndex = 1; rowIndex < rowCount; rowIndex++) {
			Row r = s1.getRow(rowIndex);
			
			int ncindex=0;
			
			Cell c1 = r.getCell(1);
			Cell c2 = r.getCell(2);

			String secondCellData = c1.getStringCellValue();
			String thirdCellData = c2.getStringCellValue();

			if (thirdCellData.equalsIgnoreCase("Y") && 
					secondCellData.equalsIgnoreCase(testcaseName)) {
				
				int cc = r.getPhysicalNumberOfCells(); 
				
				for(int cellIndex=3; cellIndex<cc;cellIndex++)
				{
					tdata[nridex][ncindex++]=
							r.getCell(cellIndex).getStringCellValue();		
				}
				tdata[nridex][ncindex]=rowIndex+"";
				nridex++;
			}
		}
		return tdata;
	}
	
	
	
	public static int getGivenTestCaseCellCount(String testcaseName)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		FileInputStream fis = new FileInputStream(".\\TestData\\NewToursData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s1 = wb.getSheet("Sheet1");
	
		int rowCount = s1.getPhysicalNumberOfRows();
	
		for (int rowIndex = 1; rowIndex < rowCount; rowIndex++) {
			Row r = s1.getRow(rowIndex);

			Cell c1 = r.getCell(1);
			Cell c2 = r.getCell(2);

			String secondCellData = c1.getStringCellValue();
			String thirdCellData = c2.getStringCellValue();

			if (thirdCellData.equalsIgnoreCase("Y") && 
					secondCellData.equalsIgnoreCase(testcaseName)) {
				return r.getPhysicalNumberOfCells()-3;
			}
		}
		return 0;
	}
	
	public static int getGivenTestCaseRowCount(String testcaseName)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		FileInputStream fis = new FileInputStream(".\\TestData\\NewToursData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s1 = wb.getSheet("Sheet1");
	
		int rowCount = s1.getPhysicalNumberOfRows();
		int count = 0;
		for (int rowIndex = 1; rowIndex < rowCount; rowIndex++) {
			Row r = s1.getRow(rowIndex);

			Cell c1 = r.getCell(1);
			Cell c2 = r.getCell(2);

			String secondCellData = c1.getStringCellValue();
			String thirdCellData = c2.getStringCellValue();

			if (thirdCellData.equalsIgnoreCase("Y") && 
					secondCellData.equalsIgnoreCase(testcaseName)) {
				count++;
			}
		}
		return count;
	}
	
	
	
//	@Test
//	public void verifyHomePage() throws EncryptedDocumentException, InvalidFormatException, IOException
//	{
//		String allRowsCellsTestData[][] = storeTestData("verifyHomePage");
//		
//		for(String eachRowCellsData[] : allRowsCellsTestData)
//		{
//			for(String eachCellData : eachRowCellsData)
//			{
//				System.out.print(eachCellData+"\t");
//			}
//			System.out.println();
//			System.out.println("----------------------------------------------------------");
//		}
//		
//	}
//	
//	@Test(dataProvider="mmm", dataProviderClass=XlReader.class)//2
//	public void verifyRegistrationProcess(String... allData) 
//					throws EncryptedDocumentException, InvalidFormatException, IOException
//					//5- passing corresponding parameters
//	{
//		
//		for(String data:allData)
//				System.out.print(data+"\t");
//		
//		System.out.println("\n------------------------------------------------------");
//	}
//
//	@Test(dataProvider="mmm", dataProviderClass=XlReader.class)//2
//	public void verifySignOn(String... allData) 
//					throws EncryptedDocumentException, InvalidFormatException, IOException
//					//5- passing corresponding parameters
//	{
//		
//		for(String data:allData)
//				System.out.print(data+"\t");
//		
//		System.out.println("\n------------------------------------------------------");
//	}
//
//	
//	@Test(dataProvider="mmm", dataProviderClass=XlReader.class)//2
//	public void verifyHomePage(String... allData) 
//					throws EncryptedDocumentException, InvalidFormatException, IOException
//					//5- passing corresponding parameters
//	{
//		
//		for(String data:allData)
//				System.out.print(data+"\t");
//		
//		System.out.println("\n------------------------------------------------------");
//	}


}
