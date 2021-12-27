package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesLeafGround {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);

		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement frame1=driver.findElement(By.xpath("//div[@id='wrapframe']/iframe"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//button[text()='Click Me']")).click();
		
		driver.switchTo().defaultContent();
		//System.out.println(driver.getTitle());
		
		
		driver.switchTo().frame(driver.findElement(By.xpath("(//div[@id='wrapframe'])[2]/iframe")));
		
		WebElement frame2=driver.findElement(By.xpath("//iframe[@id='frame2']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//button[@id='Click1']")).click();
		
		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("(//div[@id='wrapframe'])[3]"));
		List<WebElement> frames=driver.findElements(By.tagName("iframe"));
		System.out.println("Total no. of frames="+frames.size());
		
	
	}

}
