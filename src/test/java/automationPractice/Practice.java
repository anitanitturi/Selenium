package automationPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Practice {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Nandi/eclipse-workspace/Hello/src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
		Assert.assertFalse(false);
		driver.findElement(By.id("checkBoxOption1")).click();
		System.out.println((driver.findElement(By.id("checkBoxOption1")).isSelected()));
		Assert.assertTrue((driver.findElement(By.id("checkBoxOption1")).isSelected()));
		driver.findElement(By.id("checkBoxOption1")).click();
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		Thread.sleep(2000);
		driver.close();

	}
}

/*
 * System.out.println(driver.getTitle());
 * System.out.println(driver.getCurrentUrl()); driver.close();
 * 
 * //driver.manage().window().minimize(); //driver.manage().window().maximize();
 */
