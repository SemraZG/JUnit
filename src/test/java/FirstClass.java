import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver_win32 (2)/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.techproeducation.com");

    }
}
