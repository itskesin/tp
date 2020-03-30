package seedu.happypills.model.data;

import static java.lang.String.valueOf;

/**
 * Represents an appointment.
 * It also functions as base class for appointments from which specialised tasks are inherited from.
 */
public class Appointment {

    /**
     * Stores the details of the appointment.
     */
    protected String nric;
    protected String reason;
    protected String date;
    protected String time;
    protected String appointmentId;
    protected boolean isDone;

    /**
     * Constructor for Appointment class.
     * It creates a new appointment with the details provided by the user.
     *
     * @param nric NRIC of patient.
     * @param reason reason for appointment.
     * @param date date of appointment.
     * @param time time of appointment.
     */
    public Appointment(String nric, String reason, String date, String time) {
        this.nric = nric;
        this.reason = reason;
        this.date = date;
        this.time = time;
        this.appointmentId = valueOf(0);
        this.isDone = false;
    }

    public String getNric() {
        return nric;
    }

    public void setNric(String nric) {
        this.nric = nric;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    private String doneString(boolean done) {
        return done ? "T" : "F";
    }

    /**
     * Create a string with all the appointment's data for storage to a text file.
     * Each variable is separated with | as a divider.
     *
     * @return a formatted string with appointment's data.
     */
    public String toSave() {
        String text = this.appointmentId + "|" + this.nric + "|"
                + this.date + "|" + this.time + "|"
                + this.reason + "|" + doneString(this.isDone) + System.lineSeparator();
        return text;
    }
}