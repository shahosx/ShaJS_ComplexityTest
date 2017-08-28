
//	void login ()  {
//		driver.findElement(By.xpath("//*[text(),'Sign In']")).click();
//		driver.findElement(By.name("email")).sendKeys("shahadat_h@outlook.com");
//		driver.findElement(By.name("password")).sendKeys("shapol123");
//		driver.findElement(By.name("submitted")).click();
//	}
package JsComplexity;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JsComplexityBoundry {
	

@Test (priority =1)
public void BoundryBelow() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\BrowserDriver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://localhost:3031");
	
	
String VerifyTitle = driver.getTitle();
Assert.assertEquals(VerifyTitle, "JS Complexity"); //title verify
driver.findElement(By.id("jsinput")).sendKeys(Keys.chord(Keys.CONTROL, "a"), " ");
driver.findElement(By.id("evaluate")).click();
String VerifyWithNoFunction = driver.findElement(By.id("result-number")).getText(); 
Assert.assertEquals(VerifyWithNoFunction, "Please input a JavaScript function");

}
@Test (priority =2)
public void BoundryAbobe() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\BrowserDriver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://localhost:3031");
	
	
String VerifyTitle = driver.getTitle();
Assert.assertEquals(VerifyTitle, "JS Complexity"); //title verify
driver.findElement(By.id("jsinput")).sendKeys("function a(x) { if (true) {return 'if';} else if (false) { return x+1;  } else {return 4}}"); //sending empty function
driver.findElement(By.id("evaluate")).click();
String VerifyWithExtraFunction = driver.findElement(By.id("result-number")).getText(); 
Assert.assertEquals(VerifyWithExtraFunction, "Only a single JavaScript function is permitted");

}@Test (priority =3)
public void VerifyHistoryButton () throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\BrowserDriver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://localhost:3031");
	
	
String VerifyTitle = driver.getTitle();
Assert.assertEquals(VerifyTitle, "JS Complexity"); //title verify
driver.findElement(By.id("evaluate")).click();
driver.findElement(By.id("clear-history")).isDisplayed(); //verify clear history button

}
}
