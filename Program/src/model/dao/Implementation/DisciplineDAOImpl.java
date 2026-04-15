package model.dao.Implementation;


import model.Discipline;
import model.dao.Interface.DisciplineDAO;
import utility.ConnectionToDatabase;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DisciplineDAOImpl implements DisciplineDAO {

    @Override
    public List<Discipline> findAll() {
        List<Discipline> disciplines = new ArrayList<>();
        String sql = "SELECT * FROM disciplines";
        try (Connection conn = ConnectionToDatabase.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                disciplines.add(SetResultToDiscipline(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching disciplines: " + e.getMessage());
        }
        return disciplines;
    }

    @Override
    public Discipline findById(int id) {
        String sql = "SELECT * FROM disciplines WHERE id = ?";
        try (Connection conn = ConnectionToDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return SetResultToDiscipline(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error finding discipline: " + e.getMessage());
        }
        return null;
    }

    private Discipline SetResultToDiscipline(ResultSet rs) throws SQLException {
        Discipline d = new Discipline();
        d.setId(rs.getInt("id"));
        d.setName(rs.getString("name"));
        d.setTeacherName(rs.getString("teacher_name"));
        d.setTeacherPhone(rs.getString("teacher_phone"));
        d.setSchoolId(rs.getInt("school_id"));
        return d;
    }

    //Можна реалізувати, але оскільки завдання не вимагає і часу не багато...
    @Override public void save(Discipline d) {}
    @Override public void update(Discipline d) {}
    @Override public void delete(int id) {}
}