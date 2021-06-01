package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestSajt {
	private static WebDriver driver = null;

	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Marina\\test2\\Test\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	}

	@Test
	public static void testLogovanje() {
		driver.get(HomeStranica.URL);
		driver.manage().window().maximize();
		
		File f = new File("data.xlsx");
		try {
			
			InputStream in = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(in);
			Sheet sheet = wb.getSheetAt(0);
			
			SoftAssert sa = new SoftAssert();
			
			for(int i = 0; i < 2; i++) {
				
			Row row	= sheet.getRow(i);
			
			Cell c0 = row.getCell(0);
			Cell c1= row.getCell(0);
			
			String username = c0.toString();
			String password = c1.toString();
			
			driver.navigate().to(HomeStranica.URL);
			
			HomeStranica.inputUsername(driver, username);
			HomeStranica.inputPassword(driver, password);
			HomeStranica.submit(driver);
			String trenutnaAdresa = driver.getCurrentUrl();
	        String registracijaAdresa = "https://www.saucedemo.com/inventory.html";
			
	        sa.assertEquals(trenutnaAdresa, registracijaAdresa);
			
			}
			
			sa.assertAll();
			
			wb.close();
			
			
			}
	catch (IOException e) {
		
	}
	
	}}

