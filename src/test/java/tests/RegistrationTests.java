package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @Test
    public void registrationPositive(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;

        User user = new User()
                .withName("John")
                .withLastName("News")
                .withEmail("john" + i + "@gmail.com")
                .withPassword("Dfr#12584tre");
        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitLogin();
        app.getUser().isRegistered();
        logger.info("Registration test starts with data: " + user.getEmail()
                + "&" + user.getPassword());
        Assert.assertTrue(app.getUser().isRegistered());
    }

    @Test
    public void registrationNegativeWrongPassword(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;

        User user = new User()
                .withName("John")
                .withLastName("News")
                .withEmail("john" + i + "@gmail.com")
                .withPassword("12584tre");
        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitLogin();

       // app.getUser().isRegistered();
    }


}
