import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Susmita\\chromedriver_win32_update\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//dynamic dropdown
		driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000L);
		//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

		//calendar
		//driver.findElement(By.cssSelector("#ctl00_mainContent_view_date1")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
		//roundtrip selection
		driver.findElement(By.xpath("//table[@id='ctl00_mainContent_rbtnl_Trip']/tbody/tr/td[2]/input[1]")).click();
		
		//return date
		driver.findElement(By.id("Div1")).getAttribute("style");
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
		{System.out.println("It is enabled");
		Assert.assertTrue(true);
		}
		
		else
		{System.out.println("It is not enabed");
		Assert.assertTrue(true);
			
		}
		
		//cick on search
		driver.findElement(By.cssSelector("input#ctl00_mainContent_btn_FindFlights")).click();
		
	}

}
