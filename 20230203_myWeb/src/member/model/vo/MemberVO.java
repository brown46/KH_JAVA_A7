package member.model.vo;

public class MemberVO {
//desc test_member
//	ID NOT NULL VARCHAR2(15)
//	PASSWD NOT NULL VARCHAR2(15)
//  NAME NOT NULL VARCHAR2(20)
//	EMAIL VARCHAR2(30)
	private String id;
	private String passwd;
	private String name;
	private String email;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
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
	
	
	
}
