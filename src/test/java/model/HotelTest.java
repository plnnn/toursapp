package model;

import lt.viko.eif.nychyporuk.toursapp.model.Hotel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    @Test
    void testHotelConstructorAndGetters() {
        String name = "Grand Hotel";
        String address = "123 Main St, Cityville";
        int stars = 5;

        Hotel hotel = new Hotel(name, address, stars);

        assertAll("Constructor and getters should work correctly",
                () -> assertEquals(name, hotel.getName(), "Name should match"),
                () -> assertEquals(address, hotel.getAddress(), "Address should match"),
                () -> assertEquals(stars, hotel.getStars(), "Stars should match"));
    }

    @Test
    void testSetters() {
        Hotel hotel = new Hotel();

        String newName = "Luxury Inn";
        String newAddress = "456 Grand Avenue, Metropolis";
        int newStars = 4;

        hotel.setName(newName);
        hotel.setAddress(newAddress);
        hotel.setStars(newStars);

        assertAll("Setters should correctly set values",
                () -> assertEquals(newName, hotel.getName(), "Name should be updated"),
                () -> assertEquals(newAddress, hotel.getAddress(), "Address should be updated"),
                () -> assertEquals(newStars, hotel.getStars(), "Stars should be updated"));
    }

    @Test
    void testToString() {
        Hotel hotel = new Hotel("Grand Hotel", "123 Main St, Cityville", 5);
        String hotelString = hotel.toString();

        assertTrue(hotelString.contains("Grand Hotel"), "toString should include name");
        assertTrue(hotelString.contains("123 Main St, Cityville"), "toString should include address");
        assertTrue(hotelString.contains("5"), "toString should include star rating");
    }
}
