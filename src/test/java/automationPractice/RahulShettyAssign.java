package automationPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RahulShettyAssign {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Nandi/eclipse-workspace/Slenium/src/test/resources/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,0500)", "");
		driver.findElement(By.name("name")).sendKeys("abcd");
		driver.findElement(By.name("email")).sendKeys("abcd@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("mnbv");
		driver.findElement(By.id("exampleCheck1")).click();
		Assert.assertTrue(true);
		WebElement staticdropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown = new Select(staticdropdown);
		dropdown.selectByIndex(1);
		driver.findElement(By.className("form-check-input")).click();
		driver.findElement(By.name("bday")).sendKeys("23/03/1987");
		driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
		Thread.sleep(2000);
		driver.close();
	}

}
