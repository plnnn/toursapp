package lt.viko.eif.nychyporuk.toursapp.db;

import lt.viko.eif.nychyporuk.toursapp.model.Tour;
import lt.viko.eif.nychyporuk.toursapp.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import java.util.List;

/**
 * A utility class responsible for loading data from the database.
 * It utilizes Hibernate for ORM (Object-Relational Mapping) to facilitate
 * interaction with the database and retrieval of Tour entities.
 */
public class DBLoader {

    /**
     * Loads all Tour entities from the database.
     * <p>
     * This method establishes a session with the database using Hibernate,
     * executes a query to fetch all Tour entities, and then closes the session.
     * In case of a HibernateException, it catches the exception and prints an error message.
     *
     * @return A List of {@link Tour} objects representing all tours in the database.
     *         Returns null if an error occurs during database access.
     */
    public static List<Tour> loadTours() {
        List <Tour> tours = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tours = session.createQuery("from Tour", Tour.class).list();
        } catch (HibernateException e) {
            System.out.println("Error loading tours from database: " + e.getMessage());
        }
        return tours;
    }
}
