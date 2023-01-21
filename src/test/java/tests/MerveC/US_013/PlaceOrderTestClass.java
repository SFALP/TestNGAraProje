package tests.MerveC.US_013;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MerveC.US_013.CheckoutPageClass;

import pages.MerveC.US_013.Homepage;
import pages.MerveC.US_013.MyOrdersPageClass;
import utilities.BaseTestReport;
import utilities.Driver;

import java.time.Duration;

public class PlaceOrderTestClass extends BaseTestReport {

    @Test
    public void placeOrderProcess() {

        extentTest = extentReports.createTest("placeOrderProcessTest");

        CheckoutPageClass ch = new CheckoutPageClass();

        ch.goToCheckout();

        // 5-Kullanıcı checkout avalibility seçebilmelidir.
        Homepage hm = new Homepage();

        //  4-Kullanıcı Offers sayfasına gider.
        hm.offersSekmesi();

        Driver.getDriver().navigate().back();

        ch.checkAvailability.click();

        //  5-Kullanıcı indirim kuponu alabilmelidir.
        ch.discountCouponBtn.click();

        //  6-Kullanıcı checkout sayfasına gittiğinde kupon metin kutusu ve kupon değeri yazılabilir olmalıdır.
        ch.enterCoupon.click();

        ch.enterCoupon.sendKeys(Keys.CONTROL + "V");

        ch.applyBtn.click();

        //  7-Kupon girildiğinde tutar üzerinden indirim uygulanmalıdır.
        Assert.assertTrue(ch.discountIsDisplayed.isDisplayed());

        // 6-Kullanıcı payment method seçebilmelidir.

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOf(ch.paymentMethod)).click();

        ch.paymentMethod.click();

        // 7-Kullanıcı place order ile ödemeyi sonlandırır.
        ch.placeOrderBtn.click();

        //   8-Kullanıcı place order ile sipariş sürecini izler.
        wait.until(ExpectedConditions.visibilityOf(ch.orderStatusIsDisplayed)).click();

        Assert.assertTrue(ch.orderStatusIsDisplayed.isDisplayed());

        MyOrdersPageClass my=new MyOrdersPageClass();

        my.myProduct();

    }

}
