package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Day08_Authentication extends TestBase {
    /*
        username : admin
        pass     : admin
        url      : the-internet.herokuapp.com/basic_auth
        SPECIAL URL FOR AUTHENTICATION:
        GO LINK  : https://username:pass@url
         */

    @Test
    public void authTest(){

        driver.get("https://the-internet.herokuapp.com/basic_auth");
        //henuz Authentication olmadığı için bu noktada kullanıcı adı ve şifre istedi ama gelen elementler inspect yapılamıyor alertdeki gibi.

        //Authentication
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        //Assertion
//      String successMessage= driver.findElement(By.xpath("//h3")).getText();
//      Assert.assertEquals("Basic Auth", successMessage);
//      //or
        String successMessage= driver.findElement(By.xpath("//p")).getText();
        Assert.assertEquals("Congratulations! You must have the proper credentials.", successMessage);


    }
}
