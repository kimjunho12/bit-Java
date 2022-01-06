package model.vo;

public class UserVO {
	private int uid;
	private String name;
	private String email;
	private String pw;
	private String phone;
	private String register_date;
	private String last_date;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int id) {
		this.uid = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRegister_date() {
		return register_date;
	}
	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}
	public String getLast_date() {
		return last_date;
	}
	public void setLast_date(String last_date) {
		this.last_date = last_date;
	}
	@Override
	public String toString() {
		return "UserVO [id=" + uid + ", name=" + name + ", email=" + email + ", pw=" + pw + ", phone=" + phone
				+ ", register_date=" + register_date + ", last_date=" + last_date + "]";
	}	
}
