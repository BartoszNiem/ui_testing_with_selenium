package BaseTest;

import Entities.WebDriverType;
import Exceptions.TAUnknownBrowserException;

public class BaseAbstractChromeTest extends BaseAbstractTest{
    public BaseAbstractChromeTest() throws TAUnknownBrowserException {
        super("chrome");
    }

}
