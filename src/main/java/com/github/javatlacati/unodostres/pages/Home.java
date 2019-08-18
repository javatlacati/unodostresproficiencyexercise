/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.javatlacati.unodostres.pages;

import com.github.javatlacati.unodostres.pages.elements.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Ruslan López Carro <scherzo16 at gmail.com>
 */
public class Home {
    private final String URL = "http://prueba.undostres.com.mx";
    private PageElement operatorInputField = new PageElement("//div[@class='field']/div/input"); //it can be also //div[@class='form']/ul/li[1]/div/div/input
    private PageElement telephoneInputField = new PageElement("//div[@class='form']/ul/li[2]/div/div/input");
    private PageElement rechargeAmountInputField = new PageElement("//div[@class='form']/ul/li[3]/div/div/input");
    private PageElement refillNextButton = new PageElement("//div[@class='next']/button[@class='button buttonRecharge']");

    public void go(WebDriver driver) {
        driver.get(URL);
    }

    public void selectOperator(WebDriver driver, String operator) {
        WebElement inputField = operatorInputField.getWebElementByXpath(driver);
        inputField.click();
        PageElement operatorFloatingMenu = new PageElement();
        operatorFloatingMenu.setXpathReference("//div[@class='suggestion']/ul/li/a[contains(string(), \"" + operator + "\")]");
        WebElement inputOption = operatorFloatingMenu.getWebElementByXpath(driver);
        inputOption.click();
    }

    public void specifyTelephoneNumber(WebDriver driver, String telephone) {
        WebElement inputField = telephoneInputField.getWebElementByXpath(driver);
        inputField.click();
        inputField.sendKeys(telephone);
    }

    public void selectRechargeAmount(WebDriver driver, int mount) {
        WebElement inputField = rechargeAmountInputField.getWebElementByXpath(driver);
        inputField.click();
        PageElement rechargeAmountFloatingMenuTab = new PageElement("//div[@class=\"suggestion\"]/div/div[contains(string(),'Recarga Saldo')]");
        WebElement tab = rechargeAmountFloatingMenuTab.getWebElementByXpath(driver);
        tab.click();
        PageElement rechargeAmountOption = new PageElement("//li[@data-name=\"" + mount + "\"]/a");// //div[@class='suggestion']/ul[2]/li[@data-name="10"]/a
        WebElement rechargeAmountItem = rechargeAmountOption.getWebElementByXpath(driver);
        rechargeAmountItem.click();
    }

    public void clickRefillNextButton(WebDriver driver) {
        WebElement nextButton = refillNextButton.getWebElementByXpath(driver);
        nextButton.click();
    }
}
