package automationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {
	static WebDriver driver=null;
	static {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Nandi\\eclipse-workspace\\Hello\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		framePractice();
	}
	public static void framePractice() {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,0500)", "");
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		//driver.switchTo().frame(0);(by index)
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		Actions a=new Actions(driver);
		WebElement source=driver.findElement(By.id("draggable"));
		WebElement target=driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, target).build().perform();
		driver.switchTo().defaultContent();
		driver.close();
	}
	
}
