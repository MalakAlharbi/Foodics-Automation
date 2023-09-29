package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TestBase {
    WebDriver driver;
    @BeforeTest
    public void setup(){
        ChromeOptions chromeOptions = new ChromeOptions();
        // TODO: handle browser options
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("--disable-web-security");
        chromeOptions.addArguments("--no-proxy-server");
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.setExperimentalOption("prefs", prefs);
        chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(chromeOptions);

        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
