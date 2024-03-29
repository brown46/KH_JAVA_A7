package kh.memeber.model.vo;


/**
 * 
 * @author user1
 * TEST_MEMBER 테이블을 이용하여
 * 0. 첫화면("/")index.jsp include header.jsp - 로그인(login Get)/로그아웃(logout Get) 버튼 토글, nav 내 정보 보기(myinfo Get)버튼
 * 로그인 화면 - 로그인(login Post) / 회원가입(enroll Get)버튼
 * 1. 회원가입("/enroll") - Get: enroll.jsp, Post: 회원가입 DB다녀와서 /로 이동
 * 회원가입 하면 - 회원가입(enroll Post) 버튼
 * 2. 로그인 ("/login") - Get: login.jsp, Post: 로그인 DB다녀와서 session("lgnss")등록(이름, email, id) 후 /로 이동
 * 3. 로그아웃("/logout") - Get 세션 만료 후 - / 로 이동
 * 4. 내정보 보기("/myinfo")
 * 내 정보 보기 화면에서 하단에 수정(infoupdate Get), 탈퇴 버튼 
 * 5. 내 정보 수정하기("/infoupdate")
 * 내정보 보기 수정 화면에서 수정(infoupdate post)
 * 
 */
public class MemberVO {
//	이름     널?       유형           
//			------ -------- ------------ 
//			ID     NOT NULL VARCHAR2(15) 
//			PASSWD NOT NULL VARCHAR2(15) 
//			NAME   NOT NULL VARCHAR2(20) 
//			EMAIL           VARCHAR2(30) 

	private String id;
	private String passwd;
	private String name;
	private String email;
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", passwd=" + passwd + ", name=" + name + ", email=" + email + "]";
	}
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

