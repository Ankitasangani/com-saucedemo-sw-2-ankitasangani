package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * 2. Create the package ‘testsuite’ and create the
 * following class inside the ‘testsuite’ package.
 * 1. LoginTest
 * <p>
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userShouldLoginSuccessfullyWithValid Credentials
 * <p>
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “PRODUCTS”
 * 2. verifyThatSixProductsAreDisplayedOnPage
 * <p>
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify that six products are displayed on
 * page
 */
public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Enter Username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // Enter password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // Click on Login button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        // Verify the text “Products”
        String expectedText = "Products";
        String actualText = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        // Enter Username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        // Enter password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        // Click on Login button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        // Verify that six products are displayed on page
        List<WebElement> productElementList = driver.findElements(By.className("inventory_item"));
        System.out.println("Total Products on the page are: " + productElementList.size());
        int actualNumberOfProducts = productElementList.size();
        int expectedNumberOfProducts = 6;
        Assert.assertEquals("Number of products did not match!", actualNumberOfProducts, expectedNumberOfProducts);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

























