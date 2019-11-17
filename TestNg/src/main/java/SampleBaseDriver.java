import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class SampleBaseDriver extends DriverSetup {
DriverSetup driver;
CustomMethods customMethods;

    public SampleBaseDriver(String selectBrowser, String driverVersion) {
        super(selectBrowser, driverVersion);
    }

    public SampleBaseDriver(){
        customMethods = new CustomMethods(this);
    }

    @Parameters({"browser"})
    @BeforeClass(description = "Initializing webdriver")
    public void setup(@Optional("firefox") String browser){
        driver = new DriverSetup("firefox","");
     }
}
