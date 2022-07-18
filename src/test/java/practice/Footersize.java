package practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Footersize {
	 static WebDriver driver;
	 static {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nandi\\eclipse-workspace\\Slenium\\src\\test\\resources\\driver\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.get("https://qaclickacademy.com/practice.php");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			}
	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		//footersize();
		dropdown();
		
	}
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nandi\\eclipse-workspace\\Slenium\\src\\test\\resources\\driver\\chromedriver.exe");
		public static void footersize() throws InterruptedException { 
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footerdriver=driver.findElement(By.id("gf-BIG"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		WebElement columndriver=footerdriver.findElement(By.xpath("//table//tbody//tr/td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
		for(int i=1;i<columndriver.findElements(By.tagName("a")).size();i++) {
			String clickonlinkTab= Keys.chord(Keys.CONTROL,Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			Thread.sleep(4000);
		}
			Set<String> abc=driver.getWindowHandles();
			Iterator<String> it= abc.iterator();
			while(it.hasNext()) {
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}
		}
		public static void dropdown() {
			driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]/input")).click();
			String opt=driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();
			WebElement dropdown=driver.findElement(By.id("dropdown-class-example"));
			Select s= new Select(dropdown);
			s.selectByVisibleText(opt);
			driver.findElement(By.name("enter-name")).sendKeys(opt);
			driver.findElement(By.id("alertbtn")).click();
			String text=driver.switchTo().alert().getText();
			if(text.contains(opt)) {
				System.out.println("Alert message success");
			}else {
				System.out.println("Something went wrong with execution");
			}
				
			
		}
		
}
		

	


