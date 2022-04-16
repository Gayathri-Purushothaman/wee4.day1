package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;


public class FramesPractice2 {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
driver.switchTo().frame(0);
driver.findElement(By.id("Click")).click();
File srcFile=driver.getScreenshotAs(OutputType.FILE);
File destFile=new File("./snaps/screenshotOfFramesPractice2.png");
FileUtils.copyFile(srcFile, destFile);
driver.switchTo().defaultContent();
driver.switchTo().frame(1);
driver.switchTo().frame("frame2");
driver.findElement(By.id("Click1")).click();
driver.switchTo().defaultContent();
List<WebElement> frameTot=driver.findElements(By.tagName("iframe"));
int count=frameTot.size();
System.out.println(count);

	}

}
