package tests;

import org.junit.Test;
import utilities.TestBase;

public class Day07_TestBaseDemo extends TestBase {
    @Test
    public  void  test1(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        System.out.println(driver.getTitle());
    }
    @Test
    public  void test2(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        System.out.println(driver.getTitle());
    }

}
