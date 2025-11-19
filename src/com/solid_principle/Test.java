package com.solid_principle;

public class Test {
	
	public static void main(String[] args) {
		String s = "akku";
		String s1 = new String("akku");
		String s2 = new String("akku");
		System.out.println(s.equals(s1));
		System.out.println(s==s1);
		
		System.out.println("check with s2 :- "+ (s1==s2));
		
		System.out.println();
		System.out.println(s.hashCode());
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
	}

}
