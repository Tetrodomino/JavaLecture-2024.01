package ch12_interface.sec02_interface;

public class Main {
	public static void main(String[] args) {
		
		Audio audio = new Audio();
		audio.turnOn();
		audio.setVolume(12);
		audio.turnOff();
		
		Television tv = new Television();
		tv.turnOn();
		tv.setVolume(5);
		tv.turnOff();
		
		
		// 다형성 방법으로 타입을 부여할 수 있음
		// 구현 객체가 무엇이든지 간에 동일한 코드 사용 가능
		RemoteControllable rc = new Audio();
		rc.turnOn();
		rc.setVolume(2);
		rc.turnOff();
	}
}
