public class FormObject {
    private String applicant;
    private String deceased;
    private String applicantDOB;
    private String deceasedDOB;
    private String applicantID;
    private String deceasedID;

    // All aspects of form
    public FormObject(String applicant, String deceased, String applicantDOB, String deceasedDOB, String applicantID,
            String deceasedID) {
        this.applicant = applicant;
        this.deceased = deceased;
        this.applicantDOB = applicantDOB;
        this.deceasedDOB = deceasedDOB;
        this.applicantID = applicantID;
        this.deceasedID = deceasedID;
    }

    // Getters
    public String getApplicant() {
        return applicant;
    }

    public String getDeceased() {
        return deceased;
    }

    public String getApplicantDOB() {
        return applicantDOB;
    }

    public String getDeceasedDOB() {
        return deceasedDOB;
    }

    public String getApplicantID() {
        return applicantID;
    }

    public String getDeceasedID() {
        return deceasedID;
    }

    // Checks that both the person and the deceased have a valid name
    public boolean validName() {
        boolean valid = true;
        String name1 = getApplicant();
        String name2 = getDeceased();
        if (name1 == null || name2 == null || name1.isEmpty() || name2.isEmpty()) {
            valid = false;
            return valid;
        }
        for (int i = 0; i < name1.length(); i++) {
            if (!Character.isLetter(name1.charAt(i))) {
                valid = false;
                break;
            }
        }
        for (int i = 0; i < name2.length(); i++) {
            if (!Character.isLetter(name2.charAt(i))) {
                valid = false;
                break;
            }
        }
        if (valid == false) {
            System.out.println("Invalid Name!");

        } else {
            System.out.println("Valid Name!");
        }
        return valid;
    }

    // Checks that both the person and the deceased have a valid DOB
    public boolean validDOB() {
        boolean valid = true;
        String dob1 = getApplicantDOB();
        String dob2 = getDeceasedDOB();
        if (dob1 == null || dob2 == null || dob1.isEmpty() || dob2.isEmpty()) {
            valid = false;
            System.out.println("Invalid DOB!");
        }
        if (!dob1.matches("\\d{4}-\\d{2}-\\d{2}") || !dob2.matches("\\d{4}-\\d{2}-\\d{2}")) {
            valid = false;
            System.out.println("Invalid DOB!");
        }
        System.out.println("Valid DOB!");
        return valid;
    }

    // Checks that both the person and the deceased have a valid ID
    public boolean validID() {
        boolean valid = true;
        String id1 = getApplicantID();
        String id2 = getDeceasedID();
        if (id1 == null || id2 == null || id1.isEmpty() || id2.isEmpty()) {
            valid = false;

        }
        for (int i = 0; i < id1.length(); i++) {
            if (!Character.isDigit(id1.charAt(i))) {
                valid = false;
                break;
            }
        }
        for (int i = 0; i < id2.length(); i++) {
            if (!Character.isDigit(id2.charAt(i))) {
                valid = false;
                break;
            }
        }
        if (valid == false) {
            System.out.println("Invalid Name!");

        } else {
            System.out.println("Valid Name!");
        }
        return valid;
    }

}