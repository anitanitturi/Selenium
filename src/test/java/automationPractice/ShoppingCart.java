package automationPractice;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class ShoppingCart {
	static WebDriver driver = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Nandi\\eclipse-workspace\\Hello\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		// driver.findElement(By.xpath("https://rahulshettyacademy.com/seleniumPractise/")).click();
		driver.manage().window().maximize();
		addtocart();
		checkout();
		
	}

	public static void addtocart() {
		int j = 0;
		String[] veggies = { "Grapes", "Almonds", "Strawberry", "Pomegranate" };
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));
		for (int i = 0; i < products.size(); i++) {
			// cucumber - 1kg

			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			// check array into array list for easy search
			// check whether name extracted is present in the arraylist r not
			List veggiesList = Arrays.asList(veggies);

			if (veggiesList.contains(formattedName)) {
				j++;
				// click add to cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == veggies.length) {
					break;
				}

			}

		}
	}
	public static void checkout() {
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("ralulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		System.out.println(driver.findElement(By.className("promoInfo")).getText());	
	}
			
}
