/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.javatlacati.unodostres.pages;

import com.github.javatlacati.unodostres.pages.elements.PageElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Abstraction that holds data and available operations on the site home page.
 *
 * @author Ruslan López Carro <scherzo16 at gmail.com>
 */
public class Home {
    private final String URL = "http://prueba.undostres.com.mx";
    @FindBy(xpath = "//div[@class='field']/div/input") //it can be also //div[@class='form']/ul/li[1]/div/div/input
    private WebElement operatorInputField;
    @FindBy(xpath = "//div[@class='form']/ul/li[2]/div/div/input")
    private WebElement telephoneInputField;
    @FindBy(xpath = "//div[@class='form']/ul/li[3]/div/div/input")
    private WebElement rechargeAmountInputField;
    @FindBy(xpath = "//div[@class='next']/button[@class='button buttonRecharge']")
    private WebElement refillNextButton;

    public void go(WebDriver driver) {
        driver.manage().deleteAllCookies();
        driver.get(URL);
    }

    public void selectOperator(WebDriver driver, String operator) {
        operatorInputField.click();
        PageElement operatorFloatingMenu =
                PageElement
                        .builder()
                        .xpathReference("//div[@class='suggestion']/ul/li/a[contains(string(), \"" + operator + "\")]")
                        .build();
        WebElement inputOption = operatorFloatingMenu.getWebElementByXpath(driver);
        inputOption.click();
    }

    public void specifyTelephoneNumber(String telephone) {
        telephoneInputField.click();
        telephoneInputField.sendKeys(telephone);
    }

    public void selectRechargeAmount(WebDriver driver, int mount) {
        rechargeAmountInputField.click();
        PageElement rechargeAmountFloatingMenuTab =
                PageElement
                        .builder()
                        .xpathReference("//div[@class=\"suggestion\"]/div/div[contains(string(),'Recarga Saldo')]")
                        .build();
        WebElement tab = rechargeAmountFloatingMenuTab.getWebElementByXpath(driver);
        tab.click();
        PageElement rechargeAmountOption =
                PageElement
                        .builder()
                        .xpathReference("//li[@data-name=\"" + mount + "\"]/a")// //div[@class='suggestion']/ul[2]/li[@data-name="10"]/a
                        .build();
        WebElement rechargeAmountItem = rechargeAmountOption.getWebElementByXpath(driver);
        rechargeAmountItem.click();
    }

    public void clickRefillNextButton() {
        refillNextButton.click();
    }

    public void acceptRefillWarning(WebDriver driver) {
        PageElement buttonOnWarningMessage =
                PageElement
                        .builder()
                        .xpathReference("//div[@class='modal-dialog']/div/div/button[contains(string(),'Continuar')]")
                        .build();

        WebElement continueButton = buttonOnWarningMessage.getWebElementByXpathWithWait(driver);
        continueButton.click();
    }
}
