package kr.co.exam03;


public class Speaker {
	
	Speaker(){}
	Speaker(int volumn){
		this(volumn,false,true);
	}
	Speaker(int volumn, boolean mute){
		setVolumn(volumn);
		this.mute=mute;
	}
	Speaker(int volumn, boolean mute,boolean power){
		//this.volumn=volumn;
		setVolumn(volumn);
		this.mute=mute;
		this.power=power;
	}
	
	private int volumn=0;
	private boolean mute=false;
	private boolean power=false;
	
	public void upVolumn() {
		if(power==false||mute==true)
			return;
		if(volumn<100)
		volumn+=5;
		if(volumn>=100)
			volumn=100;
	}
	public void downVolumn() {
		if(power==false||mute==true)
			return;
		if(volumn>0)
		volumn-=5;
		if(volumn<0)
			volumn=0;
	}
	public void toggleMute() {
		if(power==false)
			return;
		mute=!mute;
	}
	public void togglePower() {
		power=!power;
	}
	private void setVolumn(int volumn) {
		if(0<=volumn&&volumn<=100)
			this.volumn=volumn;
	}
	public String getState() {
		if(power==false) {
			return "전원 OFF";
		}else if(power==true&&mute==true) {
			return "음소거";
		}else
			return "음량 "+volumn;		
	}

	
	
}
