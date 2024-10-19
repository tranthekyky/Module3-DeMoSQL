package com.waggy.thimodule3;

import java.util.Date;

public class InfoRentals {
    private int id ;
    private String name ;
    private String phone ;
    private String date ;
    private String payment ;
    private String note ;

    public InfoRentals(int id, String name, String phone, String date, String payment, String note) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.date = date;
        this.payment = payment;
        this.note = note;
    }

    public InfoRentals(String name, String phone, String date, String payment, String note) {
        this.name = name;
        this.phone = phone;
        this.date = date;
        this.payment = payment;
        this.note = note;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "InfoRentals{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", date='" + date + '\'' +
                ", payment='" + payment + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
