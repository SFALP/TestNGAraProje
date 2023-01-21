package pages.MerveC.US__014;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.MerveC.US_013.Homepage;
import utilities.ConfigReader;
import utilities.Driver;

public class BagsPageClass {


    public BagsPageClass() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(id = "headlessui-menu-button-1")
    private WebElement groceryClick;

    @FindBy(xpath = "//div//a[@href='/bags']")
    private WebElement bagsBtn;

    @FindBy(xpath = " //header//h3[contains(text(),'Salvatore Ferragamo')]")
    private WebElement bagsIsDisplayed;

    public void setBagsBtn() {

        groceryClick.click();

        bagsBtn.click();

        Homepage hm=new Homepage();

        hm.searchArea.sendKeys(ConfigReader.getProperty("aranankelime2") + Keys.ENTER);

        Assert.assertTrue(bagsIsDisplayed.isDisplayed());
    }


}
