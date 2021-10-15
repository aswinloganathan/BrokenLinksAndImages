import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class VerifyBrokenLinkImage extends BrokenImageLinks {
	
	public static void verifylinks() throws IOException {
		
		List<WebElement> linksElementsGot = driver.findElements(By.tagName("a"));
		List<WebElement> imageElementsGot = driver.findElements(By.tagName("img"));
		linksElementsGot.addAll(imageElementsGot);
		
		System.out.println("No of Links :"+linksElementsGot.size());
		
		for (int i = 1; i < linksElementsGot.size(); i++) {
			//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", i);
			String linksGot = linksElementsGot.get(i).getAttribute("href");
			System.out.println("Link got :"+linksGot);
			if (linksGot == null || linksGot.isEmpty()) {
				continue;
			}
			URL links = new URL(linksGot);
			HttpURLConnection request= (HttpURLConnection)links.openConnection();
			//request.setRequestMethod("HEAD");
			request.connect();
			int statusCodeGot = request.getResponseCode();
			if (statusCodeGot == statusCode) {
				System.out.println("URL is:"+linksGot +" Status Code Is:"+statusCodeGot+ " and link is working Fine");
			}
			else if (statusCodeGot >= 400 && statusCodeGot <= 499) {
				System.out.println("URL is:"+linksGot +" Status Code Is:"+statusCodeGot+ " and link is not working fine");
			}	
		}
	}
		
}
