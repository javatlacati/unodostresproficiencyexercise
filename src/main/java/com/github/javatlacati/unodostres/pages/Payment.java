package com.github.javatlacati.unodostres.pages;

import com.github.javatlacati.unodostres.pages.pagesections.CreditCard;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Abstraction that holds data and available operations on the site payment page.
 *
 * @author Ruslan López Carro <scherzo16 at gmail.com>
 */
public class Payment {
    @Getter
    private final String URL;

    @FindBy(xpath = "//div[@class='list-group']/a[contains(@class,'select-card')]")
    private WebElement cardPaymentType;
    private CreditCard creditCardSection;

    public Payment() {
        URL = "https://prueba.undostres.com.mx/payment.php";
    }

    public void selectPaymentType(WebDriver driver, String paymentOption) throws NoSuchFieldError {
        String lowercasedPaymentOption = paymentOption.toLowerCase();
        switch (lowercasedPaymentOption) {
            case "tarjeta": {
                cardPaymentType.click();
                break;
            }
            default:
                throw new NoSuchFieldError("The payment type is not suported");
        }
    }

    public void enterCreditCardField(WebDriver driver, String fieldName, String fieldValue) throws NoSuchFieldException {
        String loweredFieldName = fieldName.toLowerCase();
        creditCardSection = PageFactory.initElements(driver, CreditCard.class);
        switch (loweredFieldName) {
            case "card name":
                creditCardSection.setCreditCardName(driver, fieldValue);
                break;
            case "card number":
                creditCardSection.setCardNumber(fieldValue);
                break;
            case "month":
                creditCardSection.setMonth(fieldValue);
                break;
            case "date":
                creditCardSection.setDate(fieldValue);
                break;
            case "cvv":
                creditCardSection.setCvv(fieldValue);
                break;
            case "correo electronico":
                creditCardSection.setEmail(fieldValue);
                break;
            default:
                throw new NoSuchFieldException("the specified field is not  standard field for this section (" + loweredFieldName + "," + fieldValue + ")");
        }
    }

    public void clickPayWithCard(WebDriver driver) {
        creditCardSection.clickPayButton(driver);
    }
}
