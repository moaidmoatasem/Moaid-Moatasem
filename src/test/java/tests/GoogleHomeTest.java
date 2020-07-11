package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleHomePage;

public class GoogleHomeTest extends TestBase {

    public GoogleHomePage googleHomePageObj;

    //asserting the title
    @Test (priority = 1)
    public void verifyTitleIsGoogle(){
        googleHomePageObj = new GoogleHomePage(driver);
        Assert.assertEquals("Google",driver.getTitle());
    }

    @Test (priority = 2, dependsOnMethods = {"verifyTitleIsGoogle"})
    public void verifyGoogleLogoIsDisplayed(){
        googleHomePageObj =new GoogleHomePage(driver);
        Assert.assertTrue(googleHomePageObj.homeGoogleLogo.isDisplayed());
    }

    @Test (priority = 3, dependsOnMethods = {"verifyTitleIsGoogle","verifyGoogleLogoIsDisplayed"})
    public void verifyFirstChoiceIsTypicalSameYouType() {
        googleHomePageObj = new GoogleHomePage(driver);
        String searchTxt = "instabug";
        googleHomePageObj.userSearching(searchTxt);
        int pageNum = 0;
        String expectedText = "instabug";
//        try {
            String firstSuggestion= googleHomePageObj.autoCompleteSearchList.get(pageNum).getText();
            Assert.assertEquals(firstSuggestion,expectedText);
//            System.out.println(firstSuggestion);
//        }
//        catch (Exception e) {
//            System.out.println("Error happened:"+e.getMessage());
//        }
    }

    @Test (priority = 4, dependsOnMethods = {"verifyFirstChoiceIsTypicalSameYouType"})
    public void verifyAllSuggestionsHaveSameWord(){

            /*          or normal for loop
        for (int i = 0; i <= googleHomePageObj.autoCompleteSearchList.size()-1; i++) {
*/
        googleHomePageObj = new GoogleHomePage(driver);
        for (WebElement webElement: googleHomePageObj.autoCompleteSearchList) {
                String s= webElement.getText();
//                System.out.println(s);
                String expectedText = "instabug";
                Assert.assertTrue(s.contains(expectedText));
            }

    }
    @Test (priority = 5)
    public void verifyCountry(){
        googleHomePageObj = new GoogleHomePage(driver);
//        System.out.println(googleHomePageObj.country.getText());
        String expectedText = "Egypt";
        Assert.assertEquals(googleHomePageObj.country.getText(),expectedText);
    }
}
