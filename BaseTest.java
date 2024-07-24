import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected WebDriver driver;
    protected String usernamefield;
    protected String passwordfield;

    @BeforeEach
    public void setUp() throws IOException {
        String browser = ConfigReader.getProperty("browser");
        if (browser.equals("chrome")) {
            driver = new RemoteWebDriver(new URL("http://localhost:4444"), new ChromeOptions());
        } else if (browser.equals("firefox")) {
            driver = new RemoteWebDriver(new URL("http://localhost:4444"), new FirefoxOptions());
        }
        User myUser = DataProvider.getCredentials();
       usernamefield = myUser.username;
       passwordfield = myUser.password;
         driver.get("https://www.saucedemo.com");
    }
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}