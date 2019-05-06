package algorithm;

import java.io.File;
import java.util.Arrays;

public class SortCollections {
	static int[] climbingLeaderboard(int[] scores, int[] alice) {
		int[] rankList = new int[alice.length];
		for (int i = 0; i < alice.length; i++) {
			int currRank = getRank(alice[i], scores);
			rankList[i] = currRank;
		}
		return rankList;
	}

	private static int getRank(int score, int[] scores) {
		int[] newScores = new int[scores.length + 1];
		for (int i = 0; i < scores.length; i++) {
			newScores[i] = scores[i];
		}
		newScores[newScores.length - 1] = score;
		newScores = Arrays.stream(newScores).sorted().toArray();
		for (int i = 0; i < newScores.length; i++) {
			if (score == newScores[i]) {
				System.out.println(score+":"+i);
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		/*
		 * int[] scores = new int[] { 100, 100, 50, 40, 40, 20, 10 }; int[] alice = new
		 * int[] { 5, 25, 50, 120 }; int[] output = climbingLeaderboard(scores, alice);
		 */

		int a = 3;
		a = a>>1;
		System.out.println(a);

	}
}