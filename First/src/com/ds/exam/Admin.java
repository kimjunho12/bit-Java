package com.ds.exam;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Admin extends Company {
    List<User> userList = new LinkedList<>();

    public Admin(){
        super();
        userList = null;
    }

    public Admin(String id, String pw) {
        super(id, pw);
    }

    @Override
    public void getInfo(User user) {
        // TODO Auto-generated method stub
        System.out.println(user.toString());
    }
    
    public void creatUser(String id, String pw, String name, int year) {        
        User user = new User(id, pw, name, year);
        userList.add(user);
    }

    public void deleteUser(User user) {
        userList.remove(user);
    }

    public void setInfo(){}

    public void disp() {
        Iterator<User> it = userList.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

    
}
