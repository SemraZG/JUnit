package practices.practices_türkçe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Türkçe_Actions extends TestBase {

    @Test
    public void test() {

        //Go to https://the-internet.herokuapp.com/context_menu
        driver.get("https://the-internet.herokuapp.com/context_menu");

        Actions actions=new Actions(driver);


        //Elementi locate edin
       WebElement box= driver.findElement(By.cssSelector("div[id='hot-spot']"));

       //kutuya sağ tıklayın
        actions.contextClick(box).perform();

        //alertte çıkan yazının You selected a context menu olduğunu test edin
        Assert.assertEquals("You selected a context menu", driver.switchTo().alert().getText());

        //alerti kapatın
        driver.switchTo().alert().accept();

    }

    @Test
    public void test2(){

        //https://www.amazon.com/ sayfasına git
        driver.get("https://www.amazon.com/");


        //Account & List üzerinde bekle

        Actions actions=new Actions(driver);

        WebElement accountList= driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));

        actions.moveToElement(accountList).perform();

        //açılan pencerede Account Link e tıkla
        driver.findElement(By.linkText("Account")).click();

        //title ın Your Account olduğunu doğrula
        Assert.assertEquals("Your Account", driver.getTitle());

    }

    @Test
    public void test3(){

    driver.get("https://techproeducation.com/");

    //sayfanın altına doğru gidin

        Actions actions=new Actions(driver);

//        actions.sendKeys(Keys.PAGE_DOWN).
//                sendKeys(Keys.PAGE_DOWN).
//                sendKeys(Keys.PAGE_DOWN).
//                perform();
        //or

      actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();

        //or--->ARROW_DOWN PAGE_DOWN'dan daha az mesafe aldırır

        //actions.sendKeys(Keys.ARROW_DOWN).
        // sendKeys(Keys.ARROW_DOWN).
        // sendKeys(Keys.ARROW_DOWN).
        // perform();


    //sayfanın üstüne doğru gidin
        actions.sendKeys(Keys.PAGE_UP).
                sendKeys(Keys.PAGE_UP).
                sendKeys(Keys.PAGE_UP).
                perform();

        actions.sendKeys(Keys.ARROW_RIGHT).perform();
        actions.sendKeys(Keys.ARROW_LEFT).perform();

    }

    @Test
    public void test4(){

        driver.get("https://jqueryui.com/droppable/");

        //elementi bul ve sürükle

     //driver.switchTo().frame(0);
//        or
//      WebElement iframe=driver.findElement(By.xpath("//iframe"));
//      driver.switchTo().frame(iframe);

        WebElement source= driver.findElement(By.cssSelector("div[id='draggable']"));
        waitFor(2);
        WebElement target= driver.findElement(By.cssSelector("div[id='droppable']"));

        Actions actions=new Actions(driver);
        actions.dragAndDrop(source, target).perform();



//      or
        actions.clickAndHold(source).//kaynağı tut
                moveToElement(target).//hedefe koy
                release().//kaynağı bırak
                build().//recommended, önceki methodların ilişkisini güçlendirir
                perform();



//      or----->moveByOffset ile kaynağı istediğimiz yere de bırakabiliriz
        actions.clickAndHold().
                moveByOffset(430,30).
                release().
                build().
                perform();


        driver.switchTo().defaultContent();
    }



    @Test
    public void test5() {

        driver.get("https://www.google.com/");

        //SHIFT tuşuna basarak Iphone X fiyatları yazdır
        WebElement searchBox = driver.findElement(By.cssSelector("input[class='gLFyf']"));
        //1.way; searchBox.sendKeys("Iphone X fiyatları"+ Keys.ENTER);

        Actions actions=new Actions(driver);

        actions.keyDown(searchBox, Keys.SHIFT).//arama kutusunda Shift e basılır

                sendKeys("Iphone X fiyatları ").//shift e basılıyken hepsini büyük yazdırır, içerisi büyükse yine büyük kalır

                keyUp(searchBox, Keys.SHIFT).//shift i bırakır

                sendKeys("çok pahalı"+Keys.ENTER).//normal halde mesajı yazar ve enter a basar
                build().
                perform();


    }

}
