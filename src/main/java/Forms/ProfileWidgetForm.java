package Forms;

import BaseElements.BaseAbstractForm;
import Core.TAEDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProfileWidgetForm extends BaseAbstractForm {

    @FindBy(how = How.XPATH, xpath = "//div/h2[@class='text-center']")
    private WebElement userNameLabel;

    @FindBy(how = How.XPATH, xpath = "//div[@class='col-xs-3 text-right']")
    private List<WebElement> listOfCommunityInformation;

    @FindBy(how = How.XPATH, xpath = "//div[@class='col-xs-9']")
    private List<WebElement> listOfCommunityInformationLabels;

    @FindBy(how = How.XPATH, xpath = "//div/p[@class ='text-center mb-20 font-medium']")
    private WebElement jobTitleFromForm;
    public ProfileWidgetForm(TAEDriver driver) {
        super(driver);
        PageFactory.initElements(driver.getDriver(), this);
    }

    public WebElement getUserNameLabel() {
        return userNameLabel;
    }

    public List<WebElement> getListOfCommunityInformation() {
        return listOfCommunityInformation;
    }

    public List<WebElement> getListOfCommunityInformationLabels() {
        return listOfCommunityInformationLabels;
    }

    public WebElement getJobTitleFromForm() {
        return jobTitleFromForm;
    }
}
