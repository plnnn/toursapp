package lt.viko.eif.nychyporuk.toursapp.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a visit entity with details about the visit such as the country, city,
 * duration of the visit, the hotel where guests will stay, and the sights to be seen.
 * This class is annotated for persistence in a database and XML marshalling/unmarshalling.
 */
@Entity
@Table(name = "visit")
@XmlType(propOrder = {"country", "city", "duration", "hotel", "sights"})
public class Visit extends BaseEntity {
    private String country;
    private String city;
    private int duration;

    @OneToOne(targetEntity = Hotel.class, cascade = CascadeType.ALL)
    private Hotel hotel;

    @OneToMany(fetch = FetchType.EAGER, targetEntity = Sight.class, cascade = CascadeType.ALL)
    private List<Sight> sights = new ArrayList<>();

    /**
     * Default constructor.
     */
    public Visit() {
    }

    /**
     * Constructs a Visit with specified details.
     *
     * @param country The country of the visit.
     * @param city The city of the visit.
     * @param duration The duration of the visit in days.
     * @param hotel The hotel for the visit.
     */
    public Visit(String country, String city, int duration, Hotel hotel) {
        this.country = country;
        this.city = city;
        this.duration = duration;
        this.hotel = hotel;
    }

    /**
     * Returns a string representation of the visit, including country, city,
     * duration, hotel details, and sights.
     *
     * @return A string representation of the visit.
     */
    @Override
    public String toString() {
        return String.format("\tVisit: \n" +
                "\t\tCountry: %s \n" +
                "\t\tCity: %s \n" +
                "\t\tDuration: %d \n" +
                "%s" + // Hotel's toString
                "\t\tSights: %s", this.country, this.city, this.duration, this.hotel, constructSightsList());
    }

    /**
     * Constructs a formatted string listing all sights included in the visit.
     *
     * @return A string listing sights.
     */
    private String constructSightsList() {
        StringBuilder result = new StringBuilder("\n");
        for (Sight s : this.sights) {
            result.append(s.toString());
        }
        return result.toString();
    }

    /**
     * Gets the country of the visit.
     *
     * @return The country.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country of the visit.
     *
     * @param country The new country.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets the city of the visit.
     *
     * @return The city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city of the visit.
     *
     * @param city The new city.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the duration of the visit in days.
     *
     * @return The duration.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets the duration of the visit in days.
     *
     * @param duration The new duration.
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Gets the hotel for the visit.
     *
     * @return The hotel.
     */
    public Hotel getHotel() {
        return hotel;
    }

    /**
     * Sets the hotel for the visit.
     *
     * @param hotel The new hotel.
     */
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    /**
     * Gets the list of sights to be seen during the visit.
     *
     * @return The list of sights.
     */
    public List<Sight> getSights() {
        return sights;
    }

    /**
     * Sets the list of sights to be seen during the visit.
     *
     * @param sights The new list of sights.
     */
    @XmlElementWrapper(name = "sights")
    @XmlElement(name = "sight")
    public void setSights(List<Sight> sights) {
        this.sights = sights;
    }
}
