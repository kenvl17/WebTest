/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.page;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author kentvanlim
 */
public class BasePage {

    static Config conf = ConfigFactory.parseFile(new File("conf/RunnerConf.conf"));
    public static Properties prop;
    public static WebDriver driver;

    public static enum ByLocator {
        xpath, cssSelector, name
    };

    public static void waitAndThenClick(WebDriverWait wait, ByLocator loc, String locator) {
        try {
            switch (loc) {
                case xpath:
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator))).click();
                    break;

                case cssSelector:
                    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator))).click();
                    break;

                case name:
                    wait.until(ExpectedConditions.elementToBeClickable(By.name(locator))).click();
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Boolean isElementVisible(WebDriverWait wait, ByLocator loc, String locator) {
        Boolean status = null;
        try {
            switch (loc) {
                case xpath:
                    status = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator))).isDisplayed();
                    break;

                case cssSelector:
                    status = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator))).isDisplayed();
                    break;

                case name:
                    status = wait.until(ExpectedConditions.elementToBeClickable(By.name(locator))).isDisplayed();
                    break;
            }
          
        } catch (Exception e) {
            e.printStackTrace();
        }
          return status;
    }

    public static String waitAndGetText(WebDriverWait wait, ByLocator loc, String locator) {
        String result = "";
        try {
            switch (loc) {
                case xpath:
                    result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).getText();
                    break;

                case cssSelector:
                    result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator))).getText();
                    break;

                case name:
                    result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator))).getText();
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void waitAndThenInputData(WebDriverWait wait, ByLocator loc, String locator, String keyWord) {
        try {
            switch (loc) {
                case xpath:
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).clear();
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).sendKeys(keyWord);
                    break;

                case cssSelector:
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator))).clear();
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator))).sendKeys(keyWord);
                    break;

                case name:
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator))).clear();
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator))).sendKeys(keyWord);
                    break;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static WebDriver Browser() {

        String browserName = conf.getString("DriverConfig.browser");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/kentvanlim/WebBukalapakTest/drivers/chromedriver");
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "/Users/kentvanlim/WebBukalapakTest/drivers/geckodriver");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        return driver;
    }

    public void moveTab(int indexTab, WebDriver driver) {
        try {
            ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(newTb.get(indexTab));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void sleepBeforeAnotherExecutions(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

}
