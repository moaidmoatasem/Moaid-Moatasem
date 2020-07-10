package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleHomePage;
import pages.SearchResultPage;

public class SearchResultTest extends TestBase {

    public SearchResultPage searchResultPage;

    String word="instabug";
    @Test(priority = 1)
    public void verifySpecificResultLinkURL() {
        try {
            searchResultPage = new SearchResultPage(driver);
            searchResultPage.showingSearchResult(word);
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOfAllElements(searchResultPage.mainLinks));
            //verify Link
            String link = searchResultPage.getLinkURL(0);
//            System.out.println(link);
            Assert.assertEquals(link,"https://instabug.com/");
        }
        catch (Exception e){
            System.out.println("Error happened:"+e.getMessage());
        }
    }
    @Test(priority = 2, dependsOnMethods = {"verifySpecificResultLinkURL"})
    public void verifySpecificResultText() {
        try {
            //verify text
            String linkText = searchResultPage.getLinkText(0);
            System.out.println(linkText);
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOfAllElements(searchResultPage.mainLinks));

            Assert.assertTrue(linkText.contains("Instabug: Connect with Customers and Ship Quality Apps Faster"));
        }
        catch (Exception e){
            System.out.println("Error happened:"+e.getMessage());
        }
    }

    @Test (priority = 3, dependsOnMethods = {"verifySpecificResultText","verifySpecificResultLinkURL"})
    public void verifyTextAndLinkAfterChoosingAnotherPageNumber() {
        try {
            int chosenNumber = 2;
            searchResultPage.choosePageNumber(chosenNumber);

            int resultNumber=0;
            //Assert text
            String linkText = searchResultPage.getLinkText(resultNumber);
            Assert.assertTrue(linkText.contains("Instabug (@Instabug) | Twitter"));
            //Assert LinkURL
            String linkURL = searchResultPage.getLinkURL(resultNumber);
            Assert.assertEquals(linkURL,"https://twitter.com/instabug?lang=en");

//            String result= searchResultPage.pageNumberHeader.getAttribute("text");
//            System.out.println(result);
//            Assert.assertTrue(result.contains("Page "+chosenNumber));
        } catch (Exception e) {
            System.out.println("Error happened:" + e.getMessage());
        }
    }
}