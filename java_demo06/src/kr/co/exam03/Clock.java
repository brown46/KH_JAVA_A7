package kr.co.exam03;

public class Clock {
	Clock() {}

	Clock(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	private static final int defaultTime = 0;

	int hour = defaultTime;
	int minute = defaultTime;
	int second = defaultTime;

	public String getTimeString() {
		return hour + ":" + minute + ":" + second;
	}
	public void getTime() {
		System.out.printf("%02d:%02d:%02d",hour,minute,second);
	}

}
