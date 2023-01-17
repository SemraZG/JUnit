package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Day08_Actions01 extends TestBase {
    /*
        Go to "https://the-internet.herokuapp.com/context_menu"
        Right click on the box
        Verify the alert message is “You selected a context menu”
        Accept the alert
            */
    @Test
    public void rightclickTest(){
//        Go to "https://the-internet.herokuapp.com/context_menu"
        driver.get("https://the-internet.herokuapp.com/context_menu");

//        Right click on the box

        //1.step: create "actions" object
        Actions actions=new Actions(driver);
        //2.step: Locate the web element you want to right click
        WebElement box= driver.findElement(By.id("hot-spot"));
        //3.step: Use actions object with proper method
        actions.contextClick(box).perform();

//        Verify the alert message is “You selected a context menu”
        String alertText=driver.switchTo().alert().getText();
        Assert.assertEquals("You selected a context menu", alertText);

//        Accept the alert
        driver.switchTo().alert().accept();

    }
}
