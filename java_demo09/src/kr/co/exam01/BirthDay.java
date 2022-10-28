package kr.co.exam01;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class BirthDay {

		public static final String FOUR_YEAR_FORMAT="yyyyMMdd";
		public static final String TWO_YEAR_FORMAT="yyMMdd";
		
		private Date date;
		private SimpleDateFormat dateFormat  = new SimpleDateFormat("yyyyMMdd");

		/**
		 * 지정한 날짜 형식으로 변환할 수 있도록 SimpleDateFormat 객체를 생성하여
		 * 활용하기 위해 사용.
		 * @param format : BirthDay 클래스 상수에 정의된 포멧 문자열만 사용하게함.
		 */
		private void setDateFormat(String format) {
			dateFormat = new SimpleDateFormat(format);
		}
		
		/**
		 * 현재 날짜를 기준으로 다음 생일이 언제인지 반환한다,</br>
		 * 이미 생일이 지난 경우 다음년도에 대한 BirthDay 객체를 반환하고</br>
		 * 아직 생일이 지나지 않은 경우 올해에 대한 BirthDay 객체를 반환한다.
		 * @return BirthDay : 다음 생일에 대한 정보를 담아 반환한다.
		 */
		public BirthDay nextBirthDay(Date date) {
			GregorianCalendar gc1 = new GregorianCalendar();
			GregorianCalendar gc2 = new GregorianCalendar(gc1.get(Calendar.YEAR),date.getMonth(),date.getDate());
			long f = gc1.getTimeInMillis()-gc2.getTimeInMillis();
			if(f>0) {
				gc2.add(Calendar.YEAR, 1);
				//Date d = new Date(gc2.get(Calendar.YEAR),gc2.get(Calendar.MONTH),gc2.get(Calendar.DATE));
				Date d = new Date(gc2.getTimeInMillis());
				return new BirthDay(d);
			}else if(f<0) {
				//Date d = new Date(gc2.get(Calendar.YEAR),gc2.get(Calendar.MONTH),gc2.get(Calendar.DATE));
				Date d = new Date(gc2.getTimeInMillis());
				return new BirthDay(d);
			}
			return new BirthDay(new Date());
			
		}
		/**
		 * 현재 날짜 정보를 java.util.Date 객체로 반환한다.
		 * @return Date : 현재 시스템 날짜
		 */
		public Date currentDate() {
			return new Date();
		}
		
		/**
		 * 현재 날짜 정보를 문자열로 반환한다. 기본 포멧을 yyyy년 mm월 dd일 이다.
		 * @return String : 날짜 형식의 문자열  
		 */
		public String currentDateToString() {
			
			return String.format("%1$tY년 %1$tm월 %1$td일",new Date());
		}
	/**
	 * 정수값에 해당하는 년, 월, 일 을 입력받아 BithDay 객체를 생성하기 위한
	 * 생성자.
	 * 
	 * @param year : 태어난 년도
	 * @param month : 태어난 달
	 * @param date : 태어난 일자
	 */
	
		public BirthDay(int year, int month, int date) {
//			this.date.setYear(year);
//			this.date.setMonth(month);
//			this.date.setDate(year);
			this.date= (new GregorianCalendar(year, month, date)).getTime();
		}
		/**
		 * java.util.Date 클래스를 입력받아 BirthDay객체를 생성하기 위한 생성자.		
		 * @param date
		 */
		public BirthDay(Date date) {
			this.date =date;
		}
		/**
		 * 밀리초에 해당하는 정수값을 받아 BirthDay 객체를 생성하기 위한 생성자.</br>
		 * 1970년 01월 01일 00시 00분 00초 000밀리초 를 기준으로 생성한다.
		 * 
		 * @param milliSecond : Long 타입의 밀리초 값
		 */		
		public BirthDay(long milliSecond) {
			//date.setTime(milliSecond);
			date= new Date(milliSecond);
		}
		
		
		/**
		 * 6자리(yymmdd) 또는 8자리(yyyymmdd) 날짜 형식을 받아서 BirthDay
		 * 객체를 생성하기 위한 생성자.
		 * 
		 *  @param dateFormat : 
		 */
		public BirthDay(String dateFormat) {
			switch (dateFormat.length()) {
			case 6:
				setDateFormat(BirthDay.TWO_YEAR_FORMAT);
				break;
			case 8:
				setDateFormat(BirthDay.FOUR_YEAR_FORMAT);
				break;
			}
			try {
			date =this.dateFormat.parse(dateFormat);
			}catch (ParseException e) {
				e.printStackTrace();
				date = new Date();
			}
		}
		@Override
		public String toString() {
			
			return String.format("%1$tY년 %1$tm월 %1$td일",date);
		}
		
}

