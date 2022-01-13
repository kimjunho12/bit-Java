package prob04;

public class Depart extends Employee {
	private String dept;

	public Depart(String name, int salary, String dept) {
		super(name, salary);
		this.dept = dept;
	}

	@Override
	public void getInformation() {
		System.out.println("이름:" + super.getName() + "  연봉:" + super.getSalary() + "  부서:" + dept);
	}

}
