package tests;

import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleHomePage;
import pages.SearchResultPage;

import java.sql.Time;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class GoogleHomeTest extends TestBase {

    public GoogleHomePage googleHomePageObj;
    //SearchResultPage searchResultPageObj;

    //asserting the title
    @Test (priority = 1)
    public void verifyTitleIsGoogle(){
        Assert.assertEquals("Google",driver.getTitle());
    }

    @Test (priority = 2, dependsOnMethods = {"titleIsGoogle"})
    public void verifyGoogleLogoIsDisplayed(){
        googleHomePageObj =new GoogleHomePage(driver);
        Assert.assertTrue(googleHomePageObj.homeGoogleLogo.isDisplayed());
    }

    @Test (priority = 3, dependsOnMethods = {"verifyTitleIsGoogle","verifyGoogleLogoIsDisplayed"})
    public void verifyFirstChoiceIsTypicalSameYouType() {
        googleHomePageObj = new GoogleHomePage(driver);
        googleHomePageObj.userSearching("instabug");

//        try {
            String firstSuggestion= googleHomePageObj.autoCompleteSearchList.get(0).getText();
            Assert.assertEquals(firstSuggestion,"instabug");
//            System.out.println(firstSuggestion);
//        }
//        catch (Exception e) {
//            System.out.println("Error happened:"+e.getMessage());
//        }
    }

    @Test (priority = 4, dependsOnMethods = {"firstChoiceIsTheSameYouType"})
    public void verifyAllSuggestionsHaveSameWord(){
//        try {
            /*          or normal for loop
        for (int i = 0; i <= googleHomePageObj.autoCompleteSearchList.size()-1; i++) {
*/
            for (WebElement webElement: googleHomePageObj.autoCompleteSearchList) {
                String s= webElement.getText();
                System.out.println(s);
                Assert.assertTrue(s.contains("instabug"));
            }
//        }
//        catch (Exception e) {
//            System.out.println("Error happened:"+e.getMessage());
//        }
    }
}
