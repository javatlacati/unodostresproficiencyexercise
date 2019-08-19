package com.github.javatlacati.unodostres.pages.pagesections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreditCard {
    @FindBy(xpath = "//form[@id='payment-form']/div/div/div/div/input[@name='cardname']")
    private WebElement cardName;
    @FindBy(xpath = "//form[@id='payment-form']/div/div/div/div/div/input[@name='cardno']")
    private WebElement cardNumber;
    @FindBy(xpath = "//form[@id='payment-form']/div/div/div/div/div/input[@name='expmonth']")
    private WebElement month;
    @FindBy(xpath = "//form[@id='payment-form']/div/div/div/div/div/input[@name='expyear']")
    private WebElement date;
    @FindBy(xpath = "//form[@id='payment-form']/div/div/div/div/input[@name='cvvno']")
    private WebElement cvv;
    @FindBy(xpath = "//form[@id='payment-form']/div/div/div/input[@name='txtEmail']")
    private WebElement email;
    @FindBy(id = "paylimit")//, xpath = "//button[@id='paylimit']"
    private WebElement payButton;


    public void setCreditCardName(WebDriver driver, String fieldValue) {
        writeContentForTextField(fieldValue, cardName);
    }

    public void setCardNumber(String fieldValue) {
        writeContentForTextField(fieldValue, cardNumber);
    }

    public void setMonth(String fieldValue) {
        writeContentForTextField( fieldValue, month);
    }

    public void setDate(String fieldValue) {
        writeContentForTextField( fieldValue, date);
    }

    public void setCvv(String fieldValue) {
        writeContentForTextField(fieldValue, cvv);
    }

    public void setEmail(String fieldValue) {
        writeContentForTextField(fieldValue, email);
    }

    private static void writeContentForTextField(String fieldValue, WebElement textField) {
        textField.click();
        textField.sendKeys(fieldValue);
    }

    private static void writeContentForTextFieldWithWait(WebDriver driver, String fieldValue, WebElement textField) {
        textField.click();
        textField.sendKeys(fieldValue);
    }

    public void clickPayButton(WebDriver driver) {
        payButton.click();
    }
}
