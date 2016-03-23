package jmp.module16.services;

import jmp.module16.entities.Unit;
import java.util.List;

public interface UnitService {

    public Unit create(Unit unit);

    public List<Unit> findAll();

    public void close();

}