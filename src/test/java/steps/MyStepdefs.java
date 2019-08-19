package steps;

import com.github.javatlacati.unodostres.pages.Home;
import com.github.javatlacati.unodostres.pages.Payment;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

//import cucumber.annotation.en.And;
//import cucumber.annotation.en.Given;
//import cucumber.annotation.en.Then;
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;

public class MyStepdefs {

    /**
     * Selenium web Driver instance to use
     */
    private WebDriver driver;

    /**
     * Home page
     */
    private Home home;
    /**
     * Pament page
     */
    private Payment payment;

//    public MyStepdefs() {
//        String path = "/Tools/WebDriver/chromedriver.exe";
//        System.out.println(path);
//        System.setProperty("webdriver.chrome.driver", path);


//    }

    @Given("^I open the broser \'([A-Za-z ]+)\'$")
    public void iOpenTheBroserSpecified(String browserName) {
        String lower = browserName.toLowerCase();
        switch (lower) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
        }
        home = PageFactory.initElements(driver, Home.class);
    }

    @Then("^I go to home page$")
    public void iGoToHomePage() {
        home.go(driver);
    }

    @Then("^under recarga celluar select operator as '([A-Za-z&]+)' from operador field$")
    public void underRecargaCelluarSelectOperatorAsTelecelFromOperadorField(String operator) {
        home.selectOperator(driver, operator);
    }

    @And("^Give this number ([\\d]+) under numero de celluar field$")
    public void giveThisNumberUnderNumeroDeCelluarField(String telephone) {
        home.specifyTelephoneNumber(telephone);
    }

    @And("^under  monte de recharga select (\\d+) dollar normal recharge$")
    public void underMonteDeRechargaSelectDollarNormalRecharge(int mount) {
        home.selectRechargeAmount(driver, mount);
    }

    @And("^click on siguiente$")
    public void clickOnSiguiente() {
        home.clickRefillNextButton();
    }

    @And("accept warning")
    public void acceptWarning() {
        home.acceptRefillWarning(driver);
    }

    @Then("^Verify if the user able to reach to the next screen or not\\(Payment screen\\)$")
    public void verifyIfTheUserAbleToReachToTheNextScreenOrNotPaymentScreen() {
        payment = PageFactory.initElements(driver, Payment.class);
        assertEquals(payment.getURL(), driver.getCurrentUrl());
    }

    @Then("^On payment screen click on ([A-Za-z ]+)$")
    public void onPaymentScreenClickOnTarjeta(String paymentOption) {
        payment.selectPaymentType(driver, paymentOption);
    }

    @Then("^enter the following details$")
    public void enterTheFollowingDetails(DataTable table) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.withTimeout(3, TimeUnit.SECONDS).until(ExpectedConditions.elementToBeClickable(By.id("payment-form")));
        table.asMaps()
                .forEach(row ->
                        row.forEach(
                                (fieldName, fieldVale) ->
                                {
                                    try {
                                        payment.enterCreditCardField(driver, fieldName, fieldVale);
                                    } catch (NoSuchFieldException e) {
                                        e.printStackTrace();
                                        fail(e.getMessage() + ":" + fieldName);
                                    }
                                }
                        )
                );
    }

    @Then("^Click on pagar con tarjeta to do the recharge$")
    public void clickOnPagarConTarjetaToDoTheRecharge() {
        payment.clickPayWithCard(driver);
    }

    @And("^verify if the recharge is success or not$")
    public void verifyIfTheRechargeIsSuccessOrNot() {
        driver.close();
    }
}
