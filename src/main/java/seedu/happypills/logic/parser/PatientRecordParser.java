package seedu.happypills.logic.parser;

import seedu.happypills.HappyPills;
import seedu.happypills.logic.commands.patientrecordcommands.AddPatientRecordCommand;
import seedu.happypills.logic.commands.patientrecordcommands.DeletePatientRecordCommand;
import seedu.happypills.logic.commands.patientrecordcommands.EditPatientRecordCommand;
import seedu.happypills.logic.commands.patientrecordcommands.FindPatientRecordCommand;
import seedu.happypills.logic.commands.patientrecordcommands.IncorrectPatientRecordCommand;
import seedu.happypills.logic.commands.patientrecordcommands.ListPatientRecordCommand;
import seedu.happypills.logic.commands.patientrecordcommands.PatientRecordCommand;
import seedu.happypills.model.exception.HappyPillsException;
import seedu.happypills.ui.TextUi;

import java.util.Scanner;


public class PatientRecordParser {

    /**
     * Parses the command given by the user to visit commands.
     *
     * @param fullCommand the full command entered by the user.
     * @return the command that the user has entered.
     * @throws HappyPillsException throws an exception for invalid commands.
     */
    public static PatientRecordCommand parse(String fullCommand) throws HappyPillsException {
        String[] userCommand = fullCommand.split(" ", 3);

        if (userCommand[0].equalsIgnoreCase("list")) {
            if (userCommand.length == 1 || userCommand[1].trim().isEmpty()) {
                throw new HappyPillsException("    NRIC of the patient not provided");
            }
            return new ListPatientRecordCommand(userCommand[2].trim().toUpperCase());
        } else if (userCommand[0].equalsIgnoreCase("add")) {
            if (userCommand.length == 1 || userCommand[1].trim().isEmpty()) {
                throw new HappyPillsException("    Patient's detail is empty.");
            }
            return parseAddCommand(userCommand[2]);
        } else if (userCommand[0].equalsIgnoreCase("find")) {
            if (userCommand.length == 1 || userCommand[1].trim().isEmpty()) {
                throw new HappyPillsException("    NRIC of the patient not provided");
            }
            String[] input = userCommand[2].split(" ", 2);
            return new FindPatientRecordCommand(input[0].trim().toUpperCase(), Integer.parseInt(input[1].trim()));
        } else if (userCommand[0].equalsIgnoreCase("edit")) {
            String[] edit = fullCommand.split(" ", 5);
            if (edit.length < 4) {
                throw new HappyPillsException("    Please input your patient's details correctly.");
            }
            return new EditPatientRecordCommand(
                    edit[2].trim().toUpperCase(), Integer.parseInt(edit[3].trim()), edit[4].trim());
        } else if (userCommand[0].equalsIgnoreCase("delete")) {
            if (userCommand.length == 1 || userCommand[1].trim().isEmpty()) {
                throw new HappyPillsException("    NRIC of the patient not provided");
            }
            String[] input = userCommand[2].split(" ", 2);
            return new DeletePatientRecordCommand(input[0].trim().toUpperCase(), Integer.parseInt(input[1].trim()));
        } else {
            throw new HappyPillsException("    Invalid Command.");
        }
    }

