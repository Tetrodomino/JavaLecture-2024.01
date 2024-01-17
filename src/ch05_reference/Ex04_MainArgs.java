package ch05_reference;

import java.util.Arrays;

public class Ex04_MainArgs {

	public static void main(String[] args) {
		
		//System.out.println(Arrays.toStrings(args));
		
		String[] command = "git add .".split(" "); //"" 안에 있는 것을 기준으로 분할
		command = "git  commit  -m  \"Reference Type\"".split("\\s+"); // 공백 여러개로 분리
		System.out.println(Arrays.toString(command));
	}
}
