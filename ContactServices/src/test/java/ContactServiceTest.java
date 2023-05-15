import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class ContactServiceTest {
    private ContactService contactService;
    private InputStream input;

    @Before
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        String data = "John\nDoe\n1234 Main St\n1234567890\nexit\n";
        input = new ByteArrayInputStream(data.getBytes());
        System.setIn(input);
        contactService.addContact();
        assertEquals(1, contactService.contacts.size());
    }

    @Test
    public void testRemoveContact() {
        Contact contact = new Contact();
        contact.setUniqueID("ABC123");
        contact.setFirstName("John");
        contact.setLastName("Doe");
        contact.setAddress("1234 Main St");
        contact.setPhoneNum("1234567890");
        contactService.contacts.add(contact);

        String data = "ABC123\nexit\n";
        input = new ByteArrayInputStream(data.getBytes());
        System.setIn(input);
        contactService.removeContact();
        assertEquals(0, contactService.contacts.size());
    }
}
