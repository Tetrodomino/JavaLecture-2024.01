package ch05_reference;

public class Ex99_digitalclock {
	public static void main(String[] args) {
		
		// 디지털 시계(분까지 표시)에서 하루에 3이 몇 초나 오는지
		
		String hour = "";
		
		for (int i = 0; i <= 23; i++)
		{
			hour += i + " ";
		}
		
		int hourcount = hour.replaceAll("[^3]", "").length();
		int count = hourcount * 3600;
		
		hour = "";
		
		for (int i = 0; i <= 59; i++)
		{
			hour += i + " ";
		}
		
		hour = hour.replaceAll("3{2}", "3");
		
		count += hour.replaceAll("[^3]", "").length() * 60 * (24 - hourcount);
		
		System.out.println("하루에 3이 오는 시간(초): " + count);
	}
}
