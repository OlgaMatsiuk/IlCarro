package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
//    WebDriver wd;
    EventFiringWebDriver wd;
    HelperUser user;
    HelperCar car;
    HelperSearch search;
    String browser;
    Properties properties;


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
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "pre_prod_config");
        //properties.load(new FileReader(new File("src/test/resources/pre_prod_config.properties")));
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

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
        //wd.navigate().to("https://ilcarro.web.app/search");
        wd.navigate().to(properties.getProperty("web.baseURL"));

        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


        search = new HelperSearch(wd);
    }
    public void tearDown() {
        wd.quit();
    }
}
