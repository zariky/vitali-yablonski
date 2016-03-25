package jmp.module16.services;

import jmp.module16.entities.Unit;
import java.util.List;

public interface UnitService {

    public Unit create(Unit unit);

    public Unit update(Unit unit);

    public void delete(Unit unit);

    public List<Unit> findAll();

    public Unit findById(Long id);

    public void close();

}