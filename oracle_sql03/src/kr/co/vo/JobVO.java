package kr.co.vo;



/**
 * VO 객체 Value Object로써 데이터 베이스 테이블의 Record값을 저장하기 위한 용도로 사용한다.(데이터 저장용 객체이다.)
 * 
 * @author user1
 *
 */
public class JobVO {

	
	
	private String jobId;
	private String jobTitle;
	private int minSalary;
	private int maxSalary;
	
	public int getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(int minSalary) {
		this.minSalary = minSalary;
	}

	public int getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(int maxSalary) {
		this.maxSalary = maxSalary;
	}


	
	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	@Override
	public String toString() {
		return "JobVO [jobId=" + jobId + ", jobTitle=" + jobTitle + ", minSalary=" + minSalary + ", maxSalary="
				+ maxSalary + "]";
	}














}
