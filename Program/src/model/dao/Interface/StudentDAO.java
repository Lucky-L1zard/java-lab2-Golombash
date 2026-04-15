package model.dao.Interface;

import model.Student;
import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(int id);
    List<Student> findAll();
    void update(Student student);
    void delete(int id);
}