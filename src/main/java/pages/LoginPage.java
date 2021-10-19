package pages;

import BaseElements.BaseAbstractPage;
import BaseTest.BaseAbstractTest;
import Core.TAEDriver;
import Entities.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseAbstractPage {

    public static String TITLE = "GLO Login";
    public static String INFO_TEXT = "Use your Globallogic / Windows credential to login";

    @FindBy(className = "sub-heading mb-20")
    public WebElement infoLabel;
    @FindBy(id = "login")
    public WebElement userNameInput;
    @FindBy(id = "password")
    public WebElement passwordInput;
    @FindBy(how = How.XPATH, xpath = "//input[@value='LOGIN']")
    public WebElement loginButton;

    public LoginPage(TAEDriver driver){
        super(driver, TITLE);
        PageFactory.initElements(driver.getDriver(), this);
        getLogger().info("Login page initialized");
    }
    public String getPageInfoText(){
        return INFO_TEXT;
    }
    public void setUsername(String username){
        userNameInput.sendKeys(username);
    }
    public void setPassword(String password){
        passwordInput.sendKeys(password);
    }
    public void submit(){
        loginButton.click();
    }
    public void fillLoginForm(User user){
        setUsername(user.getUserName());
        setPassword(user.getPassword());
    }
    public void tryLogin(User user){
        fillLoginForm(user);
        submit();
    }
    public void onLoginPage(){
        driver.getDriver().get("https://glo.globallogic.com/apps/glo/login");
    }

}
