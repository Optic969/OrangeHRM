package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.open;

public class TestsSetups {

    @BeforeAll
    public static void setConfiguration() {
        Configuration.timeout = 5000;
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
        Configuration.browserSize = "1680x1024";
        Configuration.browserCapabilities.setCapability("enableVNC", true);
        open(Configuration.baseUrl);
    }
    @AfterAll
    static void tearDown() {
        SelenideLogger.removeListener("allure");
        Selenide.closeWebDriver();
    }

}

