package testSuite;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import testMethod.testDeoSearchProperty;

public class RunTestDeo {
	public static FileInputStream excleFile;
	public static XSSFWorkbook workbook;
	public static XSSFSheet loginSheet;
	public static XSSFSheet testCaseSheet;
	public static XSSFSheet urlSheet;
	public FileOutputStream outFile;
	public static Row rows;
	public static int r,c,rowcount;
	public static String DeoUserName,DeoPassword,QAUserName,QAPassword,AdminUserName,AdminPassword,
	loginUrl,newDataEntryUrl;
	static ExtentReports report;
	static ExtentTest testLogin;
	static WebDriver driver;
	static WebDriverWait wait;
	public static void readExcle() throws IOException
	{
		excleFile= new FileInputStream(new File("D:\\jee-neon\\workspace\\ZeusTestData.xlsx"));
		workbook = new XSSFWorkbook(excleFile);
		testCaseSheet=workbook.getSheet("TestCaseDeo");
		urlSheet=workbook.getSheet("Url");
		loginSheet=workbook.getSheet("Login");
		//Getting Login Url
		loginUrl=urlSheet.getRow(0).getCell(1).toString();
		//Getting Page link_url
		newDataEntryUrl=urlSheet.getRow(1).getCell(1).toString();
		//Getting Login Credential
		DeoUserName=loginSheet.getRow(0).getCell(1).toString();
		DeoPassword=loginSheet.getRow(0).getCell(2).toString();
		QAUserName=loginSheet.getRow(1).getCell(1).toString();
		QAPassword=loginSheet.getRow(1).getCell(2).toString();
		AdminUserName=loginSheet.getRow(2).getCell(1).toString();
		AdminPassword=loginSheet.getRow(2).getCell(2).toString();
		//Run only those Test Case which as Yes in first column 
		rowcount=testCaseSheet.getLastRowNum();//Getting total number of test cases
		System.out.println("Total Number of TestCase - "+rowcount);
	}


	@Test
	public static void testCaseID() throws Exception
	{
		readExcle();
		for (r=1;r<=rowcount;r++)
		{
			Row rows=testCaseSheet.getRow(r);
			if(rows.getCell(2).toString().equals("Yes"))
			{
				String testcasId=rows.getCell(0).toString();
				if(testcasId.equals("BUC-001"))
				{
					testDeoSearchProperty.openUrl();
				}
				else if(testcasId.equals("BUC-002"))
				{
				}
				else if(testcasId.equals("BUC-003"))
				{
				}
			}
		}
	}

	@AfterMethod
	public static void  writeExcle() throws Throwable
	{
		FileOutputStream outFile =new FileOutputStream(new File("D:\\jee-neon\\workspace\\ZeusTestData.xlsx"));
		workbook.write(outFile);
		outFile.close();
		workbook.close();
		System.out.println("Test Completed");

	}
}
