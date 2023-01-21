package pages.MerveC.US_013;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ConfigReader;
import utilities.Driver;

public class Homepage {
    public Homepage() {

        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "(//li/a)[2]")
    public WebElement offerssekmesi;

    @FindBy(id = "search")
    public WebElement searchArea;

    @FindBy(xpath = "//button//span[contains(text(),'Add')]")
    public WebElement slicedAdd;

    @FindBy(xpath= "//*[contains(text(),'My Orders')]")
    public WebElement myOrdersBtn;

    @FindBy(xpath= "(//button[contains(@class,'ltr:t')])[3]")
    public WebElement discountCoupon;


    public void searchArea(){

        searchArea.sendKeys(ConfigReader.getProperty("aranankelime1") + Keys.ENTER);

        slicedAdd.click();

    }

    public void offersSekmesi(){

       // searchArea();

        offerssekmesi.click();

        discountCoupon.click();

    }

}
