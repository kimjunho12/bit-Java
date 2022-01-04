package vo;

public class MemberVO {
	private String name;
	private String phone;
	private String id;
	private String pw;
	
	public MemberVO() {
		name = phone = id = pw = "";
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "MemberVO [name=" + name + ", phone=" + phone + ", id=" + id + ", pw=" + pw + "]";
	}
	
}
