package utils;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class TestsSetups {

    @BeforeAll
    public static void setConfiguration() {
        Configuration.timeout = 5000;
        SelenideLogger.addListener("allure", new AllureSelenide());
        //Configuration.browser = "chrome";

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver.exe");
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("enableVNC", true);
        options.setCapability("selenoid:options", selenoidOptions);

        Configuration.browserCapabilities = options;

        open(Configuration.baseUrl);
    }
    @AfterAll
    static void tearDown() {
        SelenideLogger.removeListener("allure");
        Selenide.closeWebDriver();
    }

}

