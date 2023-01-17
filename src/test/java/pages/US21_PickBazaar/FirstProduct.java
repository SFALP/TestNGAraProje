package pages.US21_PickBazaar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FirstProduct {
    public FirstProduct() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//div/h3)[4]")
    private WebElement vegetables;

    public void firstClick() {
        vegetables.click();
    }
//(//button[.='View More'])[1]
}
