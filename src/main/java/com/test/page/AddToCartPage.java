/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.page;

import static com.test.page.BasePage.waitAndGetText;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author kentvanlim
 */
public class AddToCartPage extends BasePage {

    String text = "";

    public void pilihItem(WebDriverWait wait) {

        try {
            waitAndThenClick(wait, BasePage.ByLocator.xpath, "(//div[@class=\"bl-thumbnail--slider\"])[3]");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addToCart(WebDriverWait wait) {
        try {
            waitAndThenClick(wait, BasePage.ByLocator.xpath, "//button[contains(@class,'action__cart')]");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void buttonCheckKeranjang(WebDriverWait wait) {
        try {
            waitAndThenClick(wait, BasePage.ByLocator.xpath, " //button[contains(text(),'Lihat Keranjang')]");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String extractNamaItem(WebDriverWait wait) {
        try {
            text = waitAndGetText(wait, BasePage.ByLocator.xpath, "//h1[contains(@class,'product__title')]");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;

    }

    public String extractNamaItemKeranjang(WebDriverWait wait) {
        try {
            text = waitAndGetText(wait, BasePage.ByLocator.xpath, "//span[contains(@class,'item-name')]");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;

    }
}
