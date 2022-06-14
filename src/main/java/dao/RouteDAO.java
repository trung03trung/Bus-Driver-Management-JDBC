package dao;

import entity.Route;

import java.util.List;

public interface RouteDAO {
    boolean save(Route route);
    List<Route> getAll();
}
