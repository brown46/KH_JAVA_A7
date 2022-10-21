package kr.co.exam04;

import java.util.Scanner;

public class Run2 {

	private Scanner sc = new Scanner(System.in);
	private Student student;

	public Run2() {
		this.student = new Student("홍길동");
		this.student.addScore("국어", 67.9);
		this.student.addScore("영어", 77.7);
		this.student.addScore("수학", 84.5);
	}

	private String initMenu() {
		String menu = "";

		menu += "1. 성적표 출력\n";
		menu += "2. 과목 성적 출력\n";
		menu += "3. 과목 성적 추가\n";
		menu += "4. 과목 성적 수정\n";
		menu += "5. 과목 성적 삭제\n";
		menu += "6. 프로그램 종료\n";

		return menu;
	}

	private void select(int number) {
		switch (number) {
		case 1:
			this.printAll();
			break;
		case 2:
			this.print();
			break;
		case 3:
			this.add();
			break;
		case 4:
			this.update();
			break;
		case 5:
			this.remove();
			break;
		case 6:
			System.out.println("프로그램을 종료 합니다.");
			System.exit(0);
		}
	}

	private void printAll() {
		String s = this.student.reportCardf();
		System.out.println(s);
	}

	private void print() {
		while (true) {
			System.out.println("과목명 입력");
			String subject = sc.nextLine();

			if (subject.equals("exit")) {
				System.out.println("성적 출력 작업을 마칩니다.");
				break;
			} else
				System.out.println(student.getSubScore(subject));
		}
	}

	private void add() {
		while (true) {
			System.out.println("과목명 입력");
			String subject2 = sc.nextLine();
			// sc.nextLine();
			System.out.println("추가할 과목 명: " + subject2);
			if (student.find(subject2) != -1) {
				System.out.println("이미 존재하는 과목 정보 입니다.");
				continue;
			} else if (subject2.equals("exit")) {
				System.out.println("성적 추가 작업을 마칩니다.");
				break;

			}
			System.out.println("점수 입력");
			int score = sc.nextInt();
			sc.nextLine();
			student.addScore(subject2, score);
		}
	}

	private void update() {
		while (true) {
			System.out.println("과목명 입력");
			String subject3 = sc.nextLine();

			System.out.println("수정할 과목 명: " + subject3);
			if (subject3.equals("exit")) {
				System.out.println("성적 수정 작업을 마칩니다.");
				break;
			} else if (student.find(subject3) == -1) {
				System.out.println("존재하지 않는 과목 정보 입니다.");
				continue;
			}
			System.out.println("점수 입력(0~100)");
			int score = sc.nextInt();
			sc.nextLine();
			student.modScore(subject3, score);
		}
	}

	private void remove() {
		while (true) {
			System.out.println("과목명 입력");
			String subject4 = sc.nextLine();
			System.out.println("삭제할 과목 명: " + subject4);
			if (subject4.equals("exit")) {
				System.out.println("성적 삭제 작업을 마칩니다.");
				break;
			} else if (student.find(subject4) == -1) {
				System.out.println("존재하지 않는 과목 정보 입니다.");
				continue;
			}
			student.delScore(subject4);
			System.out.println(subject4 + "과목 삭제되었습니다.");
		}
	}

	
	public void start() {
		while(true) {
			System.out.println(initMenu());	
			int input= sc.nextInt();
			sc.nextLine();
			System.out.println("메뉴 번호 입력 : "+input);
			select(input);
			System.out.println("초기 메뉴로 돌아가려면 Enter 입력!");
			sc.nextLine();
		}
		
	}
	
	

}
