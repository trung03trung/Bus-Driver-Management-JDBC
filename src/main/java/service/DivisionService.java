package service;

import dao.*;
import entity.Division;
import entity.DivisionDetail;

import java.util.*;

public class DivisionService {
    private DivisionDAO divisionDAO=new DivisionDAOImpl();
    private DriverDAO driverDAO=new DirverDAOImpl();
    private RouteDAO routeDAO=new RouteDAOImpl();
    private DivisionDetailDAO divisionDetailDAO=new DivisionDetailDAOImpl();

    public void addNewDivision(){
        if(routeDAO.getAll().isEmpty()||driverDAO.getAll().isEmpty()){
            System.out.println("Không có dữ liệu lái xe hoặc tuyến!!!");
            return;
        }
        Scanner sc = new Scanner(System.in);
        int driverID;
        System.out.print("Nhập mã lái xe: ");
        do {
            try {
                driverID = Integer.parseInt(sc.next());
                if (driverDAO.getOneById(driverID) != null)
                    break;
                System.out.print("Mã lái xe không tồn tại vui lòng nhập lại: ");
            } catch (NumberFormatException e) {
                System.out.print("Mã lái xe phải là số nguyên dương vui lòng nhập lại: ");
            }
        } while (true);
        int n;
        System.out.print("Nhập số lượng tuyến muốn thêm: ");
        do {
            try {
                n = Integer.parseInt(sc.next());
                if (n > 0)
                    break;
                System.out.print("Số lượng tuyến phải là số nguyên dương: ");
            } catch (NumberFormatException e) {
                System.out.print("Mã lái xe phải là số nguyên dương vui lòng nhập lại: ");
            }
        } while (true);
        Division d=new Division();
        d.setDriver(driverDAO.getOneById(driverID));
        divisionDAO.save(d);
        List<DivisionDetail> list = new ArrayList<>();
        for (int i = 0; i < n; i++){
            System.out.print("Nhập mã tuyến thứ "+(i+1)+" muốn thêm: ");
            int routeID;
            do {
                try {
                    routeID = Integer.parseInt(sc.next());
                    if (routeDAO.getOneById(routeID)!=null&&checkSameID(list,routeID))
                        break;
                    System.out.print("Mã tuyến không tồn tại hoặc bị trùng vui lòng nhập lại: ");
                } catch (NumberFormatException e) {
                    System.out.print("Mã tuyến phải là số nguyên dương vui lòng nhập lại: ");
                }
            } while (true);
            System.out.print("Nhập số lượt: ");
            int numTurn;
            do {
                try {
                    numTurn = Integer.parseInt(sc.next());
                    if (numTurn>0&&numTurn<=15)
                        break;
                    System.out.print("Số lượt không vượt quá 15 vui lòng nhập lại: ");
                } catch (NumberFormatException e) {
                    System.out.print("Số lượt là số nguyên dương vui lòng nhập lại: ");
                }
            } while (true);
            DivisionDetail di=new DivisionDetail(routeDAO.getOneById(routeID),numTurn);
            list.add(di);
            divisionDetailDAO.save(di,d);
        }


    }
    private  boolean checkSameID(List<DivisionDetail> list, int id){
        for(DivisionDetail i:list) {
            if (i.getRoutes().getId() == id)
                return false;
        }
        return true;

    }
    public void showAllDivision(){
        List<Division> divisions=divisionDAO.getAll();
        for(Division i:divisions)
            System.out.println(i);
    }
    public void sortByNameDriver(){
        List<Division> divisions=divisionDAO.getAll();
        Collections.sort(divisions, new Comparator<Division>() {
            @Override
            public int compare(Division o1, Division o2) {
                return o1.getDriver().getName().compareTo(o2.getDriver().getName());
            }
        });
        for(Division i:divisions)
            System.out.println(i);

    }
    public void sortByNumTurn(){
        List<Division> divisions=divisionDAO.getAll();
        Collections.sort(divisions, new Comparator<Division>() {
            @Override
            public int compare(Division o1, Division o2) {
                int sum1=0,sum2=0;
                for(DivisionDetail i:o1.getDivisionDetails()){
                    sum1+=i.getNumTurn();
                }
                for(DivisionDetail i:o2.getDivisionDetails()){
                    sum2+=i.getNumTurn();
                }

                return sum2>sum1? 0:-1;
            }
        });
        for(Division i:divisions)
            System.out.println(i);

    }
}
