package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

    protected WebDriver driver;
    //create the Constructor
    public PageBase(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    protected static void clickBtn(WebElement btn){
        btn.click();
    }

    protected static void setTxt(WebElement txtElement, String txt){
        txtElement.clear();
        txtElement.sendKeys(txt);
    }
}
