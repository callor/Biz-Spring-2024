package com.callor.hello.exec;

public class ExecA {
	
	public static void main(String[] args) {
		ExecB execB = new ExecB();
		
		try {
			execB.add(null, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
