package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class TransferPage {

    public TransferPage(WebDriver webDriver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 15), this);
    }

    @FindBy(xpath = "//*[@id=\"leftPanel\"]/ul/li[3]/a")
    public WebElement transferFundsLink;

    @FindBy(name = "input")
    public WebElement transferFundsAmount;

    @FindBy(xpath = "//*[@id=\"toAccountId\"]")
    private WebElement Select;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div/form/div[2]/input")
    private WebElement transferButton;

    public void clickTransferFundsLink(){
        transferFundsLink.isDisplayed();
        transferFundsLink.click();
    }

    public void clickTransferFundsAmount(){
        transferFundsAmount.isDisplayed();
        transferFundsAmount.click();
        }

    public void setTransferField(WebElement field,String value) {
        field.click();
        field.sendKeys(value);
    }

    public void selectTransferAccountNumber(){
        Select dropdown = new Select(Select);
        dropdown.getOptions().get(1).click();
    }

    public void clickTransferButton(){
        transferButton.isDisplayed();
        transferButton.click();
    }

}
