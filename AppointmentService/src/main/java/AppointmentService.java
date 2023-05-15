import java.util.ArrayList;
import java.util.List;

public class AppointmentService {
    private final List<Appointment> appointments;

    public AppointmentService() {
        // Initialize the list of appointments as an empty ArrayList
        appointments = new ArrayList<>();
    }

    public void addAppointment(Appointment appointment) {
        // Check if the appointment ID is not a duplicate
        if (!isDuplicateAppointmentId(appointment.getAppointmentId())) {
            // Add the appointment to the list of appointments
            appointments.add(appointment);
        }
    }

    public void deleteAppointment(String appointmentId) {
        // Remove the appointment with the matching appointment ID from the list of appointments
        appointments.removeIf(a -> a.getAppointmentId().equals(appointmentId));
    }

    public List<Appointment> getAppointments() {
        // Return the list of appointments
        return appointments;
    }

    private boolean isDuplicateAppointmentId(String appointmentId) {
        // Check if the appointment ID already exists in the list of appointments
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentId().equals(appointmentId)) {
                return true;
            }
        }
        return false;
    }
}