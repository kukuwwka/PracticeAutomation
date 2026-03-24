package tests;

import org.testng.annotations.Test;

public class JavaScriptDelaysTest extends BaseTest {

    @Test
    public void delaysTest() {
        javaScriptDelaysPage
                .openJavaScriptDelaysPage()
                .pressStartButton()
                .waitingForLiftoffText();
    }
}