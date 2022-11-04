package kr.co.exam05;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


public class Exam {

	public static void main(String[] args) {
		/*
		 * 학생들의 성적을 관리하기 위한 프로그램을 컬렉션을 활용하여 만들어 본다.
		 * 
		 * Student 클래스에는 학생의 정보를 담기 위한 클래스로 사용한다.
		 * 	  멤버 필드 : 이름, 학년, 반, 번호
		 *    멤버 메서드 : 반드시 hashCode(), equals() 구현할 것
		 *    			 Getter/Setter, toString() 구현할 것
		 * Subject 클래스에는 과목 정보를 담기 위한 클래스로 사용한다.
		 * 	  멤버 필드 : 과목명, 점수, 등급
		 *    멤버 메서드 : Getter/Setter, toString() 구현할 것
		 *    
		 * HashMap을 기본으로 Key 에는 Student 클래스를 사용하고 Value에는 
		 * ArrayList를 사용하도록 한다. 그리고 ArrayList에 Subject 클래스를 
		 * 담아 사용하도록 한다.
		 * 
		 * 성적 관리 프로그램으로 관리하는 모든 정보는 파일에 저장하여 다음번에 다시 
		 * 프로그램을 실행 했을 때 이전 상태가 저장되어 있어야 한다.
		 * 파일명은 "학생성적관리정보.info" 로 한다.
		 */
//		HashMap<Student, ArrayList<Subject>> aMap = new HashMap<Student, ArrayList<Subject>>();
//		
////		Student st1= new Student("홍길동",3,5,28);
////		Subject sb1 = new Subject("국어",88.8);
////		Subject sb4 = new Subject("영어",76.8);
////		
////		Student st2= new Student("김철수",2,6,8);
////		Subject sb2 = new Subject("국어",78.8);
////		Subject sb5 = new Subject("영어",88.8);
////		
////		Student st3= new Student("박원정",3,7,17);
////		Subject sb3 = new Subject("국어",98.8);
////		Subject sb6 = new Subject("영어",74.8);
//		
//		HashSet<Student> stSet =new HashSet<Student>();
//		stSet.add(new Student("홍길동",3,5,28));
//		stSet.add(new Student("김철수",2,6,8));
//		stSet.add(new Student("박원정",3,7,17));
//		
////		HashSet<Subject> sbSet= new HashSet<Subject>();
////		sbSet.add(new Subject("국어",88.8));
////		sbSet.add(new Subject("영어",74.8));
////		sbSet.add(new Subject("수학",99.9));
//		Scanner sc = new Scanner(System.in);
//		System.out.println("입력할 과목 갯수 입력");
//		int times= sc.nextInt();
//		sc.nextLine();
//		for(Student student: stSet) {
//			aMap.put(student, new ArrayList<Subject>());
//		}
//		for(Student student: stSet) {
//			HashSet<Subject> sbSet= new HashSet<Subject>();
//			System.out.println(student.getstname());
//			for(int i=0; i<times;i++) {
//				System.out.println("과목 입력");
//				String sb=sc.nextLine();
//				System.out.println("점수 입력");
//				double score =sc.nextDouble();
//				sc.nextLine();
//				sbSet.add(new Subject(sb,score));
//				
//			}
//		
//			sbSet.add(new Subject("국어",50+Math.random()*50));
//			sbSet.add(new Subject("영어",50+Math.random()*50));
//			sbSet.add(new Subject("수학",50+Math.random()*50));
//			for(Subject subject: sbSet) {
//				aMap.get(student).add(subject);
//			}
//		}
//		
//		
////		ArrayList<Subject> aList = new ArrayList<Subject>();
////		aList.add(sb1);
////		aList.add(sb4);
////		
////		aMap.put(st1, aList);
//		
//		File f =new File("D:\\학생성적관리정보.info");
//		
//		try(FileWriter fw = new FileWriter(f,true)){
//			for(Student student :stSet) {
//				fw.append(student.toString());
//				for(int i=0;i<3+times;i++) {
//					fw.append(aMap.get(student).get(i).toString()+",");
//				}
//				fw.append("\n");
//			}
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}
		
		Run r = new Run();
		//r.start(); //여기서 로드가 안되거나 다시 덮어씌우는듯함
		//r.load();//메인메서드에서 로드는 잘됨....
		r.start();
		//System.out.println(r.aMap.get(new Student("김자바",3,4,5)));
		
	}

}