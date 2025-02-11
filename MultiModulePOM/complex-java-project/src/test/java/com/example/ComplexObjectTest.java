package com.example;

import com.example.model.ComplexObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComplexObjectTest {

    private ComplexObject complexObject;

    @BeforeEach
    public void setUp() {
        complexObject = new ComplexObject("John Doe", 30, "123 Main St", true);
    }

    @Test
    public void testGetName() {
        assertEquals("John Doe", complexObject.getName());
    }

    @Test
    public void testSetName() {
        complexObject.setName("Jane Doe");
        assertEquals("Jane Doe", complexObject.getName());
    }

    @Test
    public void testGetAge() {
        assertEquals(30, complexObject.getAge());
    }

    @Test
    public void testSetAge() {
        complexObject.setAge(35);
        assertEquals(35, complexObject.getAge());
    }

    @Test
    public void testGetAddress() {
        assertEquals("123 Main St", complexObject.getAddress());
    }

    @Test
    public void testSetAddress() {
        complexObject.setAddress("456 Oak St");
        assertEquals("456 Oak St", complexObject.getAddress());
    }

    @Test
    public void testIsActive() {
        assertTrue(complexObject.isActive());
    }

    @Test
    public void testSetActive() {
        complexObject.setActive(false);
        assertFalse(complexObject.isActive());
    }

    @Test
    public void testToString() {
        String expected = "ComplexObject{name='John Doe', age=30, address='123 Main St', isActive=true}";
        assertEquals(expected, complexObject.toString());
    }
}
