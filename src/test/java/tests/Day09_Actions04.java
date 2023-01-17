package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Day09_Actions04 extends TestBase {
    @Test
    public void dragAndDropTest() throws InterruptedException {

    //Go to "https://jqueryui.com/droppable/"
        driver.get("https://jqueryui.com/droppable/");

    //Drag the element "Drag me to my target" to "Drop here" element and drop it.
        //1.step: Create actions object
        Actions actions=new Actions(driver);

        //Since the elements are in an iFrame, we need to switch to iFrame first.
        driver.switchTo().frame(0);//This will switch driver to iFrame

        //2.step: Locate source and target web elements
       WebElement source= driver.findElement(By.id("draggable"));
       WebElement target=driver.findElement(By.id("droppable"));

       //3.step: Use dragAndDrop() method with web elements
        Thread.sleep(200);
        actions.dragAndDrop(source, target).perform();

        /*
            If you can not find element:
            Look for:
            1. Check the locator
            2. Wait or synchonization issue
            3. iFrame

         */
    }


    @Test
    public void clickAndHoldTest() throws InterruptedException {

        //Go to "https://jqueryui.com/droppable/"
        driver.get("https://jqueryui.com/droppable/");

        //Drag the element "Drag me to my target" to "Drop here" element and drop it.
        //1.step: Create actions object
        Actions actions=new Actions(driver);

        //Since the elements are in an iFrame, we need to switch to iFrame first.
        driver.switchTo().frame(0);//This will switch driver to iFrame

        //2.step: Locate source and target web elements
        WebElement source= driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droppable"));

        //3.step: Use clickAndHold() method with web elements
        Thread.sleep(200);
        actions.clickAndHold(source).moveToElement(target).perform();

      //  dragAndDrop() method == clickAndHold() method

    }

    @Test
    public void dragAndDropByTest() throws InterruptedException {

        //Go to "https://jqueryui.com/droppable/"
        driver.get("https://jqueryui.com/droppable/");

        //Drag the element "Drag me to my target" to "Drop here" element and drop it.
        //1.step: Create actions object
        Actions actions=new Actions(driver);

        //Since the elements are in an iFrame, we need to switch to iFrame first.
        driver.switchTo().frame(0);//This will switch driver to iFrame

        //2.step: Locate source and target web elements
        WebElement source= driver.findElement(By.id("draggable"));
        //WebElement target=driver.findElement(By.id("droppable"));--IN THİS METHOD I DO NOT NEED TARGET

        //3.step: Use dragAndDropBy() method with web elements
        Thread.sleep(200);
        actions.dragAndDropBy(source, 160, 40).perform();

    }

    @Test
    public void moveByOffsetTest() throws InterruptedException {

        //Go to "https://jqueryui.com/droppable/"
        driver.get("https://jqueryui.com/droppable/");

        //Drag the element "Drag me to my target" to "Drop here" element and drop it.
        //1.step: Create actions object
        Actions actions=new Actions(driver);

        //Since the elements are in an iFrame, we need to switch to iFrame first.
        driver.switchTo().frame(0);//This will switch driver to iFrame

        //2.step: Locate source and target web elements
        WebElement source= driver.findElement(By.id("draggable"));
        //WebElement target=driver.findElement(By.id("droppable"));--IN THİS METHOD I DO NOT NEED TARGET

        //3.step: Use moveByOffset() method with web elements
        Thread.sleep(200);
        actions.clickAndHold(source).moveByOffset(160, 40).perform();
    }
}
