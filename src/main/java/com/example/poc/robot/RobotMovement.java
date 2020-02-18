package com.example.poc.robot;

public class RobotMovement {

	public boolean isOriginPoint(String[] command) {
		boolean flag = false;

		int x = 0, y = 0;
		String dir = "N"; //E,W,S

		for (String cmd : command) {
			if ("F".equalsIgnoreCase(cmd)) {
				x++;
			} else if ("B".equalsIgnoreCase(cmd)) {
				x--;
			} else if ("L".equalsIgnoreCase(cmd)) {

			} else if ("R".equalsIgnoreCase(cmd)) {

			}
		}

		return flag;
	}

	public static void main(String[] args) {

	}
}
