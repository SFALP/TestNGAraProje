package AraProje.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BaseTestReport__ {
    protected WebDriver driver;

    protected Actions actions;

    protected ExtentReports extentReports;//extent report'a ilk atamayi yapar
    protected ExtentHtmlReporter extentHtmlReporter;//Html raporu duzenler
    protected ExtentTest extentTest;

    @BeforeSuite
    public void beforeSuite() {

        //Create extent report
        extentReports = new ExtentReports(); // Raporlamayi baslatir

        // Report PATH= creates the html report right under test-output
        //rapor oluştuktan sonra raporunuz nereye eklensin istiyorsanız buraya yazıyorsunuz.
        String currentDate = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
        String filePath = System.getProperty("user.dir") + "/test-output/report/" + currentDate + "test_report.html";

        //Attach html and extent reports
        //oluşturmak istediğimiz raporu (html formatında) başlatıyoruz, filePath ile dosya yolunu belirliyoruz.
        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);

        // Add custom information
        // İstediğiniz bilgileri buraya ekeyebiliyorsunuz.
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("Browser", "Chrome"); // chrome, firefox
        extentReports.setSystemInfo("QA Engineer", "Karl");
        extentHtmlReporter.config().setDocumentTitle("Report");
        extentHtmlReporter.config().setReportName("TestNG Reports");
        extentHtmlReporter.config().setDocumentTitle(new SimpleDateFormat("ddMMyyyy_hh_mm_ss").format(new Date()) + "_Son Test");
        //test doc uzerinde tarih yazili olacak


    }

    @BeforeMethod
    @Parameters("browser")
    public void setup(@Optional("Chrome") String browser) {
        switch (browser) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "Safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotLocation = ReUsableMethods.getScreenshot(driver, result.getName());
            extentTest.fail(result.getName());
            extentTest.addScreenCaptureFromPath(screenshotLocation);
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {//eger test calistirilmadan gecilmezse
            extentTest.skip("Test Case is skipped: " + result.getName());//ignore olanlar
        }
        driver.quit();
    }

    @AfterSuite
    public void afterSuite() {
        extentReports.flush();
    }
}
