package kr.co.exam05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Run {
	HashMap<Student, ArrayList<Subject>> aMap = new HashMap<Student, ArrayList<Subject>>();
	HashSet<Student> stSet = new HashSet<Student>();
	Scanner sc = new Scanner(System.in);

	public void printMenu() {
		String menu = "<< 학생 성적 관리 프로그램>>\n" + "[1] 전체 학생 목록\n" + "[2] 성적 검색\n" + "[3] 성적 수정\n" + "[4] 성적 추가\n"
				+ "[5] 학생 추가\n"
				+ "[6] 학생 정보 삭제\n"
				+ "[0] 프로그램 종료\n";
		System.out.println(menu);
	}

	public void load() {
		File f = new File("D:\\학생성적관리정보.info");

		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			while (br.ready()) {
				this.parse(br.readLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void parse(String rowData) {
		// 홍길동,1,2,25:영어=78.5,수학=84.7,국어=96.5

		String sArr[] = rowData.split(":");
		String studentData[] = sArr[0].split(",");
		String subjectData[] = sArr[1].split(",");
		Student student = new Student(studentData[0], Integer.valueOf(studentData[1]), Integer.valueOf(studentData[2]),
				Integer.valueOf(studentData[3]));

		ArrayList<Subject> subjectList = new ArrayList<Subject>();

		for (int i = 0; i < subjectData.length; i++) {
			String temp[] = subjectData[i].split("=");
			Subject subject = new Subject(temp[0], Double.valueOf(temp[1]));
			subjectList.add(subject);
		}
		stSet.add(student);
		this.aMap.put(student, subjectList);

	}

	public void save() {
		StringBuilder sb = new StringBuilder();
		for (Student student : stSet) {
			sb.append(student.toString());
			for (int i = 0; i < aMap.get(student).size(); i++) {
				sb.append(aMap.get(student).get(i).toString() + ",");
			}
			sb.replace(sb.length() - 1, sb.length(), "\r\n");
		}
		File f = new File("D:\\학생성적관리정보.info");
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
			bw.write(sb.toString());
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void start() {
		printMenu();
	
		int input = sc.nextInt();
		sc.nextLine();
		switch (input) {
		case 1:
			allStudent();
			break;
		case 2:
			System.out.println("학생이름 입력");
			String stName = sc.nextLine();
			findScore(stName);
			break;
		case 3:
			System.out.println("학생 이름 입력");
			String student = sc.nextLine();
			System.out.println("과목 이름 입력");
			String subject = sc.nextLine();
			System.out.println("수정할 점수 입력");
			double score = sc.nextDouble();
			sc.nextLine();
			modScore(student, subject, score);
			break;
		case 4:
			addScore();
			break;
		case 5:
			addStudent();
			break;
		case 6: 
			removeStudent();
			break;
		case 0:
			System.exit(0);
		}
//		sc.close(); java.util.NoSuchElementException에러남

	}

	public void allStudent() {
		load();
		for (Student student : stSet) {
			Collections.sort(aMap.get(student));
		}
		for (Student student : stSet) {
			System.out.print(student.getstname() + ":");
			System.out.println(aMap.get(student).toString());
		}

	}

	public void addScore() {
		load();
		Scanner sc = new Scanner(System.in);
		System.out.println("입력할 과목 갯수 입력(공백 입력시 메인화면으로 갑니다.)");

		int times = sc.nextInt();
		sc.nextLine();
		if (times <= 0)
			return;
		for (Student student : stSet) {
			HashSet<Subject> sbSet = new HashSet<Subject>();

			System.out.println(student.getstname());
			boolean isExistSubject = false;
			for (int i = 0; i < times; i++) {
				System.out.println("과목 입력. 공백입력시 저장되지 않습니다.");
				String sb = sc.nextLine();
				if (sb.equals("")) {
					continue;
				}
				for (Subject s : aMap.get(student)) {
					if ((s.getSbname()).equals(sb)) {
						isExistSubject = true;
					}
				}
				if (isExistSubject == true) {
					System.out.println("중복된 과목을 입력하셨습니다.");
					continue;
				}
				System.out.println("점수 입력");
				double score = sc.nextDouble();
				sc.nextLine();
				if (score == 0)
					continue;
				sbSet.add(new Subject(sb, score));

			}
			for (Subject subject : sbSet) {

				aMap.get(student).add(subject);
			}
		}
		save();
	}

	public void findScore(String stName) {
		load();
		for (Student s : stSet) {
			if (s.getstname().equals(stName)) {
				System.out.println(aMap.get(s).toString());
			}
		}
	}

	public void modScore(String stName, String sbName, double score) {
		load();
		boolean isExistSt = false;
		boolean isExistSb = false;

		for (Student s : stSet) {

			if (s.getstname().equals(stName)) {
				isExistSt = true;
				for (Subject sb : aMap.get(s)) {
					if (sb.getSbname().equals(sbName)) {
						isExistSb = true;
						sb.setScore(score);
						System.out.println("수정 완료");
					}
				}
			}
		}
		if (isExistSt == false||isExistSb==false) {
			System.out.println("학생이름 또는 과목이름을 잘못 입력하셨습니다.");

		} else {
			save();
		}
	}
	
	public void addStudent() {
		load();
		System.out.println("학생 이름입력. 종료하려면 exit 입력");
		String stname= sc.nextLine();
		if(stname.equals("exit")) return;
		System.out.println("학년, 반, 번호 입력(공백으로 구분)");
		String input = sc.nextLine();
		
		String stringInfo[] = input.split(" ");
		int intInfo[]= {Integer.valueOf(stringInfo[0]),Integer.valueOf(stringInfo[1]),Integer.valueOf(stringInfo[2])};
		ArrayList<Subject> subjects = new ArrayList<Subject>();
		subjects.add(new Subject("국어", 0));//기본과목추가
		aMap.put(new Student(stname, intInfo[0], intInfo[1], intInfo[2]), subjects);	
		System.out.println(aMap);
		stSet.add(new Student(stname, intInfo[0], intInfo[1], intInfo[2]));
		
		save();
	}

	public void removeStudent() {
		load();
		System.out.println("학생 이름을 입력하세요");
		String input= sc.nextLine();
		for(Student s : stSet) {
			if(s.getstname().equals(input))
			aMap.remove(s);
		}
		for(Student s : stSet) {
			if(s.getstname().equals(input))
			stSet.remove(s);
		}
		save();
	}
}