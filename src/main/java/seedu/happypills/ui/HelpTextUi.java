package seedu.happypills.ui;

public class HelpTextUi extends TextUi {

    public static String generalHelpMessage = ""
                + "    HappyPills Commands\n"
                + "    ---------------------------------------------------\n"
                + "    General Commands:\n"
                + "      help | Displays all of HappyPill's Commands\n"
                + "      exit | Exits the program\n"
                + "    ---------------------------------------------------\n"
                + "    Patient Details Commands:\n"
                + "      add patient | Adds a patient into the program\n"
                + "      list patient | Lists all the patients in the program\n"
                + "      get patient | Retrieves the details of a given patient\n"
                + "      edit patient | Edits a patient's detail\n"
                + "      delete patient | Deletes a patient from the program\n"
                + "    ---------------------------------------------------\n"
                + "    Patient Medial Records Commands:\n"
                + "      add pr | Adds a prior patient records into the program\n"
                + "      edit pr | Edits a prior patient record\n"
                + "      delete pr | Deletes a prior patient record\n"
                + "      list pr | List down all records for a particular patient\n"
                + "      find pr | Retrieves a particular record\n"
                + "    ---------------------------------------------------\n"
                + "    Appointment Scheduling Commands:\n"
                + "      add appt | Adds an appointment into the program\n"
                + "      list appt | Lists all the appointments into the program\n"
                + "      edit appt | Edits an appointment in the program\n"
                + "      delete appt | Deletes an appointment from the program\n"
                + "      done appt | Marks an appointment as done\n"
                + "      find appt | Finds all the appointments under a patient\n"
                + "    For more specific command instructions, enter `help [COMMAND]`\n"
                + "      Example: help add appt\n"
                + DIVIDER;

    public static String exitHelpMessage = ""
            + "    To exit the program, run the following command:\n"
            + "      exit\n"
            + "    The above command will save the current patient records and terminate the program.\n"
            + DIVIDER;

    //Patient help Strings
    public static String AddPatientHelpMessage = ""
            + "    To add a new patient into the program, use the following command:\n"
            + "    Note: patient details are within the parenthesis [ ]\n"
            + "      add patient /ic[NRIC] /n[NAME] /p[PHONE_NUMBER] /dob[DOB] "
            + "/b[BLOOD_TYPE] /a[Allergies] /rm[Remarks]\n"
            + "    The command above adds a new patient.\n"
            + DIVIDER;

    public static String listPatientHelpMessage = ""
            + "    To retrieve a list of all the patients within the program,\n"
            + "    run the following command:\n"
            + "      list patient\n"
            + DIVIDER;

    public static String getPatientHelpMessage = ""
            + "    To retrieve a patient's information, run the following command:\n"
            + "    Note: patient details are within the parenthesis [ ]\n"
            + "      get patient [NRIC]\n"
            + "    Example:\n"
            + "      get patient S9999999Z\n"
            + "    The command above will display information regarding the patient with NRIC S9999999Z.\n"
            + DIVIDER;

    public static String editPatientHelpMessage = ""
            + "    To edit a patient's information, run the following command:\n"
            + "    Note: patient details are within the parenthesis [ ]\n"
            + "      edit patient [NRIC] /p[PHONE_NUMBER] to edit patient's phone number,\n"
            + "      edit patient [NRIC] /a[ALLERGIES] to edit patient's allergies,\n"
            + "      edit patient [NRIC] /r[REMARKS] to edit patient's remarks\"\n"
            + "    Do note that editing the patient's records will overwrite any previous information.\n"
            + "    Adding of allergies or remarks can be done with the add command.\n"
            + DIVIDER;

    public static String deletePatientHelpMessage =""
            + "    To delete a patient, run the following command:\n"
            + "    Note: patient details are within the parenthesis [ ]\n"
            + "      delete patient [NRIC]\n"
            + "    The user will be prompted to confirm if they would like to delete the patient's records.\n"
            + "    Do note that deletion cannot be undone.\n"
            + DIVIDER;

