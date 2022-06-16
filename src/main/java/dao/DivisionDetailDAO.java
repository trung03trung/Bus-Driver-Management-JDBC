package dao;

import entity.Division;
import entity.DivisionDetail;

import java.util.List;

public interface DivisionDetailDAO {

    List<DivisionDetail> getAllByDivision(Division d);
    boolean save(DivisionDetail d,Division division);
}
