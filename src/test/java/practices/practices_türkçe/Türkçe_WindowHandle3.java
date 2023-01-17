package practices.practices_türkçe;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class Türkçe_WindowHandle3 extends TestBase {
    @Test
    public void test() throws InterruptedException {
        driver.get("https://html.com/tags/iframe");
       String windowHandle1= driver.getWindowHandle();

        //youtube videosunu çalıştırın
       WebElement iframe= driver.findElement(By.xpath("//iframe[@width='560']"));
       driver.switchTo().frame(iframe);
       driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();

       //3 saniye çalıştıktan sonra sayfayı yenileyin.
        Thread.sleep(3000);
        driver.navigate().refresh();

        //yeni sekmede amazon adresine gidiniz
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com/");

        //iphone aratınız
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //arama sonucu olarak sadece sonuçyazısnı yazdırın
      String [] result= driver.
                        findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).
                        getText().split(" ");
        System.out.println(result[2]);

        //ilk sekmeye geçin ve url i yazdırın
        driver.switchTo().window(windowHandle1);
        System.out.println(driver.getCurrentUrl());

        //ilk sekmeyi kapatın
        driver.close();


    }
}
