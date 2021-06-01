package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomeStranica {
	/*
	 * Test Selenium Zadatak Napisati program na programskom jeziku Java koji sluzi
	 * za testiranje sajta https://www.saucedemo.com/ Pokusati logovanje prvo sa
	 * nevalidnim, a potom sa validnim kredencijalima i proveriti da li se nakon
	 * toga korisnik nalazi na odgovarajucoj staranici. Na stranici
	 * https://www.saucedemo.com/inventory.html sortirati proizvode po ceni (od
	 * najnize ka najvisoj). Proveriti da li je sortiranje ispravno. Program pisati
	 * postujuci page object model. Koristiti Test NG za proveru ispravnosti
	 * testova. Kredencijale procitati iz datoteke data.xlsx. Resenje okaciti na
	 * GitHub nalog i svoj folder na google drive-u (napraviti folder pod nazivom
	 * kontrolni3).
	 * 
	 */

	public static final String URL = "https://www.saucedemo.com/";
	public static final String USERNAME_XPATH = "//*[@id=\"user-name\"]";
	public static final String PASWORD_XPATH = "//*[@id=\"password\"]";
	public static final String SUBMIT_XPATH = "//*[@id=\"login-button\"]";
	private static WebDriver driver = null;

	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Marina\\test2\\Test\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	}

	public static void inputUsername(WebDriver driver, String username) {
		driver.findElement(By.xpath(USERNAME_XPATH)).sendKeys(username);
	}

	public static void inputPassword(WebDriver driver, String password) {
		driver.findElement(By.xpath(PASWORD_XPATH)).sendKeys(password);
	}

	public static void submit(WebDriver driver) {
		driver.findElement(By.xpath(SUBMIT_XPATH)).click();
	}

}
