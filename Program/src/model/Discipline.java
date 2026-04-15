package model;

public class Discipline {
    private int id;
    private String name;
    private String teacherName;
    private String teacherPhone;
    private int schoolId;

    public Discipline(int id, String name, String teacherName, String teacherPhone, int schoolId) {
        setId(id);
        setName(name);
        setTeacherName(teacherName);
        setTeacherPhone(teacherPhone);
        setSchoolId(schoolId);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Discipline name cannot be empty.");
        }
        this.name = name;
    }

    public void setTeacherPhone(String teacherPhone) {
        if (teacherPhone != null && !teacherPhone.matches("^[+]?[0-9]{10,13}$")) {
            throw new IllegalArgumentException("Phone number must contain 10-13 digits.");
        }
        this.teacherPhone = teacherPhone;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public String getTeacherName() { return teacherName; }
    public void setTeacherName(String teacherName) { this.teacherName = teacherName; }
    public String getTeacherPhone() { return teacherPhone; }
    public int getSchoolId() { return schoolId; }
    public void setSchoolId(int schoolId) { this.schoolId = schoolId; }
}