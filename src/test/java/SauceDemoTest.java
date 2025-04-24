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

    @BeforeMethod
    public void beforeTest() {
        // Chromedriver;
        System.setProperty("webdriver.chrome.driver", "src/main/chromedriver.exe");
        driver = new ChromeDriver();
        // How to call driver methods?
        // URL: www.saucedemo.com
        driver.get("https://www.saucedemo.com");
        // Need to find element, name input field?
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // hello -> char sequence h e l l o;
        //By.id();
        //By.name();
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // Enter password!
        driver.findElement(By.xpath("//input[@data-test='login-button']")).click();
    }

    @Test
    public void verifyLoggedInTest() {
        String productsText = driver.findElement(By.className("title")).getText();
        Assertions.assertThat(productsText).isEqualTo("Products");
        Assert.assertEquals(productsText, "Products");
        }

    @AfterMethod()
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
