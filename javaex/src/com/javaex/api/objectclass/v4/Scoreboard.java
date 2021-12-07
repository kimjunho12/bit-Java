package com.javaex.api.objectclass.v4;

import java.util.Arrays;

// v4. 깊은 복제
public class Scoreboard implements Cloneable {
	// 참조 타입 필드
	private int[] scores;
	
	public Scoreboard(int[] scores) {
		this.scores = scores;
	}
	
	public Scoreboard getClone() {
		Scoreboard clone = null;
		
		try {
			clone = (Scoreboard) clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// 1. 얕은 복제 시도
		Scoreboard clone = (Scoreboard) super.clone();
		// 2. 내부 참조 객체를 복제
		clone.scores = Arrays.copyOf(scores, scores.length);
		return clone;
	}

	public int[] getScores() {
		return scores;
	}

	public void setScores(int[] scores) {
		this.scores = scores;
	}

	@Override
	public String toString() {
		return "Scoreboard [scores=" + Arrays.toString(scores) + "]";
	}
}
