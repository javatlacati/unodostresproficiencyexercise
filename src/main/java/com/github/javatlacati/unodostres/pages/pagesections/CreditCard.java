package com.github.javatlacati.unodostres.pages.pagesections;

import com.github.javatlacati.unodostres.pages.elements.PageElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreditCard {
    private PageElement cardName;
    private PageElement cardNumber;
    private PageElement month;
    private PageElement date;
    private PageElement cvv;
    private PageElement email;
    private PageElement payButton;


    public CreditCard() {
        cardName = PageElement
                .builder()
                .xpathReference("//form[@id='payment-form']/div/div/div/div/input[@name='cardname']")
                .name("cardname")
                .build();
        cardNumber = PageElement
                .builder()
                .xpathReference("//form[@id='payment-form']/div/div/div/div/input[@name='cardno']")
                .name("cardno")
                .build();
        month = PageElement
                .builder()
                .xpathReference("//form[@id='payment-form']/div/div/div/div/input[@name='expmonth']")
                .name("expmonth")
                .build();
        date = PageElement
                .builder()
                .name("expyear")
                .build();
        cvv = PageElement
                .builder()
                .name("cvvno")
                .build();
        email = PageElement
                .builder()
                .name("txtEmail")
                .build();
        payButton = PageElement
                .builder()
                .xpathReference("//button[@id='paylimit']")
                .id("paylimit")
                .build();
    }

    public void setCreditCardName(WebDriver driver, String fieldValue) {
        writeContentForTextField(driver, fieldValue, cardName);
    }

    public void setCardNumber(WebDriver driver, String fieldValue) {
        writeContentForTextFieldWithWait(driver, fieldValue, cardNumber);
    }

    public void setMonth(WebDriver driver, String fieldValue) {
        writeContentForTextField(driver, fieldValue, month);
    }

    public void setDate(WebDriver driver, String fieldValue) {
        writeContentForTextField(driver, fieldValue, date);
    }

    public void setCvv(WebDriver driver, String fieldValue) {
        writeContentForTextField(driver, fieldValue, cvv);
    }

    public void setEmail(WebDriver driver, String fieldValue) {
        writeContentForTextField(driver, fieldValue, email);
    }


    private static void writeContentForTextField(WebDriver driver, String fieldValue, PageElement textField) {
        WebElement inputField = textField.getWebElementByName(driver);
        inputField.click();
        inputField.sendKeys(fieldValue);
    }

    private static void writeContentForTextFieldWithWait(WebDriver driver, String fieldValue, PageElement textField) {
        WebElement inputField = textField.getWebElementByNameWithWait(driver);
        inputField.click();
        inputField.sendKeys(fieldValue);
    }

    public void clickPayButton(WebDriver driver) {
        WebElement button = payButton.getWebElementById(driver);
        button.click();
    }
}
