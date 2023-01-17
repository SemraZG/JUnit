package practices.practice02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q05 extends TestBase {
    @Test
    public void test(){
        // Go to URL : https://demo.automationtesting.in/Static.html
        // Drag and drop elements.

        driver.get("https://demo.automationtesting.in/Static.html");
        //Locate sources
        WebElement angular= driver.findElement(By.id("angular"));
        WebElement mongo=driver.findElement(By.id("mongo"));
        WebElement node=driver.findElement(By.id("node"));

        //Locate target
        WebElement droparea=driver.findElement(By.id("droparea"));

        //Create actions object
        Actions actions=new Actions(driver);
        actions.dragAndDrop(angular, droparea).
                dragAndDrop(mongo, droparea).
                dragAndDrop(node, droparea).
                build().perform();

    }
}