    private static PatientRecordCommand parseAddCommand(String content) throws HappyPillsException {
        String[] details;
        if (content.startsWith("/")) {
            details = content.substring(1).split(" /");
        } else {
            content = "@" + content;
            details = content.split(" /");
        }
        String[] parseInput = {"", "", "", "", "", ""};
        for (String detail : details) {
            if (detail.startsWith("ic") && parseInput[0].equalsIgnoreCase("")) {
                parseInput[0] = detail.substring(2).trim().toUpperCase();
            } else if (detail.startsWith("sym") && parseInput[1].equalsIgnoreCase("")) {
                parseInput[1] = detail.substring(3).trim();
            } else if (detail.startsWith("diag") && parseInput[2].equalsIgnoreCase("")) {
                parseInput[2] = detail.substring(4).trim();
            } else if (detail.startsWith("d") && parseInput[3].equalsIgnoreCase("")) {
                parseInput[3] = detail.substring(1).trim();
            } else if (detail.startsWith("t") && parseInput[4].equalsIgnoreCase("")
                    && isTime(detail.substring(1).trim())) {
                parseInput[4] = detail.substring(1).trim();
            } else {
                System.out.println("    " + detail + " is not a valid input.\n"
                        + "    " + detail + " will not be added\n" + TextUi.DIVIDER);
            }
        }

        while (parseInput[0].equalsIgnoreCase("") || parseInput[1].equalsIgnoreCase("")
                || parseInput[2].equalsIgnoreCase("") || parseInput[3].equalsIgnoreCase("")
                || parseInput[4].equalsIgnoreCase("") || !isDate(parseInput[3].trim())
                || !isNric(parseInput[0]) || !isTime(parseInput[4].trim())) {
            System.out.println("    Please input your missing detail listed below");
            if (parseInput[0].equalsIgnoreCase("") || !isNric(parseInput[0])) {
                System.out.println("    /ic NRIC (Format: S/T [7-digits] [A-Z])");
            }
            if (parseInput[1].equalsIgnoreCase("")) {
                System.out.println("    /sym SYMPTOMS");
            }
            if (parseInput[2].equalsIgnoreCase("")) {
                System.out.println("    /diag DIAGNOSIS");
            }
            if (parseInput[3].equalsIgnoreCase("") || !isDate(parseInput[3])) {
                System.out.println("    /d DATE  (Format: DD/MM/YYYY)");
            }
            if (parseInput[4].equalsIgnoreCase("") || !isTime(parseInput[4])) {
                System.out.println("    /t TIME (Format: HH:MM)");
            }
            String input = promptUser().trim();
            if (input.equalsIgnoreCase("clear")) {
                return new IncorrectPatientRecordCommand("\n    Command has been aborted.\n"
                        + TextUi.DIVIDER);
            }
            String[] updates;
            if (input.startsWith("/")) {
                updates = input.substring(1).split(" /");
            } else {
                input = "@" + input;
                updates = input.split(" /");
            }
            for (String update : updates) {
                if (update.trim().startsWith("ic") && (parseInput[0].equalsIgnoreCase("")
                        || !isNric(parseInput[0].trim()))) {
                    parseInput[0] = update.trim().substring(2).toUpperCase().trim();
                } else if (update.trim().startsWith("sym") && (parseInput[1].equalsIgnoreCase(""))) {
                    parseInput[1] = update.trim().substring(3);
                } else if (update.trim().startsWith("diag") && parseInput[2].equalsIgnoreCase("")) {
                    parseInput[2] = update.trim().substring(4);
                } else if (update.trim().startsWith("d") && (parseInput[3].equalsIgnoreCase("")
                        || !isDate(parseInput[3].trim()))) {
                    parseInput[3] = update.trim().substring(1);
                } else if (update.trim().startsWith("t") && (parseInput[4].equalsIgnoreCase("")
                        || !isTime(parseInput[4].trim()))) {
                    parseInput[4] = update.trim().substring(1);
                }
            }
        }

        boolean hasConfirmation = false;
        System.out.println(promptConformation(parseInput));
        while (!hasConfirmation) {
            String conformation = promptUser();
            if (conformation.equalsIgnoreCase("y")) {
                hasConfirmation = true;
            } else if (conformation.equalsIgnoreCase("n")) {
                return new IncorrectPatientRecordCommand("    The current information is not added.\n"
                        + "    Please add all the details again! Thank you.\n"
                        + TextUi.DIVIDER);
            } else {
                System.out.println("    Please input [y] for yes or [n] for no");
            }
        }

        return new AddPatientRecordCommand(parseInput[0].toUpperCase().trim(), parseInput[1].trim(),
                parseInput[2].trim(), parseInput[3].trim(), parseInput[4].trim());
    }

    private static String promptUser() {
        System.out.println(TextUi.DIVIDER);
        Scanner in = HappyPills.scanner;
        String reInput = in.nextLine();
        System.out.println(TextUi.DIVIDER);
        return reInput;
    }

    /**
     * Prompt user for conformation with this message.
     *
     * @param parseInput details to be displayed to user for confirmation
     * @return string to be displayed to user for confirmation
     */
    public static String promptConformation(String[] parseInput) {
        String text = "        Are you sure all the listed details are correct?\n"
                + "        NRIC : " + parseInput[0].trim().toUpperCase() + "\n"
                + "        Symptom : " + parseInput[1].trim() + "\n"
                + "        Diagnosis : " + parseInput[2].trim() + "\n"
                + "        Date : " + parseInput[3].trim() + "\n"
                + "        time : " + parseInput[4].trim() + "\n"
                + "                                                   (Y/N)?";
        return text;
    }

    /**
     * To check format for time.
     *
     * @param time details of time
     * @return boolean true if the time format is correct otherwise false
     */
    static boolean isTime(String time) {
        String pattern = "([01][0-9]|2[0-3]):([0-5][0-9])";
        return time.matches(pattern);
    }

    /**
     * To check format for date.
     *
     * @param date details of date
     * @return boolean true if the date format is correct otherwise false
     */
    static boolean isDate(String date) {
        String pattern = "(0?[1-9]|[12][0-9]|3[01])\\/(0?[1-9]|1[0-2])\\/([0-9]{4})";
        boolean flag = false;
        if (date.matches(pattern)) {
            flag = true;
        }
        return flag;
    }

    /**
     * To check format for nric.
     *
     * @param nric details of nric
     * @return boolean true if the time format is correct otherwise false
     */
    static boolean isNric(String nric) {
        String pattern = "([S-T][0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z])";
        return nric.matches(pattern);
    }


}
