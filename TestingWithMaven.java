public class FormObject {
    private String applicant;
    private String deceased;
    private String applicantDOB;
    private String deceasedDOB;
    private String applicantID;
    private String deceasedID;
    public FormObject(String applicant, String deceased, String applicantDOB, String deceasedDOB, String applicantID,
            String deceasedID) {
        this.applicant = applicant;
        this.deceased = deceased;
        this.applicantDOB = applicantDOB;
        this.deceasedDOB = deceasedDOB;
        this.applicantID = applicantID;
        this.deceasedID = deceasedID;
    }

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

}
