package practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SSLCheck {

	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FirefoxOptions options=new FirefoxOptions();
		options.setAcceptInsecureCerts(true);
		System.setProperty("webdriver.gecko.driver", "C:/Users/Nandi/eclipse-workspace/Slenium/src/test/resources/driver/geckodriver.exe");
		WebDriver driver= new FirefoxDriver(options);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
	 File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 FileUtils.copyFile(src, new File("C:\\Anita\\sdet44 postman\\screenshot.png"));
	 
	}

}
