package kr.co.exam03;

import java.util.Collection;
import java.util.HashMap;

public class Exam {

	public static void main(String[] args) {
		/*
		 * 과목 정보를 담기 위한 HashMap을 사용해 보세요 
		 * 과목명과 과목 점수가 HashMap에 저장될 수 있게 하세요.
		 * 
		 * 	과목명 : 국어, 영어, 수학, 사회, 과학, 체육, 미술
		 * 
		 * 실수형의 임의의 점수로 저장하여 HashMap에 저장된 과목의 총합과
		 * 평균을 구하여 출력하세요. 
		 */
		HashMap<String, Double> aMap = new HashMap<String, Double>();
		
		aMap.put("국어", 88.8);
		aMap.put("영어", 77.7);
		aMap.put("수학", 99.9);
		aMap.put("사회", 77.8);
		aMap.put("과학", 88.9);
		aMap.put("체육", 66.7);
		aMap.put("미술", 99.5);
		Collection<Double> values = aMap.values();
		double sum =0;
		Object[] arr =values.toArray();
		for(int i=0;i<arr.length;i++) {
			sum+=(double)arr[i];
		}
		System.out.printf("평균 : %.2f\n",sum/arr.length);
		System.out.println("총점 : "+sum);

		
		
//		double sum =0;
//		for(Double score : aMap.values()) {
//			sum+=score;
//		}
//		double avg= sum/aMap.size();
//		System.out.println("총점 : "+avg);
		
	}

}
