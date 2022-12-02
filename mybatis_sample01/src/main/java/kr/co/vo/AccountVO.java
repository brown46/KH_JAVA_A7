package kr.co.vo;

import java.sql.Date;
import java.util.Objects;

public class AccountVO {
	private String aid;// VARCHAR2(10) PRIMARY KEY
	private String apw;// VARCHAR2(20)
	private String aemail;// VARCHAR2(40)
	private Date adate;// DATE
	private char astate;// VARCHAR2(2)
	// 회원요청테이블의 컬럼을 멤버변수로 선언

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getApw() {
		return apw;
	}

	public void setApw(String apw) {
		this.apw = apw;
	}

	public String getAemail() {
		return aemail;
	}

	public void setAemail(String aemail) {
		this.aemail = aemail;
	}

	public Date getAdate() {
		return adate;
	}

	public void setAdate(Date adate) {
		this.adate = adate;
	}

	public char getAstate() {
		return astate;
	}

	public void setAstate(char astate) {
		this.astate = astate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountVO other = (AccountVO) obj;
		return Objects.equals(aid, other.aid);
	}

	@Override
	public String toString() {
		return "AccountVO [aid=" + aid + ", apw=" + apw + ", aemail=" + aemail + ", adate=" + adate + ", astate=" + astate
				+ "]";
	}

}
