package com.zb.pojo;

public class Door {
    private int id;
    private String name;
    private String tel;
    private String addr;
    private int sale;

    public Door() {
    }
    public Door(String name, int sale) {
        this.name = name;
        this.sale=sale;
    }
    public Door(String name, String tel, String addr) {
        this.name = name;
        this.tel = tel;
        this.addr = addr;
    }

    public Door(int id, String name, String tel, String addr) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.addr = addr;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public Door(int id, String name, String tel, String addr, int sale) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.addr = addr;
        this.sale = sale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Door{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
