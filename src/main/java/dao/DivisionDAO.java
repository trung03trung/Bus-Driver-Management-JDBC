package dao;

import entity.Division;
import entity.DivisionDetail;

import java.util.List;

public interface DivisionDAO {
    boolean save(Division d);
    List<Division> getAll();

}
