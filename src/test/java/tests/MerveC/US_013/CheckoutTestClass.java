package tests.MerveC.US_013;

import com.github.javafaker.Faker;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MerveC.US_013.CheckoutPageClass;
import utilities.BaseTestReport;
import utilities.JSUtils;
public class CheckoutTestClass extends BaseTestReport {


    @Test
    public void checkoutPageTest() {

        extentTest = extentReports.createTest("checkoutPageTest");

        CheckoutPageClass check = new CheckoutPageClass();

        check.goToCheckout();

        // 5-Kullanıcı aldığı ürünleri görür.

        Assert.assertTrue(check.sliced.isDisplayed());

        // 6-Kullanıcı ödeyeceği tutarı görür.

        Assert.assertTrue(check.subTotal.isDisplayed());

        //  7-Kullanici Contact Number bilgisini update eder.

        check.contactNumberUpdate.click();

         check.flagChangeBtn.click();

         check.flagChange.click();

         check.flagUpdateChangeBtn.click();

        // 8-Kullanici Billing Address bilgisini update eder.

        check.billingAddressUpdate();

        check.title.sendKeys("my billing address");

        Faker faker = new Faker();

        check.country.sendKeys(faker.country().name());

        check.city.sendKeys(faker.address().cityName());

        check.state.sendKeys(faker.address().streetName());

        check.zip.sendKeys(faker.address().zipCode());

        check.adress.sendKeys(faker.address().fullAddress());

        check.updateAdressBtn.click();

        //  9-Kullanici Shipping Address bilgisini update eder.

        check.shippingAddressUpdate();

        check.title.sendKeys("my shipping address");

        check.country.sendKeys(faker.country().name());

        check.city.sendKeys(faker.address().cityName());

        check.state.sendKeys(faker.address().streetName());

        check.zip.sendKeys(faker.address().zipCode());

        check.adress.sendKeys(faker.address().fullAddress());

        check.updateAdressBtn.click();

        //   5-Kullanici Delivery Schedule seçer.

        JSUtils.clickElementByJS(check.deliverySchedule);

        check.deliverySchedule.click();
    }
}


