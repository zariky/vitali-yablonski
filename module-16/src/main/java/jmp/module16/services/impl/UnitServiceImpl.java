package jmp.module16.services.impl;

import jmp.module16.entities.Unit;
import jmp.module16.services.UnitService;
import java.util.List;

public class UnitServiceImpl extends AbstractServiceImpl implements UnitService {

    @Override
    public Unit create(Unit unit){
        return merge(unit);
    }

    @Override
    public Unit update(Unit unit) {
        return merge(unit);
    }

    @Override
    public void delete(Unit unit) {
        em.getTransaction().begin();
        em.remove(unit);
        em.getTransaction().commit();
    }

    @Override
    public List<Unit> findAll(){
        return em.createNamedQuery("Unit.findAll", Unit.class).getResultList();
    }

    @Override
    public Unit findById(Long id) {
        return em.find(Unit.class, id);
    }

    private Unit merge(Unit unit1) {
        em.getTransaction().begin();
        Unit unit = em.merge(unit1);
        em.getTransaction().commit();
        return unit;
    }

}