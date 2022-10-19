package kr.co.exam04;

import java.util.Arrays;

public class Student {

	//public Subject s[] = new Subject[0];
	public Subject s[] = { new Subject("국어", 70), new Subject("수학", 70) };

	private String name;
	private int year;

	Student(String name, int year) {
		this.name = name;
		this.year = year;
	}

	Student(String name) {
		this.name = name;
		this.year = 1;
	}

	private int find(String sName) {
		for (int i = 0; i < s.length; i++) {
			if (s[i].getName().equals(sName)) {
				return i;
			}
		}
		return -1;
	}

	public void addScore(String sName, int score) {
		if (find(sName) != -1) {
			System.out.println("중복입력된 "+sName+"점수 수정됨");
			modScore(sName,score);
			return;
		}	
		int len =s.length;
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

	public void modScore(String sName, int score) {
		int i=find(sName);
		if(find(sName)!=-1) {
			s[i].setScore(score);
		}
	}
	
	
}
