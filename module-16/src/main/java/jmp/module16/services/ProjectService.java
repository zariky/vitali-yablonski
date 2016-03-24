package jmp.module16.services;

import jmp.module16.entities.Project;
import java.util.List;

public interface ProjectService {

    public Project create(Project project);

    public List<Project> findAll();

    public void close();

}