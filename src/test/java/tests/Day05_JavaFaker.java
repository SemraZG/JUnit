package tests;

import com.github.javafaker.Faker;
import org.junit.Test;

public class Day05_JavaFaker {
/*
    TEST DATA : username, password, URL, test enviroment, city, ssn...
     Where do you get your test data?
    -BA-Business Analyst(Wretes the aceptance criteria(AC))
    -Test Lead
    -Manuel Tester
    -Tech Lead(Team Lead)
    -Developer
    -We can get retrieve data from the database
    -We can get retrieve data from API
    -Documentation, for exp swagger doc can be used for API

    --If we need mock data(fake data), we can use the Java Faker
    Note: Java Faker generates data randomly.

 */
    @Test
    public void javaFaker(){
        //1. Create the Faker Object
        Faker faker= new Faker();

        //2. Now that we have faker object we can generate the fake data
        // --generating username
        String firstname= faker.name().firstName();
        System.out.println(firstname);//it gives us any name randomly --Merlyn or Semra or Jake or Osman

        // --generating lastname
        String lastname= faker.name().lastName();
        System.out.println(lastname);
        // --generating username
        String username= faker.name().username();
        System.out.println(username);
        // --generating title
        String title=faker.name().title();
        System.out.println(title);
        // --generating city
        String city=faker.address().city();
        System.out.println(city);
        // --generating state
        String state=faker.address().state();
        System.out.println(state);
        // --generating full address
        String fullAddress=faker.address().fullAddress();
        System.out.println(fullAddress);
        // --generating cellphone
        System.out.println(faker.phoneNumber().cellPhone());
        // --generating email
        System.out.println(faker.internet().emailAddress());
        // --generating zip code
        System.out.println(faker.address().zipCode());
        // --generating random digit number
        System.out.println(faker.number().digits(8));
    }


}
