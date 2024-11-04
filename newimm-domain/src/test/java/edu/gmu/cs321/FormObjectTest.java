//Asma Razick
package edu.gmu.cs321;

public class FormObjectTest {
    FormObject form;
    boolean approval = true;

    public boolean validName() {
        boolean valid = true;
        String name1 = form.getApplicant();
        String name2 = form.getDeceased();
        if (name1 == null || name2 == null || name1.isEmpty() || name2.isEmpty()) {
            this.approval = false;
            valid = false;
            return valid;
        }
        for (int i = 0; i < name1.length(); i++) {
            if (!Character.isLetter(name1.charAt(i))) {
                valid = false;
                this.approval = false;
                break;
            }
        }
        for (int i = 0; i < name2.length(); i++) {
            if (!Character.isLetter(name2.charAt(i))) {
                this.approval = false;
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

    public boolean validDOB() {
        boolean valid = true;
        String dob1 = form.getApplicantDOB();
        String dob2 = form.getDeceasedDOB();
        if (dob1 == null || dob2 == null || dob1.isEmpty() || dob2.isEmpty()) {
            this.approval = false;
            valid = false;
            System.out.println("Invalid DOB!");
        }
        if (!dob1.matches("\\d{4}-\\d{2}-\\d{2}") || !dob2.matches("\\d{4}-\\d{2}-\\d{2}")) {
            this.approval = false;
            valid = false;
            System.out.println("Invalid DOB!");
        }
        System.out.println("Valid DOB!");
        return valid;
    }

    public boolean validID() {
        boolean valid = true;
        String id1 = form.getApplicantID();
        String id2 = form.getDeceasedID();
        if (id1 == null || id2 == null || id1.isEmpty() || id2.isEmpty()) {
            this.approval = false;
            valid = false;

        }
        for (int i = 0; i < id1.length(); i++) {
            if (!Character.isDigit(id1.charAt(i))) {
                this.approval = false;
                valid = false;
                break;
            }
        }
        for (int i = 0; i < id2.length(); i++) {
            if (!Character.isDigit(id2.charAt(i))) {
                this.approval = false;
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

    public boolean approveForm() {
        if (this.approval == true) {
            System.out.println("Success! Your form has been approved!");
            return this.approval;
        } else {
            System.out.println("Uh Oh! Your form has issues and has been rejected!");
            return this.approval;
        }
    }

}