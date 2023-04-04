package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {

    public HomePage(WebDriver webDriver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 15), this);
    }

    @FindBy(css = "#topPanel > a:nth-child(2) > img")
    public WebElement parabankTitle;

    @FindBy(xpath = "//*[@id=\"loginPanel\"]/p[2]/a")
    public WebElement registerLink;

    @FindBy(xpath = "//*[@id=\"leftPanel\"]/ul/li[8]/a")
    public WebElement logoutLink;

    public boolean homePageIsDisplayed(){
        parabankTitle.isDisplayed();
        return true;
    }

    public void clickRegisterLink() {
        registerLink.isDisplayed();
        registerLink.click();
    }

    public void clickLogOutLink() {
        logoutLink.isDisplayed();
        logoutLink.click();
    }

}
