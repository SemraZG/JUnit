package practices.practices_türkçe;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Türkçe_DropDown extends TestBase {
    @Test
    public void test() throws InterruptedException {

        //option 1 i 3 yöntemle şeçiniz
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown= driver.findElement(By.id("dropdown"));

        Select select=new Select(dropdown);
        select.selectByIndex(1);
       String seçilenOpsiyonIndex= select.getFirstSelectedOption().getText();
        System.out.println(seçilenOpsiyonIndex);

        Thread.sleep(2000);
        select.selectByValue("1");
       String seçilenOpsiyonValue= select.getFirstSelectedOption().getText();
        System.out.println(seçilenOpsiyonValue);

        select.selectByVisibleText("Option 1");
       String seçilenOpsiyonVisible= select.getFirstSelectedOption().getText();

       //tüm optionları yazdırma
      List<WebElement> tümOpsiyonlar= select.getOptions();
      int sayaç=1;
      for (WebElement w: tümOpsiyonlar){
          System.out.println(sayaç +" .opsiyon: "+w.getText());
          sayaç++;
      }
    }

}
