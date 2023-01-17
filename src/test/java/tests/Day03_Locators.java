package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class Day03_Locators {
    /*
        User goes to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        Locate the elements of Username textbox, Password textbox, and Login button
        Enter below username and password then click on login button
                Username :  Admin
                Password :  admin123
        Verify the login is successful
        Sign out from the page
        */
    @Test

    public void loginTest() throws InterruptedException {
        //User goes to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Thread.sleep(3000);

        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Locate the elements of Username textbox, Password textbox, and Login button
        Thread.sleep(5000);
        WebElement usernameTextBox =driver.findElement(By.xpath("//input[@name='username']"));//done:)
        // we need to use java==> Thread.sleep (3000) for example to wait the required elements to be loaded...
        WebElement passwordTextBox =driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.tagName("button"));

        //Enter below username and password then click on login button
        //Username :  Admin
        //Password :  admin123

       usernameTextBox.sendKeys("Admin" );
        passwordTextBox.sendKeys("admin123");
        loginButton.click();

       //Assert the login is successful
      //https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index =>current url
       boolean actualValue= driver.getCurrentUrl().contains("dashboard");
       assertTrue(actualValue);


    }
}
