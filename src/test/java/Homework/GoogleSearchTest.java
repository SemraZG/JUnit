package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import utilities.TestBase;

import java.time.Duration;

public class GoogleSearchTest {
    protected WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//15 seconds wait in case needed
        driver.manage().window().maximize();
    }
    @Test
    public void searchtTest(){
        /*
          When user goes to https://www.google.com/
        Search for “porcelain teapot”
        And print how many related results displayed on Google
         */

        driver.get("https://www.google.com/");
      WebElement element= driver.findElement(By.xpath("//input[@class='gLFyf']"));
      element.sendKeys("porcelain teapot", Keys.ENTER);


       String result= driver.findElement(By.id("result-stats")).getText();

        System.out.println(result);

        }
    }

