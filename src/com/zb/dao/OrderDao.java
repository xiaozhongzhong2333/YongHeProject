package com.zb.dao;

import com.zb.pojo.Door;
import com.zb.pojo.Order;
import com.zb.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.sql.Timestamp;
public class OrderDao {
    public List<Order> dopage(Integer pageOn,Integer pageSize){
        Connection conn = null;
        try {
            conn = DBUtils.getConnectionByDatasource();
            String sql = "select * from tb_order limit ?,?";
            pageOn = (pageOn-1)*pageSize;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,pageOn);
            ps.setInt(2,pageSize);
            ResultSet rs = ps.executeQuery();
            List<Order> list = new ArrayList<>();
            Order order = null;
            while (rs.next()){
                order=new Order();
                order.setId(rs.getInt("id"));
                order.setDoor_id(rs.getInt("door_id"));
                order.setOrder_no(rs.getString("order_no"));
                order.setOrder_type(rs.getString("order_type"));
                order.setPnum(rs.getInt("pnum"));
                order.setCashier(rs.getString("cashier"));
                order.setOrder_time(rs.getTime("order_time"));
                order.setPay_time(rs.getTime("pay_time"));
                order.setPay_type(rs.getString("pay_type"));
                order.setPrice(rs.getDouble("price"));
                System.out.println("价格为"+rs.getDouble("price"));
                list.add(order);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
        return null;
    }












    public List<Order> findAll() throws SQLException {
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "select * from tb_order o join tb_door d on o.door_id=d.id  ";
        PreparedStatement psmt = conn.prepareStatement(sql);
        ResultSet rs = psmt.executeQuery();
        List<Order> list = new ArrayList<Order>();
        while (rs.next()) {
            Order order = new Order();
            order.setId(rs.getInt(1));
            order.setDoor_id(rs.getInt(2));
            order.setOrder_no(rs.getString(3));
            order.setOrder_type(rs.getString(4));
            order.setPnum(rs.getInt(5));
            order.setCashier(rs.getString(6));
            Timestamp ts = rs.getTimestamp(7);
            Date date=new Date();
            date=ts;
            order.setOrder_time(date);
            Timestamp ts1 = rs.getTimestamp(8);
            Date date1=new Date();
            date1=ts1;
            order.setPay_time(date1);
            order.setPay_type(rs.getString(9));
            order.setPrice(rs.getDouble(10));
//            order.setName(rs.getString(12));
            list.add(order);
        }
        psmt.close();
        conn.close();
        return list;
    }



    //查询总数
    public Integer pagecount(){
        Connection conn = null;
        try {
            conn =DBUtils.getConnectionByDatasource();
            String sql = "select count(*) from tb_order";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Integer count = 0;
            while (rs.next()){
                count = rs.getInt(1);
            }
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
        return null;
    }

    //根据名字返回door_id
    public int find_Door_id(String door_name) throws SQLException {
        System.out.println("店铺名字"+door_name);
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "select id from  tb_door where name=? ";
        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setString(1,door_name);
        ResultSet rs = psmt.executeQuery();
        int result=0;
        while (rs.next()) {
            result=rs.getInt(1);
        }
        System.out.println("查询结果为"+result);
        psmt.close();
        conn.close();
        return result;
    }

    //增加门店
    public int addOrder(Order order) throws SQLException {

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String order_time=sdf.format(order.getOrder_time());
        String pay_time=sdf.format(order.getPay_time());
        System.out.println(order_time);
        System.out.println(java.sql.Timestamp.valueOf(order_time));
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "insert into tb_order (door_id,order_no,order_type," +
                "pnum,cashier,order_time,pay_time,pay_Type,price)" +
                " values (?,?,?,?,?,?,?,?,?)";
        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setInt(1, order.getDoor_id());
        psmt.setString(2, order.getOrder_no());
        psmt.setString(3, order.getOrder_type());
        psmt.setInt(4, order.getPnum());
        psmt.setString(5, order.getCashier());
        psmt.setTimestamp(6,java.sql.Timestamp.valueOf(order_time));
        psmt.setTimestamp(7,java.sql.Timestamp.valueOf(pay_time));
        psmt.setString(8, order.getPay_type());
        psmt.setDouble(9, order.getPrice());
        int result = psmt.executeUpdate();
        conn.close();
        return result;
    }

    //删除
    public int delOrder(int id) throws SQLException {
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "delete from tb_order where id=?";
        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setInt(1, id);
        int result = psmt.executeUpdate();
        conn.close();
        return result;
    }
//
//    //查询单个
//    public Door findById(String name
//
//    ) throws SQLException {
//        Connection conn = DBUtils.getConnectionByDatasource();
//        String sql = "select * from tb_door where id=?";
//        PreparedStatement psmt = conn.prepareStatement(sql);
//        psmt.setInt(1,id);
//        ResultSet rs = psmt.executeQuery();
//        Door door = new Door();
//        while (rs.next()) {
//            door.setId(rs.getInt("id"));
//            door.setName(rs.getString("name"));
//            door.setTel(rs.getString("tel"));
//            door.setAddr(rs.getString("addr"));
//        }
//        psmt.close();
//        conn.close();
//        return door;
//    }
//
//    //修改
//    public int updateDoor(Door door) throws SQLException {
//        Connection conn = DBUtils.getConnectionByDatasource();
//        String sql = "update tb_door set name=?,tel=?,addr=? where id=?";
//        PreparedStatement psmt = conn.prepareStatement(sql);
//        psmt.setString(1, door.getName());
//        psmt.setString(2, door.getTel());
//        psmt.setString(3, door.getAddr());
//        psmt.setInt(4, door.getId());
//        int result = psmt.executeUpdate();
//        conn.close();
//        return result;
//    }


}
