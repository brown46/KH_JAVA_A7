package kr.co.exam04;

import java.util.HashMap;
import java.util.Map.Entry;

public class Exam {

	public static void main(String[] args) {
		/*
		 * Map 컬렉션에 사용할 값을 사용자 정의 객체로 지정하여 사용해 본다.
		 * 
		 * Subject 클래스에 등급(A~F), 점수 멤버필드를 만들어서 사용한다.
		 * 
		 * Map 컬렌션에 사용할 키에는 과목명 문자열을 사용하도록 한다.
		 * 
		 * 		과목명 : 국어, 영어, 수학, 사회, 과학, 체육, 미술
		 * 
		 * 모든 과목의 이름과 등급이 출력될 수 있게 하세요.
		 * 추가로 총합과 평균을 구하여 출력하세요.
		 * 
		 */

		
		HashMap<String, Subject> aMap = new HashMap<String, Subject>();
		aMap.put("국어", new Subject('B',88.8));
		aMap.put("영어", new Subject('C',77.7));
		aMap.put("수학", new Subject('D',66.6));
		aMap.put("사회", new Subject('A',99.9));
		aMap.put("과학", new Subject('B',88.7));
		aMap.put("체육", new Subject('C',77.6));
		aMap.put("미술", new Subject('D',66.5));
		double sum =0;
		double avg =0;
		StringBuilder sb = new StringBuilder();
		for(Entry<String, Subject> e:aMap.entrySet()) {
			sb.append(e.getKey()+":");
			sb.append(e.getValue().getGrade()+"\t");
			sum+=e.getValue().getScore();
		}
		avg =sum/aMap.size();
		sb.append("\n총합: "+sum+"\n");
		sb.append("평균: "+avg+"\n");
		System.out.println(sb.toString());

//		ArrayList<String> name = new ArrayList<String>(aMap.keySet());
//		
//		for(int i=0 ; i<7;i++) {
//			System.out.print(name.get(i)+" ");
//			System.out.print((aMap.get(name.get(i))).getGrade()+"\t");
//		}
//		double sum =0;
//		for(Subject s : aMap.values()) {
//			sum+=s.getScore();	
//		}
//		double avg = sum/aMap.size();
//	
//		System.out.printf("총점 : %.2f\n",sum);
//		System.out.printf("평균 : %.2f",avg);
//		
		
	}

}
