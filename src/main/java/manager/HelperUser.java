package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{


    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void openLoginForm() {
        click(By.xpath("//a[.=' Log in ']"));
    }

    public void submitLogin() {
        click(By.cssSelector("button[type='submit']"));
    }
    public void fillLoginForm(String email, String password) {
        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), password);

    }
    public void confirmMessage(){
        click(By.xpath("//button[normalize-space()='Ok']"));
    }
    public boolean isLogged() {
        return isElementPresent(By.xpath("//a[.=' Logout ']"));
    }
    public void logout() {
        click(By.xpath("//a[normalize-space()='Logout']"));
//        click(By.xpath("//button[normalize-space()='Ok']"));
//        pause(3000);
//        click(By.xpath("//a[.=' Logout ']"));
       // wd.navigate().to("https://ilcarro.web.app/search");
    }


}
