package practices.practice06;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Q01 {
    @Test
    public void test() throws FileNotFoundException {
        /*
    Given
        Save EarningList.xlsx file into your project
    When
        In the row column, write the row numbers according to the earnings amount.
    Then
        Assert that row number of Wednesday is 1
     */

       FileInputStream fileInputStream= new FileInputStream("src/test/java/resourecs/EarningList (2).xlsx");


    }
}
