package model.service.Implementation;

import model.dao.Interface.StudentDAO;
import model.dao.Implementation.StudentDAOImpl;
import model.Student;
import model.service.StudentService;

import java.sql.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    public void registerStudent(Student student) {
        boolean exists = studentDAO.findAll().stream()
                .anyMatch(s -> s.getFullName().equalsIgnoreCase(student.getFullName()));

        if (exists) {
            System.out.println("Помилка: Студент з ім'ям " + student.getFullName() + " вже існує!");
            return;
        }

        studentDAO.save(student);
        System.out.println("Студента успішно зареєстровано.");
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.findAll();
    }

    @Override
    public List<Student> filterStudents(Predicate<Student> condition) {
        return studentDAO.findAll().stream()
                .filter(condition)
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> getStudentsByDiscipline(int disciplineId) { //як варіант використання filterStudents
        return filterStudents(s -> s.getDisciplineId() == disciplineId);
    }

    @Override
    public void removeStudent(int id) {
        studentDAO.delete(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentDAO.update(student);
    }
}