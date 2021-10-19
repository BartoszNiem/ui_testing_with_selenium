import BaseTest.BaseAbstractChromeTest;
import BaseTest.BaseAbstractTest;
import Exceptions.TAUnknownBrowserException;
import org.testng.annotations.Test;


public class Test1 extends BaseAbstractChromeTest {

    public Test1() throws TAUnknownBrowserException {
    }

    @Test
    public void test(){
       int a = 5+6;
    }
}
