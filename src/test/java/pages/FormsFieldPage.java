package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import utils.PropertyReader;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.awt.SystemColor.text;
import static pages.BasePage.BASE_URL;

public class FormsFieldPage {
    String formsFieldsLink = PropertyReader.getProperty("form-fields.url");

    final SelenideElement nameField = $x("//*[@id='name-input']");
    final SelenideElement passwordField = $("input[type='password']");
    final ElementsCollection favouriteDrinkElements = $$("input[type='checkbox'][name='fav_drink']");
    final ElementsCollection radioBtnFavouriteColor = $$("input[type='radio'][name='fav_color']");
    final SelenideElement dropDownAutomation = $("select[name='automation'][id='automation']");
    final SelenideElement automationTools = $x("//label[text()='Automation tools']/following-sibling::ul");
    final SelenideElement emailField = $x("//input[@type='text' and @title='No fake emails!' and @id='email']");
    final SelenideElement messageField = $x("//textarea[@id='message'][@name='message']");
    final SelenideElement submitBtn = $x("//button[@class='custom_btn btn_hover'][@id='submit-btn']");

    public FormsFieldPage openFormsFieldPage() {
        open(BASE_URL + formsFieldsLink);
        return this;
    }

    public FormsFieldPage fillFormsFieldPage() {
        nameField.sendKeys("123123");
        passwordField.sendKeys("123123");
        favouriteDrinkElements.forEach(SelenideElement::click);

        for (SelenideElement checkbox : favouriteDrinkElements) {
            checkbox.shouldBe(enabled, selected);
        }

        favouriteDrinkElements.forEach(SelenideElement::click);

        for (SelenideElement checkbox : favouriteDrinkElements) {
            checkbox.shouldNot(disabled)
                    .shouldNotBe(selected);
        }

        for (SelenideElement radioButton : radioBtnFavouriteColor) {
            radioButton.click();
            radioButton.shouldBe(selected);
        }

        dropDownAutomation.selectOption(1, 2, 3);

        automationTools.
                shouldHave(text("Selenium"),
                text("Playwright"),
                text("Cypress"),
                text("Appium"),
                text("Katalon Studio"));

        emailField.sendKeys("123123@sdgfsd.hi");
        messageField.sendKeys("geergerer");
        submitBtn.click();

        return this;
    }

}
