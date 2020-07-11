package tests;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchResultPage;

public class SearchResultTest extends TestBase {

    public SearchResultPage searchResultPage;


    @Test(priority = 1)
    public void verifySpecificResultLinkURL() {
        searchResultPage = new SearchResultPage(driver);
        String searchingWord="instabug";
        searchResultPage.showingSearchResult(searchingWord);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(searchResultPage.mainLinks));
        //verify Link
        int linkNumber = 0;
        String link = searchResultPage.getLinkURL(linkNumber);
//            System.out.println(link);
        String linkURL="https://instabug.com/";
        Assert.assertEquals(link,linkURL);

    }
    @Test(priority = 2, dependsOnMethods = {"verifySpecificResultLinkURL"})
    public void verifySpecificResultText() {
        searchResultPage = new SearchResultPage(driver);
        //verify text
        int linkNumber = 0;
        String linkText = searchResultPage.getLinkText(linkNumber);
//            System.out.println(linkText);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElements(searchResultPage.mainLinks));
        String expectedText = "Instabug: Connect with Customers and Ship Quality Apps Faster";
        Assert.assertTrue(linkText.contains(expectedText));
    }

    @Test (priority = 3, dependsOnMethods = {"verifySpecificResultText","verifySpecificResultLinkURL"})
    public void verifyTextAndLinkAfterChoosingAnotherPageNumber() {
        searchResultPage = new SearchResultPage(driver);
        int chosenNumber = 2;
        searchResultPage.choosePageNumber(chosenNumber);

        int resultNumber=0;
        //Assert text
        String linkText = searchResultPage.getLinkText(resultNumber);
        String expectedText = "Instabug (@Instabug) | Twitter";
        Assert.assertTrue(linkText.contains(expectedText));
        //Assert LinkURL
        String expectedLinkURL = "https://twitter.com/instabug?lang=en";
        String linkURL = searchResultPage.getLinkURL(resultNumber);
        Assert.assertEquals(linkURL,expectedLinkURL);

//            String result= searchResultPage.pageNumberHeader.getAttribute("text");
//            System.out.println(result);
    }
}
