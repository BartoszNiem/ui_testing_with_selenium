package pages;

import BaseElements.BaseAbstractPage;
import Core.TAEDriver;
import Entities.HotelsSearch;
import Entities.Travellers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import uicontrols.CustomSelect;
import uicontrols.TravellersControl;

public class HotelsPage extends BaseAbstractPage {
    public static String TITLE = "Search Hotels - PHPTRAVELS";
    CustomSelect cityDropdown;
    TravellersControl travellersForm;

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

    public HotelsPage(TAEDriver driver) {
        super(driver, TITLE);
        PageFactory.initElements(driver.getDriver(), this);
        cityDropdown = new CustomSelect("HotelCity", driver, "//span[@role='combobox']");
        travellersForm = new TravellersControl("HotelCity", driver, "//*[@class = 'dropdown dropdown-contain']");
    }

    public HotelsPage selectCity(String cityName) {
        cityDropdown.selectItem(cityName);
        return this;
    }

    public HotelsPage setTravellers(Travellers travellers) {
        //you code here
        clearForm();
        rooms.sendKeys(String.valueOf(travellers.getNumberOfRooms()));
        getLogger().info("number of rooms given - " + String.valueOf(travellers.getNumberOfRooms()));
        adults.sendKeys(String.valueOf(travellers.getNumberOfAdults()));
        getLogger().info("number of adults given - " + String.valueOf(travellers.getNumberOfAdults()));
        childs.sendKeys(String.valueOf(travellers.getNumberOfChilds()));
        getLogger().info("number of childs given - " + String.valueOf(travellers.getNumberOfChilds()));
        return this;
    }

    public HotelsPage submit() {
        //your code
        getLogger().info(" -------- Searching hotels --------");
        searchButton.click();
        return this;
    }

    public HotelsPage fillPage(HotelsSearch hotelsSearch) {
        selectCity(hotelsSearch.getCityName());
        setTravellers(hotelsSearch.getTravellers());
        return this;
    }

    public HotelsPage fillPageAndSearch(HotelsSearch hotelsSearch) {
        fillPage(hotelsSearch);
        submit();
        return this;
    }

    public HotelsPage clickDropBoxHotelSetting(){
        boxDropdownForHotels.click();
        return this;
    }
    public HotelsPage clearForm(){
        rooms.clear();
        adults.clear();
        childs.clear();
        getLogger().info("Cleared values in travellers form");
        return this;
    }
    public boolean isNoMatchFoundLabelDisplayed(){
        getLogger().info("Did get a 'no match found' message - " + noMatchFoundLabel.isDisplayed());
        return noMatchFoundLabel.isDisplayed();
    }

    public TravellersControl getTravellersForm() {
        return travellersForm;
    }
}