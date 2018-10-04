package com.example.uzma.bookmylook;

//Provider er homepage e customer der booking er list er jonno created class
//use kora hoise fixit pg e jokhn place your booking button ta click kore
//tokhn eta firebase e oi cust er shob booking info parlour er under e save kore
//****************
public class Customers {
    public String cust_id,cust_mail,customername, appointment_date, appointment_time, booked_service;

    public Customers() {

    }



    public Customers(String s0, String s5, String s1, String s2, String s3, String s4) {

        cust_id=s0;
        cust_mail=s5;
        customername = s1;
        appointment_date = s2;

        appointment_time = s3;
        booked_service = s4;

    }

    public String getCust_mail() {
        return cust_mail;
    }

    public void setCust_mail(String cust_mail) {
        this.cust_mail = cust_mail;
    }

    public String getCust_id() {
        return cust_id;
    }

    public void setCust_id(String cust_id) {
        this.cust_id = cust_id;
    }


    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(String appointment_date) {
        this.appointment_date = appointment_date;
    }

    public String getAppointment_time() {
        return appointment_time;
    }

    public void setAppointment_time(String appointment_time) {
        this.appointment_time = appointment_time;
    }

    public String getBooked_service() {
        return booked_service;
    }

    public void setBooked_service(String booked_service) {
        this.booked_service = booked_service;
    }
}