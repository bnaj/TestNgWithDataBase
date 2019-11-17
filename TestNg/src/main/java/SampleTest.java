import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import sample.database.dao.AdressDao;
import sample.database.dao.UserDao;
import sample.database.entities.Adress;
import sample.database.entities.User;

public class SampleTest extends SampleBaseDriver {

    User userData;
    Adress adressData;
    PageObject object;

    /**
     * In this method we initialize data from data base.
     */
    @BeforeClass(description = "Initialize data")
    public void step00(){
        object = new PageObject(driver.getWebDriver());
        userData = new UserDao().getUserById(1,"testData");
        adressData = new AdressDao().getAdressByUserId(2,"testData");
    }

    /**
     * Simple test method we use are getter from address clase to get address.
     */
    @Test(description = "Going to site")
    public void step01() {
        driver.getWebDriver().get(adressData.getFirst());
    }

    /**
     * Simple test method like  above. But we use are getter from user clase to get address.
     */
    @Test(description = "Send data from base")
    public void step02(){
        customMethods.sendKeys(object.sub, userData.getLogin());
    }
}
