package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.JavaScriptDelaysPage;
import pages.FormsFieldPage;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static pages.BasePage.BASE_URL;

public class BaseTest {
    JavaScriptDelaysPage javaScriptDelaysPage;
    FormsFieldPage formsFieldPage;

    @BeforeMethod
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.baseUrl = PropertyReader.getProperty("practice-automation.url");

        javaScriptDelaysPage = new JavaScriptDelaysPage();
        formsFieldPage = new FormsFieldPage();
    }

    @AfterMethod
    public void close() {
        clearBrowserCookies();
        closeWebDriver();
    }
}