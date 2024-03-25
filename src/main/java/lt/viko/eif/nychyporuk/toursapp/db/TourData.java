package lt.viko.eif.nychyporuk.toursapp.db;

import lt.viko.eif.nychyporuk.toursapp.model.Tour;
import java.util.ArrayList;
import java.util.List;

/**
 * Encapsulates a collection of {@link Tour} objects.
 * This class serves as a data holder for tour entities, providing methods
 * to retrieve and modify the list of tours.
 */
public class TourData {

    private List<Tour> tours = new ArrayList<>();

    /**
     * Gets the list of tour entities.
     *
     * @return A list of {@link Tour} objects currently held by this instance.
     */
    public List<Tour> getTours() {
        return tours;
    }

    /**
     * Sets the list of tour entities.
     * <p>
     * This method replaces the current list of tours with the provided list.
     *
     * @param tours The new list of {@link Tour} objects to be stored.
     */
    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }
}
