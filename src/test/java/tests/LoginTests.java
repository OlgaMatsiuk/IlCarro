package tests;

import manager.ProviderData;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import manager.ProviderData;

public class LoginTests extends TestBase {

    @BeforeMethod(alwaysRun = true)

    public void precondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
        }
    }


    @Test
    public void loginPositive() {
        String email = "matsiuk2015@gmail.com", password = "Aravaavara0#";

        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//h1[normalize-space()='Logged in']")));
        app.getUser().confirmMessage();
        // app.getUser().pause(2000);

    }

    @Test(groups = {"smokeGroup","sanityGroup","regressionGroup"})
    public void loginPositiveUser() {
        String email = "matsiuk2015@gmail.com", password="Aravaavara0#";

        User user = new User().withEmail(email).withPassword(password);



        app.getUser().openLoginForm();
        // app.getUser().fillLoginForm(email, password);
        // app.getUser().fillLoginForm(user.getEmail(), user.getPassword());
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
       // Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//h1[normalize-space()='Logged in']")));
        app.getUser().confirmMessage();
        // app.getUser().pause(2000);

    }

    @Test
    public void loginNegativeUser() {
        //String email = "matsiuk2015@gmail.com", password="Aravaavara0#";

        User user = new User().withEmail("matsiuk+2015gmailcom").withPassword("Aravaavara0");


        app.getUser().openLoginForm();
        // app.getUser().fillLoginForm(email, password);
        // app.getUser().fillLoginForm(user.getEmail(), user.getPassword());
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        if (app.getUser().isElementPresent(By.xpath("//button[@disabled]"))) {
            System.out.println("Email or password are not valid");
        } else {
            Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//h1[normalize-space()='Login failed']")));
            app.getUser().confirmMessage();
            // app.getUser().pause(2000);

        }
    }

    @Test(dataProvider = "userModelListDTO", dataProviderClass = ProviderData.class)
    public void loginPositiveUser(User user) {
       // String email = "matsiuk2015@gmail.com", password="Aravaavara0#";

       // User user = new User().withEmail(email).withPassword(password);
logger.info("User: " + user.toString() + " is provided");



        app.getUser().openLoginForm();
        // app.getUser().fillLoginForm(email, password);
        // app.getUser().fillLoginForm(user.getEmail(), user.getPassword());
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        // Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//h1[normalize-space()='Logged in']")));
        app.getUser().confirmMessage();
        // app.getUser().pause(2000);

    }

}


