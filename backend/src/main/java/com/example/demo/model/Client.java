package com.example.demo.model;


import java.util.Date;

public class Client {

    private int cid;
    private String image;
    private String cname;
    private String password;
    private String phoneNumber;
    private String email;
    private Date createTime;
    private int ckind;
    private int test;

    // Constructors
    public Client() {
    }

    public Client(int cid, String image, String cname, String password, String phoneNumber, String email, Date createTime, int ckind, int test) {
        this.cid = cid;
        this.image = image;
        this.cname = cname;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.createTime = createTime;
        this.ckind = ckind;
        this.test = test;
    }

    // Getters and Setters
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getCkind() {
        return ckind;
    }

    public void setCkind(int ckind) {
        this.ckind = ckind;
    }

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "Client{" +
                "cid=" + cid +
                ", image='" + image + '\'' +
                ", cname='" + cname + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                ", ckind=" + ckind +
                ", test=" + test +
                '}';
    }
}
