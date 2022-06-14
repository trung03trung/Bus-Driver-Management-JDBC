package dao;

import Utils.OracleConnUtils;
import entity.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DirverDAOImpl implements DriverDAO {
    public boolean save(Driver driver){
        String sql="INSERT INTO driver(id,name,address,phonenum,levels) "
                +" VALUES(?,?,?,?,?)";
        try {

            Connection conn = OracleConnUtils.getOracleConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            int id=getAll().size()+1;
            pstm.setInt(1,id);
            pstm.setString(2, driver.getName());
            pstm.setString(3, driver.getAddress());
            pstm.setString(4, driver.getPhoneNum());
            pstm.setString(5, driver.getLevel());
            pstm.execute();
            return true;
        }catch (ClassNotFoundException e){
            System.out.println(e);
        }catch (SQLException e){
            System.out.println(e);
        }
        return false;
      }
        public List<Driver> getAll(){
            String sql="SELECT * FROM driver";
            try {

                Connection conn = OracleConnUtils.getOracleConnection();
                Statement st= conn.createStatement();
                ResultSet rs=st.executeQuery(sql);
                List<Driver> drivers=new ArrayList<>();
                while (rs.next()){
                    int id= rs.getInt(1);
                    String name=rs.getString("name");
                    String address=rs.getString("address");
                    String phonenum=rs.getString("phonenum");
                    String level=rs.getString("levels");
                    Driver d=new Driver(id,name,address,phonenum,level);
                    drivers.add(d);
                }
                conn.close();
                return drivers;
            }catch (ClassNotFoundException e){
                System.out.println(e);
            }catch (SQLException e){
                System.out.println(e);
            }
            return null;
        }
    }

