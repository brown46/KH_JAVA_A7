package kr.co.demo05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Demo {

	public static void main(String[] args) throws ParseException {
		/*
		 * 날짜 관련 클래스
		 * 		-Date : 시스템으로부터 현재 날짜, 시간 정보를 가져와서 사용할 수 있게 만들어진 클래스
		 * 		-Calendar : new 연산자로 객체 생성을 할 수 없음. 대신 getInstance() 메서드를 사용하여
		 * 				날짜, 시간 정보를 생성해야 한다.
		 * 		-GregorianCalendar : Calendar 클래스를 상속한 하위 클래스로 년, 월, 일, 시, 분, 초
		 * 				 정보를 다룰수 있게 되어있다.
		 * 		-SimpleDateFormat : 날짜 및 시간 정보를 정해진 형식에 맞추어 문자열로 만들어 주는 기능을
		 * 				 제공한다. 또는 문자열로 만들어진 날짜 및 시간 형식을 Date클래스 객체로 만들어 준다.
		 */
		
		
		Date date = new Date();
		System.out.println("date 기본 출력: "+date);
		
		System.out.println("data.getTime() 출력: "+date.getTime());
		//1970년 1월 1일 0분0초부터 시작한 밀리초 값  epoch
		
		String year =String.format("%tY", date);
		String month =String.format("%tm", date);
		String day =String.format("%td", date);
		String strDay =String.format("%tA", date);
		System.out.println(year +"년 "+month+"월 "+day +"일 " +strDay);
		
		String hour=String.format("%tH", date);
		String minute=String.format("%tM", date);
		String second=String.format("%tS", date);
		String ms=String.format("%tL", date);
		System.out.println(hour +"시 "+minute+"분 "+second +"초 ."+ms);
		
		
		/*
		 * calendar 클래스
		 */
		Calendar c =Calendar.getInstance();
		
		//c.add(Calendar.MONTH,1); 날짜 계산
		
		int cYear= c.get(Calendar.YEAR);
		int cMonth =c.get(Calendar.MONTH)+1;//Month는 0부터 시작
		int cDate =c.get(Calendar.DATE);
		int cDay =c.get(Calendar.DAY_OF_WEEK);
		
		switch (cDay) {
		case Calendar.SUNDAY:
			strDay="일요일";
			break;
		case Calendar.MONDAY:
			strDay="월요일";
			break;
		case Calendar.TUESDAY:
			strDay="화요일";
			break;
		case Calendar.WEDNESDAY:
			strDay="수요일";
			break;
		case Calendar.FRIDAY:
			strDay="목요일";
			break;
		case Calendar.SATURDAY:
			strDay="금요일";
			break;

		
		}
		
		System.out.println(cYear +"년 "+cMonth+"월 "+cDate +"일 "+strDay );
		
		/*
		 * GregorianCalendar 
		 */
		GregorianCalendar gc= new GregorianCalendar();
		gc = new GregorianCalendar(2022,0,1);
		gc = new GregorianCalendar(2022,0,1,12,20,30);
		
		 cYear= gc.get(Calendar.YEAR);
		 cMonth =gc.get(Calendar.MONTH)+1;
		 cDate =gc.get(Calendar.DATE);
		 cDay =gc.get(Calendar.DAY_OF_WEEK);
		
		switch (cDay) {
		case Calendar.SUNDAY:
			strDay="일요일";
			break;
		case Calendar.MONDAY:
			strDay="월요일";
			break;
		case Calendar.TUESDAY:
			strDay="화요일";
			break;
		case Calendar.WEDNESDAY:
			strDay="수요일";
			break;
		case Calendar.FRIDAY:
			strDay="목요일";
			break;
		case Calendar.SATURDAY:
			strDay="금요일";
			break;

		
		}
		System.out.println(cYear +"년 "+cMonth+"월 "+cDate +"일 "+strDay );
		
		
		/*
		 * SimpleDateFormat
		 */
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-EEEE-HH-mm-ss .SSS");
		String fDate =df.format(new Date());
		System.out.println(fDate);
		
		
		//df.applyPattern("yyyy-MM-dd");//패턴바꾸기
		date = df.parse("2022-01-01-토요일-00-00-00 .000");//패턴을 일치시켜야 parse가 가능하다

		System.out.println(date);
		System.out.println(gc.YEAR);
	}

}
