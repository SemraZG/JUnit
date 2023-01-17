package practices.practices_türkçe;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EkranGörüntüsüAlma extends TestBase {
    /*
   ---- Ekran gürüntüsü alma

    Dökünmantasyon ve
    geçen testlerin geçtiğini ve kalan testlerin kaldığını kayda geçirmek içim alırız.

    Seleniumdan gelen TakeScreenshot apiindan gelen getScreenshotAs metodunu kullanarak otomatik screenshot alabiliriz.
    Selenium 4 den itibaren tüm ekran görüntüsünü veya sadece belirli bir elementin ekran görüntüsünü alabiliriz.

     */

    @Test
    public void test() throws IOException {
        driver.get("https://www.techproeducation.com");
        //1.Ekran görüntüsünü getScreenshotAs metodu ile alıp File  olarak oluşturuyoruz
       File image=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //2. Ekran görüntüsünü nereye kaydedeceğimizi ayarlıyoruz

        String currentDate=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        //kayıt ismini dinamik yapmak için date objesi oluşturduk

       String path=System.getProperty("user.dir")+"test-output/Screeenshots/"+currentDate+"image.png";
       File target=new File(path);

       //3.Ekran görüntüsü ile dosyayı birleştirip kaydediyoruz
        FileUtils.copyFile(image, target);


        //QA araması yap
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("QA"+ Keys.ENTER);
        waitFor(3);

        String text=driver.findElement(By.xpath("//*[contains(text(), 'Search Results for')]")).getText();
        String expected="Search Results for: QA";
        Assert.assertTrue(expected.contains(text));

        //Reusable method ile ekran görüntüsünü al
        takeScreenshotOfPage();

        //Sosyal medya elemanlarının görüntüsünü al
        driver.get("https://www.techproeducation.com");

        WebElement socialMedyaIcon= driver.findElement(By.xpath("(//div[@class='elementor-social-icons-wrapper elementor-grid'])[1]"));
        File imageOfIcons=socialMedyaIcon.getScreenshotAs(OutputType.FILE);
        String currentTime= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String pathOfElement=System.getProperty("user.dir")+"test-output/Screeenshots/"+currentTime+"image.png";

        FileUtils.copyFile(imageOfIcons, new File(pathOfElement));

        //Reusable method ile Sosyal medya elemanlarının görüntüsünü al
        takeScreenshotOfTheElement(socialMedyaIcon);

        //dosya uzerinde sağ tıklayarak open in explorer ile kaydedilen resimlere localde de ulaşabiliriz.



        /*

        --Interwiew sorusu

    Seleniumda tüm ekran görüntüsü nasıl alınır?

    Seleniumdan gelen getScreenshotAs metodununu kullanarak otomatik screenshot alabiliriz.
    getScreenshotAs metodu Seleniumdaki TakeScreenshot apiindan gelir.
    Selenium 4den itibaren hem tüm sayfanın hem tek bir elementin/elementlerin screenshot ı alınabilir.
    Reusable method ile screenhot almak da daha kolay ve kullanışlıdır.


         */

    }

}
