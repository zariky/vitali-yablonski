package jmp.module16.services.impl;

import jmp.module16.entities.Unit;
import jmp.module16.services.UnitService;
import javax.persistence.TypedQuery;
import java.util.List;

public class UnitServiceImpl extends AbstractServiceImpl implements UnitService {

    @Override
    public Unit create(Unit unit1){
        em.getTransaction().begin();
        Unit unit = em.merge(unit1);
        em.getTransaction().commit();
        return unit;
    }

    @Override
    public List<Unit> findAll(){
        TypedQuery<Unit> namedQuery = em.createNamedQuery("Unit.findAll", Unit.class);
        return namedQuery.getResultList();
    }

}