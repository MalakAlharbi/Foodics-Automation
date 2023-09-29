package testcases;

import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_GooglePage;

@Epic("Google Search Regression Testing using TestNG")
@Feature("Verify Search Results in Google")
public class TC01_CheckGoogleResults extends TestBase{

    // define test data
    String searchData="Automation";
    @Test
    @Story("Google Search")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Verify Search Results in Google")
    public void verifySearchResults() {
        new P01_GooglePage(driver).addSearchData(searchData).clickSearchButton();
        Assert.assertTrue(new P01_GooglePage(driver).checkSearchResult());
    }
    @Test
    @Story("Google Search")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Verify Search Results in Google with new data")
    public void removeAndSearchWithNewData() {
        searchData="foodics";
        new P01_GooglePage(driver).addSearchData(searchData).clickSearchButton();
        Assert.assertTrue(new P01_GooglePage(driver).checkSearchResult());

        // scroll to bottom of page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }

}
