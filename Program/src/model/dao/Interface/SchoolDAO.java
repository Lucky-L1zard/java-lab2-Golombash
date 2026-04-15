package model.dao.Interface;

import model.School;
import java.util.List;

public interface SchoolDAO {
    void save(School school);
    School findById(int id);
    List<School> findAll();
}