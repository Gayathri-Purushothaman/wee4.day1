package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Servicenow {

	public static void main(String[] args) throws InterruptedException  {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://dev101323.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
driver.findElement(By.id("user_name")).sendKeys("admin");
driver.findElement(By.id("user_password")).sendKeys("Karthik@2014");
driver.findElement(By.id("sysverb_login")).click();
Thread.sleep(10000);
Shadow shadow = new Shadow(driver);
WebElement searchFilter = shadow.findElementByXPath("//div[text() = 'All']");
Actions builder=new Actions(driver);
builder.moveToElement(searchFilter).click().perform();
Thread.sleep(10000);
WebElement filterIncident=shadow.findElementByXPath("//input[@id='filter']");
filterIncident.sendKeys("incident");
Thread.sleep(10000);
searchFilter.click();
WebElement selectAll=shadow.findElementByXPath("//span[text()='All']");
builder.moveToElement(selectAll).click().perform();
Thread.sleep(10000);
WebElement frameOfNew=shadow.findElementByXPath("//iframe[@id='gsft_main']");
driver.switchTo().frame(frameOfNew);
WebElement newButton=driver.findElement(By.xpath("//button[@type='submit'][text()='New']"));
newButton.click();
driver.switchTo().defaultContent();
Thread.sleep(10000);
WebElement frameOfCaller=shadow.findElementByXPath("//iframe[@id='gsft_main']");
driver.switchTo().frame(frameOfCaller);
String incidentNumberExpected=driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
WebElement callerField=driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']"));
callerField.click();
Set<String>winSet=driver.getWindowHandles();
List<String>winList=new LinkedList<String>(winSet);
driver.switchTo().window(winList.get(1));
driver.manage().window().maximize();
driver.findElement(By.xpath("//a[@role='button'][@class='glide_ref_item_link']")).click();
driver.switchTo().window(winList.get(0));
driver.switchTo().frame(frameOfCaller);
driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("test");
driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']")).click();
driver.findElement(By.xpath("//input[@id='incident_table_header_search_control']")).sendKeys(incidentNumberExpected,Keys.ENTER);
String incidenceNumberActual=driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
if(incidentNumberExpected.equals(incidenceNumberActual))
{
	System.out.println("Incidence created successfully");
}
else
{
	System.out.println("Incidence number is not as expected");
}

}

	}


