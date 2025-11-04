import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.component.CheckComponent;

import static io.qameta.allure.Allure.step;

public class RegistrationTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    CheckComponent checkComponent = new CheckComponent();

    @Test
    @Tag("demoqa")
    void formTest() {

        registrationPage.openSite("/automation-practice-form")
                .setFirstName("Name")
                .setLastName("Surname")
                .setUserEmail("email@mail.com")
                .setGender("Female")
                .setNumber("0123456789")
                .setDateOfBirth("19", "May", "1998")
                .setSubject("Math")
                .setSubject("Ch")
                .setHobbies("Music")
                .setHobbies("Reading")
                .setPicture("img.png")
                .setAddress("Address")
                .setState("NCR")
                .setCity("Delhi")
                .submitForm();

        checkComponent.haveResultPhrase()
                .checkResult("Name Surname")
                .checkResult("email@mail.com")
                .checkResult("Female")
                .checkResult("0123456789")
                .checkResult("19 May,1998")
                .checkResult("Maths, Chemistry")
                .checkResult("Music, Reading")
                .checkResult("img.png")
                .checkResult("Address")
                .checkResult("NCR Delhi");

    }

    @Test
    @Tag("demoqa")
    void minimalFormTest() {
        registrationPage.openSite("/automation-practice-form")
                .setFirstName("Name")
                .setLastName("Surname")
                .setUserEmail("email@mail.com")
                .setGender("Female")
                .setNumber("0123456789")
                .setDateOfBirth("19", "May", "1998")
                .submitForm();

        checkComponent.haveResultPhrase()
                .checkResult("Name Surname")
                .checkResult("email@mail.com")
                .checkResult("Female")
                .checkResult("0123456789")
                .checkResult("19 May,1998");
    }

    @Tag("demoqa")
    @Test
    void negativeFormTest() {
        registrationPage.openSite("/automation-practice-form")
                .setFirstName("Name")
                .setLastName("Surname")
                .setUserEmail("email@mail")
                .submitForm();

        checkComponent.notHaveResultPhrase();
    }


}