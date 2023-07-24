package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;

public class TestStepDefinition {
	
	public WebDriver driver=null;
		
	@Given("^Launch kayak website$")
	public void launch_kayak_website() throws Exception {
		// Comment14
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.kayak.ch");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  //Implicit wait	
		driver.findElement(By.className("_ixe")).click();
		Thread.sleep(5000);
	}
	
	// From Airport is Mumbai (BOM)
	@Given("^Select from airport$")
	public void select_from_airport() throws Exception {		
		// Select FROM Airport
		driver.findElement(By.className("vvTc-item-close")).click();	
		driver.findElement(By.className("k_my-input")).click();
		driver.findElement(By.className("k_my-input")).sendKeys("Mumbai (BOM)");
		Thread.sleep(2000);
		driver.findElement(By.className("k_my-input")).sendKeys(Keys.ENTER);
	}
	
	// To Airport is Kolkata (CCU)
	@Given("^Select to airport$")
	public void select_to_airport() throws Exception {	
		// Select TO Airport
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/main/div[1]/div[1]/div/div[1]/div/div/section[2]/div/div/div/div/div/div[1]/div[2]/div/div[3]/div/div/div[2]")).click();
		driver.findElement(By.className("k_my-input")).sendKeys("Kolkata (CCU)");
		Thread.sleep(2000);
		driver.findElement(By.className("k_my-input")).sendKeys(Keys.ENTER);
	}
	
	// start date 12 oct 2021
	@Given("^Select start date$")
	public void select_start_date() throws Exception {				
		// Select START date
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='cQtq-input']")).click();
		driver.findElement(By.xpath("//div[@aria-label='12. Oktober 2021']")).click();
	}
	
	// end date 28 oct 2021
	@Given("^Select end date$")
	public void select_end_date() throws Exception {			
		// Select END date
		driver.findElement(By.xpath("//div[@aria-label='28. Oktober 2021']")).click();
	}
	
	@Given("^Click search button$")
	public void click_search_button() throws Exception {	
		// Click search button
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/main/div[1]/div[1]/div/div[1]/div/div/section[2]/div/div/div/div/div/div[1]/div[2]/div/div[5]/button")).click();
	}
	
	@Given("^scroll down$")
	public void scroll_down() throws Exception {
		// Scroll down and click on arrow button in Price
		Thread.sleep(5000);
		String js_command="window.scroll(0,1800)";
		JavascriptExecutor js_driver=(JavascriptExecutor)driver;
		js_driver.executeScript(js_command);
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/main/div[2]/div[2]/div[2]/div/div[1]/div/div[3]/div/div[2]/div[1]/div[14]/div/div[1]/div/div")).click();
	}
	
	// Max price -100 slide from the maximum price
	@Given("^drag price slider left$")
	public void drag_price_slider_left() throws Exception {
		// Drag price slider left
		Thread.sleep(2000);
		WebElement slider=driver.findElement(By.xpath("//div[@aria-label='Maximalpreis']"));
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(slider, -100, 0).perform();
	}
}
		
