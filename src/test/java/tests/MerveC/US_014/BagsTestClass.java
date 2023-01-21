package tests.MerveC.US_014;

import org.testng.annotations.Test;

import pages.MerveC.US__014.BagsPageClass;
import utilities.BaseTestReport;
import utilities.ConfigReader;
import utilities.Driver;

public class BagsTestClass extends BaseTestReport {

    //kullanıcı, bags urun kategorisini sectigide urun arayabilmelidir

    // Search areadan urunleri keyword ile aradiginda listelenen urunlerde aranan keyword bulunmalidir

     @Test
    public void bagsTest(){

         extentTest = extentReports.createTest("discountCouponTest");

         //  1-Kullanıcı URL gider
         //  2-

          Driver.getDriver().get(ConfigReader.getProperty("pickBazar_url"));

         //  3-Kullanıcı search areadan keyword ile ürün arar.
         //  4-Kullanıcı aradığı ürünü, listede görür.

         BagsPageClass bg=new BagsPageClass();

         bg.setBagsBtn();

}


}
