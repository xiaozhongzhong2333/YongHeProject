package com.zb.dao;

import com.zb.pojo.Door;
import com.zb.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoorDao {
    //查询所有门店
    public List<Door> findAll() throws SQLException {
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "select * from tb_door ";
        PreparedStatement psmt = conn.prepareStatement(sql);
        ResultSet rs = psmt.executeQuery();
        List<Door> list = new ArrayList<Door>();
        System.out.println("Door查询结果");
        while (rs.next()) {
            Door door = new Door();
            door.setId(rs.getInt("id"));
            door.setName(rs.getString("name"));
            door.setTel(rs.getString("tel"));
            door.setAddr(rs.getString("addr"));
            door.setSale(rs.getInt("sale"));
            list.add(door);
        }
        psmt.close();
        conn.close();
        return list;
    }

    //增加门店
    public int addDoor(Door door) throws SQLException {
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "insert into tb_door(name,tel,addr) values (?,?,?)";
        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setString(1, door.getName());
        psmt.setString(2, door.getTel());
        psmt.setString(3, door.getAddr());
        int result = psmt.executeUpdate();
        conn.close();
        return result;
    }

    //删除
    public int delDoor(int id) throws SQLException {
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "delete from tb_door where id=?";
        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setInt(1, id);
        int result = psmt.executeUpdate();
        conn.close();
        return result;
    }

    //查询单个
    public Door findById(int id) throws SQLException {
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "select * from tb_door where id=?";
        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setInt(1,id);
        ResultSet rs = psmt.executeQuery();
        Door door = new Door();
        while (rs.next()) {
            door.setId(rs.getInt("id"));
            door.setName(rs.getString("name"));
            door.setTel(rs.getString("tel"));
            door.setAddr(rs.getString("addr"));
        }
        psmt.close();
        conn.close();
        return door;
    }

    //修改
    public int updateDoor(Door door) throws SQLException {
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "update tb_door set name=?,tel=?,addr=? where id=?";
        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setString(1, door.getName());
        psmt.setString(2, door.getTel());
        psmt.setString(3, door.getAddr());
        psmt.setInt(4, door.getId());
        int result = psmt.executeUpdate();
        conn.close();
        return result;
    }

    //查询销售额
    public List<Door> showSale() throws SQLException {
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "select name,sale from tb_door";
        PreparedStatement psmt = conn.prepareStatement(sql);
        ResultSet rs = psmt.executeQuery();
        List<Door> list = new ArrayList<Door>();
        while (rs.next()) {
            Door door = new Door();
            door.setName(rs.getString("name"));
            door.setSale(rs.getInt("sale"));
            list.add(door);
        }
        psmt.close();
        conn.close();
        return list;
    }
}
