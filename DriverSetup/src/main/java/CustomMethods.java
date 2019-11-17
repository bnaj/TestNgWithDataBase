import org.openqa.selenium.WebElement;

public class CustomMethods {

    private DriverSetup driver;

  public CustomMethods(DriverSetup driver){
        this.driver = driver;
    }

    public void click(WebElement elementToClick){
       elementToClick.click();
    }

    public void sendKeys(WebElement element, String keys) {
        element.sendKeys(keys);
    }
}
