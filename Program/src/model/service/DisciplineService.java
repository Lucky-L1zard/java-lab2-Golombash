package model.service;

import model.Discipline;

import java.util.List;

public interface DisciplineService {
    List<Discipline> getAllDisciplines();
    Discipline getDisciplineById(int id);
}

