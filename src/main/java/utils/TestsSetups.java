package utils;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;


import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

public class TestsSetups {

    @BeforeAll
    public static void setConfiguration() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
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

