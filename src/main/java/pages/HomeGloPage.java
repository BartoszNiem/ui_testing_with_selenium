package pages;

import BaseElements.BaseAbstractPage;
import Core.TAEDriver;
import Entities.User;
import Forms.ProfileWidgetForm;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomeGloPage extends BaseAbstractPage {

    private static  String TITLE = "Glo:Home";
    public ProfileWidgetForm profileWidgetForm;

    @FindBy(how = How.XPATH, xpath = "//div/a[@class='btn btn-link color-inherit' and text()[contains(., 'Sign out')]]")
    public WebElement signOutButton;

    public HomeGloPage(TAEDriver driver) {
        super(driver, TITLE);
        PageFactory.initElements(driver.getDriver(), this);
        this.profileWidgetForm = new ProfileWidgetForm(driver);
        getLogger().info("--- Successfully logged in to Glo! ---");
    }
    public String getUserNameFromForm(){
        String nameInForm = profileWidgetForm.getUserNameLabel().getText();
        return nameInForm;
    }
    public String getJobTitleFromForm(){
        return profileWidgetForm.getJobTitleFromForm().getText();
    }
    public List<String> getMetricsFromForm(){
        List<String> listOfMetricsToReturn = List.of(
                profileWidgetForm.getListOfCommunityInformation().get(0).getText(),
                profileWidgetForm.getListOfCommunityInformation().get(1).getText(),
                profileWidgetForm.getListOfCommunityInformation().get(2).getText(),
                profileWidgetForm.getListOfCommunityInformation().get(3).getText()
        );

        return listOfMetricsToReturn;
    }

    public List<String> getMetricsLabelsFromForm() {
        List<String> listOfMetricsLabelsToReturn = List.of(
                profileWidgetForm.getListOfCommunityInformationLabels().get(0).getText(),
                profileWidgetForm.getListOfCommunityInformationLabels().get(1).getText(),
                profileWidgetForm.getListOfCommunityInformationLabels().get(2).getText(),
                profileWidgetForm.getListOfCommunityInformationLabels().get(3).getText()
        );
        return listOfMetricsLabelsToReturn;
    }
    public void signOut(){
        signOutButton.click();
    }
}
