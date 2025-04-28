import lv.acodemy.page_object.InventoryPage;
import lv.acodemy.page_object.LoginPage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SauceDemoTest {

    ChromeDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;

    @BeforeMethod
    public void beforeTest() {
        // Chromedriver;
        System.setProperty("webdriver.chrome.driver", "src/main/chromedriver.exe");
        driver = new ChromeDriver();
        // How to call driver methods?
        // URL: www.saucedemo.com
        driver.get("https://www.saucedemo.com");

        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
    }

    @Test
    public void verifyLoggedInTest() {
        loginPage.authorize("standard_user", "secret_sauce");
        String productsText = driver.findElement(By.className("title")).getText();
        Assertions.assertThat(productsText).isEqualTo("Products");
        Assert.assertEquals(productsText, "Products");
        }
    @Test
    public void logInTest() {
        loginPage.authorize("standard_user", "secret_sauce");

    }

    @Test
    public void addItemToTheCart() {
        loginPage.authorize("standard_user", "secret_sauce");


        inventoryPage.addItemToCartByName("Onesie");
    }

    @AfterMethod()
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
