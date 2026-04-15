package model.service.Implementation;

import model.dao.Interface.SchoolDAO;
import model.dao.Implementation.SchoolDAOImpl;
import model.School;
import model.service.SchoolService;

import java.util.List;

public class SchoolServiceImpl implements SchoolService {
    private final SchoolDAO schoolDAO = new SchoolDAOImpl();

    @Override
    public List<School> getAllSchools() {
        return schoolDAO.findAll();
    }
}