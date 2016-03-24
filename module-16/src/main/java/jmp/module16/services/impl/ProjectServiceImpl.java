package jmp.module16.services.impl;

import jmp.module16.entities.Project;
import jmp.module16.services.ProjectService;
import java.util.List;

public class ProjectServiceImpl extends AbstractServiceImpl implements ProjectService {

    @Override
    public Project create(Project project){
        return merge(project);
    }

    @Override
    public Project update(Project project) {
        return merge(project);
    }

    @Override
    public void delete(Project project) {
        em.getTransaction().begin();
        em.remove(project);
        em.getTransaction().commit();
    }

    @Override
    public List<Project> findAll(){
        return em.createNamedQuery("Project.findAll", Project.class).getResultList();
    }

    @Override
    public Project findById(Long id) {
        return em.find(Project.class, id);
    }

    private Project merge(Project project1) {
        em.getTransaction().begin();
        Project project = em.merge(project1);
        em.getTransaction().commit();
        return project;
    }

}