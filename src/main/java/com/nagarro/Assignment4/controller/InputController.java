package com.nagarro.Assignment4.controller;
import java.util.*;
import com.nagarro.Assignment4.constant.*;
import com.nagarro.Assignment4.validation.*;
import com.nagarro.Assignment4.service.*;

public class InputController
{
	
	public static void main( String[] args)
    {
    	
    	String colour = Constant.x;
    	String size  = Constant.x;
    	String gender  = Constant.x;
    	String preference;
    	
    	Validation v1 = new Validation();
    	Scanner sc = new Scanner(System.in);
    	boolean valid = false;
    	
    	while(valid == false) {
    		System.out.println(Constant.STR);
        	colour = sc.nextLine();
        	valid = v1.check(colour);
    	}
    	valid = false;
    	while(valid == false) {
    		System.out.println(Constant.Size);
    		System.out.println(Constant.STR1);
        	size = sc.nextLine();
        	valid = v1.check1(size);
        	
    	}
    	valid = false;
    	while(valid == false) {
    		System.out.println(Constant.Gender);
    		System.out.println(Constant.STR2);
        	gender = sc.nextLine();
        	valid = v1.check2(gender);
      	
    	}
    	System.out.println(Constant.STR3);
    	preference = sc.nextLine();
    	
    	sc.close();
    	
    	CSVservice myobj = new CSVservice(colour,size,gender,preference);
    	myobj.start();
    	
		
		
    }
}
