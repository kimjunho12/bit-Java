package com.ds.exam;

public class User extends Company{

    private int code, year;
    String name;
    Salary salary;
    
    public User() {
        super();
        code = year = 0;
        name = "null";
        salary = null;
    }

    public User(String id, String pw, String name, int year){
        super(id, pw);
        this.code = this.hashCode();
        this.name = name;
        this.year = year;
        this.salary = new Salary();
    }

    @Override
    public String toString() {
        return "User [code=" + code + ", name=" + name + ", salary=" + salary + ", year=" + year + "]";
    }

    @Override
    public void getInfo(User user) {
        // TODO Auto-generated method stub
        System.out.println(user.toString());        
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public void getMyInfo() {
        System.out.println(toString());
    }

    class Salary {
        private int amount;
        private int base;
        private int incentive;

        Salary() {
            base = 3800;
            incentive = 200;
            amount = calAmount(base, incentive, year);
        }

        Salary(int base, int incentive) {
            this.base = base;
            this.incentive = incentive;
            amount = calAmount(base, incentive, year);
        }

        public int getBase() {
            return base;
        }

        public void setBase(int base) {
            this.base = base;
        }

        public int getIncentive() {
            return incentive;
        }

        public void setIncentive(int incentive) {
            this.incentive = incentive;
        }

        int calAmount(int base, int incentive, int year) {
            return base + incentive * year;
        }

        void updateSalary(int base, int incentive) {
            this.amount = calAmount(base, incentive, year);
        }

        @Override
        public String toString() {
            return "Salary [amount=" + amount + "]";
        }

        // int calTax(int amount) {
        //     return -1;
        // }
    }

}
