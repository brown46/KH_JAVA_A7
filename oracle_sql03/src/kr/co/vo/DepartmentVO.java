package kr.co.vo;


import java.util.Objects;

/**
 * VO 객체 Value Object로써 데이터 베이스 테이블의 Record값을 저장하기 위한 용도로 사용한다.(데이터 저장용 객체이다.)
 * 
 * @author user1
 *
 */
public class DepartmentVO {

	private int deptId;
	private String deptName;
	private int managerId;
	private int locationId;

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	@Override
	public String toString() {
		return "DepartmentVO [deptId=" + deptId + ", deptName=" + deptName + ", managerId=" + managerId
				+ ", locationId=" + locationId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(deptId, deptName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DepartmentVO other = (DepartmentVO) obj;
		return deptId == other.deptId && Objects.equals(deptName, other.deptName);
	}

	


}
