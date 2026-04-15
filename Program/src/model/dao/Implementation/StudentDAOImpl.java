package model.dao.Implementation;

import model.dao.Interface.StudentDAO;
import model.Student;
import utility.ConnectionToDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

    public class StudentDAOImpl implements StudentDAO {

        @Override
        public void save(Student student) {
            String sql = "INSERT INTO students (full_name, email, discipline_id) VALUES (?, ?, ?)";
            try (Connection conn = ConnectionToDatabase.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, student.getFullName());
                pstmt.setString(2, student.getEmail());
                pstmt.setInt(3, student.getDisciplineId());
                pstmt.executeUpdate();

            } catch (SQLException e) {
                System.err.println("Error saving student: " + e.getMessage());
            }
        }

        @Override
        public Student findById(int id) {
            String sql = "SELECT * FROM students WHERE id = ?";
            try (Connection conn = ConnectionToDatabase.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, id);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        return SetResultToStudent(rs);
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error finding student: " + e.getMessage());
            }
            return null;
        }

        @Override
        public List<Student> findAll() {
            List<Student> students = new ArrayList<>();
            String sql = "SELECT * FROM students";
            try (Connection conn = ConnectionToDatabase.getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    students.add(SetResultToStudent(rs));
                }
            } catch (SQLException e) {
                System.err.println("Error fetching all students: " + e.getMessage());
            }
            return students;
        }

        @Override
        public void update(Student student) {
            String sql = "UPDATE students SET full_name = ?, email = ?, discipline_id = ? WHERE id = ?";
            try (Connection conn = ConnectionToDatabase.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, student.getFullName());
                pstmt.setString(2, student.getEmail());
                pstmt.setInt(3, student.getDisciplineId());
                pstmt.setInt(4, student.getId());
                pstmt.executeUpdate();

            } catch (SQLException e) {
                System.err.println("Error updating student: " + e.getMessage());
            }
        }

        @Override
        public void delete(int id) {
            String sql = "DELETE FROM students WHERE id = ?";
            try (Connection conn = ConnectionToDatabase.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, id);
                pstmt.executeUpdate();

            } catch (SQLException e) {
                System.err.println("Error deleting student: " + e.getMessage());
            }
        }

        private Student SetResultToStudent(ResultSet rs) throws SQLException {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setFullName(rs.getString("full_name"));
            student.setEmail(rs.getString("email"));
            student.setEnrollmentDate(rs.getDate("enrollment_date"));
            student.setDisciplineId(rs.getInt("discipline_id"));
            return student;
        }
    }
