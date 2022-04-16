package week4.day1;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
						WebDriverManager.chromedriver().setup();
						ChromeDriver driver=new ChromeDriver();
						driver.get("http://leaftaps.com/opentaps/control/login");
						driver.manage().window().maximize();
						driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
						driver.findElement(By.id("password")).sendKeys("crmsfa");
						driver.findElement(By.className("decorativeSubmit")).click();
						driver.findElement(By.linkText("CRM/SFA")).click();
				driver.findElement(By.linkText("Contacts")).click();
				driver.findElement(By.linkText("Merge Contacts")).click();
				driver.findElement(By.xpath("//input[@id='partyIdFrom']/following-sibling::a/img[@alt='Lookup']")).click();
				System.out.println(driver.getTitle());
				Set<String> setHandles=driver.getWindowHandles();
				List<String> listHandles=new LinkedList<String>(setHandles);
			
				driver.switchTo().window(listHandles.get(1));
		System.out.println(driver.getTitle());
				driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
				
				driver.switchTo().window(listHandles.get(0));
			
				driver.findElement(By.xpath("//input[@id='partyIdTo']/following-sibling::a/img[@alt='Lookup']")).click();
				Set<String> setHandles1=driver.getWindowHandles();
				List<String> listHandles1=new ArrayList<String>(setHandles1);
				driver.switchTo().window(listHandles1.get(1));
			Thread.sleep(10000);
				driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[2]//a[@class='linktext']")).click();
		
				driver.switchTo().window(listHandles1.get(0));
				driver.findElement(By.xpath("//a[@class='buttonDangerous'][text()='Merge']")).click();
				Alert alert=driver.switchTo().alert();
				alert.accept();
				String str=driver.getTitle();
				if(str.equals("View Contact | opentaps CRM"))
				{
					System.out.println("Title is correct");
				}
				else
				{
					System.out.println("Title is incorrect");
				}
				
	}

}
