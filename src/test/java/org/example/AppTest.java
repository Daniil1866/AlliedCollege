package org.example;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testng.Driver; // your Driver class from before
import pom.FormPom;   // your Page Object

public class AppTest {

    WebDriver driver;
    static public String URL = "https://demoqa.com/automation-practice-form";
    static public String USER_NAME = "Daniil";
    static public String USER_SURNAME = "Sahov";
    static public String USER_EMAIL = "daniilshahov33@gmail.com";
    static public String USER_GENDER = "Male";
    static public String USER_DOB = "18 Jun 2006";
    static public String USER_NUMBER = "0123456789";
    static public String USER_SUBJECT = "Maths";

    @BeforeClass
    public void setUp() {
        driver = Driver.getLocalDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void fillFormTest() throws InterruptedException {
        driver.get(URL);
        FormPom form = new FormPom(driver);
        form.setFirstName(USER_NAME);
        form.setLastName(USER_SURNAME);
        form.closeAdvert();
        form.setUserEmail(USER_EMAIL);
        form.scrollToFirstName();
        form.setUserGender(USER_GENDER);
        form.setUserNumber(USER_NUMBER);
        form.scrollToDOB();
        form.setUserDOB(USER_DOB);
//        form.setUserSubject(USER_SUBJECT);
        System.out.println();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}