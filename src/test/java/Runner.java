
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.test.page.BasePage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import com.test.helper.WebDriverUtil;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import java.io.File;
import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Runner {

    WebDriverUtil util = new WebDriverUtil();
    static Config conf = ConfigFactory.parseFile(new File("conf/Data.conf"));

    WebDriver driver = util.Browser();
    WebDriverWait wait = new WebDriverWait(driver, 20, 4000);

    BasePage func = new BasePage();

    String result="";
    
    
    @BeforeTest
    public void setupTest() {
        driver.get("https://www.facebook.com/");
        driver.manage().window().fullscreen();
    }
    
   

    @AfterTest
    public void tearDown() {
        driver.quit();
        
    }

}
