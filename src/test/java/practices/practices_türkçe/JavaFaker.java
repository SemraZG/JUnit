package practices.practices_türkçe;

import com.github.javafaker.Faker;
import org.bouncycastle.jcajce.provider.symmetric.Serpent;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class JavaFaker extends TestBase {
    @Test
    public void test(){

        driver.get("https://www.facebook.com");

        //yeni hesap oluştur a tıklayın
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        //isim kutusunu locate edin
        WebElement nameBox= driver.findElement(By.name("firstname"));

        //kutucukları TAB ile dolaşarak faker bilgilerle doldurun

        Faker faker=new Faker();
        Actions actions= new Actions(driver);

        String email=faker.internet().emailAddress();

        actions.click(nameBox).sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).sendKeys(email).
                sendKeys(Keys.TAB).sendKeys(email).
                sendKeys(Keys.TAB).sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("15").
                sendKeys(Keys.TAB).
                sendKeys("Mart").
                sendKeys(Keys.TAB).
                sendKeys("2000").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_RIGHT).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();

    }

}
