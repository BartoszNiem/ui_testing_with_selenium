package uicontrols;

import BaseControlls.BaseControl;
import Core.TAEDriver;
import Entities.Travellers;
import Forms.HotelForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TravellersControl extends BaseControl {



    public TravellersControl(String name, TAEDriver driver, By locator) {
        super(name, driver, locator);
        PageFactory.initElements(driver.getDriver(), this);
    }

    public TravellersControl(String name, TAEDriver driver, String xpath) {
        super(name, driver, xpath);
        PageFactory.initElements(driver.getDriver(), this);
    }

    public void setTravellers(Travellers travellers){
        //this method should set travellers controls
        //to the state of passed travellers object

        HotelForm hotelForm = new HotelForm(driver);

        hotelForm.clearForm();

        hotelForm.rooms.sendKeys(String.valueOf(travellers.getNumberOfRooms()));
        getLogger().info("number of rooms given - " + String.valueOf(travellers.getNumberOfRooms()));
        hotelForm.adults.sendKeys(String.valueOf(travellers.getNumberOfAdults()));
        getLogger().info("number of adults given - " + String.valueOf(travellers.getNumberOfAdults()));
        hotelForm.childs.sendKeys(String.valueOf(travellers.getNumberOfChilds()));
        getLogger().info("number of childs given - " + String.valueOf(travellers.getNumberOfChilds()));

        hotelForm.submit();
    }


}