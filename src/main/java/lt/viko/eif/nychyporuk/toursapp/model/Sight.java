package lt.viko.eif.nychyporuk.toursapp.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Represents a sightseeing location entity with properties for the sight's name and
 * the duration of the visit. This class is annotated for persistence in a relational
 * database using JPA and for XML marshalling/unmarshalling using JAXB. It extends
 * the {@link BaseEntity} class, inheriting its ID field.
 */
@Entity
@Table(name = "sight")
@XmlType(propOrder = {"name", "duration"})
public class Sight extends BaseEntity {
    private String name;
    private int duration;

    /**
     * Default constructor.
     */
    public Sight() {
    }

    /**
     * Constructs a new Sight with specified name and duration of visit.
     *
     * @param name The name of the sightseeing location.
     * @param duration The duration of the visit in minutes.
     */
    public Sight(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    /**
     * Returns a string representation of the sight, including its name and duration.
     *
     * @return A formatted string representing the sight.
     */
    @Override
    public String toString() {
        return String.format("\t\tSight: \n" +
                "\t\t\tName: %s \n" +
                "\t\t\tDuration: %d minutes\n", this.name, this.duration);
    }

    /**
     * Gets the name of the sightseeing location.
     *
     * @return The name of the sight.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the sightseeing location.
     *
     * @param name The new name of the sight.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the duration of the visit to the sightseeing location in minutes.
     *
     * @return The duration of the visit.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets the duration of the visit to the sightseeing location.
     *
     * @param duration The new duration of the visit in minutes.
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }
}
