package kr.co.demo01;

import java.util.stream.Stream;

public class Demo {
	
	
	public static void main(String[] args) {
		/*
		 * String 관련 클래스 - String : 문자열 클래스로 문자열 데이터를 다루기 위해 사용한다. 수정 불가능(불변타입)한 타입으로
		 * 데이터 수정 시 원본 데이터를 복사하여 새로운 데이터를 만드는 형태로 동작한다.
		 * 
		 * - StringBuilder : 문자열 클래스로 String의 불변타입을 변경가능으로 사용할 수 있게 만들어진 클래스이다. Thread
		 * safe 기능을 제공하지 않는다.
		 * 
		 * - StringBuffer : StringBuilder와 동일한 기능의 클래스로 유일한 차이는 Thread safe 기능을 제공하는
		 * 것이다. Thread safe 기능은 다중 쓰레드 작업에 활용될 때 공유 자원에 대한 안정성을 높여 주기 위한 기능이다.
		 */
		String str1 = "문자열 리터럴을 사용하여 생성";
		String str2 = new String("new 연산자로 문자열 생성");

		char ch[] = new char[] { '문', '자', '배', '열' };
		String str3 = new String(ch);

		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println();

		// 특정 위치에 있는 문자를 반환하는 메서드
		for (int i = 0; i < str1.length(); i++) {
			char c1 = str1.charAt(i);
			System.out.printf("str1.charAt(%d) -> %c\n", i,c1);
		}
		int count =0;
		for (int i = 0; i < str1.length(); i++) {
			if(str1.charAt(i)==' ') {
				count++;
			}
		}
		System.out.printf("이 문자열에는 공백이 %d 개 있습니다.\n",count);
		System.out.println();
		
		//문자 코드값을 반환하는 메서드
		int point = str1.codePointAt(0);
		System.out.printf("%d -> %c\n",point,(char)point); 
		
		str1 = new String("가");
		str2 = new String("나");
		int compare = str1.compareTo(str2);
		System.out.println(compare);
		int compare2 = str2.compareTo(str1);
		System.out.println(compare2); //만약 값이 0이면 같은 문자열이라는 뜻
		
		System.out.println(str1.codePointAt(0)+"/"+str2.codePointAt(0));
		
		str1 = new String("가");
		str2 = new String("나");
		//문자열을 결합하여 반환하는 메서드
		str3 =str1.concat(str2); 
		System.out.println(str3);
		System.out.println();
		
		//contains() : 문자열 안에 매개변수로 전달한 문자열이 포함되어 있는지에 대한 유무를
        //			   반환하는 메서드
		str1 = new String("contains 메서드 에제");
		boolean res1 = str1.contains("메서드");
		boolean res2 = str1.contains("안녕하세요");
		
		System.out.println(res1+"/"+res2);
		System.out.println();
		
		//contentEquals() : 동일한 문자열 내용을 가지고 있는지 유무를 반환하는 메서드
		//					Thread safe 기능이 사용되고있어서 성능저하가 발생할 수 있다.
		str1 = new String("contentEquals 메서드 예제");
		res1 =str1.contentEquals("contentEquals 메서드 예제");
		res2 =str1.contentEquals("contentEquals Method 예제");
		System.out.println(res1+"/"+res2);
		System.out.println();
		
		// endsWith(), startsWith() : 문자열에서 특정 문자열로 끝(ends)나거나 시작(starts)
		// 하는지 유무를 반환하는 메서드
		str1 =new String("endsWith, startsWith() 메서드 예제");
		res1= str1.endsWith("예제");
		res2 =str1.startsWith("endsWith");
		
		System.out.println(res1+"/"+res2);
		System.out.println();

		// equalsIgnoreCase() : 대소문자 구분을 무시하고 동일한 문자열인지 반환하는 메서드
		str1 = new String("Hello");
		res1 = str1.equalsIgnoreCase("HELLO");
		res2 = str1.equalsIgnoreCase("hello");
		System.out.println(res1+"/"+res2);
		System.out.println();
		
		// indexOf : 매개변수로 전달한 문자열의 위치를 찾아 해당 index 값을 반환하는 메서드
		str1= new String("indexOf 메서드 사용 예제로 이 메서드는 메서드 오버로딩이 되어 있습니다.");
		int index =str1.indexOf("메서드");
		System.out.println(index);
		index =str1.indexOf("메서드",9);
		System.out.println(index);
		index =str1.indexOf("메서드",22);
		System.out.println(index);
		index =str1.indexOf("메서드",27);
		System.out.println(index); //찾을 수 없다면 -1을 반환한다.
		
		
		//문자열에서 특정 문자열이 몇개 존재하는지 찾으시오.
		
		System.out.println(count(str1,"메서드"));
		System.out.println();	
		
		// isBlank(), isEmpty() : 빈 문자열인지 유무를 반환하는 메서드
		// isBlank()는 공백도 빈 문자열로 판단하지만 isEmpty()는 공백은 
		// 빈 문자열로 판단하지 않는다.
		str1=new String("");
		res1=str1.isBlank();
		res2=str1.isEmpty();
		System.out.println(res1+"/"+res2);
		
		str1=new String(" ");
		res1=str1.isBlank();
		res2=str1.isEmpty(); //공백도 빈 문자열이 아니라고 판단
		System.out.println(res1+"/"+res2);
	
		str1=new String("\n");
		res1=str1.isBlank();
		res2=str1.isEmpty(); //개행문자도 빈 문자열이 아니라고 판단
		System.out.println(res1+"/"+res2);
		System.out.println();
		
		//lines() : 문자열에서 개행을 기준으로 문자열을 분리하여 반환하는 메서드. 시스템에 따라서 알아서 구분해준다.
		str1= new String("11 버전에서\n새로 생긴\nlines()\n메서드");
		Stream<String> stream =str1.lines();
		Object[] objArr = stream.toArray();
		for(int i =0; i<objArr.length;i++) {
			String s = (String)objArr[i];
			System.out.println(i+1+"번 줄\t"+s);
		}
		System.out.println();
		
		//split() : 문자열을 특정 문자를 기준으로 분리하여 문자열 배열을 반환하는 메서드
		str1= new String("11 버전에서\n새로 생긴\nlines()\n메서드");
		String strArr[] =str1.split("\\n");
		for(int i=0; i<strArr.length;i++) {
			System.out.println(i+1+"번 줄\t"+strArr[i]);
		}
		System.out.println();
		
		//repeat()
		str1 = new String("Hello");
		str2 = str1.repeat(2);
		System.out.println(str2);
		System.out.println();
		
		//replace()
		str1 =new String("문자열을 변경하기 위해 사용하는 문자열 메서드");
		str2 = str1.replace("문자열","string");
		System.out.println(str2);
		System.out.println();
		
		//strip(); 
		str1 =new String("    문자열 앞 뒤로 공백이 있으면 제거   ");
		str2 =str1.strip();
		System.out.println("|"+str2+"|");
		str2 =str1.stripLeading();
		System.out.println("|"+str2+"|");
		str2 =str1.stripTrailing();
		System.out.println("|"+str2+"|");
		//trim과의 차이 - 제거하는 공백 종류가 strip이 더 많다.
		System.out.println();
		
		// subString()
		str1= new String("문자열 일부만 잘라내기");
		str2= str1.substring(0,3);
		System.out.println(str2);
		str2= str1.substring(4,7);
		System.out.println(str2);
		str2= str1.substring(4);
		System.out.println(str2);
		System.out.println();
		
		//
		str1= new String("HeLLo");
		str2= str1.toLowerCase();
		System.out.println(str2);
		str2=str1.toUpperCase();
		System.out.println(str2);
		System.out.println();
		
		//String.format("포멧문자열",값...)
		str1= String.format("%s / %d / %f","문자열포멧",30,3.0);
		//이런 정적메서드,클래스메서드는 인스턴스 생성을 하지 않고 사용할 수 있다.
		System.out.println(str1);
		
		//String.join("구문문자", 문자열배열)
		//String.join("구문문자", 문자열1, 문자열2,.....)
		str1= String.join(",", new String[] {"A","B","C","D"});
		System.out.println(str1);
		str1=String.join("_", "A","B","C","D");
		System.out.println(str1);
		System.out.println();
		
		//String.valueOf(다양한 데이터값)
		str1=String.valueOf(true);
		System.out.println(str1);
		str1 =String.valueOf(10);
		System.out.println(str1);
		str1=""+10;//간단하지만 속도가 느림
		System.out.println(str1);
		
		
		
	}
	public static int count(String s1, String s2) {
		int count =0;
		int i=0;
		while(true) {
			int index =s1.indexOf(s2,i);
			if(index==-1) {
				return count;
			}
			count++;		
			i=index+1;
		}
		
	}
	
}
