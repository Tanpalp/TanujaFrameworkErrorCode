import com.automationbyTanu.browser.Drivermanager;
import com.automationbyTanu.components.BaseActions;
import com.automationbyTanu.components.ElementsFindBy;
import com.automationbyTanu.components.TestActions;
import com.automationbyTanu.configrationexceptions;
import com.automationbyTanu.properties.propertyloader;
import com.automationbyTanu.properties.propertyvalidator;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class sampletest extends TestActions {


    @Test
    public void loadBrowserTest() throws Exception {
pageactions.typeinto("LoginPage.tbx_Username","Admin");
pageactions.typeinto("LoginPage.tbx_Password","admin123");
        pageactions.clickit("LoginPage.btn_Submit");
        Thread.sleep(4000);
    }
}
