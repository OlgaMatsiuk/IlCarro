package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
//    WebDriver wd;
    EventFiringWebDriver wd;
    HelperUser user;
    HelperCar car;
    HelperSearch search;
    String browser;


    public HelperSearch getSearch() {
        return search;
    }


    public HelperUser getUser() {
        return user;
    }

    public HelperCar getCar() {
        return car;
    }

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
       // wd = new EventFiringWebDriver(new ChromeDriver());
        if(browser.equals(BrowserType.CHROME)){
            wd = new EventFiringWebDriver(new ChromeDriver());
            logger.info("Test start on Chrome");
        } else if(browser.equals(BrowserType.FIREFOX)){
            wd = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("Test start on Firefox");
        }
        wd.register(new MyListener());

        //wd = new ChromeDriver();
        user = new HelperUser(wd);
        car = new HelperCar(wd);
        wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro.web.app/search");
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        search = new HelperSearch(wd);
    }
    public void tearDown() {
        wd.quit();
    }
}
