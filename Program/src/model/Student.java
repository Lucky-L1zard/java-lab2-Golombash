package model;

import java.util.Date;

public class Student {
    private int id;
    private String fullName;
    private String email;
    private Date enrollmentDate;
    private int disciplineId;

    public Student() {}

    public Student(int id, String fullName, String email, Date enrollmentDate, int disciplineId) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.enrollmentDate = enrollmentDate;
        this.disciplineId = disciplineId;
    }

    public boolean isValid() {

        boolean isNameValid = fullName != null && fullName.trim().split("\\s+").length >= 2;
        boolean isEmailValid = email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");

        return isNameValid && isEmailValid && disciplineId > 0;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Date getEnrollmentDate() { return enrollmentDate; }
    public void setEnrollmentDate(Date enrollmentDate) { this.enrollmentDate = enrollmentDate; }
    public int getDisciplineId() { return disciplineId; }
    public void setDisciplineId(int disciplineId) { this.disciplineId = disciplineId; }
}