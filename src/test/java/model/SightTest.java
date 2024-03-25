package model;

import lt.viko.eif.nychyporuk.toursapp.model.Sight;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SightTest {

    @Test
    void testSightConstructorAndGetters() {
        String name = "Eiffel Tower";
        int duration = 120; // Duration in minutes

        Sight sight = new Sight(name, duration);

        assertAll("Constructor and getters should work correctly",
                () -> assertEquals(name, sight.getName(), "Name should match"),
                () -> assertEquals(duration, sight.getDuration(), "Duration should match"));
    }

    @Test
    void testSetters() {
        Sight sight = new Sight();

        String newName = "Statue of Liberty";
        int newDuration = 90; // Duration in minutes

        sight.setName(newName);
        sight.setDuration(newDuration);

        assertAll("Setters should correctly set values",
                () -> assertEquals(newName, sight.getName(), "Name should be updated"),
                () -> assertEquals(newDuration, sight.getDuration(), "Duration should be updated"));
    }

    @Test
    void testToString() {
        Sight sight = new Sight("Colosseum", 60);
        String sightString = sight.toString();

        assertTrue(sightString.contains("Colosseum"), "toString should include name");
        assertTrue(sightString.contains("60 minutes"), "toString should include duration");
    }
}
