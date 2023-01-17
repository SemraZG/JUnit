package practices.practices_türkçe;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class WebTables extends TestBase {
    @Test
    public void test() {
        driver.get("https://the-internet.herokuapp.com/tables");
        //Table1 i print edin
        String table1 = driver.findElement(By.xpath("//table[@id='table1']")).getText();
        System.out.println(table1);

        List<WebElement> tümVeriler = (List<WebElement>) driver.findElement(By.xpath("//table[@id='table1']//td"));
        for (WebElement w : tümVeriler) {
            System.out.println(w.getText());
        }

    }

}