package selenium;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Test {
	
	private ChromeDriver driver = new ChromeDriver();
	
	private boolean isStarted = false;

	private long sleepTime = 3000;
	

	public Test() {
		
		driver.get(
				"https://api.whatsapp.com/send?phone=573188061583"
				+ "&text=I'm%20interested%20in%20your%20car%20for%20sale");
		
		System.out.println(driver.findElementByClassName("block__action").getText());
				
		WebElement element = driver.findElementByClassName("block__action");
		element.click();
		
	}
	
	@SuppressWarnings("unused")
	private void openWhatsapp() {
		/**
		 * wait till whatsapp is loaded after scanning the QR code then type
		 * start in console to start sending messages
		 */
		Scanner sc = new Scanner(System.in);
		String command = sc.next();
		if (!command.equalsIgnoreCase("start")) {
			driver.quit();
			System.exit(1);
		}
		sc.close();

		/**
		 * keep checking for unread count every sleepTime milli secs.
		 * If some elementFound, then click it and set isStarted to true
		 * The while will check for this variable, and then will reply on that element.
		 */
		while (true) {
			try {
				if (isStarted) {

				}

				/**
				 *  get the user who just pinged, whose 'unread-count' will be 1 or more
				 */
				List<WebElement> nonSelectedWindows = driver.findElements(By
						.xpath("//span[contains(@class,'unread-count')]"));
				if (nonSelectedWindows==null) {
					isStarted = true;
				} else {

					System.out.println(driver.getTitle());
					System.out.println(driver.findElementByClassName("_2lkdt").getText());
					
					Thread.sleep(sleepTime);
					
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}

		driver.quit();
	}


	public static void main(String[] args) {
		
		/*
		ChromeDriver driver = new ChromeDriver();


		driver.get(
				"https://api.whatsapp.com/send?phone=573118471788&text=I'm%20interested%20in%20your%20car%20for%20sale");
	
		
		System.out.println(driver.findElementByClassName("block__action").getText());
		
	
		WebElement element = driver.findElementByClassName("block__action");
		
		
		element.click();
		*/
		
		/**
		 * // Enter something to search for element.sendKeys("java");
		 * 
		 * // Now submit the form. WebDriver will find the form for us from the
		 * element element.submit();
		 * 
		 * // Check the title of the page System.out.println("Page title is: " +
		 * driver.getTitle());
		 * 
		 * // Google's search is rendered dynamically with JavaScript. // Wait
		 * for the page to load, timeout after 10 seconds (new
		 * WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
		 * public Boolean apply(WebDriver d) { return
		 * d.getTitle().toLowerCase().startsWith("java"); } });
		 * 
		 * 
		 * System.out.println("Page title is: " + driver.getTitle());
		 * 
		 * //Close the browser driver.quit();
		 **/
		
		Test web = new Test();
		web.openWhatsapp();
	}

}
