package com.aurionpro.lambdas;

public class DemoImplementation {
	public static void main(String args[]) {

//		//1. First Way
//		IDemo iDemo = new IDemo() {
//			public int sum(int x,int y) {
//				return x+y;
//			}
//		};
//		System.out.println(iDemo.sum(10,20));

		
////		2. Second way
//		IDemo iDemo = (x,y)-> (x+y);	
//		System.out.println(iDemo.sum(10,20));
		
//		3. Third Way
		display((x,y)->x+y);
	}
	
	public static void display(IDemo demo) {
		System.out.println(demo.sum(10, 20));
	}
}
