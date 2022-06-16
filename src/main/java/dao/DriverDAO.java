package dao;

import entity.Driver;

import java.util.List;

public interface DriverDAO {
    boolean save(Driver driver);
    List<Driver> getAll();
    Driver getOneById(int id);
}
