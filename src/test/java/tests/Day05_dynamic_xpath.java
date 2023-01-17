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

public class Day05_dynamic_xpath {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @Test
    public void dynamicXpath(){
        //THERE ARE DIFFERENT XPATH TO LOCATE A TEXT ELEMENT ON A PAGE
        //1.XPATH ==> //*[.='TEXT OH THE ELEMENT']
        //Verify id "Username : Admin" is text is displayed on the page
        ////[.='Username : Admin!] return thr element whose text = Username : Admin
        WebElement userNameText=driver.findElement(By.xpath("//*[.='Username : Admin']"));
        assertTrue(userNameText.isDisplayed());

       //Verify if "Password : admin123" text is displayed on the page
        WebElement passwordText=driver.findElement(By.xpath("//*[.='Password : admin123']"));//ACCEPTS JUST FULL TEXT
        assertTrue(passwordText.isDisplayed());

        //2.XPATH ==> //*[(text()='TEXT OH THE ELEMENT']
        WebElement userNameText1=driver.findElement(By.xpath("//*[(text()='Username : Admin')]"));//ACCEPTS JUST FULL TEXT
        assertTrue(userNameText1.isDisplayed());

        //"//*[.='Username : Admin']" == "//*[(text()='Username : Admin']"

        //3.XPATH ==> //*[contains(text(), 'PARTIAL OR FULL TEXT OF THE ELEMENT')]
        WebElement passwordText1=driver.findElement(By.xpath("//*[contains(text(), 'Passw')]"));//ACCEPTS PARTIAL OR FULL TEXT
        assertTrue(passwordText1.isDisplayed());

        //    "//*[.='Username : Admin']"===> THİS WAY İS RECOMMENDED
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
