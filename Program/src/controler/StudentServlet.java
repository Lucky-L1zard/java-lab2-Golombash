package controler;

import model.Student;
import model.Discipline;
import model.service.StudentService;
import model.service.DisciplineService;
import model.service.Implementation.StudentServiceImpl;
import model.service.Implementation.DisciplineServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {

    private final StudentService studentService = new StudentServiceImpl();
    private final DisciplineService disciplineService = new DisciplineServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "list";

        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteStudent(request, response);
                    break;
                default:
                    listStudents(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Student> listStudent = studentService.getAllStudents();
        List<Discipline> disciplines = disciplineService.getAllDisciplines();

        request.setAttribute("students", listStudent);
        request.setAttribute("disciplines", disciplines);
        request.getRequestDispatcher("student-list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Discipline> disciplines = disciplineService.getAllDisciplines();
        request.setAttribute("disciplines", disciplines);
        request.getRequestDispatcher("student-form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student existingStudent = studentService.getAllStudents().stream()
                .filter(s -> s.getId() == id).findFirst().orElse(null);

        List<Discipline> disciplines = disciplineService.getAllDisciplines();

        request.setAttribute("student", existingStudent);
        request.setAttribute("disciplines", disciplines);
        request.getRequestDispatcher("student-form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        String idStr = request.getParameter("id");
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        String discIdStr = request.getParameter("disciplineId");

        if (fullName != null && discIdStr != null) {
            int disciplineId = Integer.parseInt(discIdStr);

            Student student = new Student();
            student.setFullName(fullName);
            student.setEmail(email);
            student.setDisciplineId(disciplineId);

            if (!email.matches(emailRegex)) {
                request.setAttribute("errorMessage", "Адреса має містити '@' та крапку в домені (наприклад: \".com\")");
                request.setAttribute("student", student);
                showNewForm(request, response);
                return;
            }

            if (idStr == null || idStr.isEmpty()) {
                // Реєстрація нового студента
                studentService.registerStudent(student);
            } else {
                // Оновлення існуючого
                student.setId(Integer.parseInt(idStr));
                studentService.updateStudent(student);
            }
        }
        response.sendRedirect("students");
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentService.removeStudent(id);
        response.sendRedirect("students");
    }
}