package pages;

import org.openqa.selenium.By;

import static helper.setup.driver;

public class WebPage {

    By inputEmail = By.id("user[email]");
    By inputPassword = By.id("user[password]");
    By clickLogin = By.xpath("//button[@type='submit']");
    By seeHomePage = By.xpath("//h2[@class='collections__heading']");
    By invalidMassage = By.xpath("//li[@class='form-error__list-item']");
    By accountSetting = By.xpath("//button[@class='dropdown__toggle-button']");
    By signOutButton = By.xpath("//a[@href='/users/sign_out']");
    By logOutPage = By.xpath("//h2[@class='section__heading section__heading-ornament section__heading___d6c74']");

    public void openWeb(){
        driver.get("https://courses.ultimateqa.com/users/sign_in");
    }

    public void userInputTheValidEmail(String email){
        driver.findElement(inputEmail).sendKeys(email);
    }

    public void userInputTheValidpassword(String password){
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void setClickLoginButton(){
        driver.findElement(clickLogin).click();
    }

    public void userDirectToHomepage(){
        driver.findElement(seeHomePage).isDisplayed();
    }

    public void inputWrongEmail(String email){
        driver.findElement(inputEmail).sendKeys(email);
    }

    public void userSeeInvalidMassage(){
        driver.findElement(invalidMassage).isDisplayed();
    }

    public void userClickAccountSet(){
        driver.findElement(accountSetting).click();
    }

    public void userClickSignOut(){
        driver.findElement(signOutButton).click();
    }

    public void userSeeLogoutPage(){
        driver.findElement(logOutPage).isDisplayed();
    }

}
