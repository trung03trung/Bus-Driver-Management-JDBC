package Main;

import Utils.OracleConnUtils;
import service.DivisionService;
import service.DriverService;
import service.RouteService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static DriverService driverService=new DriverService();
    public static RouteService routeService=new RouteService();
    public static DivisionService divisionService=new DivisionService();
    public static void main(String[] args)  {
        while (true) {
            System.out.println("-------Phần mềm quản lý điểm sinh viên-------");
            System.out.println("1.Nhập lái xe mới");
            System.out.println("2.In ra danh sách lái xe");
            System.out.println("3.Nhập tuyến mới");
            System.out.println("4.In ra danh sách tuyến");
            System.out.println("5.Nhập và in ra danh sách phân công cho mỗi lái xe");
            System.out.println("6.Sắp xếp danh sách phân công theo họ tên lái xe");
            System.out.println("7.Sắp xếp danh sách phân công theo số lượng tuyến");
            System.out.println("8.Thống kê tổng khoảng cách chạy xe trong ngày của mỗi lái xe");
            System.out.println("0.Thoát");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:
                    driverService.addNewDriver();
                    break;
                case 2:
                    driverService.showAllDriver();
                    break;
                case 3:
                    routeService.addNewRoute();
                    break;
                case 4:
                    routeService.showAllRoute();
                    break;
                case 5:
                    divisionService.addNewDivision();
                    divisionService.showAllDivision();
                    break;
                case 6:
                    divisionService.sortByNameDriver();

                    break;
                case 7:
                    divisionService.sortByNumTurn();
                    break;


                default:
                    System.out.println("Chỉ chọn từ 0 đến 8!!");
                    break;
            }

        }
        }


}
