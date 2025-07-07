package utils;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import static com.codeborne.selenide.Selenide.open;

public class TestsSetups {

    @BeforeAll
        public static void setConfiguration() throws IOException {
        System.out.println("Working directory: " + System.getProperty("user.dir"));
        System.out.println("Full path: " + new File("config/login.properties").getAbsolutePath());
        //updatePropertiesFile();
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
    public static String generateRandomUserName() {
        return "User" + new Random().nextInt(10000);
    }
    public static void updatePropertiesFile() throws IOException {
        Properties props = new Properties();
        try (FileInputStream in = new FileInputStream("login.properties")) {
            props.load(in);
        }
        props.setProperty("userName", generateRandomUserName());
        try (FileOutputStream out = new FileOutputStream("login.properties")) {
            props.store(out, "Updated with random userName");
        }
    }

    @AfterAll
    static void tearDown() {
        SelenideLogger.removeListener("allure");
        Selenide.closeWebDriver();
    }

}

