package com.qualitystream.tutorial.QualityStreamTutorial;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		
		 
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://s1.demo.opensourcecms.com/wordpress/wp-login.php/");
		
	}
	
	@Test
	public void testGooglePage() {
		
		WebElement box = driver.findElement(By.id("user_login"));
		box.clear();
		box.sendKeys("opensourcecms");
		
		WebElement passbox = driver.findElement(By.id("user_pass"));
		passbox.clear();
		passbox.sendKeys("opensourcecms");
		
		WebElement button = driver.findElement(By.xpath("//*[@id=\"wp-submit\"]"));
		try {
			Thread.sleep(5000);
			button.click();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement field = driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/a/div[3]"));
	
		field.click();
		
		WebElement field1 = driver.findElement(By.xpath("//*[@id=\"menu-posts\"]/ul/li[2]/a"));
		
		field1.click();
		
		
		WebElement compare = driver.findElement(By.xpath("//*[@id=\"wpbody-content\"]/div[5]/h1"));
		
		
		assertEquals("Posts", compare.getText());
		
		
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}

}
