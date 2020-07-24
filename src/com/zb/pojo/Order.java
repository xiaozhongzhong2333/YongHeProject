package com.zb.pojo;

import java.sql.Timestamp;
import java.util.Date;

public class Order {
    private int id;
    private int door_id;
    private String order_no;
    private String order_type;
    private int pnum;
    private String cashier;
    private Date order_time;
    private Date pay_time;
    private String pay_type;
    private double price;

    public Order() {

    }
    public Order(int door_id, String order_no, String order_type, int pnum, String cashier,  String pay_type, double price) {
        this.door_id = door_id;
        this.order_no = order_no;
        this.order_type = order_type;
        this.pnum = pnum;
        this.cashier = cashier;
        this.pay_type = pay_type;
        this.price = price;
    }
    public Order(int door_id, String order_no, String order_type, int pnum, String cashier, Date order_time, Date pay_time, String pay_type, double price) {
        this.door_id = door_id;
        this.order_no = order_no;
        this.order_type = order_type;
        this.pnum = pnum;
        this.cashier = cashier;
        this.order_time = order_time;
        this.pay_time = pay_time;
        this.pay_type = pay_type;
        this.price = price;
    }

    public Order(int id, int door_id, String order_no, String order_type, int pnum, String cashier, Date order_time, Date pay_time, String pay_type, double price) {
        this.id = id;
        this.door_id = door_id;
        this.order_no = order_no;
        this.order_type = order_type;
        this.pnum = pnum;
        this.cashier = cashier;
        this.order_time = order_time;
        this.pay_time = pay_time;
        this.pay_type = pay_type;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDoor_id() {
        return door_id;
    }

    public void setDoor_id(int door_id) {
        this.door_id = door_id;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public int getPnum() {
        return pnum;
    }

    public void setPnum(int pnum) {
        this.pnum = pnum;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }

    public Date getPay_time() {
        return pay_time;
    }

    public void setPay_time(Date pay_time) {
        this.pay_time = pay_time;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", door_id=" + door_id +
                ", order_no='" + order_no + '\'' +
                ", order_type='" + order_type + '\'' +
                ", pnum=" + pnum +
                ", cashier='" + cashier + '\'' +
                ", order_time=" + order_time +
                ", pay_time=" + pay_time +
                ", pay_type='" + pay_type + '\'' +
                ", price=" + price +
                '}';
    }
}
