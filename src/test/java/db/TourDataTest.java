package db;

import lt.viko.eif.nychyporuk.toursapp.db.TourData;
import lt.viko.eif.nychyporuk.toursapp.model.Tour;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TourDataTest {

    private TourData tourData;

    @BeforeEach
    void setUp() {
        tourData = new TourData();
    }

    @Test
    void testGetAndSetTours() {
        List<Tour> testTours = new ArrayList<>();
        Tour tour1 = new Tour();
        Tour tour2 = new Tour();

        testTours.add(tour1);
        testTours.add(tour2);

        tourData.setTours(testTours);
        List<Tour> retrievedTours = tourData.getTours();

        assertEquals(2, retrievedTours.size(),
                "The size of retrieved tours should match the size of the set list.");
        assertTrue(retrievedTours.contains(tour1),
                "The retrieved tours should contain tour1.");
        assertTrue(retrievedTours.contains(tour2),
                "The retrieved tours should contain tour2.");
    }
}
