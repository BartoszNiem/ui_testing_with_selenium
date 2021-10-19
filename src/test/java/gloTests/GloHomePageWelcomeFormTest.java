package gloTests;

import BaseTest.BaseAbstractChromeTest;
import BaseTest.BaseAbstractTest;
import Entities.User;
import Exceptions.TAUnknownBrowserException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.xml.dom.Tag;
import pages.HomeGloPage;
import pages.LoginPage;

import java.util.List;

public class GloHomePageWelcomeFormTest extends BaseAbstractChromeTest {
    public GloHomePageWelcomeFormTest() throws TAUnknownBrowserException {
    }
    private LoginPage loginPage;
    private HomeGloPage homeGloPage;
    private User user;
    @BeforeTest
    public void init(){
        getDriver().getDriver().get("https://glo.globallogic.com/apps/glo/login");
        user = new User("bartosz.niemczyk@globallogic.com", "HasloGloballogic99");
        loginPage = new LoginPage(getDriver());
        loginPage.tryLogin(user);
        homeGloPage = new HomeGloPage(getDriver());
    }

    @Test(groups = "GloHomePage")
    public void testWelcomeFormEmployeeName(){

        user.setFirstName("Bartosz");
        user.setLastName("Niemczyk");

        Assert.assertEquals(homeGloPage.getUserNameFromForm(), user.getFullNmae());

    }

    @Test(groups = "GloHomePage")
    public void testWelcomeFormJobTitle(){

        String correctJobTitle = "Trainee Test Engineer,Quality Assurance";

        Assert.assertEquals(homeGloPage.getJobTitleFromForm(), correctJobTitle );

    }

    @Test(groups = "GloHomePage")
    public void checkWelcomeFormMetrics(){


        List<String> correctMetrics = List.of("1", "1", "204", "23");
        Assert.assertEquals(homeGloPage.getMetricsFromForm(), correctMetrics);

    }
    @Test(groups = "GloHomePage")
    public void checkWelcomeFormMetricsLabels(){

        List<String> correctMetricsLabels = List.of("People Who Follow Me", "People I Follow", "Teammates", "My Communities");
        Assert.assertEquals(homeGloPage.getMetricsLabelsFromForm(), correctMetricsLabels);

    }

}
