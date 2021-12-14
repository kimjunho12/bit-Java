package com.ds.exam;

import java.util.List;
import java.util.Scanner;

/**
 * 관리자 ID와 PW 는 admin / admin 이다.
 */

public class SalaryApp {
    Admin admin = new Admin("admin", "admin");
    List<User> userList = admin.userList;

    public static void main(String[] args) {
        SalaryApp sa = new SalaryApp();
        System.out.println("=================================== 급여 관리 프로그램 ===================================");
        sa.choice();
    }

    private void choice() {
        Scanner sc = new Scanner(System.in);
        CHOICE: while (true) {
            System.out.println("로그인 할 계정을 선택하세요.");
            System.out.print("1. 사용자 \t2. 관리자 \t(0. 종료)\n>> ");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    User currentUser = userLogin();
                    if (currentUser != null)
                        startUser(currentUser);
                    else
                        System.out.println("사용자 정보가 없습니다.");
                    break;
                case 2:
                    adminLogin();
                    break;
                case 0:
                    break CHOICE;
                default:
                    break;
            }
            System.out.println();
        }
    }

    private User userLogin() {
        Scanner sc = new Scanner(System.in);

        System.out.print("아이디를 입력하세요 : "); String id = sc.next();
        System.out.print("패스워드를 입력하세요 : "); String pw = sc.next();
        
        User cur;

        for (int i = 0; i < userList.size(); ++i){
            cur = userList.get(i);
            if (cur.id.equals(id) && cur.pw.equals(pw))
                return cur;
        }
        return null;
    }

    private void startUser(User user) {
        System.out.println("=================================== 사용자 모드 ===================================");
        Scanner sc = new Scanner(System.in);

        USER: while (true) {
            System.out.println("메뉴를 선택하세요");
            System.out.print("1. 정보 조회 \t(0. 종료)\n>> ");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    user.getMyInfo();
                    break ;
                case 0:
                    break USER;
                default:
                    user.getMyInfo();
            }
            System.out.println();
        }
    }

    private void adminLogin() {
        Scanner sc = new Scanner(System.in);

        System.out.print("관리자 아이디를 입력하세요 : "); String id = sc.next();
        System.out.print("관리자 패스워드를 입력하세요 : "); String pw = sc.next();

        if (id.equals("admin") && pw.equals("admin")){
            startAdmin();
        } else {
            System.out.println("관리자 정보가 일치하지 않습니다.");
        }
    }

    private void startAdmin() {
        System.out.println("=================================== 관리자 모드 ===================================");
        Scanner sc = new Scanner(System.in);

        ADMIN: while (true) {
            System.out.println("메뉴를 선택하세요");
            System.out.print("1. 정보 조회 \t2. 직원 생성 \t3. 직원 수정 \t4. 직원 삭제 \t(0. 종료)\n>> ");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    getUserInfo();
                    break;
                case 2:
                    createUser();
                    break;
                case 3:
                    updateUser();
                    break;
                case 4:
                    deleteUser();
                    break;
                case 0:
                    break ADMIN;
                default:
                    showAllUsers();
                    break ;
            }
            System.out.println();
        }
    }

    private void getUserInfo() {
        Scanner sc =  new Scanner(System.in);
        System.out.print("검색할 이름을 입력 하세요.\n>> ");
        User user = findUser(sc.next());
        if (user == null) {
            System.out.println("사용자 정보가 없습니다");
            return ;
        }
        admin.getInfo(user);
    }

    private void createUser() {
        Scanner sc = new Scanner(System.in);
        System.out.print("아이디를 입력하세요 : ");
        String id = sc.next();
        System.out.print("패스워드를 입력하세요 : ");
        String pw = sc.next();
        System.out.print("이름을 입력하세요 : ");
        String name = sc.next();
        System.out.print("년차를 입력하세요 : ");
        int year = sc.nextInt();
        admin.creatUser(id, pw, name, year);
    }

    private void updateUser() {
        Scanner sc =  new Scanner(System.in);
        System.out.print("수정할 이름을 입력 하세요.\n>> ");
        User user = findUser(sc.next());
        if (user == null) {
            System.out.println("사용자 정보가 없습니다");
            return ;
        }

        System.out.print("년차를 입력하세요 : ");
        user.setYear(sc.nextInt());
        System.out.print("기본급을 입력하세요 : ");
        int base = sc.nextInt();
        user.salary.setBase(base);
        System.out.print("성과금을 입력하세요 : ");
        int incentive = sc.nextInt();
        user.salary.setIncentive(incentive);

        user.salary.updateSalary(base, incentive);
        System.out.printf("%s님의 정보가 변경 되었습니다.\n", user.name);
        System.out.println(user.toString());
    }

    private void deleteUser() {
        Scanner sc =  new Scanner(System.in);
        System.out.print("삭제할 이름을 입력 하세요.\n>> ");
        User user = findUser(sc.next());
        if (user == null) {
            System.out.println("사용자 정보가 없습니다");
            return ;
        }
        admin.deleteUser(user);
    }

    private User findUser(String name) {
        User cur;
        for (int i = 0; i < userList.size(); ++i){
            cur = userList.get(i);
            if (cur.name.equals(name))
                return cur;
        }
        return null;
    }

    private void showAllUsers() {
        admin.disp();
    }


}
