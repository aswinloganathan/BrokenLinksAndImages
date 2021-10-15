import java.io.IOException;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrokenImageLinks {
    
    protected static WebDriver driver;
    public static int statusCode = 200;
    
    public static void main(String[] args) throws MalformedURLException, IOException {
        // TODO Auto-generated method stub
        
    	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver1.exe");
    	ChromeOptions option = new ChromeOptions();
    	option.addArguments("--disable-notifications");
    	option.addArguments("--incognito ");
    	option.addArguments("--headless");
    	option.addArguments("--start-maximized"); 
    	 
    	driver = new ChromeDriver(option);
		driver.get("https://www.drlinkcheck.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		VerifyBrokenLinkImage.verifylinks();
		
		driver.quit();
    }
}