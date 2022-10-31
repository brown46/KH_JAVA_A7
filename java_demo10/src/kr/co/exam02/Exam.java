package kr.co.exam02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Exam {

	public static void main(String[] args) {
		/*
		 * 파일에 저장된 성적 데이터를 읽고 프로그램에 
		 * 사용할 수 있는 객체로 변환한다.
		 * 변환된 Subject 를 활용하여 데이터 추가 및 수정, 삭제를
		 * 진행 후 다시 동일한 파일에 저장할 수 있게 한다.
		 * 파일명은 "학생명.subject" 로 하며, 파일에 작성된 데이터는 
		 * 다음의 구조를 가진다.
		 * 
		 * 학생명.subjects
		 * 	  과목명1 점수1 등급1
		 * 	  과목명2 점수2 등급2
		 * 	  과목명3 점수3 등급3
		 * 	  ...
		 * 	  ...
		 */
		File f = new File("D:\\홍길동.subjects");
		
		StringBuilder sb = new StringBuilder(512);
		
		try(FileReader fr = new FileReader(f)){
			char[] buffer= new char[8];
			while(true) {
				int readChars = fr.read(buffer);
				System.out.println(readChars);
				if(readChars ==-1)break;
				sb.append(buffer, 0, readChars);
			}
			String strDatas[]=sb.toString().split("\r\n");//개행문자 주의!
			for(int i=0; i<strDatas.length;i++) {
				String strSubject[] =strDatas[i].split(" ");
				Subject s =new Subject();
				s.setName(strSubject[0]);
				s.setScore(Double.valueOf(strSubject[1]));
				s.setGrade(strSubject[2].charAt(0));
				System.out.println(s);
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
