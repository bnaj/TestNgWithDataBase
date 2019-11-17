import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {

    private WebDriver webDriver;

    public DriverSetup() {
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    DriverSetup(String selectBrowser, String driverVersion){
        this.webDriver = generator(selectBrowser, driverVersion);
    }

    private WebDriver generator(String selectBrowser, String driverVersion){
        WebDriver driver = null;

        switch(selectBrowser){
            //"77.0.3865.40"
            case "chrome":
                WebDriverManager.chromedriver().version(driverVersion).setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().version(driverVersion).setup();
                driver = new FirefoxDriver();
                break;
        }
        return driver;
    }
}
