package gfg;

/*
 Given a grid of size N X M and a robot is placed at cell (N – 1, M – 1). 
 Also, given string str which consists only of the characters 
 ‘U’ (Up), ‘D’ (Down), ‘L’ (Left) and ‘R’ (Right) representing 
 the moves the robot is going to perform within the grid. 
 The task is to find whether the robot will be safe at the end of the last move. 
 Robot is said to be safe if it is within the bounds of the grid.*/

public class RobotMove {
	private boolean isMoveAllowed(int row, int col, String cmd) {
		char[] cmdArr = cmd.toCharArray();
		boolean flag = true;
		int modifiedRow = row, modifiedCol = col;
		for (char ch : cmdArr) {
			switch (ch) {
			case 'L':
				modifiedCol--;
				break;
			case 'R':
				modifiedCol++;
				break;
			case 'U':
				modifiedRow++;
				break;
			case 'D':
				modifiedRow--;
				break;
			default:
				break;
			}
			if (modifiedRow < 1 || modifiedCol < 1 || modifiedRow > row || modifiedCol > col) {
				flag = false;
			}
		}
		return flag;
	}

	public static void main(String[] args) {
		RobotMove obj = new RobotMove();
		System.out.println(obj.isMoveAllowed(2, 3, "RR"));
	}
}
