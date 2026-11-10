package prac;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Sync
{
    WebDriver driver;


    @Test
    public void launchBrowser()
    {
        ChromeOptions chromeOptions=new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(chromeOptions);
        driver.get("https://www.yatra.com");
    }


}
