package kr.co.demo05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class Demo {

	public static void main(String[] args) {
		/*
		 * HashMap에 ArrayList를 담아서 사용하기
		 * 
		 * ArrayList에는 Subject클래스가 담기게 한다. 과목명 : 국어, 영어, 수학, 사회, 과학, 체육, 미술
		 */
		Random rand = new Random();
		HashMap<String, ArrayList<Subject>> datas = new HashMap<String, ArrayList<Subject>>();
//		ArrayList<Subject> subList1 = new ArrayList<Subject>();
//		subList1.add(new Subject("국어",rand.nextInt(40)*1.0+60));
//		subList1.add(new Subject("영어",rand.nextInt(40)*1.0+60));
//		subList1.add(new Subject("수학",rand.nextInt(40)*1.0+60));
//		subList1.add(new Subject("사회",rand.nextInt(40)*1.0+60));
//		subList1.add(new Subject("과학",rand.nextInt(40)*1.0+60));
//		subList1.add(new Subject("체육",rand.nextInt(40)*1.0+60));
//		subList1.add(new Subject("미술",rand.nextInt(40)*1.0+60));
//		datas.put("홍길동", subList1);
//		ArrayList<Subject> subList2 = new ArrayList<Subject>();
//		subList2.add(new Subject("국어",rand.nextInt(40)*1.0+60));
//		subList2.add(new Subject("영어",rand.nextInt(40)*1.0+60));
//		subList2.add(new Subject("수학",rand.nextInt(40)*1.0+60));
//		subList2.add(new Subject("사회",rand.nextInt(40)*1.0+60));
//		subList2.add(new Subject("과학",rand.nextInt(40)*1.0+60));
//		subList2.add(new Subject("체육",rand.nextInt(40)*1.0+60));
//		subList2.add(new Subject("미술",rand.nextInt(40)*1.0+60));
//		datas.put("김철수", subList2);
//		ArrayList<Subject> subList3 = new ArrayList<Subject>();
//		subList3.add(new Subject("국어",rand.nextInt(40)*1.0+60));
//		subList3.add(new Subject("영어",rand.nextInt(40)*1.0+60));
//		subList3.add(new Subject("수학",rand.nextInt(40)*1.0+60));
//		subList3.add(new Subject("사회",rand.nextInt(40)*1.0+60));
//		subList3.add(new Subject("과학",rand.nextInt(40)*1.0+60));
//		subList3.add(new Subject("체육",rand.nextInt(40)*1.0+60));
//		subList3.add(new Subject("미술",rand.nextInt(40)*1.0+60));
//		datas.put("박원정", subList3);

		Set<String> names = new HashSet<String>();
		names.add("홍길동");
		names.add("김철수");
		names.add("박원정");

		Set<String> subjects = new HashSet<String>();
		subjects.add("국어");
		subjects.add("영어");
		subjects.add("수학");
		subjects.add("사회");
		subjects.add("과학");
		subjects.add("체육");
		subjects.add("미술");

		for (String name : names) {
			datas.put(name, new ArrayList<Subject>());
			List<Subject> data = datas.get(name);
			for (String subject : subjects) {
				double score = rand.nextInt(40) * rand.nextDouble() + 60;
				data.add(new Subject(subject, score));
			}
		}
		System.out.println("홍길동=" + datas.get("홍길동"));
		System.out.println("김철수=" + datas.get("김철수"));
		System.out.println("박원정=" + datas.get("박원정"));

		ArrayList<Subject> avgData = new ArrayList<Subject>();
		for (Entry<String, ArrayList<Subject>> e : datas.entrySet()) {
			double sum = 0;
			double avg = 0;
			for (Subject s : e.getValue()) {
				sum += s.getScore();
			}
			avg = sum / e.getValue().size();
			avgData.add(new Subject(e.getKey(), avg));
		}
		Collections.sort(avgData);
		Collections.reverse(avgData);
		System.out.println(avgData);

		/*
		 * { "홍길동" : [Subject, Subject, Subject,...], "김철수" : [Subject, Subject,
		 * Subject,...], "박원정" : [Subject, Subject, Subject,...], }
		 * 
		 * 평균 점수가 가장 높은 학생을 구하시오.
		 */
//		double sum[] =new double[3];
//		double avg[] =new double[3];
//		for(int i=0; i<subList1.size();i++) {
//			sum[0]+=datas.get("홍길동").get(i).getScore();
//		}
//		avg[0]= sum[0]/subList1.size();
//		System.out.println(sum[0]);
//		System.out.println(avg[0]);
//		
//		for(int i=0; i<subList1.size();i++) {
//			sum[1]+=datas.get("김철수").get(i).getScore();
//		}
//		avg[1]= sum[1]/subList1.size();
//		System.out.println(sum[1]);
//		System.out.println(avg[1]);
//		
//		for(int i=0; i<subList1.size();i++) {
//			sum[2]+=datas.get("박원정").get(i).getScore();
//		}
//		avg[2]= sum[2]/subList1.size();
//		System.out.println(sum[2]);
//		System.out.println(avg[2]);
//		
//		
//		
//		
//		
//		
//		if(avg[0]> avg[1]) {
//			if(avg[0]>avg[2]) {
//				System.out.println(avg[0]);
//			}else
//				System.out.println(avg[2]);
//		}else if(avg[1]>avg[0]) {
//			if(avg[1]>avg[2]) {
//				System.out.println(avg[1]);
//			}else
//				System.out.println(avg[2]);
//		}

	}

}
