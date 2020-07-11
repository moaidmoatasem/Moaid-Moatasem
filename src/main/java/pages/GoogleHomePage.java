package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GoogleHomePage extends PageBase{

    public GoogleHomePage(WebDriver driver){
        super(driver);
    }

    //google logo
    @FindBy (id = "hplogo")
    public WebElement homeGoogleLogo;

    //Search bar
    @FindBy (xpath = "//*[@class='gLFyf gsfi']") //or by name: @FindBy (name = "q")
    WebElement homeSearchBar;

    //Search button
    @FindBy (xpath = "//*[@class='gNO89b']") //or by name: @FindBy (name = "btnK")
    WebElement homeSearchBtn;

    //AutoComplete
    @FindBy (xpath = "//li[not(@id='sbt')][@class='sbct']/div[@class='jKWzZXdEJWi__suggestions-inner-container']") // "//*[@class='sbct']/div/div/div")
    public List<WebElement> autoCompleteSearchList;

    //Country in Bottom
    @FindBy (xpath = "//span[@class='Q8LRLc']")
    public WebElement country;

    public void userSearching(String searchTxt){
        /* without wrapping - encapsulation
        homeSearchBar.sendKeys(searchTxt,Keys.ENTER);
         homeSearchBar.sendKeys(Keys.ENTER); //or instead of Keys.ENTER clickBtn(homeSearchBtn);
         */
        //after wrapping
        setTxt(homeSearchBar,searchTxt);
    }

}
