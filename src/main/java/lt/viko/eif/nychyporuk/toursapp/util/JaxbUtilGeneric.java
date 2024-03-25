package lt.viko.eif.nychyporuk.toursapp.util;

import jakarta.xml.bind.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Utility class for JAXB operations. Provides functionality to convert
 * Java objects (POJOs) into XML representation and vice versa. This version
 * includes a method to marshal a Java object into XML and save it to a file.
 */
public class JaxbUtilGeneric {
    /**
     * Default constructor.
     */
    public JaxbUtilGeneric() {
    }

    /**
     * Converts a Java object (POJO) to XML and writes the XML to a specified file.
     * This method marshals the given Java object into an XML representation and
     * saves it to the file system at the specified location.
     *
     * @param <T> the type of the Java object to be converted into XML.
     * @param object the Java object to be marshaled into XML.
     * @param xmlFileName the name of the file (including path) to which the XML data should be written.
     * @throws RuntimeException if a JAXBException or FileNotFoundException occurs, indicating
     *         an issue with the marshaling process or a problem with the file output, respectively.
     */
    public static <T> void convertPOJOToXML(T object, String xmlFileName) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            OutputStream os = new FileOutputStream(xmlFileName);
            marshaller.marshal(object, os);

        } catch (JAXBException | FileNotFoundException e) {
            throw new RuntimeException("Error during XML conversion: " + e.getMessage(), e);
        }
    }
}
