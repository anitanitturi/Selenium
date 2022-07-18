package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo {
	ExtentReports extent;

	@BeforeTest
	public void config() {
		// extent reports,ExtentSparkReporter
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("test results");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester", "Rahul Shetty");
	}

	@Test
	public void initialdemeo() {
		extent.createTest("initialdemo");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Nandi\\eclipse-workspace\\Slenium\\src\\test\\resources\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.getTitle());
		extent.flush();
	}

}
