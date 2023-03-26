package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static tests.FakerData.*;

public class RegistrationTestsWitchFakerData extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void testForm() {
        Faker faker = new Faker();


        registrationPage.openPage()
                .closeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(userGender)
                .setPhoneNumber(phoneNumber)
                .dateBirthday (dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjectsInput(subject)
                .setHobbies(hobby)
                .setUploadFile(picture)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .setClickSubmit();

        registrationPage.verifyResultsModalAppears()
                .verifyResults("Student Name", firstName + " " + lastName)
                .verifyResults("Student Email", userEmail)
                .verifyResults("Gender", userGender)
                .verifyResults("Mobile", phoneNumber)
                .verifyResults("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .verifyResults("Subjects", subject)
                .verifyResults("Hobbies", hobby)
                .verifyResults("Picture", picture)
                .verifyResults("Address", currentAddress)
                .verifyResults("State and City", state + " " + city);

    }
}