    //Patient Record Help Strings
    public static String AddPatientRecordHelpMessage =""
            + "    To add a new patient record into the program, use the following command:\n"
            + "    Note: patient record details are within the parenthesis [ ]\n"
            + "      add pr /ic[NRIC] /sym[SYMPTOMS] /diag[DIAGNOSIS] /d[DATE] /t[TIME]\n"
            + "    The command above adds a new patient medical record.\n"
            + DIVIDER;

    public static String listPatientRecordHelpMessage = ""
            + "    To retrieve a list of all the patient records of a particular patient,\n"
            + "    run the following command:\n"
            + "      list pr [NRIC]\n"
            + DIVIDER;

    public static String editPatientRecordHelpMessage = ""
            + "    To edit a patient's records, run the following command:\n"
            + "    Note: patient details are within the parenthesis [ ]. \n"
            + "    The INDEX can be found by running the list pr command.\n"
            + "      edit pr [NRIC] [INDEX] /sym [SYMPTOMS] /diag [DIAGNOSIS] /d [DATE] /t [TIME]\n"
            + "    You can also edit a single attribute: \n"
            + "      edit pr [NRIC] [INDEX] /sym [SYMPTOMS] to edit patient's symptoms,\n"
            + "    Do note that editing the patient's records will overwrite any previous information.\n"
            + DIVIDER;

    public static String deletePatientRecordHelpMessage = ""
            + "    To delete a patient's records on a particular visit, run the following command:\n"
            + "    Note: patient details are within the parenthesis [ ]\n"
            + "    The INDEX can be found by running the list pr command.\n"
            + "      delete pr [NRIC] [INDEX]\n"
            + "    The user will be prompted to confirm if they would like to delete the patient's records.\n"
            + "    Do note that deletion cannot be undone.\n"
            + DIVIDER;

    public static String findPatientRecordHelpMessage = ""
            + "    To get a better look at a patient's particular record, run the following command:\n"
            + "    Note: appointment details are within the parenthesis [ ]\n"
            + "    The INDEX can be found by running the list pr command.\n"
            + "      find pr [NRIC] [INDEX]\n"
            + DIVIDER;

    //Appointment
    public static String printAddAppointmentHelp = ""
            + "    To add a new appointment into the program, use the following command:\n"
            + "    Note: appointment details are within the parenthesis [ ]\n"
            + "    A unique ID will be given to every appointment added.\n"
            + "      add appt /ic[NRIC] /d[DATE] /t[TIME] /r[REASON]\n"
            + "    The command above adds a new appointment.\n"
            + "    Please ensure that the date is formatted as DD-MM-YYYY and time as HH:mm:ss\n"
            + DIVIDER;

    public static String printListAppointmentHelp = ""
            + "    To retrieve a list of all the appointments within the program,\n"
            + "    run the following command:\n"
            + "      list appt\n"
            + DIVIDER;

    public static String printEditAppointmentHelp = ""
            + "    To edit a patient's appointment, run the following command:\n"
            + "      edit appt [NRIC] [APPTID] /d [DD/MM/YYYY] to edit appointment's date,\n"
            + "      edit appt [NRIC] [APPTID] /t [HH:MM] to edit appointment's time,\n"
            + "      edit appt [NRIC] [APPTID] /r [REASON] to edit appointment's reason\"\n"
            + "    Do note that editing the patient's records will overwrite any previous information.\n"
            + "    The apptID can be found using \"find appt [NRIC]\"\n"
            + DIVIDER;

    public static String printDeleteAppointmentHelp = ""
            + "    To delete an appointment, run the following command:\n"
            + "    Note: appointment details are within the parenthesis [ ]\n"
            + "      delete appt [APPT_ID]\n"
            + "    The user will be prompted to confirm if they would like to delete the patient's records.\n"
            + "    Do note that deletion cannot be undone.\n"
            + DIVIDER;

    public static String printFindAppointmentHelp = ""
            + "    To find all of a patient's appointments, run the following command:\n"
            + "    Note: appointment details are within the parenthesis [ ]\n"
            + "      find appt [NRIC]\n"
            + DIVIDER;

    public static String printDoneAppointmentHelp = ""
            + "    To make an appointment as done, run the following command:\n"
            + "    Note: appointment details are within the parenthesis [ ]\n"
            + "      done appt [NRIC] [APPT_ID]\n"
            + DIVIDER;
}
