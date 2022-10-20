package kr.co.exam04;

import java.util.Arrays;

public class Student {

	public Subject s[] = new Subject[0];
	// public Subject s[] = { new Subject("국어", 70), new Subject("수학", 70) };

	private String name;
	private int year;

	Student(String name, int year) {
		this.name = name;
		this.year = year;
		// System.out.println(this.toString());
	}

	Student(String name) {
		this.name = name;
		this.year = 1;
	}

	public String getName() {
		return this.name;
	}
	public Subject getSubject(String subjectName) {
		Subject result = null;
		int idx = this.find(subjectName);

		if (idx >= 0) {
			result = this.s[idx];
		}

		return result;
	}

	public Subject[] getSubjects(String... subjectNames) {
		Subject results[] = new Subject[0];
		for (int i = 0; i < subjectNames.length; i++) {
			Subject subject = this.getSubject(subjectNames[i]);
			if (subject != null) {
				results = Arrays.copyOf(results, results.length + 1);
				results[results.length - 1] = subject;
			}
		}
		return results;
	}

	public int find(String sName) {
		for (int i = 0; i < s.length; i++) {
			if (s[i].getName().equals(sName)) {
				return i;
			}
		}
		return -1;
	}

//메서드 오버로딩(Overloading) : 동일한 이름의 메서드를 여러개 작성 하는 것.
	// 매겨변수 타입/ 매개변수 수량이 기존과 달라야 한다.
	// 오버로딩된 메서드를 사용하는 사용자 입장에서는 해당 메서드를 사용할 때
	// 타입에 대한 부분을 신경쓰지 않아도 되며, 다양한 타입을 사용해서 동일한 결과를
	// 얻을 수도 있다
	public void addScore(Subject s) {
		this.addScore(s.getName(), s.getScore());
	}
//	public void addScore( String sName,double score) {
//		this.addScore(sName,score);
//	}

	public void addScore(String sName, double score) {
		if (find(sName) != -1) {
			System.out.println("중복입력된 " + sName + "점수 수정됨");
			modScore(sName, score);
			return;
		}
		int len = s.length;
		s = Arrays.copyOf(s, len + 1);
		s[len] = new Subject(sName, score);
	}

	public void delScore(String sName) {
		for (int i = 0; i < s.length; i++) {
			if (sName.equals(s[i].getName())) {
				for (int j = i; j < s.length - 1; j++) {
					s[j] = s[j + 1];
				}
			}
		}
		s = Arrays.copyOf(s, s.length - 1);
	}

//	public void removeScore(String sName) {
//		Subject tmp[] = new Subject[s.length - 1];
//		for (int i = 0; i < s.length; i++) {
//			if (sName.equals(s[i].getName())) {
//				for (int j = 0, k = 0; j < s.length - 1; j++) {
//					if (i != j) {
//						tmp[k] = s[j];
//						k++;
//					}
//				}
//			}
//		}
//		s = tmp;
//	}
	// Subject 객체를 매개변수로 사용하여 기존과 동일하게 동작하는 메서드로 오버로딩하기
	public void removeScore(Subject... subject) {

		Subject results[] = new Subject[0];
		for (int i = 0; i < subject.length; i++) {

			results = Arrays.copyOf(results, results.length + 1);
			results[results.length - 1] = getSubject(subject[i].getName());
		}
		for (int k = 0; k < results.length; k++) {
			for (int i = 0; i < s.length; i++) {
				if (results[k].getName().equals(s[i].getName())) {
					for (int j = i; j < s.length - 1; j++) {
						s[j] = s[j + 1];
					}
				}
			}
			s = Arrays.copyOf(s, s.length - 1);
		}

	}

	public void removeScore(String sName) {
		Subject tmp[] = new Subject[s.length - 1];
		int idx = find(sName);
		for (int i = 0, j = 0; i < s.length - 1; i++) {
			if (idx != i) {
				tmp[j] = s[i];
				j++;
			}
		}
		s = tmp;
	}

	public String getSubScore(String sName) {
		String res = "";
		for (int i = 0; i < s.length; i++) {
			Subject s = this.s[i];
			if (sName.equals(s.getName())) {
				res = String.format("%s점수: %.2f", s.getName(), s.getScore());
				return res;
			}
		}
		return "과목이 없습니다.";
	}

	public String reportCard() {
		String res = "";
		System.out.println(year + "학년 " + "이름: " + name);
		for (int i = 0; i < s.length; i++) {
			res += String.format("과목: %s\t점수: %.2f\t등급: %s\n", s[i].getName(), s[i].getScore(), s[i].getGrade());
		}
		return res;
	}
	public String reportCardf() {
		String res="과목";
		for (int i = 0; i < s.length; i++) {
			res += String.format("\t%s", s[i].getName());
		}
		
		res+="\n점수";
		for (int i = 0; i < s.length; i++) {
			res += String.format("\t%s", s[i].getScore());
		}
		res+="\n등급";
		for (int i = 0; i < s.length; i++) {
			res += String.format("\t%s", s[i].getGrade());
		}
		return res;
	}

	public void modScore(String sName, double score) {
		int i = find(sName);
		if (find(sName) != -1) {
			s[i].setScore(score);
		}
	}

	// Subject 객체를 매개변수로 사용하여 기존과 동일하게 동작하는 메서드로 오버로딩하기
	// 여러개의 성적 정보 수정가능하게
	public void modScore(Subject subject, double score) {
		int i = find(subject.getName());
		if (i != -1) {
			s[i].setScore(score);
		}
	}

//	public Subject[] getSubjects(String[] subjectNames) {
//		Subject result[]= new Subject[0];
//		Subject subject=;
//	}

}
