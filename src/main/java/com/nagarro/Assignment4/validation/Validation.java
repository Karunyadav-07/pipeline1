package com.nagarro.Assignment4.validation;

public class Validation {
	
	public boolean check(String str){
		if (!((str.charAt(0) >= 'a' && str.charAt(0) <= 'z')
		        || (str.charAt(0)>= 'A' && str.charAt(0) <= 'Z')))
		        return false;
		 
		    // Traverse the string for the rest of the characters
		    for (int i = 1; i < str.length(); i++)
		    {
		        if (!((str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
		            || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')))
		            return false;
		    }
		 
		    // String is a valid identifier
		    return true;
	}
	public boolean check1(String str){
		if((str.charAt(0)=='M' || str.charAt(0)=='S' || str.charAt(0) == 'L') && str.length()==1) {
			return true;
		}
		else return false;
	}
	public boolean check2(String str){
		if((str.charAt(0)=='M' || str.charAt(0)=='F' || str.charAt(0)=='m' || str.charAt(0)=='f') && str.length()==1) {
			return true;
		}
		else return false;
	}

}
