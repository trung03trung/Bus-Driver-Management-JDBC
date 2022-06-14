package service;

import dao.DirverDAOImpl;
import entity.Driver;

import java.util.List;

public class DriverService {
    public DirverDAOImpl dirverDAO=new DirverDAOImpl();

    public void addNewDriver(){
        Driver d=new Driver();
        d.inputInfor();
        boolean add=dirverDAO.save(d);
        if(add)
            System.out.println("Thêm mới thành công!");
        else {
            System.out.println("Thêm mới thất bại");
        }
    }
    public void showAllDriver(){
        List<Driver> drivers=dirverDAO.getAll();
        for(Driver i:drivers)
            System.out.println(i);
    }
}
