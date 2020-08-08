package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Attachment;
import junit.framework.TestResult;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

public class TestsSetups {

    @BeforeClass
    public static void setConfiguration() {
        Configuration.timeout = 10000;
        Configuration.baseUrl = "https://opensource-demo.orangehrmlive.com/";
        Configuration.browserSize = "1680x1024";
        open(Configuration.baseUrl);
    }
    /*@AfterClass
    public static void closeBrowser() {
        close();
    }

    /*@After
    public void onTestFailure(TestResult tr) {
        makeScreenshot();
    }

    @Attachment(value = "Attachment Screenshot", type = "image/png")
    public byte[] makeScreenshot() {
        Object driver = null;
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }*/

}

