import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

public class AppointmentServiceTest {
    private AppointmentService appointmentService;

    @BeforeEach
    public void setUp() {
        // Create a new instance of AppointmentService before each test
        appointmentService = new AppointmentService();
    }

    @Test
    public void testAddAppointment() {
        // Create a sample appointment
        Appointment appointment = new Appointment("1234567890", new Date(), "Sample appointment");

        // Add the appointment to the appointment service
        appointmentService.addAppointment(appointment);

        // Get the list of appointments from the appointment service
        List<Appointment> appointments = appointmentService.getAppointments();

        // Verify that the appointment was added successfully
        Assertions.assertEquals(1, appointments.size());
        Assertions.assertEquals(appointment, appointments.get(0));

        // Verify that the appointment's date and description are not null
        Assertions.assertNotNull(appointment.getAppointmentDate());
        Assertions.assertNotNull(appointment.getDescription());
    }

    @Test
    public void testAddDuplicateAppointment() {
        // Create two appointments with the same ID
        Appointment appointment1 = new Appointment("1234567890", new Date(), "Sample appointment");
        Appointment appointment2 = new Appointment("1234567890", new Date(), "Duplicate appointment");

        // Add the first appointment to the appointment service
        appointmentService.addAppointment(appointment1);

        // Attempt to add the second appointment (duplicate)
        appointmentService.addAppointment(appointment2);

        // Get the list of appointments from the appointment service
        List<Appointment> appointments = appointmentService.getAppointments();

        // Verify that only the first appointment was added (duplicate was not added)
        Assertions.assertEquals(1, appointments.size());
        Assertions.assertEquals(appointment1, appointments.get(0));
    }

    @Test
    public void testDeleteAppointment() {
        // Create two appointments
        Appointment appointment1 = new Appointment("1234567890", new Date(), "Sample appointment");
        Appointment appointment2 = new Appointment("0987654321", new Date(), "Another appointment");

        // Add both appointments to the appointment service
        appointmentService.addAppointment(appointment1);
        appointmentService.addAppointment(appointment2);

        // Delete the first appointment by its ID
        appointmentService.deleteAppointment("1234567890");

        // Get the list of appointments from the appointment service
        List<Appointment> appointments = appointmentService.getAppointments();

        // Verify that the first appointment was deleted and only the second appointment remains
        Assertions.assertEquals(1, appointments.size());
        Assertions.assertEquals(appointment2, appointments.get(0));
    }
}