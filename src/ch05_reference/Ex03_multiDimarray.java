package ch05_reference;

import java.util.Arrays;

public class Ex03_multiDimarray {

	public static void main(String[] args) {
		
		// 2차원 배열 (matrix)
		
		int[][] maxtix = new int[2][3];
		int score[][] = {{80, 90, 70}, {85, 88, 72} };
		System.out.println(Arrays.toString(score));
		
		
		// 인덱싱
		System.out.println(score[0][0] + ", " + score[1][1]);
		
		// 사각형이 아닌 형태(톱니바퀴 형태)의 배열도 가능
		int gear[][] = {{1, 3, 5, 9}, {2, 6}, {1, 2, 3}};
		
		// 연습문제
		// 두 행렬의 dot product 구하기
		int[][] a = {{1, 2, 3}, {4, 5, 6}}; // 2 × 3 형태
		int[][] b = {{1, 2}, {3, 4}, {5, 6}}; // 3 × 2
		int[][] c = new int[2][2];
		
		// 지뢰찾기
		char[][] mines = new char[8][8];
		for (int i = 0; i < mines.length; i++)
		{
			for (int k = 0; k < mines[i].length; k++)
			{
				mines[i][k] = (Math.random() > 0.7) ? '*' : '.';
			}
		}
		
		printMines(mines);
	}

	static void printMines(char[][] arr) {
		for (int i = 0; i < arr.length; i++)
		{
			for (int k = 0; k < arr[i].length; k++)
			{
				System.out.print(arr[i][k]);
			}
			System.out.println();
		}
	}
}
