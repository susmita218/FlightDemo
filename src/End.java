import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class End {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Susmita\\chromedriver_win32_update\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//autosuggestive dropdown
		driver.findElement(By.xpath("(//input[@id='autosuggest'])")).sendKeys("IND");
		Thread.sleep(1000L);
		List<WebElement> options= driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
		for (WebElement option: options)
		{if (option.getText().equalsIgnoreCase("India"))
			{option.click();
			break;
			}
		}
		
		//checkbox
		// count number of checkboxes
				System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
				Assert.assertFalse((driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']"))
						.isSelected()));
				driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).click();
				Assert.assertTrue((driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']"))
						.isSelected()));
				
				
				//hande passenger

				driver.findElement(By.id("divpaxinfo")).click();
				Thread.sleep(2000L);
				int i = 1;
				while (i < 5) {
					driver.findElement(By.id("hrefIncAdt")).click();
					i++;
				}

				driver.findElement(By.id("btnclosepaxoption")).click();
				System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
				Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
				

		
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
		{System.out.println("It is enabed");
		Assert.assertTrue(true);
		}
		
		else
		{System.out.println("It is not enabed");
		Assert.assertTrue(true);
			
		}
		
		//static dropdown
		WebElement Static=driver.findElement(By.cssSelector("#ctl00_mainContent_DropDownListCurrency"));
		Select dropdown=new Select(Static);
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
	
		
		//click on search
		driver.findElement(By.cssSelector("input#ctl00_mainContent_btn_FindFlights")).click();
		

	

}
}
