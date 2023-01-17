package practices.practices_türkçe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class Türkçe_WindowHandle2 extends TestBase {
    @Test
    public void test(){
        driver.get("https://www.amazon.com/");

        //sayfanın window handle değerini alın
        String amazonWindow= driver.getWindowHandle();

        //title ın amazon içerdiğini test edin
       Assert.assertTrue(driver.getTitle().contains("Amazon"));

       //yeni bir tab oluşturun ve techpro adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);//yeni sekme açmış olduk
        driver.get("https://techproeducation.com");

        //yeni bir window oluşturun ve walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://walmart.com");

        //title in Walmart içerdiğini test edin
       Assert.assertTrue(driver.getTitle().contains("Walmart"));

       //ilk sayfaya gidin ve amazon sayfası olduğunu test edin
        driver.switchTo().window(amazonWindow);
        Assert.assertEquals("https://www.amazon.com/", driver.getCurrentUrl());
    }
}
