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
        // Create a new appointment
        Appointment appointment = new Appointment("1234567890", new Date(), "Sample appointment");

        // Add the appointment to the appointment service
        appointmentService.addAppointment(appointment);

        // Retrieve the list of appointments from the appointment service
        List<Appointment> appointments = appointmentService.getAppointments();

        // Verify that the appointment was added successfully
        Assertions.assertEquals(1, appointments.size());
        Assertions.assertEquals(appointment, appointments.get(0));
    }

    @Test
    public void testAddDuplicateAppointment() {
        // Create two appointments with the same appointment ID
        Appointment appointment1 = new Appointment("1234567890", new Date(), "Sample appointment");
        Appointment appointment2 = new Appointment("1234567890", new Date(), "Duplicate appointment");

        // Add the first appointment to the appointment service
        appointmentService.addAppointment(appointment1);

        // Add the second appointment to the appointment service
        appointmentService.addAppointment(appointment2);

        // Retrieve the list of appointments from the appointment service
        List<Appointment> appointments = appointmentService.getAppointments();

        // Verify that only the first appointment is added (no duplicates)
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

        // Delete the first appointment by appointment ID
        appointmentService.deleteAppointment("1234567890");

        // Retrieve the list of appointments from the appointment service
        List<Appointment> appointments = appointmentService.getAppointments();

        // Verify that only the second appointment remains (first appointment is deleted)
        Assertions.assertEquals(1, appointments.size());
        Assertions.assertEquals(appointment2, appointments.get(0));
    }
}
