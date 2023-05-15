import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {
    private Contact contact;

    @BeforeEach
    public void setUp() {
        contact = new Contact();
    }

    @Test
    public void testSetFirstName() {
        contact.setFirstName("John");
        Assertions.assertEquals("John", contact.getFirstName());
    }

    @Test
    public void testSetLastName() {
        contact.setLastName("Doe");
        Assertions.assertEquals("Doe", contact.getLastName());
    }

    @Test
    public void testSetAddress() {
        contact.setAddress("123 Main St");
        Assertions.assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testSetPhoneNum() {
        contact.setPhoneNum("5551234567");
        Assertions.assertEquals("5551234567", contact.getPhoneNum());
    }

    @Test
    public void testSetUniqueID() {
        contact.setUniqueID("12345");
        Assertions.assertEquals("12345", contact.getUniqueID());
    }

    @Test
    public void testToString() {
        contact.setUniqueID("12345");
        contact.setFirstName("John");
        contact.setLastName("Doe");
        contact.setAddress("123 Main St");
        contact.setPhoneNum("5551234567");

        String expected = "12345\nJohn Doe\n123 Main St\n5551234567\n";
        Assertions.assertEquals(expected, contact.toString());
    }
}
