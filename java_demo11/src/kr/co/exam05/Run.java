package kr.co.exam05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;

public class Run {
	HashMap<Student, ArrayList<Subject>> aMap = new HashMap<Student, ArrayList<Subject>>();
	HashSet<Student> stSet =new HashSet<Student>();
	public void printMenu() {
		String menu = "<< 학생 성적 관리 프로그램>>\n"
		+"[1] 전체 학생 목록\n"
		+"[2] 성적 검색\n"
		+"[3] 성적 수정\n"
		+"[4] 프로그램 종료\n";
		System.out.println(menu);
	}
	
	public void load() {
		File f = new File("D:\\학생성적관리정보.info");
		
		try(BufferedReader br = new BufferedReader(new FileReader(f))){
			while(br.ready()) {
				this.parse(br.readLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void parse(String rowData) {
		// 홍길동,1,2,25:영어=78.5,수학=84.7,국어=96.5
		
		String sArr[] = rowData.split(":");
		String studentData[] =sArr[0].split(",");
		String subjectData[] =sArr[1].split(",");
		Student student = new Student(studentData[0],
				Integer.valueOf(studentData[1]),
				Integer.valueOf(studentData[2]),
				Integer.valueOf(studentData[3]));
		
		ArrayList<Subject> subjectList = new ArrayList<Subject>();
		
		for(int i=0; i<subjectData.length;i++) {
			String temp[]= subjectData[i].split("=");
			Subject subject = new Subject(temp[0],Double.valueOf(temp[1]));
			subjectList.add(subject);
		}
		
		this.aMap.put(student, subjectList);
		
	}
	public void save(int times) {
		StringBuilder sb = new StringBuilder();
		for(Student student :stSet) {
			sb.append(student.toString());
			for(int i=0;i<stSet.size()+times;i++) {
				sb.append(aMap.get(student).get(i).toString()+",");
			}
			sb.replace(sb.length()-1, sb.length(),"\r\n");
		}
		File f =new File("D:\\학생성적관리정보.info");
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(f,true))){
			bw.write(sb.toString());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	public void start() {
		//load();
	
//		stSet.add(new Student("홍길동",3,5,28));
//		stSet.add(new Student("김철수",2,6,8));
//		stSet.add(new Student("박원정",3,7,17));
		Scanner sc = new Scanner(System.in);
		System.out.println("입력할 과목 갯수 입력");
		int times= sc.nextInt();
		sc.nextLine();
//		for(Student student: stSet) {
//			aMap.put(student, new ArrayList<Subject>());
//		}
		for(Student student: stSet) {
			HashSet<Subject> sbSet= new HashSet<Subject>();
			System.out.println(student.getstname());
			for(int i=0; i<times;i++) {
				System.out.println("과목 입력");
				String sb=sc.nextLine();
				System.out.println("점수 입력");
				double score =sc.nextDouble();
				sc.nextLine();
				sbSet.add(new Subject(sb,score));
				
			}
			for(Subject subject: sbSet) {
				aMap.get(student).add(subject);
			}
		}
		save(times);
		

		System.out.println(aMap);
		for(Entry<Student, ArrayList<Subject>> e: aMap.entrySet()) {
			System.out.println(e.getKey().getstname());
		}
	}

	
}
