package lt.viko.eif.nychyporuk.toursapp.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 * An abstract base class for entities, providing a common ID property.
 * This class is annotated for use with JPA (Java Persistence API) for database operations
 * and JAXB for XML binding. The ID property is automatically generated for database
 * entities and is excluded from XML serialization/deserialization.
 */
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    /**
     * Default constructor.
     */
    public BaseEntity() {
    }

    /**
     * Constructs a new BaseEntity with a specified ID.
     *
     * @param id the ID of the entity.
     */
    public BaseEntity(int id) {
        this.id = id;
    }

    /**
     * Returns the ID of this entity.
     *
     * @return the ID of the entity.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of this entity.
     * This method is annotated with @XmlTransient to prevent
     * the marshalling of the ID field to XML.
     *
     * @param id the new ID of the entity.
     */
    @XmlTransient
    public void setId(int id) {
        this.id = id;
    }
}
