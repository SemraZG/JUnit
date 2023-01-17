package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;

import javax.accessibility.AccessibleTable;
import java.sql.SQLOutput;

public class Day02_Titleverification {
    public static void main(String[] args) {
        /*
       //getPageSource() returns page source code as a string
        //We might use this to verify if a certain text exist in the entire page
        //Note that pageSource is not used a lot to do assertions
        //Because it is too general and can lead false result
        TEST CASE:
        Test if amazon contains “Registry” on the homepage
        Create a new class : GetPageSource
         */

        System.setProperty("webdriver.chrome.driver","./src/resources/drivers/chromedriver_win32 (2)/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.techproeducation.com");

        //get the title
       String actualTitle= driver.getTitle();
       String expectedTitle= "Techpro Education | Online It Courses & Bootcamps";

       //verify if page title is “Techpro Education | Online It Courses & Bootcamps”

        if (actualTitle.equals(expectedTitle)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("ACTUAL TITLE: "+ actualTitle);
            System.out.println("BUT EXPECTED TITLE : "+expectedTitle);
        }
        driver.quit();

    }
}
