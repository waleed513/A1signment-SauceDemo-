import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

public class CartTests extends BaseTest {
//    @BeforeEach
//    public void setUp() throws MalformedURLException {
//
//    }
    @Tag("cart")
    @Test
    public void testAddRemoveItemsFromProductsPage() {
        driver.findElement(By.id("user-name")).sendKeys(usernamefield);
        driver.findElement(By.id("password")).sendKeys(passwordfield);
        driver.findElement(By.id("login-button")).click();
        // Add items to the cart
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        // Verify item added
        Assertions.assertTrue(driver.findElement(By.className("shopping_cart_badge")).isDisplayed());
        // Remove items from the cart
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
        // Verify item removed
        Assertions.assertFalse(driver.findElement(By.className("shopping_cart_badge")).isDisplayed());
    }
    @Tag("cart")
    @Test
    public void testAddRemoveItemsFromCheckoutPage() {
        driver.findElement(By.id("user-name")).sendKeys(usernamefield);
        driver.findElement(By.id("password")).sendKeys(passwordfield);
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.id("checkout")).click();
        // Remove item from cart on checkout page
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
        // Verify item removed
        Assertions.assertFalse(driver.findElement(By.className("shopping_cart_badge")).isDisplayed());
    }
    @Tag("cart")
    @Test
    public void testAddRemoveItemsFromProductDetailsPage() {
        driver.findElement(By.id("user-name")).sendKeys(usernamefield);
        driver.findElement(By.id("password")).sendKeys(passwordfield);
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("item_4_title_link")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        // Verify item added
        Assertions.assertTrue(driver.findElement(By.className("shopping_cart_badge")).isDisplayed());
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
        // Verify item removed
        Assertions.assertFalse(driver.findElement(By.className("shopping_cart_badge")).isDisplayed());
    }
    @Tag("cart")
    @Test
    public void testCartPersistence() throws IOException {
//        Map<String, String> credentials = DataProvider.getCredentials();
        driver.findElement(By.id("user-name")).sendKeys(usernamefield);
        driver.findElement(By.id("password")).sendKeys(passwordfield);
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();
        driver.findElement(By.id("user-name")).sendKeys(usernamefield);
        driver.findElement(By.id("password")).sendKeys(passwordfield);
        driver.findElement(By.id("login-button")).click();
        // Verify cart persistence
        Assertions.assertTrue(driver.findElement(By.className("shopping_cart_badge")).isDisplayed());
    }
}