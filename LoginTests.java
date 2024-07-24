import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.Map;
public class LoginTests extends BaseTest {
    @Tag("login")
    @Test
    public void testSuccessfulSignIn() throws IOException {
//        Map<String, String> credentials = DataProvider.getCredentials();
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();

        // Verify that the user is redirected to the Products page
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            System.out.println("Login successful - Test Passed!");
        } else {
            System.out.println("Login unsuccessful - Test Failed!");
        }

    }
}