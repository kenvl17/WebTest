/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.helper;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

/**
 *
 * @author kentvanlim
 */
public class WebDriverUtil {
    static Config conf = ConfigFactory.parseFile(new File("conf/RunnerConf.conf"));
    WebDriver driver;
    
     public WebDriver Browser(){
		
		String browserName = conf.getString("DriverConfig.browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","/Users/kentvanlim/WebBukalapakTest/drivers/chromedriver");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver","/Users/kentvanlim/NetBeansProjects/compass/driver/geckodriver");
   	
			driver = new FirefoxDriver(); 
		}
	
		
		return driver;
	}
}
