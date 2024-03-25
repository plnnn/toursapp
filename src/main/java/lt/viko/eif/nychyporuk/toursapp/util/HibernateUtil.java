package lt.viko.eif.nychyporuk.toursapp.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Utility class for Hibernate that provides a singleton instance of
 * {@link SessionFactory}. This class is responsible for initializing
 * Hibernate's session factory based on the configuration specified in
 * hibernate.cfg.xml, and provides a global point of access to it.
 */
public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    /**
     * Retrieves the single instance of {@link SessionFactory}. If it doesn't exist,
     * it initializes it using the Hibernate configuration.
     *
     * @return The singleton {@link SessionFactory} object for creating sessions.
     * @throws ExceptionInInitializerError if an error occurs during the creation
     *         of the {@link SessionFactory} object.
     */
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                registry = new StandardServiceRegistryBuilder().configure().build();
                MetadataSources sources = new MetadataSources(registry);
                Metadata metadata = sources.getMetadataBuilder().build();
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            } catch (Exception e) {
                System.out.println("Error creating sessionFactory object: " + e.getMessage());
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
                throw new ExceptionInInitializerError(e);
            }
        }

        return sessionFactory;
    }
}
