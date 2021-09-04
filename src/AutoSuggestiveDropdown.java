import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Susmita\\chromedriver_win32_update\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.xpath("(//input[@id='autosuggest'])")).sendKeys("IND");
		Thread.sleep(1000L);
		List<WebElement> options= driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
		for (WebElement option: options)
		{if (option.getText().equalsIgnoreCase("India"))
			{option.click();
			break;
			}
			
			
		}
		
	}

}
