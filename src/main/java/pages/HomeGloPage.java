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
        getLogger().info("Full name from welcome form");
        return nameInForm;
    }
    public String getJobTitleFromForm(){
        String jobTitleOfUserFromForm = profileWidgetForm.getJobTitleFromForm().getText();
        getLogger().info("Job title from the welcome form -> " + jobTitleOfUserFromForm);
        return jobTitleOfUserFromForm;
    }
    public List<String> getMetricsFromForm(){
        List<String> listOfMetricsToReturn = List.of(
                profileWidgetForm.getListOfCommunityInformation().get(0).getText(),
                profileWidgetForm.getListOfCommunityInformation().get(1).getText(),
                profileWidgetForm.getListOfCommunityInformation().get(2).getText(),
                profileWidgetForm.getListOfCommunityInformation().get(3).getText()
        );
        getLogger().info("Metrics from Glo welcome form -> " + listOfMetricsToReturn);
        return listOfMetricsToReturn;
    }

    public List<String> getMetricsLabelsFromForm() {
        List<String> listOfMetricsLabelsToReturn = List.of(
                profileWidgetForm.getListOfCommunityInformationLabels().get(0).getText(),
                profileWidgetForm.getListOfCommunityInformationLabels().get(1).getText(),
                profileWidgetForm.getListOfCommunityInformationLabels().get(2).getText(),
                profileWidgetForm.getListOfCommunityInformationLabels().get(3).getText()
        );
        getLogger().info("List of welcome form metrics labels -> " + listOfMetricsLabelsToReturn);
        return listOfMetricsLabelsToReturn;
    }
    public void signOut(){
        getLogger().info("--- Signing out from Glo ---");
        signOutButton.click();
    }
}
