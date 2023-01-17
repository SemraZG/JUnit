package practices.practices_türkçe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class Türkçe_WindowHandle extends TestBase {
    @Test
    public void test() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
       String title= driver.getTitle();
        Assert.assertEquals("The Internet", title);

        //Sayfadaki textin Opening a new window olduğunu doğrula
        String window1text= driver.findElement(By.xpath("//h3[.='Opening a new window']")).getText();
        Assert.assertEquals("Opening a new window", window1text);

        driver.findElement(By.linkText("Click Here")).click();//--bu noktada ikinci window açılır
        Thread.sleep(3000);

        //açılan yeni sayfanın başlığının New Window olduğunu doğrula
        //String title2= driver.getTitle();
        //System.out.println(title2);  --> The Internet-----> yeni window açılırsa onu switch yapmadan devam edersem ilk sayfanın bilgilerini getirir.


        //açılan yeni sayfanın başlığının New Window olduğunu doğrula
        //öncelikle ilk sayfanın id si alınır
        String window1id= driver.getWindowHandle();
        //bu noktada 2 pencere açık ve ikincisine geçmek istıyorum.
       Set<String> allWindowHandles= driver.getWindowHandles();
        System.out.println(allWindowHandles);

        for (String w: allWindowHandles){
            if (!w.equals(window1id)){
                driver.switchTo().window(w); //----> eğer listedeki id window1 e eşit değilse otomatil olarak window2 ye eşittir.

            }
        }

        String title2= driver.getTitle();
        System.out.println(title2);

        //yeni sayfadaki textin New Window olduğunu test edin
        String text2= driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("New Window", text2);

        Thread.sleep(2000);
        driver.switchTo().window(window1id);

        System.out.println(title);


        //exp:2
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");
        driver.findElement(By.linkText("Click Here")).click();
       String window1= driver.getWindowHandle();
      Set<String> allWindows=  driver.getWindowHandles();
        for (String w: allWindows){
            if (!w.equals(window1)){
                driver.switchTo().window(w);
            }
        }
       String exp2title2= driver.getTitle();
        System.out.println(exp2title2);
        Assert.assertEquals("New Window",exp2title2);






    }
}
