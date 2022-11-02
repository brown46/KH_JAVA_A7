package kr.co.demo04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

public class Demo {

	public static void main(String[] args) {
		/*
		 * 컬렉션에 컬렉션을 넣어서 사용하기
		 * 
		 */
		ArrayList<HashMap<String, Double>> datas = new ArrayList<HashMap<String, Double>>();
		Random rand = new Random();
		
		for (int i = 0; i < 5; i++) {
			HashMap<String, Double> hashData = new HashMap<String, Double>();
			hashData.put("국어", rand.nextInt(40)*1.0+60);
			hashData.put("영어", rand.nextInt(40)*1.0+60);
			hashData.put("수학", rand.nextInt(40)*1.0+60);
			hashData.put("사회", rand.nextInt(40)*1.0+60);
			hashData.put("과학", rand.nextInt(40)*1.0+60);
			hashData.put("체육", rand.nextInt(40)*1.0+60);
			hashData.put("미술", rand.nextInt(40)*1.0+60);
			datas.add(hashData);
		}

		
		/*
		 * ArrayList를 전체 탐색하면서 HashMap에 있는 모든 Key, Value에 접근하여
		 * 평균 및 총점을 구하고 해당하는 HashMap에 추가하기
		 * 
		 */
		StringBuilder sb = new StringBuilder();
		for(int i=0 ;i<datas.size();i++) {
			double sum =0;
			double avg =0;
			for(Entry<String, Double> e :datas.get(i).entrySet()) {
				sb.append(e.getKey()+" ");
				sb.append(e.getValue()+" ");
				sum+=e.getValue();
				avg= sum/datas.get(i).size() ;
				
				}
			datas.get(i).put("총점", sum);
			datas.get(i).put("평균", avg);
			sb.append("총점 : "+sum+" ");
			sb.append("평균 : "+avg);
			sb.append("\n");
		}
		System.out.println(datas);
	}

}
