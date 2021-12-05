/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.page;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import java.io.File;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author kentvanlim
 */
public class LoginAndRegisterPage extends BasePage {

    static Config conf = ConfigFactory.parseFile(new File("conf/Credential.conf"));
    Boolean status = null;

    public void pilihDaftar(WebDriverWait wait) {
        
        try {
            waitAndThenClick(wait, ByLocator.xpath, "//p[contains(text(),'Daftar')]");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickButtonFormDaftar(WebDriverWait wait) {
        try {
            waitAndThenClick(wait, ByLocator.xpath, "//span[contains(text(),'Daftar')]");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pilihLogin(WebDriverWait wait) {
        
        try {
            waitAndThenClick(wait, ByLocator.cssSelector, ".te-header-login");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendEmailToFacebook(WebDriverWait wait) {
        
        try {
            waitAndThenInputData(wait, ByLocator.xpath, "//input[@id=\"email\"]", conf.getString("Account.email"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void clickGoogleLogin(WebDriverWait wait) {
        try {
            waitAndThenClick(wait, ByLocator.cssSelector, ".qa--btn-google");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void clickGoogleSignup(WebDriverWait wait) {
        try {
            waitAndThenClick(wait, ByLocator.cssSelector, ".icon-google");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  
    public void lanjutkanDenganAkunFacebook(WebDriverWait wait) {
        try {
            waitAndThenClick(wait, ByLocator.xpath, "//span[contains(text(),'Lanjutkan sebagai'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void inputEmailGoogleLogin(WebDriverWait wait) {
        
        try {
            waitAndThenInputData(wait, ByLocator.xpath, " //input[@type=\"email\"]", conf.getString("Account.email"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public void inputEmailDaftarGoogle(WebDriverWait wait) {
        
        try {
            waitAndThenInputData(wait, ByLocator.xpath, " //input[@type=\"email\"]", conf.getString("Account.emailNotRegistered"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void sendPasswordToGoogle(WebDriverWait wait) {
        
        try {
            waitAndThenInputData(wait, ByLocator.xpath, " //input[@type=\"password\"]", conf.getString("Account.password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void clickLanjutkanSetelahEmailGoogle(WebDriverWait wait) {
        try {
            waitAndThenClick(wait, ByLocator.xpath, "//span[contains(text(),'Berikutnya')]");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void clickFaceBookLogin(WebDriverWait wait) {
        try {
            waitAndThenClick(wait, ByLocator.cssSelector, ".qa--btn-facebook");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void sendPasswordToFacebook(WebDriverWait wait) {
        try {
            waitAndThenInputData(wait, ByLocator.name, "pass", "Bapakmu123");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void clickButtonLogin(WebDriverWait wait) {
        try {
            waitAndThenClick(wait, ByLocator.name, "login");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void verifikasiLogin(WebDriverWait wait) {
        try {
            waitAndThenClick(wait, ByLocator.xpath, "//p[contains(text(),'Verifikasi Login')]");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String isAvatarShownAfterLogin(WebDriverWait wait) {
        try {
            status = isElementVisible(wait, ByLocator.xpath, "//img[@class=\"bl-avatar__img\"]");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(status);
    }
     public String daftarNoHandphone(WebDriverWait wait) {
        try {
              waitAndThenInputData(wait, ByLocator.xpath, "//input[contains(@aria-label,\"Nomor handphone \")]",conf.getString("Account.phoneNumber"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(status);
    }
    
}
