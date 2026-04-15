package model;

import java.util.Date;

public class Student {
    private int id;
    private String fullName;
    private String email;
    private Date enrollmentDate;
    private int disciplineId;

    public Student(int id, String fullName, String email, Date enrollmentDate, int disciplineId) {
        setId(id);
        setFullName(fullName);
        setEmail(email);
        setEnrollmentDate(enrollmentDate);
        setDisciplineId(disciplineId);
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.trim().split("\\s+").length < 2) {
            throw new IllegalArgumentException("Full name must contain at least two words (First and Last name).");
        }
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email format.");
        }
        this.email = email;
    }

    public void setDisciplineId(int disciplineId) {
        if (disciplineId <= 0) {
            throw new IllegalArgumentException("Discipline ID must be a positive number.");
        }
        this.disciplineId = disciplineId;
    }
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public Date getEnrollmentDate() { return enrollmentDate; }
    public void setEnrollmentDate(Date enrollmentDate) { this.enrollmentDate = enrollmentDate; }
    public int getDisciplineId() { return disciplineId; }
}