package dao;

import Utils.OracleConnUtils;
import entity.Driver;
import entity.Route;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RouteDAOImpl implements RouteDAO {
    @Override
    public boolean save(Route route) {
        String sql="INSERT INTO route(id,distance,stoppoint) "
                +" VALUES(?,?,?)";
        try {

            Connection conn = OracleConnUtils.getOracleConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            int id=getAll().size()+1;
            pstm.setInt(1,id);
            pstm.setLong(2, route.getDistance());
            pstm.setInt(3, route.getStopPoint());
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
    public List<Route> getAll() {
        String sql="SELECT * FROM route";
        try {

            Connection conn = OracleConnUtils.getOracleConnection();
            Statement st= conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            List<Route> routes=new ArrayList<>();
            while (rs.next()){
                int id= rs.getInt(1);
                long distance=rs.getLong("distance");
                int stopPoint=rs.getInt("stoppoint");
                Route r=new Route(id,distance,stopPoint);
                routes.add(r);
            }
            conn.close();
            return routes;
        }catch (ClassNotFoundException e){
            System.out.println(e);
        }catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }
}
