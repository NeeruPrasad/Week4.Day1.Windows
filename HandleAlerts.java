package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAlerts {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);

		driver.get("http://www.leafground.com/pages/Alert.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		Alert al=driver.switchTo().alert();
		al.accept();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		Alert al1=driver.switchTo().alert();
		al1.dismiss();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		Alert al2=driver.switchTo().alert();
		al2.sendKeys("Test Leaf");
		al2.accept();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[text()='Line Breaks?']")).click();
		Alert al3=driver.switchTo().alert();
		String text=al3.getText();
		System.out.println(text);
		al3.accept();
		Thread.sleep(2000);
		
		driver.findElement(By.id("btn")).click();
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		
		
	
		
		
	}

}
