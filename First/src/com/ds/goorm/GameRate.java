package com.ds.goorm;
import java.io.*;

public class GameRate {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		String[] inputArr = input.split(" ");
		
		int m, n;
		m =  Integer.valueOf(inputArr[0]);
		n =  Integer.valueOf(inputArr[1]);
			
		double dRate = ((double) n / m * 100);
		if (dRate >= 99){			// 초기 승률이 99 % 이상이라면 더 게임을 진행하더라도
			System.out.print("X");	// 1% 승률을 상승 시킬 수 없다
			return ;
		}
		int rate = (int) ((double) n / m * 100);	// 소숫점 자리 버림
		int master = rate + 1;						// 목표 승률
		
		int x = 0;
		
		for (; dRate < master ; x++){
			// System.out.print(x + " " + dRate + " " + master + "\t");
			dRate = ((double) (n + x) / (m + x) * 100);	// 1 게임씩 진행하며 목표 승률과 현재 승률 비교
			// System.out.print(x + " " + dRate + "\n");
		}
		System.out.print(x-1);
	}
}