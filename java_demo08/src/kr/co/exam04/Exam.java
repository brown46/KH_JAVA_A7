package kr.co.exam04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Exam {

	public static void main(String[] args) throws ParseException {
		/*
		 * 현재 날짜를 구하고 다음 형식에 맞추어 출력하세요
		 * 		1. 2022/01/01
		 * 		2. 2022년 01월 01일
		 * 		3. 12시 14분 45초
		 * 		4. 12:15:45
		 * 
		 * 2022년 10월 중 주말에 해당하는 날짜만 문자열 배열에 담아 출력하세요
		 * 
		 * 		-GregorianCalendar의 isLeapYear를 사용하면 윤년을 알 수 있습니다.
		 * -GregorianCalendar의 getMaximum(Calendar.DAY_OF_MONTH)을 사용하면 해당 월의 최대 일자를 알 수 있습니다.
		 * 
		 */
		
		
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sd= new SimpleDateFormat("yyyy/MM/dd");
		String date= sd.format(new Date());
		System.out.println(date);
		
		sd= new SimpleDateFormat("yyyy년 MM월 dd일");
		date= sd.format(new Date());
		System.out.println(date);
		
		sd= new SimpleDateFormat("hh시 mm분 ss초");
		date= sd.format(new Date());
		System.out.println(date);
		
		sd= new SimpleDateFormat("hh:mm:ss");
		date= sd.format(new Date());
		System.out.println(date);
		
	
		GregorianCalendar gc= new GregorianCalendar();

		

		int arr[] =new int[0];		
		for(int i=1;i<gc.getMaximum(Calendar.DAY_OF_MONTH)+1;i++) {
			gc = new GregorianCalendar(2022,9,i);
		
			if(gc.get(Calendar.DAY_OF_WEEK)==1||gc.get(Calendar.DAY_OF_WEEK)==7) {
				arr=Arrays.copyOf(arr, arr.length+1);
				arr[arr.length-1]=i;
			}
		}
		System.out.println(Arrays.toString(arr));

		
		/*
		 * 자신의 생년월일을 입력하면 현재로부터 며칠 남았는지 알려주는 D-DAY 정보를
		 * 출력하세요
		 * 1. 현재 날짜로부터 다음 자신의 생일이 올해 안에 있는 경우...
		 * 		- 현재 월의 남은 일수  -> A
		 * 		- 다음 월 부터 생일 전 달 까지의 모든 일 수 -> B
		 * 		- 생일달의 1 ~ 부터 생일까지의 일수 -> C
		 * 		- A + B + C -> D-Day
		 */
		
		/*
		 * 2. 현재 날짜로부터 다음 자신의 생일이 다음년에 있는 경우..
		 * 		- 
		 */
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("생일 입력 (yyyy-MM-dd)");
		String birthDay = sc.nextLine();

		GregorianCalendar gc2 = new GregorianCalendar();
		try {
		Date bd = new SimpleDateFormat("yyyy-MM-dd").parse(birthDay);
		SimpleDateFormat df =new SimpleDateFormat("yyyy년 MM월 dd일");
		
		GregorianCalendar gc1 = new GregorianCalendar(gc2.get(Calendar.YEAR),bd.getMonth(),bd.getDate());
		long f =gc2.getTimeInMillis()-gc1.getTimeInMillis();	
		
		f= f/(1000*60*60*24);
		System.out.println("현재 날짜는 "+ df.format(gc2.getTime())+" 입니다");
		if(f<0) {
			System.out.println("다음 생일은 "+df.format(gc1.getTime())+" 입니다.");
		}else if(f>0) {
			gc1.add(GregorianCalendar.YEAR, 1);
			f =gc2.getTimeInMillis()-gc1.getTimeInMillis();
			f= f/(1000*60*60*24);
			System.out.println("다음 생일은 "+df.format(gc1.getTime())+" 입니다.");
			
		}
		
		System.out.println("D"+"-"+(-f) );
		if(f==0)System.out.println("생일입니다.");
		}catch(ParseException e) {
			System.out.println("잘못 입력하였습니다.");
			} 
		
	}

}
