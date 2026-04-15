package model.service.Implementation;

import model.dao.Interface.DisciplineDAO;
import model.dao.Implementation.DisciplineDAOImpl;
import model.Discipline;
import model.service.DisciplineService;
import java.util.List;

public class DisciplineServiceImpl implements DisciplineService {
    private final DisciplineDAO disciplineDAO = new DisciplineDAOImpl();

    @Override
    public List<Discipline> getAllDisciplines() {
        return disciplineDAO.findAll();
    }

    @Override
    public Discipline getDisciplineById(int id) {
        return disciplineDAO.findById(id);
    }
}