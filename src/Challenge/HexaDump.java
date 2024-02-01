package Challenge;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class HexaDump {

	public static void main(String[] args) throws Exception {
		// 파일 입력
		Scanner scan = new Scanner(System.in);
		System.out.print("찾을 바이너리 파일> ");
		String filename = scan.nextLine();
		scan.close();
		
		// 텍스트 파일 내용을 받기 위한 인풋스트림
		InputStream is = new FileInputStream(filename);
		
		// 파일 내용을 담을 버퍼 생성
		byte[] buffer = new byte[1024];
		int addr = 0;
		
		while (true) {
			int num = is.read(buffer); // 1024의 크기만큼 담기
			if (num == -1)
				break;
			for (int i = 0; i <= num / 16; i++) {
				System.out.printf("%04x:  ", addr); // 4자리의 16진수로 현재 줄의 번호를 표현
				
				// 16글자씩  16진수로 변환하는 로직
				for (int k = 0; k < 16; k++) {
					
					int index = i * 16 + k;
					
					// 텍스트를 16진수로 담기
					// 1. index가 담은 데이터의 크기보다 크면 그냥 빈 칸만 채우기
					if (index >= num)
						System.out.print("   ");
					// 2. 받은 데이터에 해당하는 16진수 출력
					else
						System.out.printf("%02x ", buffer[index]);
					
					// 8번째 데이터마다 빈 칸 하나 추가해서 띄우기
					if (k == 7)
						System.out.print(" ");
				}
				System.out.print(" ");
				
				// 16글자를 채우고나서 원래 어떤 텍스트였는지 채우는 과정
				for (int k = 0; k < 16; k++) {
					int index = i * 16 + k;
					if (index >= num) // index가 크면 더 이상 채울 텍스트가 없으므로 그냥 종료
						break;
					if (buffer[index] >= 32 && buffer[index] < 127) // 문자일 경우 그대로 문자 출력
						System.out.print((char)buffer[index]);
					else
						System.out.print("."); // 문자가 아니면 .만 출력
					if (k == 7)
						System.out.print(" ");
				}
				System.out.println();
				if ((i + 1) * 16 >= num)
					break;
				
				// 16진수의 2번째 자리부터 자릿수가 올라가므로 16씩 더하기
				addr += 16;
			}
			System.out.println();
		}
	}

}