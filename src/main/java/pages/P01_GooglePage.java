package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_GooglePage {
    WebDriver driver;
    public P01_GooglePage(WebDriver driver){
        this.driver=driver;
    }

    private By SEARCH_BOX=By.xpath("//textarea[@name='q']");
    private By SEARCH_BUTTON=By.xpath("(//input[@name=\"btnK\"])[2]");
    private By SEARCH_RESULT=By.id("result-stats");

    public P01_GooglePage addSearchData(String data){
        driver.findElement(SEARCH_BOX).sendKeys(data);
        return this;
    }
    public P01_GooglePage clickSearchButton(){
        driver.findElement(SEARCH_BUTTON).click();
        return this;
    }
    public boolean checkSearchResult(){
        return driver.findElement(SEARCH_RESULT).isDisplayed();
    }

}
