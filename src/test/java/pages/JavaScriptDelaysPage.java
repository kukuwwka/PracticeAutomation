package pages;

import com.codeborne.selenide.SelenideElement;
import utils.PropertyReader;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static pages.BasePage.BASE_URL;

public class JavaScriptDelaysPage extends  BasePage {
    String javaScriptDelaysLink = PropertyReader.getProperty("javascript-delays.url");

    final SelenideElement startButton = $x("//button[@id='start']");
    final SelenideElement textLiftoff = $("[id='delay']");

    public JavaScriptDelaysPage openJavaScriptDelaysPage() {
        open("/" + javaScriptDelaysLink);
        return this;
    }

    public JavaScriptDelaysPage pressStartButton() {
        startButton.click();
        return this;
    }

    public JavaScriptDelaysPage waitingForLiftoffText() {
        textLiftoff
                .shouldHave(text("Liftoff!"), Duration.ofSeconds(11));
        return this;
    }
}