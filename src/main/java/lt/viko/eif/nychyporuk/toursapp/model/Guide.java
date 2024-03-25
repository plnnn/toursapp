package lt.viko.eif.nychyporuk.toursapp.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Represents a guide entity with first name, last name, and experience.
 * This class is annotated for persistence in a relational database using JPA
 * and for XML marshalling/unmarshalling using JAXB. It extends the {@link BaseEntity}
 * class, inheriting its ID field.
 */
@Entity
@Table(name = "guide")
@XmlType(propOrder = {"firstName", "lastName", "experience"})
public class Guide extends BaseEntity {
    private String firstName;
    private String lastName;
    private int experience;

    /**
     * Default constructor.
     */
    public Guide() {
    }

    /**
     * Constructs a new Guide with specified first name, last name, and experience.
     *
     * @param firstName The first name of the guide.
     * @param lastName  The last name of the guide.
     * @param experience The number of years the guide has experience.
     */
    public Guide(String firstName, String lastName, int experience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.experience = experience;
    }

    /**
     * Returns a string representation of the guide, including first name, last name, and experience.
     *
     * @return A formatted string representing the guide.
     */
    @Override
    public String toString() {
        return String.format("\tGuide: \n" +
                "\t\tFirstName: %s \n" +
                "\t\tLastName: %s \n" +
                "\t\tExperience: %d \n", this.firstName, this.lastName, this.experience);
    }

    /**
     * Gets the first name of the guide.
     *
     * @return The first name of the guide.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the guide.
     *
     * @param firstName The new first name of the guide.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the guide.
     *
     * @return The last name of the guide.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the guide.
     *
     * @param lastName The new last name of the guide.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the experience of the guide in years.
     *
     * @return The number of years the guide has experience.
     */
    public int getExperience() {
        return experience;
    }

    /**
     * Sets the experience of the guide.
     *
     * @param experience The new number of years of experience for the guide.
     */
    public void setExperience(int experience) {
        this.experience = experience;
    }
}
