/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.page;

import static com.test.page.BasePage.waitAndThenInputData;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author kentvanlim
 */
public class SearchPage extends BasePage {

    String text = "";

    public void inputKeyWordToSearch(WebDriverWait wait, String keywords) {

        try {
            waitAndThenInputData(wait, BasePage.ByLocator.name, "search[keywords]", keywords);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String validateHasilPencarian(WebDriverWait wait) {

        try {
            text = waitAndGetText(wait, BasePage.ByLocator.xpath, "//div//p[contains(text(),'Hasil pencarian')]//following-sibling::h1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    public void searchIcon(WebDriverWait wait) {

        try {
            waitAndThenClick(wait, BasePage.ByLocator.xpath, "//button[@type='submit']");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
