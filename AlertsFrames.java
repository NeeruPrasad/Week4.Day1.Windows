package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsFrames {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert al=driver.switchTo().alert();
		al.sendKeys("Neeraja");
		al.accept();
		String s=driver.findElement(By.xpath("//p[@id='demo']")).getText();
		System.out.println(s);
		if(s.contains("Neeraja"))
		{
			System.out.println("Name Present");
		}
		else
		{
			System.out.println("Not Present");
		}
		
		
		
		
	}
	

}
