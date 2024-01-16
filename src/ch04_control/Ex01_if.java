package ch04_control;

public class Ex01_if {

	public static void main(String[] args) {
		
		int score = 60 + (int)(41 * Math.random());
		
		if (score >= 80)
			System.out.println(score + "점은 평균 이상입니다.");
		else
			System.out.println(score + "점은 평균 미만입니다.");
		
		char grade;
		if (score >= 90)
			grade = 'A';
		else if (score>= 80)
			grade = 'B';
		else if (score>= 70)
			grade = 'C';
		else if (score>= 60)
			grade = 'D';
		else
			grade = 'F';
		
		System.out.println("등급은 " + grade + " 입니다.");
		
		switch(score / 10)
		{
		case 10:
		case 9:
			grade = 'A';
			break;
		case 8:
			grade = 'B';
			break;
		case 7:
			grade = 'C';
			break;
		case 6:
			grade = 'D';
			break;
		default:
			grade = 'F';
		}
	}

}
