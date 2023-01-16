package AraProje.tests;

import AraProje.pages.SellerLoginPage;
import AraProje.utilities.Driver;
import org.testng.annotations.Test;

public class SellerLoginPageClass {


    @Test
    public void test() {

        Driver.getDriver().get("https://shop-pickbazar-rest.vercel.app/");

        SellerLoginPage sellLog=new SellerLoginPage();

        sellLog.logAsSeller();



    }
}
