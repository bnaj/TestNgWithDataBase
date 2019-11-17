import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

    public WebDriver driver;

    PageObject( WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.ID, using = "address")
    public WebElement sub;
}
