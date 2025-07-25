
package com.aurionpro.basic.commandline;

public class DistanceCalculator {

	private static double distanceCalculator(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}

	public static void main(String[] args) {
		int x1 = Integer.parseInt(args[0]);
		int y1 = Integer.parseInt(args[1]);
		int x2 = Integer.parseInt(args[2]);
		int y2 = Integer.parseInt(args[3]);
		double distance = distanceCalculator(x1, y1, x2, y2);

		System.out.println("The distance betweeen given two point is : " + distance);

	}

}
