package tests;

import org.testng.annotations.Test;
import utils.PropertyReader;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class JavaScriptDelaysTest extends BaseTest {
    String javascriptDelays = PropertyReader.getProperty("javascript-delays");

    @Test
    public void delaysTest() {
        open(javascriptDelays);

        $x("//button[@id='start']")
                .click();
        $("[id='delay']")
                .shouldHave(text("Liftoff!"), Duration.ofSeconds(11));
    }
}