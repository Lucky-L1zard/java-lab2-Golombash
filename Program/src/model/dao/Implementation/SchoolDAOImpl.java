package model.dao.Implementation;

import model.dao.Interface.SchoolDAO;
import model.School;
import utility.ConnectionToDatabase;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SchoolDAOImpl implements SchoolDAO {

    @Override
    public List<School> findAll() {
        List<School> schools = new ArrayList<>();
        String sql = "SELECT * FROM schools";
        try (Connection conn = ConnectionToDatabase.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                schools.add(new School(rs.getInt("id"), rs.getString("name"), rs.getString("address")));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching schools: " + e.getMessage());
        }
        return schools;
    }

    @Override
    public School findById(int id) {
        String sql = "SELECT * FROM schools WHERE id = ?";
        try (Connection conn = ConnectionToDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new School(rs.getInt("id"), rs.getString("name"), rs.getString("address"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error finding school: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void save(School school) { /* Не реалізуємо згідно з умовою */ }
}