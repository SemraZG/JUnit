package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Day14_TimeOutException extends TestBase {
    @Test
    public void timeOutExceptionTest(){

        driver.get("https://techproeducation.com/");

        waitForVisibility(By.xpath("//123"), 3);//if it can not find the element in 3 secs, it will throe time out exception

    }
}
