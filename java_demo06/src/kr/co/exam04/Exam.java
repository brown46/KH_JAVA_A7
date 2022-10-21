package kr.co.exam04;

public class Exam {

	public static void main(String[] args) {
		/*
		 * 학생들의 성적을 관리하기 위한 용도의 클래스 생성
		 * 		학생 클래스
		 * 			멤버변수 : 성적배열, 이름, 학년
		 * 			멤버메서드 : 성적표출력, 과목점수출력, 과목점수수정, 성적추가/삭제	
		 * 
		 * 		성적 클래스
		 * 			멤버변수 : 과목명, 점수, 등급
		 * 			멤버메서드 : 점수로 등급을 산출하는 메서드
		 */
		
		Student s= new Student("홍길동",3);
		s.addScore(new Subject("한국사",67));
	
//		Subject sub= new Subject("세계사",66);
//		s.addScore(sub);
		s.modScore(new Subject("한국사"),99);
		//System.out.println(s.toString());
		s.addScore("영어",90);
		s.addScore("국어",80);
		s.addScore("수학",84);
		s.addScore("과학",95);
		s.addScore("사회", 50);
		System.out.println(s.getSubScore("국어"));
		String score =s.getSubScore("수학");
		System.out.println(score);
		System.out.println(s.reportCard());
		s.addScore("수학",70);
//		s.modScore("영어", 95);
//		s.delScore("수학");
//		s.removeScore("사회");
//		s.removeScore(new Subject("과학"));
		
		s.removeScore(new Subject("사회"),new Subject("과학"),new Subject("국어"));
		System.out.println(s.reportCard());
	
		Run2 run = new Run2();
		run.start();
	}

}
