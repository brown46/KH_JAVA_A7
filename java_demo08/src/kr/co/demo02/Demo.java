package kr.co.demo02;

public class Demo {

	public static void main(String[] args) {
		/*
		 * StringBuilder /StringBuffer
		 */

		StringBuilder sb =new StringBuilder(128); //버퍼는 기본값으로 16의 공간을 갖는다.
		sb.append("문자열");//버퍼에 추가
		sb.append("추가");//배열 크기가 할당된 값을 넘게된다면 다시 할당받아야한다.
		System.out.println(sb.toString());
		
		String str="문자열";
		str+="추가"; //새로운 객체가 만들어진다.
		System.out.println(str);
		System.out.println();
		
		//capacity(): 버퍼 크기 반환
		int capacity =sb.capacity();
		System.out.println(capacity);
		System.out.println();
		
		//delete(): 문자열 삭제
		sb.delete(2, 3);
		System.out.println(sb.toString());
		System.out.println();
		
		//insert(): 지정한 위치에 문자열추가
		sb.insert(0, "문자열");
		System.out.println(sb.toString());
		sb.insert(03, " insert() ");
		System.out.println(sb.toString());
		System.out.println();
		
		//length() : 문자열 길이
		int length= sb.length(); //문자열 길이와 버퍼크기는 다르다
		System.out.println(length);
		System.out.println();
		
		//reverse(): 문자열을 역순으로 나열
		sb.reverse();
		System.out.println(sb.toString());
		System.out.println();
		
		//setLength(): 문자열의 크기조정
		sb.setLength(20);
		sb.reverse();
		System.out.println(sb.toString());
		System.out.println();
		
		// trimToSize() : 버퍼 크기를 문자열 크기로 변경
		sb.trimToSize();
		System.out.println(sb.capacity());
		
		//sb.indexOf(), sb.replace(), sb.charAt(), sb.compareTo()
		//위 메서드는 기존 String 클래스에서 사용한 메서드와 동일한 기능을 수행
		
		
	}

}
