package ch06_class.sec05_Melon;

import java.util.ArrayList;
import java.util.List;

public class MelonMain {

	public static void main(String[] args) {
		
		Melon mel = new Melon();
		mel.setRank(1); mel.setTitle("비의 랩소디"); mel.setArtist("임재현"); mel.setAlbum("비의 랩소디"); mel.setLike(33216);
		//System.out.println(mel);
		
		Melon mel2 = new Melon(2, "To. X", "태연", "To. X - The 5th Mini Album", 82811);
		
		Melon[] me = new Melon[5];
		
		me[0] = mel;
		me[1] = mel2;
		me[2] = new Melon(3, "Perfect Night", "LE SSERAFIM", "Perfect Night", 94997);
		me[3] = new Melon(4, "Drama", "aespa", "Drama - The 4th Mini Album", 68539);
		me[4] = new Melon(5, "에피소드", "이무진", "에피소드", 33249);
		
//		for (Melon m: me)
//		{
//			System.out.println(m);
//		}
		
		// 실전에서 사용하는 리스트 방식의 클래스
		List<Melon> list = new ArrayList<>();
		list.add(mel);
		list.add(mel2);
		list.add(new Melon(3, "Perfect Night", "LE SSERAFIM", "Perfect Night", 94997));
		list.add(new Melon(4, "Drama", "aespa", "Drama - The 4th Mini Album", 68539));
		list.add(new Melon(5, "에피소드", "이무진", "에피소드", 33249));
		
		list.forEach(x -> System.out.println(x)); // forEach를 이용한 하나씩 출력
		
		
		Interpark[] ip = {new Interpark(1, "마흔에 읽는 쇼펜하우어", "강용수", "유노북스", 15300),
				new Interpark(2, "처음부터 시작하는 주식투자", "홍인기", "길벗", 18900),
				new Interpark(3, "남에게 보여주려고 인생을 낭비하지 마라", "쇼펜하우어", "박제헌", "페이지2북스", 15750),
				new Interpark(4, "나는 메트로폴리탄 미술관의 경비원입니다", "패트릭 브링리", "김희정, 조현주", "웅진지식하우스", 15750),
				new Interpark(5, "세이노의 가르침", "세이노", "데이원", 6480) };
		
		for (Interpark i: ip)
		{
			System.out.println(i);
		}
	}

}
