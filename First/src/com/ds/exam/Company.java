package com.ds.exam;

public abstract class Company {
    protected String id;
    protected String pw;

    public Company() {
        this.id = null;
        this.pw = null;
    }

    public Company(String id, String pw){
        this.id = id;
        this.pw = pw;
    }

    public abstract void getInfo(User user);
}
