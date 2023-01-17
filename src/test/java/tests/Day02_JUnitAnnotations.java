package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Day02_JUnitAnnotations {
    /*
    So far we kept using main method
    We no longer need to use main method to create test cases with JUnit.

    @Test Annotation: is used to create test cases

    Note: All @Test methods must be void.

    @Before Annotation : Runs before each @Test class, this is used to run repeated Pre Conditions.
                         For exp: setup, create driver, maximize window

    @After Annotation : Runs after each @Test class, this is used to run repeated After Conditions.
                        For exp: driver quit, report generation
     */


    @Before
    public void setUp(){
        System.out.println("Before method runs before each @Test Annotation.");
    }
    @After
    public void tearDown(){
        System.out.println("After method runs after each @Test Annotation.");
    }
    @Test
    public void test1(){
        System.out.println("Test 1");
    }
    @Test
    public void test2(){
        System.out.println("Test 2");
    }
    @Test
    public void test3(){
        System.out.println("Test 3");
    }
    @Test
    public void test4(){
        System.out.println("Test 4");
    }
    @Test
    public void test5(){
        System.out.println("Test 5");
    }
}
