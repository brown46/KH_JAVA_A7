package kr.co.exam04;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Student s = new Student("홍길동", 3);
		Scanner sc = new Scanner(System.in);
		loop: while (true) {
			System.out.println("<<< " + s.getName() + " 학생 성적 관리 메뉴>>>");
			System.out.println("1. 성적표 출력");
			System.out.println("2. 과목 성적 출력");
			System.out.println("3. 과목 성적 추가");
			System.out.println("4. 과목 성적 수정");
			System.out.println("5. 과목 성적 삭제");
			System.out.println("6. 프로그램 종료");
			System.out.println();
			int input = sc.nextInt();
			sc.nextLine();
			if (0 >= input && input <= 7)
				continue;
			System.out.println("메뉴 번호 입력 : " + input);
			switch (input) {
			case 1:
				System.out.println(s.reportCardf());
				System.out.println("초기 메뉴로 돌아가려면 Enter 입력!");
				String exit = sc.nextLine();
				if (exit.equals(""))
					break;
				break;
			case 2:
				while (true) {
					System.out.println("과목명 입력");
					String subject = sc.nextLine();

					if (subject.equals("exit")) {
						System.out.println("성적 출력 작업을 마칩니다.");
						System.out.println("초기 메뉴로 돌아가려면 Enter 입력!");
						exit = sc.nextLine();
						if (exit.equals(""))
							break;
					} else
						System.out.println(s.getSubScore(subject));
				}
				break;
			case 3:
				while (true) {
					System.out.println("과목명 입력");
					String subject2 = sc.nextLine();
					// sc.nextLine();
					System.out.println("추가할 과목 명: " + subject2);
					if (s.find(subject2) != -1) {
						System.out.println("이미 존재하는 과목 정보 입니다.");
						continue;
					} else if (subject2.equals("exit")) {
						System.out.println("성적 추가 작업을 마칩니다.");
						System.out.println("초기 메뉴로 돌아가려면 Enter 입력!");
						exit = sc.nextLine();
						if (exit.equals(""))
							break;
					}
					System.out.println("점수 입력");
					int score = sc.nextInt();
					sc.nextLine();
					s.addScore(subject2, score);
				}
				break;
			case 4:
				while (true) {
					System.out.println("과목명 입력");
					String subject3 = sc.nextLine();

					System.out.println("수정할 과목 명: " + subject3);
					if (subject3.equals("exit")) {
						System.out.println("성적 수정 작업을 마칩니다.");
						System.out.println("초기 메뉴로 돌아가려면 Enter 입력!");
						exit = sc.nextLine();
						if (exit.equals(""))
							break;
					} else if (s.find(subject3) == -1) {
						System.out.println("존재하지 않는 과목 정보 입니다.");
						continue;
					}
					System.out.println("점수 입력(0~100)");
					int score = sc.nextInt();
					sc.nextLine();
					s.modScore(subject3, score);
				}
				break;
			case 5:
				while (true) {
					System.out.println("과목명 입력");
					String subject4 = sc.nextLine();
					System.out.println("삭제할 과목 명: " + subject4);
					if (subject4.equals("exit")) {
						System.out.println("성적 삭제 작업을 마칩니다.");
						System.out.println("초기 메뉴로 돌아가려면 Enter 입력!");
						exit = sc.nextLine();
						if (exit.equals(""))
							break;
					} else if (s.find(subject4) == -1) {
						System.out.println("존재하지 않는 과목 정보 입니다.");
						continue;
					}
					s.delScore(subject4);
					System.out.println(subject4 + "과목 삭제되었습니다.");
				}
				break;
			case 6:
				System.out.println("프로그램을 마칩니다.");
				break loop;

			}

		}
sc.close();
	}
}