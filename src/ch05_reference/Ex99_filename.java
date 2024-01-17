package ch05_reference;

public class Ex99_filename {

	public static void main(String[] args) {
		
		// 특정 경로 내에서 마지막 파일명만 출력시키기
		
		String path = "C:Workspace/WebProject/03.JavaScript/ch07.표준내장객체/04.String연습.js";
		
		String filename = path.substring(path.lastIndexOf("/") + 1);
		
		System.out.println(filename);
	}

}
