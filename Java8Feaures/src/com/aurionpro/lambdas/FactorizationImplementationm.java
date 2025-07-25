package com.aurionpro.lambdas;

public class FactorizationImplementationm {

	public static void main(String args) {
		display(
				(x)->{
					int ans =0;
					for(int i=2;i<x;i++) {
						ans++;
					}
					return x;
		});
		
	}
	public static void display(IFactorization factorization) {
		factorization.findFactorization(10);
	}
}
