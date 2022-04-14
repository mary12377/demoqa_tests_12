package pages;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static java.text.MessageFormat.format;

public class TextBoxRegistrationTests {
    RegistrationPage registrationPage = new RegistrationPage();

    String firstName = "Maria";
    String lastName = "Bulanjova";
    String email = "maria@mail.ru";
    String Mobil = "89817572792";
    String Subjects = "History";
    String Hobbies = "Music";
    String address = "academician yangel street";
    String gender = "Female";
    String day = "6";
    String month = "April";
    String year = "1993";
    String file = "Lesson_2.JPG";
    String state = "NCR";
    String city = "Delhi";
    String stateCity = format("%s %s", state, city);



    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTests() {

        registrationPage .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setMobil(Mobil);
        registrationPage .setDate(day,month,year);
        registrationPage .openPage()
                .setSubject(Subjects)
                .setHobby(Hobbies)
                .uploadPicture(file)
                .setAddress(address)
                .setState(state)
                .setCity(city);
        registrationPage .submitForm();


         registrationPage.checkResult(  firstName, lastName)
                .checkResult( email )
                .checkResult( gender)
                .checkResult( Mobil)
                .checkResult(day,month,year)
                .checkResult(  Hobbies)
                .checkResult(file)
                .checkResult( address)
                .checkResult(stateCity)
                .checkResult( Subjects)
                .clickCloseModal();


    }

    }
