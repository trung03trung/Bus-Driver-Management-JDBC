package dao;

import Utils.OracleConnUtils;
import entity.Division;
import entity.DivisionDetail;
import entity.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DivisionDetailDAOImpl implements DivisionDetailDAO {

    private RouteDAO routeDAO=new RouteDAOImpl();

    @Override
    public List<DivisionDetail> getAllByDivision(Division d) {
        String sql="SELECT * FROM divisiondetail where division_id=?";
        try {
            Connection conn=OracleConnUtils.getOracleConnection();
            PreparedStatement pstm=conn.prepareStatement(sql);
            pstm.setInt(1,d.getDriver().getId());
            ResultSet rs= pstm.executeQuery();
            List<DivisionDetail> divisionDetails=new ArrayList<>();
            while (rs.next()){
                int route_id= rs.getInt("route_id");
                int numTurn=rs.getInt("num_turn");
                divisionDetails.add(new DivisionDetail(routeDAO.getOneById(route_id),numTurn));
            }
            return divisionDetails;
        }catch (ClassNotFoundException e){
            System.out.println(e);
        }catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public boolean save(DivisionDetail d,Division division) {
        String sql="INSERT INTO divisiondetail(route_id,division_id,num_turn) "
                +" VALUES(?,?,?)";
        try {

            Connection conn = OracleConnUtils.getOracleConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1,d.getRoutes().getId());
            pstm.setInt(2,division.getDriver().getId());
            pstm.setInt(3,d.getNumTurn());
            pstm.execute();
            return true;
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
