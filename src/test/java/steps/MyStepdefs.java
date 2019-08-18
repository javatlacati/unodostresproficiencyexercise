package steps;

import com.github.javatlacati.unodostres.pages.Home;
//import cucumber.annotation.en.And;
//import cucumber.annotation.en.Given;
//import cucumber.annotation.en.Then;
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyStepdefs {

    private WebDriver driver;
    private WebDriverWait wait;

    Home home;

    public MyStepdefs() {
        String path = "/ambiente/chromedriver.exe";
        System.out.println(path);
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
        home = PageFactory.initElements(driver, Home.class);
    }

    //    @Before
//    public void setUp() throws Exception {
//
//    }

    @Given("^I go to home page$")
    public void iGoToHomePage() {
        home.go(driver);
    }

    @Then("^under recarga celluar select operator as '([A-Za-z&]+)' from operador field$")
    public void underRecargaCelluarSelectOperatorAsTelecelFromOperadorField(String operator) {
        home.selectOperator(driver,operator);
    }

    @And("^Give this number ([\\d]+) under numero de celluar field$")
    public void giveThisNumberUnderNumeroDeCelluarField(String telephone) {
        home.selectTelephoneNumber(driver, telephone);
    }

    @And("^under  monte de recharga select (\\d+) dollar normal recharge$")
    public void underMonteDeRechargaSelectDollarNormalRecharge(int mount) {

    }

    @And("^click on siguiente$")
    public void clickOnSiguiente() {

    }

    @Then("^Verify if the user able to reach to the next screen or not\\(Payment screen\\)$")
    public void verifyIfTheUserAbleToReachToTheNextScreenOrNotPaymentScreen() {

    }

    @Then("^On payment screen click on tarjeta$")
    public void onPaymentScreenClickOnTarjeta() {

    }

    @Then("^enter the following details$")
    public void enterTheFollowingDetails(DataTable table) {

    }

    @Then("^Click on pagar con tarjeta to do the recharge$")
    public void clickOnPagarConTarjetaToDoTheRecharge() {

    }

    @And("^verify if the recharge is success or not$")
    public void verifyIfTheRechargeIsSuccessOrNot() {

    }
}
