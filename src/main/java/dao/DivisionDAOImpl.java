package dao;

import Utils.OracleConnUtils;
import entity.Division;
import entity.DivisionDetail;
import entity.Route;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DivisionDAOImpl implements DivisionDAO{
    private DriverDAO driverDAO=new DirverDAOImpl();
    private DivisionDetailDAO divisionDetailDAO=new DivisionDetailDAOImpl();
    @Override
    public boolean save(Division d) {
        String sql="INSERT INTO division(driver_id) "
                +" VALUES(?)";
        try {

            Connection conn = OracleConnUtils.getOracleConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            int id=10000+getAll().size();
            pstm.setInt(1,d.getDriver().getId());
            pstm.execute();
            return true;
        }catch (ClassNotFoundException e){
            System.out.println(e);
        }catch (SQLException e){
            System.out.println(e);
        }
        return false;
    }

    @Override
    public List<Division> getAll() {
        String sql="SELECT * FROM division";
        try {

            Connection conn = OracleConnUtils.getOracleConnection();
            Statement st= conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            List<Division> divisions=new ArrayList<>();
            while (rs.next()){
                int driver_id= rs.getInt("driver_id");
                Division d=new Division();
                d.setDriver(driverDAO.getOneById(driver_id));
                d.setDivisionDetails(divisionDetailDAO.getAllByDivision(d));
                divisions.add(d);
            }
            conn.close();
            return divisions;
        }catch (ClassNotFoundException e){
            System.out.println(e);
        }catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }


}
