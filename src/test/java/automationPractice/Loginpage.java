package automationPractice;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

public class Loginpage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Nandi\\eclipse-workspace\\Hello\\src\\test\\resources\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(6));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		WebElement options = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select dropdown = new Select(options);
		dropdown.selectByVisibleText("Consultant");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		//Thread.sleep(3000);
		//driver.close();
		WebDriverWait w2=new WebDriverWait(driver,Duration.ofSeconds(5));
		w2.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout")));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,0200)", "");
		List <WebElement> products=driver.findElements(By.xpath("//div[@class='card-footer']"));
		for( int i=0;i<products.size();i++) {
			products.get(i).click();
		}
		js.executeScript("window.scrollBy(0,0)", "");
		driver.findElement(By.partialLinkText("Checkout")).click();
		
	}

}




/*for fluent wait
  Wait<WebDriver> w=new FluentWait<WebDriver>(driver).withTimeout(10,Seconds).pollingEvery(2,Seconds)
 .ignoring(NoSuchElementException.class)*/
