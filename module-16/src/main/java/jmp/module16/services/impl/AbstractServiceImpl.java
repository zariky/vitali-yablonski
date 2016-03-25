package jmp.module16.services.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class AbstractServiceImpl {

    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("module16");
    protected EntityManager em = emf.createEntityManager();

    public void close(){
        em.close();
        emf.close();
    }

}