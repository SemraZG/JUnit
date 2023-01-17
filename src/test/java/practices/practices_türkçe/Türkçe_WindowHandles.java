package practices.practices_türkçe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class Türkçe_WindowHandles extends TestBase {
    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/iframe");

       String window1= driver.getWindowHandle();

        //An İframe.. altındaki Box a techproeducation yazın
        WebElement iframe=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);

        WebElement box= driver.findElement(By.id("tinymce"));
        box.clear();
        box.sendKeys("Techproeducation");

        //box in altında bulunan  Elemental Selenium yazısının görünür olduğunu test edin
        driver.switchTo().defaultContent();

        WebElement elementium= driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementium.isDisplayed());

        // Elemental Selenium yazısına tıklayın
        elementium.click();
        //yeni bir pencere açacağı için önce o pencereye geçmem gerekecek bunun için de windowHandles yöntemlerini kullanmalıyım; set veya list olarak

        List<String> windowHandles= new ArrayList<>(driver.getWindowHandles());
        System.out.println(windowHandles);
        driver.switchTo().window(windowHandles.get(1));//-->2. pencereye geçmiş oluruz, index 0'dan başşladığı içim get(1) bize ikinci window u getirecek.

        //or
//        Set<String> windowHandleSeti= driver.getWindowHandles();
//        String ikinciWindow= "";
//        for (String w: windowHandleSeti){
//            if (!w.equals(window1)){
//                ikinciWindow=w;
//            }
//        }


        //açılan sayfanın sayfa başlığını yazdırın
        System.out.println(driver.getTitle());

        //Elemental Selenium linki altındaki Sauce Labs yazısının
        WebElement sauceLabs=driver.findElement(By.linkText("Sauce Labs"));
        Assert.assertTrue(sauceLabs.isDisplayed());

        //Sauce Labs linkine tıklayın
        sauceLabs.click();//--tıkladığımızda bizi üçüncü bir pencereye götürüyor

        List<String> windowHandles2= new ArrayList<>(driver.getWindowHandles());//yeni bir window geldiği için eskisini kullanamam yeni bir list oluşturuyorum
        driver.switchTo().window(windowHandles2.get(2));//get(2) ile 3. window a geçebilmiş olacağım

        //açılan sayfa başlığını yazdırın
        System.out.println(driver.getTitle());

        //ilk sekmeye geri dönüp url i yazdırın
        driver.switchTo().window(windowHandles.get(0));

        //ilk sayfayı kapatın
        driver.close();

//     //windowslar arası geçiş yapma
//     public static void switchToWindow(int windowNumber){
//      List<String> allWindows=new ArrayList<>(driver.getWindowHandles());
//      driver.switchTo().window(allWindows.get(windowNumber));
//     }

        switchToWindow(1);


    }
}
