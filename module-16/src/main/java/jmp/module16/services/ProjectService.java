package jmp.module16.services;

import jmp.module16.entities.Project;
import java.util.List;

public interface ProjectService {

    public Project create(Project project);

    public Project update(Project employee);

    public void delete(Project employee);

    public List<Project> findAll();

    public Project findById(Long id);

    public void close();

}