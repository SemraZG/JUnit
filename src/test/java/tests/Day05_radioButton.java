package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class Day05_radioButton {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://testcenter.techproeducation.com/index.php?page=radio-buttons");
    }
    @Test
    public void radioTest(){
//select red button
        WebElement redOption=driver.findElement(By.id("red"));
        redOption.click();
        assertTrue(redOption.isSelected());//Verifying the red button is selected
//select football button
        WebElement footballOption=driver.findElement(By.id("football"));
        footballOption.click();
        assertTrue(footballOption.isSelected());

    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
