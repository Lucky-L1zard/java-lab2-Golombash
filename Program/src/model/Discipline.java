package model;

public class Discipline {
    private int id;
    private String name;
    private String teacherName;
    private int schoolId;

    public Discipline() {}

    public Discipline(int id, String name, String teacherName, int schoolId) {
        this.id = id;
        this.name = name;
        this.teacherName = teacherName;
        this.schoolId = schoolId;
    }

    public boolean isValid() {
        return name != null && !name.trim().isEmpty() &&
                teacherName != null && teacherName.length() >= 2 &&
                schoolId > 0;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getTeacherName() { return teacherName; }
    public void setTeacherName(String teacherName) { this.teacherName = teacherName; }
    public int getSchoolId() { return schoolId; }
    public void setSchoolId(int schoolId) { this.schoolId = schoolId; }
}