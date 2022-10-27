package kr.co.demo04;

public class Demo {

	public static void main(String[] args) {
		/*
		 * Wrapper 클래스
		 * 		- 문자열을 기본 자료형으로 만들수 있게 도와주는 클래스
		 * 		- 기본 자료형을 클래스로 만들어서 다룰 수 있게 도와주는 클래스
		 * 
		 * Wrapper 클래스 종루
		 * 		Boolean, Byte, Character, Short, Integer, Long, Float, Double
		 */
		boolean bool1 = Boolean.parseBoolean("true");
		byte bt1 = Byte.valueOf("100");
		byte bt2 = Byte.parseByte("100");
		char ch1 ="A".charAt(0);
		char ch2 = Character.valueOf('a');
		short sh1 =Short.parseShort("100");
		int it1 =Integer.parseInt("100");
		long lg1 =Long.parseLong("100");
		float ft1 =Float.parseFloat("100.1234");
		double db1 = Double.parseDouble("100.2323");
		System.out.println(bt1);
		System.out.println(ch2);
		
		// 기본 자료형을 Wrapper 객체로 변환
		
		Boolean bool2 = Boolean.valueOf(true);
		Byte bt3= Byte.valueOf((byte)100);
		Character ch3 =Character.valueOf('A');
		Short sh2= Short.valueOf((short)100);
		Integer it2 = Integer.valueOf(100);
		Long lg2= Long.valueOf(100l);
		Float ft2 =Float.valueOf(100.1234f);
		Double db2 =Double.valueOf(100.1234);
		
		

	}

}
