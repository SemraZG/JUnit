package practices.practice04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

/*
  Given
      Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
  When
      Click on "click me" button
  Then
      Verify that "Event Triggered"
   */

public class Q02 extends TestBase {
    @Test
    public void test(){

//        Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
        driver.get("https://testpages.herokuapp.com/styled/challenges/growing-clickable.html");

//        Click on "click me" button
       WebElement clickButton=  driver.findElement(By.id("growbutton"));
       //fluentWait("//button[@id='growbutton']", 10,2).click();
       //waitForClickablility(clickButton, 5).click();
        waitFor(4);//other waits did not work
       clickButton.click();
//        Verify that "Event Triggered"
       String growButtonStatus= driver.findElement(By.id("growbuttonstatus")).getText();
       assertEquals("Event Triggered", growButtonStatus);

    }
}
