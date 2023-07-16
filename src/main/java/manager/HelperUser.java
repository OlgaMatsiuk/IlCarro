package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class HelperUser extends HelperBase{


    public HelperUser(WebDriver wd) {
        super(wd);
    }
//    public void openLoginForm() {
//        click(By.xpath("//a[.=' Log in ']"));
//    }
//
//    public void openRegistrationForm() {
//        click(By.xpath("//a[.=' Sign Up ']"));
//    }
    public void openLoginForm(){
        click(By.xpath("//a[text()=' Log in ']"));
    }

    public void openRegistrationForm(){
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void submitLogin() {
        click(By.cssSelector("button[type='submit']"));
    }
    public void fillLoginForm(String email, String password) {
        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), password);

    }
    public void fillLoginForm(User user) {
        type(By.xpath("//input[@id='email']"), user.getEmail());
        type(By.xpath("//input[@id='password']"), user.getPassword());

    }
    public void fillRegistrationForm(User user) {
        //type(By.xpath("//input[@id='name']"), user.getName());
        type(By.xpath("//input[@id='name']"), user.getName());
        type(By.xpath("//input[@id='lastName']"), user.getLastName());
        type(By.xpath("//input[@id='email']"), user.getEmail());
        type(By.xpath("//input[@id='password']"), user.getPassword());
        //click(By.cssSelector("label[for='terms-of-use']"));
//        JavascriptExecutor js = (JavascriptExecutor) wd;
//        js.executeScript("document.querySelector('#terms-of-use').click()");
        checkboxClick();
    }

    //method signature : type + name + parameters types
    public void confirmMessage(){
        click(By.xpath("//button[normalize-space()='Ok']"));
        pause(2000);
    }
    public boolean isLogged() {
       // WebDriverWait wait = new WebDriverWait(wd,10);
       // wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.partialLinkText("success"))));
        return isElementPresent(By.xpath("//a[.=' Logout ']"));
    }
    public void logout() {
        click(By.xpath("//a[normalize-space()='Logout']"));
//        click(By.xpath("//button[normalize-space()='Ok']"));
//        pause(3000);
//        click(By.xpath("//a[.=' Logout ']"));
       // wd.navigate().to("https://ilcarro.web.app/search");
    }

    public boolean isRegistered() {
      WebDriverWait wait = new WebDriverWait(wd, 10);
       wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".dialog-container"))));
        return wd.findElement(By.cssSelector(".dialog-container")).getText().contains("Registered");
    }

    public void login(User user) {
        openLoginForm();
        fillLoginForm(user);
        submitLogin();
        confirmMessage();
    }
    public void checkboxClick() {

        //variant 1
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').click()");

        //variant 2

//        Rectangle rect = wd.findElement(By.cssSelector(".checkbox-container")).getRect();
//        int x = rect.getX()+5;
//        int y = rect.getY()+rect.getHeight() / 4;
//        Actions actions = new Actions(wd);
//        actions.moveByOffset(x, y).click().perform();



    }



}
