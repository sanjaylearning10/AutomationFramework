import com.utility.BrowserUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class LoginTestBackUp {
    public static void main(String[] args) {

        ChromeOptions chromeOptions=new ChromeOptions();
         WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.get("http://www.automationpractice.pl/index.php");
        driver.manage().window().maximize();

       By loginLocator= By.cssSelector("a.login");
       WebElement loginLocatorElement =driver.findElement(loginLocator);
       loginLocatorElement.click();

       By emailLocator= By.cssSelector("input#email");
        WebElement emailLocatorElement=driver.findElement(emailLocator);
        emailLocatorElement.sendKeys("automationpractise@mailinator.com");

        By passwordLocator= By.cssSelector("input#passwd");
        WebElement passwordLocatorElement=driver.findElement(passwordLocator);
        passwordLocatorElement.sendKeys("Passw0rd");

        By signInLocator= By.cssSelector("button#SubmitLogin");
        WebElement signInLocatorElement=driver.findElement(signInLocator);
        signInLocatorElement.click();

        driver.close();


    }


}
