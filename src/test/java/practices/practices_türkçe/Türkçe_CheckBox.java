package practices.practices_türkçe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Türkçe_CheckBox extends TestBase {
    @Test
    public void test(){
        //https://demo.guru99.com/test/radio.html
        driver.get("https://demo.guru99.com/test/radio.html");

        driver.findElement(By.id("vfb-6-0")).click();
        driver.findElement(By.id("vfb-6-1")).click();
        driver.findElement(By.id("vfb-6-2")).click();

        //sadece bir box ı seçebiliyorsam "radio button", birden fazla box ı aynı anda seçebiliyorsam bu "checkbox button" olur.

      WebElement option2= driver.findElement(By.id("vfb-7-2"));
      option2.click();
        WebElement option3= driver.findElement(By.id("vfb-7-3"));
        WebElement option1= driver.findElement(By.id("vfb-7-1"));

        Assert.assertTrue(option2.isSelected());
        Assert.assertFalse(option3.isSelected());
        Assert.assertFalse(option1.isSelected());



    }
}
