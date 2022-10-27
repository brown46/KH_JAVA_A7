package kr.co.exam02;

public class Phone {
	private Phone(String phone) {
		this.check(phone);
		this.phone=phone;
	}
	boolean isValid =false;
	String phone;
	
	public void check(String phone) {
		String arr[]= phone.split("-");
		if(phone.startsWith("010")==false) {
			System.out.println("010으로 시작해야 합니다.");
			return;
		}
		if(arr.length!=3) {
			System.out.println("하이픈으로 구분해주세요");
			return;
		}
		
		if(phone.length()!=13) {
			System.out.println("하이픈을 포함한13자리 번호를 입력해야 합니다.");
			return;
		}
		for(int i=1; i<arr.length;i++) {
			for(int j=0;j<arr[i].length();j++) {
				if(arr[i].length()!=4) {
					System.out.println("하이픈을 잘못 입력하셨습니다.");
					return ;
				}
			}
		}

		for(int i=1; i<arr.length;i++) {
			for(int j=0;j<arr[i].length();j++) {
				if(arr[i].charAt(j)>'9'||arr[i].charAt(j)<'0') {
					System.out.println("숫자를 입력해주세요");
					return ;
				}
			}
		}
		
		isValid =true;
	}
	public String getNumber() {
		if(isValid) {
			return phone;
		}else return "오류";
	}
	public String getNumber(boolean hidden) {
		String arr[]= phone.split("-");
		if(isValid) {
			String arr1=String.join("-", arr[0],arr[1],"****");
			return arr1;
		}else return "오류";
	}
	
	public static Phone valueOf(String phone) {
		return new Phone(phone);
	}
}
