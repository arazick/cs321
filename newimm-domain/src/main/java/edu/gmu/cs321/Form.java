package edu.gmu.cs321;

public class Form {
    private String id;
    private String applicantName;
    private String details;
    private String status;
    private String issues;

    public Form(String id, String applicantName, String details, String status) {
        this.id = id;
        this.applicantName = applicantName;
        this.details = details;
        this.status = status;
        this.issues = "";
    }

    public String getId() {
        return id;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public String getDetails() {
        return details;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIssues() {
        return issues;
    }

    public void setIssues(String issues) {
        this.issues = issues;
    }
}
