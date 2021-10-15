
import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webtable {

	public static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/sorttable.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement table = driver.findElement(By.xpath("//table[@id='table_id']//tbody"));
		
//		List<WebElement> allRows = table.findElements(By.tagName("tr"));
//		for(int i=0; i<allRows.size(); i++) {
//			List<WebElement> allcols = allRows.get(i).findElements(By.tagName("td"));
//			WebElement names = allcols.get(1);
//			String nameText = names.getText();
//			System.out.println(nameText);
//		}
		
		
		
		
	}

}
