package jmp.module16.services.impl;

import jmp.module16.entities.Project;
import jmp.module16.services.ProjectService;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProjectServiceImpl extends AbstractServiceImpl implements ProjectService {

    @Override
    public Project create(Project project1){
        em.getTransaction().begin();
        Project project = em.merge(project1);
        em.getTransaction().commit();
        return project;
    }

    @Override
    public List<Project> findAll(){
        TypedQuery<Project> namedQuery = em.createNamedQuery("Project.findAll", Project.class);
        return namedQuery.getResultList();
    }

}
