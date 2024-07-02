package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ApiPage;
import pages.WebPage;

public class WebStep {
    WebPage webPage;

    public WebStep(){
        this.webPage = new WebPage();
    }

    @Given("user in the logging page")
    public void userInTheLoggingPage() {
        webPage.openWeb();
    }

    @Then("user input the valid email {string}")
    public void userInputTheValidEmail(String email) {
        webPage.userInputTheValidEmail(email);
    }

    @And("user input valid password {string}")
    public void userInputValidPassword(String password) {
        webPage.userInputTheValidpassword(password);
    }

    @And("user click loggin button")
    public void userClickLogginButton() {
        webPage.setClickLoginButton();
    }

    @And("user direct to homepage")
    public void userDirectToHomepage() {
        webPage.userDirectToHomepage();
    }

    @Then("user input the invalid email {string}")
    public void userInputTheInvalidEmail(String email) {
        webPage.inputWrongEmail(email);
    }

    @And("user will see the invalid massage")
    public void userWillSeeTheInvalidMassage() {
        webPage.userSeeInvalidMassage();
    }


    @Then("user click the account setting")
    public void userClickTheAccountSetting() {
        webPage.userClickAccountSet();
    }

    @And("user click logout text")
    public void userClickLogoutText() {
        webPage.userClickSignOut();
    }

    @And("user will direct out to logging page")
    public void userWillDirectOutToLoggingPage() {
        webPage.userSeeLogoutPage();
    }


}
