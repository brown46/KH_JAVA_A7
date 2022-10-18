package kr.co.exam03;

public class Clock {
	Clock() {}

	Clock(int hour, int minute, int second) {
//		this.hour = hour;
//		this.minute = minute;
//		this.second = second;
		setHour(hour);
		setMinute(minute);
		this.setSecond(second);
	}

	private static final int defaultTime = 0;

	private int hour = defaultTime;
	private int minute = defaultTime;
	private int second = defaultTime;

	public void setHour(int hour) {
		this.hour = hour%24;
	}
	public void setMinute(int minute) {
		this.minute = minute%60;
	}
	public void setSecond(int second) {
		this.second = second%60;
	}
	public String getTimeString() {
		return hour + ":" + minute + ":" + second;
	}
	public void getTime() {
		System.out.printf("%02d:%02d:%02d\n",hour,minute,second);
	}
	
}
