package pages.MerveC.US_013;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Login.CustomerLoginPage;

import utilities.Driver;

import java.time.Duration;

public class CheckoutPageClass {

    public CheckoutPageClass() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//span[@class='text-sm text-body']")
    public WebElement sliced;

    @FindBy(xpath = "//div[@class='flex justify-between']")
    public WebElement subTotal;

    @FindBy(xpath = "//button[contains(text(),'Update')]")
    public WebElement contactNumberUpdate;

    @FindBy(xpath = "//*[contains(text(),'Checkout')]")
    public WebElement checkoutLoctr;

    @FindBy(xpath = "//img[@alt='user name']")
    public WebElement monsterLoctr;

    @FindBy(xpath = "(//div[@class='selected-flag'])[2]")
    public WebElement flagChangeBtn;

    @FindBy(xpath = "//ul//li[@data-country-code='dz']")
    public WebElement flagChange;

    @FindBy(xpath = "(//button[contains(text(),'Update')])[2]")
    public WebElement flagUpdateChangeBtn;

    @FindBy(id = "headlessui-radiogroup-option-22")
    public WebElement deliverySchedule;

    @FindBy(xpath = "//span[contains(text(),'Cash On Delivery')]")
    public WebElement paymentMethod;

    @FindBy(xpath = "//button[contains(text(),'Check Availability')]")
    public WebElement checkAvailability;

    @FindBy(xpath = "//button[contains(text(),'Place Order')]")
    public WebElement  placeOrderBtn;

    @FindBy(xpath = "//*[contains(text(),'Order Status')]")
    public WebElement orderStatusIsDisplayed;

    @FindBy(xpath = "//div//p[@role='button']")
    public WebElement discountCouponBtn;

    @FindBy(xpath = "//button[contains(text(),'Apply')]")
    public WebElement applyBtn;

    @FindBy(id = "code")
    public WebElement enterCoupon;

    @FindBy(xpath = "(//div[@class='flex justify-between'])[4]")
    public WebElement discountIsDisplayed;

    @FindBy(xpath = "(//button[contains(text(),'Add')])[1]")
    public WebElement billingAddressUpdate;

    @FindBy(id = "title")
    public WebElement title;

    @FindBy(id = "address.country")
    public WebElement country;

    @FindBy(id = "address.city")
    public WebElement city;

    @FindBy(id = "address.state")
    public WebElement state;

    @FindBy(id = "address.zip")
    public WebElement zip;

    @FindBy(id = "address.street_address")
    public WebElement adress;

    @FindBy(xpath = "(//button[contains(text(),'Update')])[2]")
    public WebElement updateAdressBtn;

    @FindBy(xpath = "(//button[contains(text(),'Add')])[2]")
    public WebElement shippingAddressUpdate;

    public void goToCheckout() {

        // 1-Kullanıcı URL gider.
        // 2-Kullanıcı olarak giriş yapar.
        // 3-Kullanıcı ürünü arar ve ürünü checkout a ekler.
        // 4-Kullanıcı checkout a gider.

        CustomerLoginPage lp = new CustomerLoginPage();

        lp.customerLogin();

        Homepage hm = new Homepage();

        hm.searchArea();

        monsterLoctr.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(monsterLoctr));

        checkoutLoctr.click();

        wait.until(ExpectedConditions.urlToBe("https://shop-pickbazar-rest.vercel.app/checkout"));
    }

    public void billingAddressUpdate()  {

        billingAddressUpdate.click();
    }

    public void shippingAddressUpdate() {

        shippingAddressUpdate.click();
    }


}
