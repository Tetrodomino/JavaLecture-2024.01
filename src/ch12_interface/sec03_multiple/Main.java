package ch12_interface.sec03_multiple;

import ch12_interface.sec02_interface.RemoteControllable;

public class Main {

	public static void main(String[] args) {
		
		RemoteControllable rc = new SmartTV();
		rc.turnOn(); rc.setVolume(3); rc.turnOff();
		
		
		Searchable sc = new SmartTV();
		sc.search("youtube");
		
		SmartTV stv = new SmartTV();
		stv.turnOn(); stv.setVolume(1); stv.search("naver"); stv.turnOff();
		
		
		sc = new Searchable() {
			
			// main 내에서 바로 오버라이드
			@Override
			public void search(String url) {
				System.out.println("익명 구현체가 검색을 합니다.");
			}
		};
		
		sc.search("kakao");
	}

}
