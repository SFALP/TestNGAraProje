package pages.MerveC.US_013;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import utilities.Driver;


public class MyOrdersPageClass {

    public MyOrdersPageClass() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(partialLinkText = "Sliced Turkey Breast")
    private WebElement product;


    public void myProduct() {

        //  9-Kullanıcı My Orders sayfasına gider.

        CheckoutPageClass ch = new CheckoutPageClass();

        ch.monsterLoctr.click();

        Homepage hm = new Homepage();

        hm.myOrdersBtn.click();

        //  10-Kullanıcı sipariş ettiği ürün ve tutarı görür.

        Assert.assertTrue(product.isDisplayed());

    }


}
