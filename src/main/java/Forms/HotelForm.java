package Forms;

import BaseElements.BaseAbstractForm;
import Core.TAEDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pages.HotelsPage;

public class HotelForm extends BaseAbstractForm {
    @FindBy(how = How.XPATH, xpath = "//*[@id='rooms']")
    public WebElement rooms;

    @FindBy(how = How.XPATH, xpath = "//*[@id='adults']")
    public WebElement adults;

    @FindBy(how = How.XPATH, xpath = "//*[@id='childs']")
    public WebElement childs;

    @FindBy(how = How.XPATH, xpath = "//*[@id='submit']")
    public WebElement searchButton;

    @FindBy(how = How.XPATH, xpath = "//*[@class='dropdown-menu dropdown-menu-wrap']/..")
    public WebElement boxDropdownForHotels;

    @FindBy(how = How.XPATH, xpath = "//*[@*='no results']")
    public WebElement noMatchFoundLabel;
    public HotelForm(TAEDriver driver) {
        super(driver);
        PageFactory.initElements(driver.getDriver(), this);
    }

    public void submit() {
        //your code
        getLogger().info(" -------- Searching hotels --------");
        searchButton.click();

    }
    public void clickDropBoxHotelSetting(){
        boxDropdownForHotels.click();
    }

    public void clearForm(){
        rooms.clear();
        adults.clear();
        childs.clear();
        getLogger().info("Cleared values in travellers form");
    }
}