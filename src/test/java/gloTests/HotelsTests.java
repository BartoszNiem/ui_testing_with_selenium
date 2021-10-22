package gloTests;

import BaseTest.BaseAbstractTest;
import Entities.HotelsSearch;
import Entities.Travellers;
import Exceptions.TAUnknownBrowserException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HotelsPage;
import uicontrols.CustomSelect;
import uicontrols.TravellersControl;

public class HotelsTests extends BaseAbstractTest {

    public HotelsTests() throws TAUnknownBrowserException {
        super("chrome");
    }

    @BeforeTest
    public void init(){
        getDriver().navigateTo("https://www.phptravels.net/");
        HomePage homePage = new HomePage(getDriver());
        homePage.switchToHotelsPage();
        String city = "London";
        CustomSelect customSelect = new CustomSelect("HotelCity", getDriver(), "(//*[@role='combobox'])[1]");
        customSelect.selectItem(city);
    }

    @Test
    public void testHotelsPage() {

        Travellers travellers = new Travellers(4,4,4);
        HotelsPage hotelsPage = new HotelsPage(getDriver());
        hotelsPage.clickDropBoxHotelSetting();
        hotelsPage.setTravellers(travellers);
        hotelsPage.submit();
        Assert.assertTrue(hotelsPage.isNoMatchFoundLabelDisplayed());

    }


}