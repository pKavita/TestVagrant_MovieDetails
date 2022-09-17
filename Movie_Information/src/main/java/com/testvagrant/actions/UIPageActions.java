package com.testvagrant.actions;

public class UIPageActions {
	
	public String splitString(String str) {
		String[] data = str.split(" ");
		String result=data[1].substring(0, data[1].length()-1)+" "+data[0]+" "+data[2];
		return result;
	}
}
