package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TextBoxTests {


    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTests() {
        String firstName = "Maria";
        String lastName = "Bulanjova";
        String email = "maria@mail.ru";
        String Mobil = "89817572792";
        String Subjects = "History";
        String Hobbies = "Music";
        String imgPath = "image.JPG";
        String address = "academician yangel street";

        Selenide.open("/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $(byText("Female")).click();
        $("#userNumber").setValue(Mobil);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1993");
        $(byText("6")).click();
        $("#subjectsInput").setValue(Subjects).pressEnter();
        $("#hobbiesWrapper").$(byText(Hobbies)).click();
        $("#uploadPicture").uploadFromClasspath(imgPath);
        $("#currentAddress").setValue(address);
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive") .shouldHave(text("firstName lastName"),

                text(email),
                text(Mobil),
                text(Subjects),
                text(Hobbies),
                text(imgPath),
                text(address));

        
        $("#closeLargeModal").click();

    }
    }

