package service;

import dao.RouteDAO;
import dao.RouteDAOImpl;
import entity.Route;

import java.util.List;

public class RouteService {
    public RouteDAO routeDAO=new RouteDAOImpl();
    public void addNewRoute(){
        Route r=new Route();
        r.inputInfor();
        boolean add=routeDAO.save(r);
        if(add)
            System.out.println("Thêm mới thành công!");
        else {
            System.out.println("Thêm mới thất bại");
        }

    }
    public void showAllRoute(){
        List<Route> routes=routeDAO.getAll();
        for(Route i:routes)
            System.out.println(i);
    }
}
