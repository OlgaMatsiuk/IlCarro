package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod

    public void precondition(){
        if(app.getUser().isLogged()) {
            app.getUser().logout();
        }
    }


    @Test
    public void loginPositive() {
        String email = "matsiuk2015@gmail.com", password="Aravaavara0#";

        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//h1[normalize-space()='Logged in']")));
        app.getUser().confirmMessage();
       // app.getUser().pause(2000);

    }

}
