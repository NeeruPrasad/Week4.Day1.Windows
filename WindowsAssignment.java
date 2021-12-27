package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsAssignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);

		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("home")).click();
		Set<String> windowHandles=driver.getWindowHandles();
		List<String> handles=new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(handles.get(2));
		driver.findElement(By.xpath("//h5[text()='Window']/..")).click();
		driver.switchTo().window(handles.get(2)).close();
		
		
		//System.out.println(handles.size());
		
		
		driver.switchTo().window(handles.get(1));
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		
		Set<String> windowHandles1=driver.getWindowHandles();
		List<String> handles1=new ArrayList<String>(windowHandles1);
		System.out.println("Number of windows opened= "+handles1.size());
		
		for(int i=handles1.size()-1;i>1;i--)
		{
			driver.switchTo().window(handles1.get(i)).close();
			
		}
		
		
	
		
		driver.switchTo().window(handles1.get(1));
		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
		
		Set<String> windowHandles2=driver.getWindowHandles();
		List<String> handles2=new ArrayList<String>(windowHandles2);
		
		//System.out.println(handles2.size());
		for(int i=handles2.size()-1;i>1;i--)
		{
			driver.switchTo().window(handles2.get(i)).close();
			
		}
		
		driver.switchTo().window(handles2.get(1));
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		Set<String> windowHandles3=driver.getWindowHandles();
		List<String> handles3=new ArrayList<String>(windowHandles3);
		
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.numberOfWindowsToBe(handles3.size()));
	
		
		
		//System.out.println(handles3.size());
		
		for(int i=handles3.size()-1;i>0;i--)
		{
			driver.switchTo().window(handles3.get(i)).close();
			
		}
		
		
		
		

	}

}
