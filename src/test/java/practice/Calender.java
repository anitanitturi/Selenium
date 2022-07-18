package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nandi\\eclipse-workspace\\Slenium\\src\\test\\resources\\driver\\chromedriver.exe");
		 ChromeDriver driver= new ChromeDriver();
		 driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		 driver.manage().window().maximize();
		 driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		 List<WebElement> date = driver.findElements(By.xpath("//a[@class='ui-state-default']"));
		int count= driver.findElements(By.xpath("//a[@class='ui-state-default']")).size();
		 
		for(int i=0;i<count;i++) {
			String text=driver.findElements(By.xpath("//a[@class='ui-state-default']")).get(i).getText();
			if(text.equalsIgnoreCase("20")) {
				driver.findElements(By.xpath("//a[@class='ui-state-default']")).get(i).click();
				break;
			}
		}
	}

}
