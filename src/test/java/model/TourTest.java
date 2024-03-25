package model;

import lt.viko.eif.nychyporuk.toursapp.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class TourTest {

    private Tour tour;
    private Guide guide;
    private Visit visit1, visit2;

    @BeforeEach
    void setUp() {
        guide = new Guide("John", "Doe", 10);
        visit1 = new Visit("France", "Paris", 2, new Hotel("Luxury Inn", "123 Main St", 4));
        visit2 = new Visit("Italy", "Rome", 3, new Hotel("Cozy Place", "456 Side St", 3));
        tour = new Tour("European Highlights", 10, guide, 2000);
        tour.setVisits(Arrays.asList(visit1, visit2));
    }

    @Test
    void testTourProperties() {
        assertEquals("European Highlights", tour.getName());
        assertEquals(10, tour.getDuration());
        assertEquals(guide, tour.getGuide());
        assertEquals(2000, tour.getPrice());
        assertTrue(tour.getVisits().containsAll(Arrays.asList(visit1, visit2)));

        Guide newGuide = new Guide("Jane", "Smith", 8);
        tour.setName("Amazing Asia");
        tour.setDuration(15);
        tour.setGuide(newGuide);
        tour.setPrice(3000);
        Visit newVisit = new Visit("Japan", "Tokyo", 5, new Hotel("Stay Japan", "789 Tokyo St", 5));
        tour.setVisits(Arrays.asList(newVisit));

        assertAll("Ensure all properties are correctly managed",
                () -> assertEquals("Amazing Asia", tour.getName()),
                () -> assertEquals(15, tour.getDuration()),
                () -> assertEquals(newGuide, tour.getGuide()),
                () -> assertEquals(3000, tour.getPrice()),
                () -> assertTrue(tour.getVisits().contains(newVisit) && tour.getVisits().size() == 1)
        );
    }

    @Test
    void testToString() {
        String tourStr = tour.toString();
        assertTrue(tourStr.contains("European Highlights"));
        assertTrue(tourStr.contains("John"));
        assertTrue(tourStr.contains("Paris") && tourStr.contains("Rome"));
        assertTrue(tourStr.contains("2000"));
    }
}
