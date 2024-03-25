package lt.viko.eif.nychyporuk.toursapp.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlType;

/**
 * Represents a hotel entity with properties for name, address, and star rating.
 * This class is annotated for persistence in a relational database using JPA
 * and for XML marshalling/unmarshalling using JAXB. It extends the {@link BaseEntity}
 * class, inheriting its ID field.
 */
@Entity
@Table(name = "hotel")
@XmlType(propOrder = {"name", "address", "stars"})
public class Hotel extends BaseEntity {
    private String name;
    private String address;
    private int stars;

    /**
     * Default constructor.
     */
    public Hotel() {
    }

    /**
     * Constructs a new Hotel with specified name, address, and star rating.
     *
     * @param name The name of the hotel.
     * @param address The address of the hotel.
     * @param stars The star rating of the hotel.
     */
    public Hotel(String name, String address, int stars) {
        this.name = name;
        this.address = address;
        this.stars = stars;
    }

    /**
     * Returns a string representation of the hotel, including its name, address, and star rating.
     *
     * @return A formatted string representing the hotel.
     */
    @Override
    public String toString() {
        return String.format("\t\tHotel: \n" +
                "\t\t\tName: %s \n" +
                "\t\t\tAddress: %s \n" +
                "\t\t\tStars: %d \n", this.name, this.address, this.stars);
    }

    /**
     * Gets the name of the hotel.
     *
     * @return The name of the hotel.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the hotel.
     *
     * @param name The new name of the hotel.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the address of the hotel.
     *
     * @return The address of the hotel.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the hotel.
     *
     * @param address The new address of the hotel.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the star rating of the hotel.
     *
     * @return The star rating of the hotel.
     */
    public int getStars() {
        return stars;
    }

    /**
     * Sets the star rating of the hotel.
     *
     * @param stars The new star rating of the hotel.
     */
    public void setStars(int stars) {
        this.stars = stars;
    }
}
