package ch05_reference;

import java.util.Scanner;

public class Ex99_mineMap {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("지뢰 개수 입력(5 ~ 55): ");
		
		int mines = Integer.parseInt(scan.nextLine());
		scan.close();
		
		char[][] originMap = new char[8][8];
		char[][] displayMap = new char[8][8];
		
		originMap = DrawMap(originMap, mines);
		
		//PrintMap(originMap);
		
		displayMap = WrapMap(originMap, displayMap);
		
		PrintMap(displayMap);
	}
	
	static char[][] DrawMap(char[][] originMap, int mines) {
		
		int remainMines = mines;
		
		while(remainMines > 0)
		{
			int row = (int) (Math.random() * 8);
			int col = (int) (Math.random() * 8);
			
			if (originMap[row][col] != '*')
			{	
				originMap[row][col] = '*';
				remainMines--;
			}
		}
		
		for (int i = 0; i < originMap.length; i++)
		{
			for (int j = 0; j < originMap[i].length; j++)
			{
				if (originMap[i][j] != '*')
					originMap[i][j] = '.';
			}
		}
		
		return originMap;
	}
	
	static void PrintMap(char[][] originMap) {
		for (int i = 0; i < originMap.length; i++)
		{
			for (int j = 0; j < originMap[i].length; j++)
			{
				System.out.print(originMap[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static char[][] WrapMap(char[][] originMap, char[][] displayMap) {
		
		for (int i = 0; i < originMap.length; i++)
		{
			for (int j = 0; j < originMap[i].length; j++)
			{
				if (originMap[i][j] == '*')
				{
					displayMap[i][j] = '*';
				}
				else
					displayMap[i][j] = CountMine(originMap, i, j);
			}
		}
		
		return displayMap;
	}
	
	static char CountMine(char[][] originMap, int row, int col) {
		char c = '.';
		int count = 0;
		
		for (int i = row - 1; i <= row + 1; i++)
		{
			if (i < 0 || i >= originMap.length)
				continue;
			
			for (int j = col - 1; j <= col + 1; j++)
			{
				if (j < 0 || j >= originMap.length)
					continue;
				
				if (originMap[i][j] == '*')
					count++;
			}
		}
		
		if (count > 0)
			c = (char)(count + '0');
		return c;
	}
}
