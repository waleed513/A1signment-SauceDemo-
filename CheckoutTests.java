import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
public class CheckoutTests extends BaseTest {
    @Tag("purchase")
    @Test
    public void testBuyItems() {
        driver.findElement(By.id("user-name")).sendKeys(usernamefield);
        driver.findElement(By.id("password")).sendKeys(passwordfield);
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();
        // Verify purchase
        Assertions.assertTrue(driver.findElement(By.className("complete-header")).isDisplayed());
    }
}









