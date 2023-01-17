package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_BasicNavigations {
    public static void main(String[] args) {
        //Step 1: Set Up
        System.setProperty("webdriver.chrome.driver","./src/resources/drivers/chromedriver_win32 (2)/chromedriver.exe");
        //Sep 2:
        WebDriver driver= new ChromeDriver();
        //Step 3: Write test scripts
        /*
        Maximize the window
        Open google home page https://www.walmart.com/.
        On the same class, Navigate to amazon home page https://www.amazon.com/
        Navigate back to walmart
        Navigate forward to amazon
        Refresh the page
        Close/Quit the browser
         */

        // Maximize the window
        driver.manage().window().maximize();
        //Open google home page https://www.walmart.com/.
        driver.get("https://www.walmart.com/");
        //On the same class, Navigate to amazon home page https://www.amazon.com/
        //1.way
        //driver.get("https://www.amazon.com/");
        //2.way
        driver.navigate().to("https://www.amazon.com/");
        //Navigate back to walmart
        driver.navigate().back();
        //Navigate forward to amazon
        driver.navigate().forward();
        //Refresh the page
        driver.navigate().refresh();
        //Close/Quit the browser
        //1.way
        //driver.close();-->just active/last driver is closed.
        //2.way
        driver.quit();//-->it closes all of them


    }
}
