package TestSuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldLoginSuccessfullyWithValidCredentials() {

//Find the Username and password Field
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        //Find the password Field and Enter the password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
//Click on Login Button

        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        String expectedText = "Secure Area";
        String actualText = driver.findElement(By.tagName("h2")).getText();
        System.out.println(expectedText);
        Assert.assertEquals("Verify the text", expectedText, actualText);

    }

    @Test
    public void verifyTheUsernameErrorMessage(){

        //Find the Username and password Field
        driver.findElement(By.name("username")).sendKeys("tomsmith1");
        //Find the password Field and Enter the password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
//Click on Login Button

        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        String expectedText = "Your username is invalid!\n" +
                "×";
        String actualText = driver.findElement(By.id("flash")).getText();
        System.out.println(actualText);
        Assert.assertEquals("Your username is Invalid", expectedText, actualText);
    }

    @Test
    public void verifyTheUserPasswordErrorMessage(){
        //Find the Username and password Field
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        //Find the password Field and Enter the password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
//Click on Login Button

        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        String expectedText = "Your password is invalid!\n" +
                "×";
        String actualText = driver.findElement(By.id("flash")).getText();
        System.out.println(actualText);
        Assert.assertEquals("Your password is Invalid", expectedText, actualText);

    }

    @After
    public void tearDown(){
        //closeBrowser();
    }

}
