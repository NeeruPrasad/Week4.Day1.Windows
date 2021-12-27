package week4.day1;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);

		driver.get("https://dev58465.service-now.com/login.do?user_name=admin&sys_action=sysverb_login&user_password=Qu9OFQlQvn7z");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Sakisis@123");
		driver.findElement(By.id("sysverb_login")).click();
		driver.findElement(By.id("filter")).sendKeys("incident");
		driver.findElement(By.xpath("//div[@class='sn-widget-list-title' and text()='Incidents']")).click();
		driver.switchTo().frame("gsft_main");
		WebElement all=driver.findElement(By.xpath("//span[@id='incident_breadcrumb']/a[@class='breadcrumb_link']"));
		Actions builder=new Actions(driver);
		builder.moveToElement(all).click().perform();

		driver.findElement(By.id("sysverb_new")).click();
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		Set<String> windowHandles=driver.getWindowHandles();
		List<String> handles=new ArrayList<String>(windowHandles);
		driver.switchTo().window(handles.get(2));
		driver.findElement(By.xpath("//table[@id='sys_user_table']//tr[1]/td[3]/a")).click();
		driver.switchTo().window(handles.get(1));
		driver.switchTo().frame("gsft_main");
	
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("Not connecting");
		
		String incidentNo=driver.findElement(By.id("incident.number")).getAttribute("value");

		//System.out.println(incidentNo);
		
		driver.findElement(By.id("sysverb_insert")).click();
		
		
		WebElement e=driver.findElement(By.xpath("//div[@role='search']/input"));
		e.sendKeys(incidentNo);
		e.sendKeys(Keys.ENTER);
		String s=driver.findElement(By.xpath("(//table[@id='incident_table']//tr[1]/td[2])/a")).getAttribute("data-original-title");
		if(s.contains(incidentNo))
		{
			System.out.println("Incident created successfully");
		}
		else
			System.out.println("Incident not created");
		File source=driver.getScreenshotAs(OutputType.FILE);
		File destination=new File("./incident.png");
		FileUtils.copyFile(source, destination);
		
		
	}

}
