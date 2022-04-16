package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesPractice1 {

	public static void main(String[] args) throws InterruptedException  {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//b[@id='topic']/following::input")).sendKeys("Frames");
		driver.switchTo().frame("frame3");
		driver.findElement(By.id("a")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		WebElement d1=driver.findElement(By.id("animals"));
		Select s=new Select(d1);
		s.selectByValue("avatar");
		

	}

}
