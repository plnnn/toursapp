package model;

import lt.viko.eif.nychyporuk.toursapp.model.BaseEntity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BaseEntityTest {

    private static class TestEntity extends BaseEntity {
        public TestEntity() {
            super();
        }

        public TestEntity(int id) {
            super(id);
        }
    }

    @Test
    void testIdProperty() {
        int testId = 5;
        BaseEntity entity = new TestEntity();
        entity.setId(testId);

        assertEquals(testId, entity.getId(), "The ID should be correctly set and retrieved.");
    }

    @Test
    void testIdConstructor() {
        int testId = 10;
        BaseEntity entity = new TestEntity(testId);

        assertEquals(testId, entity.getId(), "The ID set through the constructor should match the retrieved ID.");
    }
}
