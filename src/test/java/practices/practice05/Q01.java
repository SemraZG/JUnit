package practices.practice05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Q01 extends TestBase {
    @Test
    public void test(){

        //https://testpages.herokuapp.com/styled/tag/table.html

        //Calculate the total amount on the table
        driver.get("https://testpages.herokuapp.com/styled/tag/table.html");

       List<WebElement> amounts= driver.findElements(By.xpath("//tbody//td[2]"));

       double sum= 0;
       for (WebElement each: amounts){
         sum= sum+ Double.parseDouble(each.getText());
         //parseDouble just convert into primitive data -->double, if it is Double parseDouble does not work.
           //we can also use valueOf() instead of parseDouble
       }

       System.out.println("sum= "+sum);


       //Assert the amount
        Assert.assertTrue(sum==110.3);




    }

}
