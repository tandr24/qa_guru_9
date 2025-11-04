package pages;

import com.codeborne.selenide.SelenideElement;
import pages.component.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import io.qameta.allure.Step;


public class RegistrationPage {
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement genderInput = $("#genterWrapper");
    private final SelenideElement numberInput = $("#userNumber");
    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesWrapperInput = $("#hobbiesWrapper");
    private final SelenideElement uploadPictureInput = $("#uploadPicture");
    private final SelenideElement statefieldInput = $("#state");
    private final SelenideElement stateInput = $("#react-select-3-input");
    private final SelenideElement cityfieldInput = $("#city");
    private final SelenideElement cityInput = $("#react-select-4-input");
    private final SelenideElement addressInput = $("#currentAddress");
    private final SelenideElement submitInput = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();

    @Step("Open site")
    public RegistrationPage openSite(String value) {
        open(value);
        return this;
    }

    @Step("Set first name")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Set Last Name")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Set email")
    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    @Step("Set Gender")
    public RegistrationPage setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    @Step("Set Number")
    public RegistrationPage setNumber(String value) {
        numberInput.setValue(value);
        return this;
    }

    @Step("Set Date of Birth")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("Set Object")
    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Set Hobbies")
    public RegistrationPage setHobbies(String value) {
        hobbiesWrapperInput.$(byText(value)).click();
        return this;
    }

    @Step("Set Picture")
    public RegistrationPage setPicture(String value) {
        uploadPictureInput.uploadFromClasspath(value);
        return this;
    }

    @Step("Set Address")
    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    @Step("Set State")
    public RegistrationPage setState(String value) {
        statefieldInput.click();
        stateInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Set city")
    public RegistrationPage setCity(String value) {
        cityfieldInput.scrollTo();
        cityfieldInput.click();
        cityInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Submit Form ")
    public RegistrationPage submitForm() {
        submitInput.click();
        return this;
    }

}