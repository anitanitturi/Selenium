package automationPractice;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowsHandling {
	static WebDriver driver=null;
	static{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Nandi\\eclipse-workspace\\Hello\\src\\test\\resources\\drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,0800)", "");
		
		
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//windows();
		iframes();
		
	}
	public static void windows() throws InterruptedException {
		
		
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		
		Set<String> windows=driver.getWindowHandles();
		Iterator<String>it=windows.iterator();
		String parentId=it.next();
		//String childId=it.next();
		driver.switchTo().window(it.next());
		System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
		driver.switchTo().window(parentId);
		System.out.println(driver.findElement(By.xpath("//div[@id='content']/div/h3")).getText());
		
		Thread.sleep(2000);
		driver.close();
	}
	public static void iframes() {
		driver.findElement(By.linkText("Nested Frames")).click();
		System.out.println(driver.findElements(By.tagName("frame")).size());
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		System.out.println(driver.findElement(By.id("content")).getText());
	}
	}

		
	

		
		
		
		
		
		
		
		
		