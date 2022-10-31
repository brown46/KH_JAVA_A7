package kr.co.exam01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Exam {

	public static void getBirthDay(String filePath) throws ParseException {
		File f = new File(filePath);
		//File f = new File("D:\\birthday.txt");
		char[] cArr = new char[0];
		try(FileReader fr = new FileReader(f)){
			
			char[] buffer = new char[8];
			while(true) {
				int readChars=	fr.read(buffer);
				if(readChars==-1)break;
				cArr =Arrays.copyOf(cArr, cArr.length+readChars);
				System.arraycopy(buffer, 0, cArr, cArr.length-readChars, readChars);
			}
			
		}catch (FileNotFoundException e) {
			System.out.println(f.getPath() + " 경로에 파일이 존재하지 않습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("파일을 읽는 과정중에 문제가 발생하였습니다.");
			e.printStackTrace();
		}
		
		String birthDay = new String(cArr);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date date = df.parse(birthDay);
		int year = Integer.parseInt(String.format("%tY", date));
		int month = Integer.parseInt(String.format("%tm", date));
		int day = Integer.parseInt(String.format("%td", date));
		GregorianCalendar gc = new GregorianCalendar(year, month-1,day);
		
		df.applyPattern("yyyy년 MM월 dd일 EEEE");
		f = new File("D:\\birthday100.txt");
		try(FileWriter fw = new FileWriter(f)){
			for(int i=0; i<100; i++) {
				fw.append(df.format(gc.getTime())+"\n");
				gc.add(Calendar.YEAR,1);
			}
		}catch (Exception e) {
			
		}
		
	}

	public static void main(String[] args) throws ParseException {
		/*
		 * birthday.txt 파일에 작성된 생년월일을 읽고
		 * 100년 동안의 생일에서 일 ~ 토요일 까지의 모든
		 * 요일 정보를 birthday100.txt 에 저장하도록 한다.
		 */
		
		getBirthDay("D:\\birthday.txt");

	}

}
