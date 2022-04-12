package pages;

import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendar = new CalendarComponent();


    public RegistrationPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }



    public RegistrationPage setFirstName(String firstName) {
        $("#firstName").setValue(firstName);

        return this;
    }


    public RegistrationPage setLastName(String lastName) {
        $("#lastName").setValue(lastName);

        return this;
    }

    public RegistrationPage setEmail(String email) {
        $("#userEmail").setValue(email);

        return this;
    }

    public RegistrationPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }

    public void setMobil(String mobil) {
        $("#userNumber").setValue(mobil);

    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day,month,year);

        return this;

    }

    public RegistrationPage setSubject(String Subject) {
        $("#subjectsInput").setValue(Subject).pressEnter();

        return this;
    }

    public RegistrationPage setHobby(String Hobby) {
        $("#hobbiesWrapper").$(byText(Hobby)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        $("[id=uploadPicture]").uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setAddress(String address) {
        $("#currentAddress").setValue(address);

        return this;
    }

    public RegistrationPage setState(String value) {
        $("#state").click();
        $(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        $("#city").click();
        $(byText(value)).click();

        return this;
    }


    public void submitForm() {
        $("#submit").click();
    }
    public RegistrationPage checkResult( String key, String value) {
        $(".table-responsive").$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }

    public void clickCloseModal() {
        $("#closeLargeModal").click();

    }
}


