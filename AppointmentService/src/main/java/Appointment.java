import java.util.Date;

public class Appointment {
    private final String appointmentId;
    private final Date appointmentDate;
    private final String description;

    public Appointment(String appointmentId, Date appointmentDate, String description) {
        // Assign the provided values to the respective instance variables
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;

        // Check if the description is null or exceeds the maximum length
        if (description == null || description.length() > 50) {
            // Throw an exception with an error message if the description is invalid
            throw new IllegalArgumentException("Appointment description must not be null and must not exceed 50 characters.");
        }

        // Assign the description to the respective instance variable
        this.description = description;
    }

    public String getAppointmentId() {
        // Return the appointment ID
        return appointmentId;
    }

    public Date getAppointmentDate() {
        // Return the appointment date
        return appointmentDate;
    }

    public String getDescription() {
        // Return the appointment description
        return description;
    }
}