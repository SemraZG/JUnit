package tests;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class Day09_FileExistTest {
    /*
    Given
        Create a file on desktop
    When
        Copy the path of file ------  C:\Users\semra\OneDrive\Masaüstü\file.txt.txt
    Then
        Assert if the file exists
    */


    @Test
    public void isExistTest(){

      String userDir=  System.getProperty("user.dir");//Gives the path of the current project folder
        System.out.println("userDir = "+userDir);

      String userHome =  System.getProperty("user.home");//Gives the user folder
        System.out.println("userHome = "+userHome);
        //Assert if the file exist
        boolean isExist= Files.exists(Paths.get("C:\\Users\\semra\\OneDrive\\Masaüstü\\file.txt.txt"));

        assertTrue(isExist);
    }
}
