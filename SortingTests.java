import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class SortingTests extends BaseTest {
    @Tag("sorting")
    @Test
    public void testSortingOptions() {
        driver.findElement(By.id("user-name")).sendKeys(usernamefield);
        driver.findElement(By.id("password")).sendKeys(passwordfield);
        driver.findElement(By.id("login-button")).click();
        Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
        // Verify sorting by name (A to Z)
        dropdown.selectByVisibleText("Name (A to Z)");
        List<WebElement> items = driver.findElements(By.className("inventory_item_name"));
        Assertions.assertTrue(isSortedByName(items, true));
        // Verify sorting by name (Z to A)
        dropdown.selectByVisibleText("Name (Z to A)");
        items = driver.findElements(By.className("inventory_item_name"));
        Assertions.assertTrue(isSortedByName(items, false));
        // Verify sorting by price (low to high)
        dropdown = new Select(driver.findElement(By.className("product_sort_container")));
        dropdown.selectByVisibleText("Price (low to high)");
        items = driver.findElements(By.className("inventory_item_price"));
        Assertions.assertTrue(isSortedByPrice(items, true));
        // Verify sorting by price (high to low)
        dropdown = new Select(driver.findElement(By.className("product_sort_container")));
        dropdown.selectByVisibleText("Price (high to low)");
        items = driver.findElements(By.className("inventory_item_price"));
        Assertions.assertTrue(isSortedByPrice(items, false));
    }
    private boolean isSortedByName(List<WebElement> items, boolean ascending) {
        List<String> itemNames = items.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> sortedNames = new ArrayList<>(itemNames);
        sortedNames.sort(ascending ? String::compareTo : Comparator.reverseOrder());
        return itemNames.equals(sortedNames);
    }
    private boolean isSortedByPrice(List<WebElement> items, boolean ascending) {
        List<Double> itemPrices = items.stream()
                .map(item -> Double.parseDouble(item.getText().replace("$", "")))
                .collect(Collectors.toList());
        List<Double> sortedPrices = new ArrayList<>(itemPrices);
        sortedPrices.sort(ascending ? Double::compareTo : Comparator.reverseOrder());
        return itemPrices.equals(sortedPrices);
    }
}