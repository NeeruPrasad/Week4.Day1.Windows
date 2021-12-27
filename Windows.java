package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windows {

	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		//options.addArguments("--disable-notifications");
		//options.setHeadless(true);
		ChromeDriver driver=new ChromeDriver(options);

		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("FLIGHTS")).click();
		Set<String> windowHandles=driver.getWindowHandles();
		List<String> handles=new ArrayList<String>(windowHandles);
		driver.switchTo().window(handles.get(2));
		String windowTitle=driver.getTitle();
		System.out.println(windowTitle);
		driver.switchTo().window(handles.get(1));
		driver.close();
		
	
		
		
	}
}
