package model;

import lt.viko.eif.nychyporuk.toursapp.model.Hotel;
import lt.viko.eif.nychyporuk.toursapp.model.Sight;
import lt.viko.eif.nychyporuk.toursapp.model.Visit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class VisitTest {

    private Visit visit;
    private Hotel hotel;
    private Sight sight1, sight2;

    @BeforeEach
    void setUp() {
        hotel = new Hotel("Grand Hotel", "123 Main St", 5);
        sight1 = new Sight("Eiffel Tower", 60);
        sight2 = new Sight("Louvre Museum", 120);
        visit = new Visit("France", "Paris", 3, hotel);
        visit.setSights(Arrays.asList(sight1, sight2));
    }

    @Test
    void testGettersAndSetters() {
        assertEquals("France", visit.getCountry());
        assertEquals("Paris", visit.getCity());
        assertEquals(3, visit.getDuration());
        assertEquals(hotel, visit.getHotel());
        assertTrue(visit.getSights().containsAll(Arrays.asList(sight1, sight2)));

        visit.setCountry("Italy");
        visit.setCity("Rome");
        visit.setDuration(4);
        Hotel newHotel = new Hotel("Rome Hotel", "456 Another St", 4);
        Sight newSight = new Sight("Colosseum", 90);
        visit.setHotel(newHotel);
        visit.setSights(Arrays.asList(newSight));

        assertAll(
                () -> assertEquals("Italy", visit.getCountry()),
                () -> assertEquals("Rome", visit.getCity()),
                () -> assertEquals(4, visit.getDuration()),
                () -> assertEquals(newHotel, visit.getHotel()),
                () -> assertTrue(visit.getSights().contains(newSight) && visit.getSights().size() == 1)
        );
    }

    @Test
    void testToString() {
        String visitStr = visit.toString();
        assertTrue(visitStr.contains("France"));
        assertTrue(visitStr.contains("Paris"));
        assertTrue(visitStr.contains("3"));
        assertTrue(visitStr.contains("Grand Hotel"));
        assertTrue(visitStr.contains("Eiffel Tower"));
        assertTrue(visitStr.contains("Louvre Museum"));
    }
}
