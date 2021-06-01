package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Sortiranje {
	public static final String STRANICAPRODAJE = "https://www.saucedemo.com/inventory.html";

	private static WebDriver driver = null;

	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Marina\\test2\\Test\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	}

	@Test
	public static void testSortLowToHigh() {
		driver.get(HomeStranica.URL);
		HomeStranica.inputUsername(driver, "standard_user");
		HomeStranica.inputPassword(driver, "secret_sauce");
		HomeStranica.submit(driver);

		driver.navigate().to(STRANICAPRODAJE);
		Select sortPrice = new Select(driver.findElement(By.className("product_sort_container")));

		sortPrice.selectByVisibleText("Price (low to high)");

		List<WebElement> listaProizvoda = driver
				.findElements(By.cssSelector(".invetory_container .inventory_item .invetory_item_price"));
		List<Double> priceList = new ArrayList<Double>();

		for (WebElement productPrice : listaProizvoda) {

			String priceDolar = productPrice.getText();
			double price = Double.parseDouble(priceDolar.substring(1));
			priceList.add(price);

		}

		for (int i = 0; i < priceList.size() - 1; i++) {
			Assert.assertTrue(priceList.get(i) <= priceList.get(i + 1));

		}

	}
	
	@AfterClass
	public static void afterTests() {
	
		driver.quit();
		
		
	}
}
