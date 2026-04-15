package model.dao.Interface;

import model.Discipline;
import java.util.List;

public interface DisciplineDAO {
    void save(Discipline discipline);
    Discipline findById(int id);
    List<Discipline> findAll();
    void update(Discipline discipline);
    void delete(int id);
}