package ch12_interface.sec02_interface;

public interface RemoteControllable {
	// 상수
	public static final int MIN_VOLUME = 0;
	
	// public static final 생략해도 무방
	int MAX_VOLUME = 10;
	
	
	// 추상 메소드
	public abstract void turnOn();
	public abstract void turnOff();
	
	// public abstract 생략해도 추상 메소드로 생성
	void setVolume(int volume);
}
