package util;

import lt.viko.eif.nychyporuk.toursapp.model.*;
import lt.viko.eif.nychyporuk.toursapp.util.JaxbUtilGeneric;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import static org.junit.jupiter.api.Assertions.*;

class JaxbUtilGenericTest {

    @Test
    void testConvertPOJOToXML_ThrowsRuntimeException_ForInvalidPath() {
        Guide guide = new Guide("Pavlo", "Nychyporuk", (byte) 3);
        Tour tour = new Tour("Iceland", (byte) 7, guide, (short) 1000);
        String invalidFileName = "/invalid/path/tour.xml";

        Exception exception = assertThrows(RuntimeException.class, () ->
                        JaxbUtilGeneric.convertPOJOToXML(tour, invalidFileName),
                "A RuntimeException should be thrown if the file path is invalid.");

        assertInstanceOf(FileNotFoundException.class, exception.getCause(),
                "The cause should be FileNotFoundException.");
    }
}
