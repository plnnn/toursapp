package model;

import lt.viko.eif.nychyporuk.toursapp.model.Guide;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GuideTest {

    @Test
    void testGuideConstructorAndGetters() {
        String firstName = "John";
        String lastName = "Doe";
        int experience = 5;

        Guide guide = new Guide(firstName, lastName, experience);

        assertAll("Constructor and getters should work correctly",
                () -> assertEquals(firstName, guide.getFirstName(), "First name should match"),
                () -> assertEquals(lastName, guide.getLastName(), "Last name should match"),
                () -> assertEquals(experience, guide.getExperience(), "Experience should match"));
    }

    @Test
    void testSetters() {
        Guide guide = new Guide();

        String newFirstName = "Jane";
        String newLastName = "Smith";
        int newExperience = 10;

        guide.setFirstName(newFirstName);
        guide.setLastName(newLastName);
        guide.setExperience(newExperience);

        assertAll("Setters should correctly set values",
                () -> assertEquals(newFirstName, guide.getFirstName(), "First name should be updated"),
                () -> assertEquals(newLastName, guide.getLastName(), "Last name should be updated"),
                () -> assertEquals(newExperience, guide.getExperience(), "Experience should be updated"));
    }

    @Test
    void testToString() {
        Guide guide = new Guide("John", "Doe", 5);
        String guideString = guide.toString();

        assertTrue(guideString.contains("John"), "toString should include first name");
        assertTrue(guideString.contains("Doe"), "toString should include last name");
        assertTrue(guideString.contains("5"), "toString should include experience");
    }
}
