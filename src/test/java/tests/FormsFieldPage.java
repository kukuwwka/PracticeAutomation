package tests;

import org.testng.annotations.Test;

public class FormsFieldPage extends BaseTest {

    @Test
    public void formsTest() {
        formsFieldPage
                .openFormsFieldPage()
                .fillFormsFieldPage();
    }
}