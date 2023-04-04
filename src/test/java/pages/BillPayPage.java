package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class BillPayPage {

    public BillPayPage(WebDriver webDriver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 15), this);
    }

    @FindBy(xpath = "//*[@id=\"leftPanel\"]/ul/li[4]/a")
    private WebElement billPayLink;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[1]/td[2]/input")
    public WebElement payeeName;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[2]/td[2]/input")
    public WebElement payeeAddress;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[3]/td[2]/input")
    public WebElement payeeCity;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[4]/td[2]/input")
    public WebElement payeeState;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[5]/td[2]/input")
    public WebElement payeeZipCode;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div[2]/div/div[1]/form/table/tbody/tr[6]/td[2]/input")
    public WebElement payeePhone;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[8]/td[2]/input")
    public WebElement payeeAccount;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[9]/td[2]/input")
    public WebElement payeeVerifyAccount;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[11]/td[2]/input")
    public WebElement payeeAmount;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[14]/td[2]/input")
    private WebElement sendPaymentButton;

    public void clickBillPayLink(){
        billPayLink.isDisplayed();
        billPayLink.click();
    }

    public void setBillPayField(WebElement field,String value) {
        field.click();
        field.sendKeys(value);
    }

    public void clickSendPaymentButton(){
        sendPaymentButton.isDisplayed();
        sendPaymentButton.click();
    }
}
