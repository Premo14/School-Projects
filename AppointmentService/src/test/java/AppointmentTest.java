import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class AppointmentTest {

    @Test
    public void testValidAppointment() {
        // Create a valid appointment
        String appointmentId = "1234567890";
        Date appointmentDate = new Date();  // Use the current date as the appointment date
        String description = "Sample appointment";

        // Create an instance of the Appointment class
        Appointment appointment = new Appointment(appointmentId, appointmentDate, description);

        // Verify that the appointment ID, appointment date, and description are set correctly
        Assertions.assertEquals(appointmentId, appointment.getAppointmentId());
        Assertions.assertEquals(appointmentDate, appointment.getAppointmentDate());
        Assertions.assertEquals(description, appointment.getDescription());
    }

    @Test
    public void testInvalidDescription() {
        // Try to create an appointment with a null description
        String appointmentId = "1234567890";
        Date appointmentDate = new Date();  // Use the current date as the appointment date
        final String nullDescription = null;

        // Verify that creating an appointment with a null description throws an IllegalArgumentException
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Appointment(appointmentId, appointmentDate, nullDescription));

        // Try to create an appointment with a description exceeding the maximum length
        final String longDescription = "This is a very long appointment description that exceeds the maximum length allowed.";

        // Verify that creating an appointment with an invalid description throws an IllegalArgumentException
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Appointment(appointmentId, appointmentDate, longDescription));
    }
}
