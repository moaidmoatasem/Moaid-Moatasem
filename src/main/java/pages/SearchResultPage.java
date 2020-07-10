package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultPage extends PageBase {
    public GoogleHomePage googleHomePage;

    public SearchResultPage(WebDriver driver){
        super(driver);
    }

    @FindBy (xpath = "//div[@class='r']/a[@href]") //div[@class="TbwUpd NJjxre"]/cite[@class="iUh30 bc tjvcx"]
    public List<WebElement> mainLinks;

    @FindBy (xpath = "div[@class='TbwUpd NJjxre']/cite[@class='iUh30 bc tjvcx']")
    public List<WebElement> mainText;

    @FindBy (xpath = "//div/table/tbody/tr/td[not(@class='b d6cvqb')]/a[@class='fl']")
    public List<WebElement> buttonsPagination;

    @FindBy (xpath = "//*/div [@id='slim_appbar']//div[@id='result-stats']")
    public WebElement pageNumberHeader;

    public void choosePageNumber(int number){
//        Actions actions = new Actions(driver);
//        actions.moveToElement(buttonsPagination.get(number));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(0,2000)");
        try {
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.elementToBeClickable(buttonsPagination.get(number)));
            buttonsPagination.get(number-2).click();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//        actions.click();
    }

    public String getLinkURL(int linkNumber){
        String link = mainLinks.get(linkNumber).getAttribute("href");
        return link;
    }

    public String getLinkText(int linkNumber){
        String linkText = mainLinks.get(linkNumber).getText();
        return linkText;
    }

    public void showingSearchResult(String word){
        googleHomePage = new GoogleHomePage(driver);
        googleHomePage.userSearching(word);
        googleHomePage.homeSearchBtn.click();
    }
}
