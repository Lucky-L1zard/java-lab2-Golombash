package model.service;

import model.Student;
import java.util.List;
import java.util.function.Predicate;

public interface StudentService {
    void registerStudent(Student student);
    List<Student> getAllStudents();
    List<Student> filterStudents(Predicate<Student> condition);
    void removeStudent(int id);
    List<Student> getStudentsByDiscipline(int disciplineId);
    void updateStudent(Student student);
}