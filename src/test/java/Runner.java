
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.test.page.BasePage;
import com.test.page.LoginAndRegisterPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import com.test.helper.WebDriverUtil;
import com.test.page.AddToCartPage;
import com.test.page.SearchPage;
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
    LoginAndRegisterPage log = new LoginAndRegisterPage();
    SearchPage sc = new SearchPage();
    AddToCartPage add = new AddToCartPage();
    String result="";
    
    
    @BeforeTest
    public void setupTest() {
        driver.get("https://www.bukalapak.com/");
        driver.manage().window().fullscreen();
    }
    
    @Test(enabled = false)
    public void testLoginWithFaceBook() {
        log.clickFaceBookLogin(wait);
        func.moveTab(1, driver);
        log.sendEmailToFacebook(wait);
        log.sendPasswordToFacebook(wait);
        log.clickButtonLogin(wait);
        log.lanjutkanDenganAkunFacebook(wait);
    }
    
    @Test(enabled = false)
    public void testRegisterWithFacebook() {
        log.clickFaceBookLogin(wait);
        func.moveTab(1, driver);
        log.sendEmailToFacebook(wait);
        log.sendPasswordToFacebook(wait);
        log.clickButtonLogin(wait);
        log.lanjutkanDenganAkunFacebook(wait);
    }
    
   @Test(dependsOnMethods = {"testLoginWithGmail"})
    public void testSearchItem() {
        sc.inputKeyWordToSearch(wait,conf.getString("Data.keywordsSearch"));
        sc.searchIcon(wait);
        Assert.assertEquals(sc.validateHasilPencarian(wait),conf.getString("Data.keywordsResult"));
    }

    @Test(dependsOnMethods = {"testSearchItem"})
    public void testAddToBag() {
        add.pilihItem(wait);
        result = add.extractNamaItem(wait);
        add.addToCart(wait);
        add.buttonCheckKeranjang(wait);
        Assert.assertEquals(add.extractNamaItemKeranjang(wait),result);
    }
    @Test(enabled = false)
    public void testRegisterWithGoogle() {
        log.pilihDaftar(wait);
        log.clickGoogleSignup(wait);
        func.moveTab(1,driver);
        log.inputEmailDaftarGoogle(wait);
        log.clickLanjutkanSetelahEmailGoogle(wait);
        log.sendPasswordToGoogle(wait);
    }
    @Test
    public void testLoginWithGmail() {
        log.pilihLogin(wait);
        log.clickGoogleLogin(wait);
        func.moveTab(1, driver);
        log.inputEmailGoogleLogin(wait);
        log.clickLanjutkanSetelahEmailGoogle(wait);
        log.sendPasswordToGoogle(wait);
        log.clickLanjutkanSetelahEmailGoogle(wait);
        func.moveTab(0, driver);
        Assert.assertEquals(log.isAvatarShownAfterLogin(wait), "true");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();

    }

}
