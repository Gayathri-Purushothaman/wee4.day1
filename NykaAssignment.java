package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaAssignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get(" https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions builder=new Actions(driver);
WebElement brandElement=driver.findElement(By.xpath("//a[text()='brands']"));

builder.moveToElement(brandElement).pause(3000).perform();

WebElement searchBrand=driver.findElement(By.xpath("//input[@id='brandSearchBox']"));
builder.moveToElement(searchBrand).sendKeys("L'Oreal Paris").pause(2000).perform();
WebElement selectParis=driver.findElement(By.xpath("//a[contains(text(),'Paris')]"));
selectParis.click();
Thread.sleep(5000);
String title=driver.getTitle();
if(title.contains("L'Oreal Paris"))
{
System.out.println("The title "+title+" is as expected");	
}
else
{
	System.out.println("The title "+title+" is not as expected");	
}
WebElement sort=driver.findElement(By.xpath("//span[@class='sort-name']"));
sort.click();
WebElement topRated=driver.findElement(By.xpath("//span[text()='customer top rated']/parent::div/following-sibling::div[@class='control-indicator radio ']"));
topRated.click();
WebElement category=driver.findElement(By.xpath("//span[text()='Category']"));
category.click();
WebElement hair=driver.findElement(By.xpath("//span[text()='Hair']"));
hair.click();
WebElement hairCare=driver.findElement(By.xpath("//span[text()='Hair Care']"));	
hairCare.click();
WebElement shampoo=driver.findElement(By.xpath("//span[text()='Shampoo']/parent::div[@class='control-value']/following-sibling::div[@class='control-indicator checkbox ']"));
shampoo.click();
Thread.sleep(3000);
WebElement concern=driver.findElement(By.xpath("//span[text()='Concern']"));
concern.click();
WebElement colorProtection=driver.findElement(By.xpath("//span[text()='Color Protection']/parent::div[@class='control-value']/following-sibling::div[@class='control-indicator checkbox ']"));
colorProtection.click();
WebElement filterValue=driver.findElement(By.xpath("//span[@class='filter-value']"));
String filterValueText=filterValue.getText();
if(filterValueText.contains("Shampoo"))
{
	System.out.println("The Filter "+filterValueText+ " is applied as expected");
}
else
{
	System.out.println("The Filter "+filterValueText+ " is not applied as expected");
}
WebElement resultElement=driver.findElement(By.xpath("//a[contains(@href,'l-oreal-paris-color-protect-shampoo')]"));
resultElement.click();
Set<String> setHandle=driver.getWindowHandles();

List<String>listHandle=new ArrayList<String>(setHandle);

driver.switchTo().window(listHandle.get(1));
WebElement size=driver.findElement(By.xpath("//select[@title='SIZE']"));
Select sizeOptions=new Select(size);
sizeOptions.selectByValue("0");
WebElement price=driver.findElement(By.xpath("//span[text()='MRP:']/following-sibling::span"));
String mrpText=price.getText().substring(1);
System.out.println("The price is "+mrpText);
WebElement addToBag=driver.findElement(By.xpath("//button[@type='button']//span[text()='ADD TO BAG']"));
addToBag.click();
WebElement cart=driver.findElement(By.xpath("//span[@class='cart-count']/parent::button/*"));
cart.click();
driver.switchTo().frame(0);

WebElement grandTotal=driver.findElement(By.xpath("//div[@class='value medium-strong']"));
String grandTotalText=grandTotal.getText().substring(1);
System.out.println("The grand total is "+grandTotalText);
WebElement proceedButton=driver.findElement(By.xpath("//span[@class='vernacular-string'][text()='PROCEED']"));
proceedButton.click();
driver.switchTo().defaultContent();
WebElement guestButton=driver.findElement(By.xpath("//button[@class='btn full big']"));
guestButton.click();
WebElement grandTotalLast=driver.findElement(By.xpath("//div[text()='Grand Total']/following-sibling::div[@class='value']/span"));
String grandTotalLastText=grandTotalLast.getText();
System.out.println("The grand total is "+grandTotalLastText);
if(grandTotalText.equals(grandTotalLastText))
{
	System.out.println("The Grand total is same");
}
else
{
	System.out.println("The Grand total is not same");
}
	}

}
