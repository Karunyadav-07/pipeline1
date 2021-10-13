package com.nagarro.Assignment4.service;
import java.util.*;
import java.io.*;
import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;

class userPrefrencePrice implements Comparator<String[] > {
	  
    // overriding the compare() method
    public int compare(String[] s1, String[] s2)
    {
        if (Float.parseFloat(s1[5]) == Float.parseFloat(s2[5]))
            return 0;
        else if (Float.parseFloat(s1[5]) > Float.parseFloat(s2[5]))
            return 1;
        else
            return -1;
    }
}

class userPrefrenceRating implements Comparator<String[] > {
	  
    // overriding the compare() method
    public int compare(String[] s1, String[] s2)
    {
        if (Float.parseFloat(s1[6]) == Float.parseFloat(s2[6]))
            return 0;
        else if (Float.parseFloat(s1[6]) > Float.parseFloat(s2[6]))
            return 1;
        else
            return -1;
    }
}


public class CSVservice extends Thread{
	
	
	
	String colour;
	String size;
	String gender;
	String preference;
	
	ArrayList<String[]> list = new ArrayList<String[]>();
	
	public CSVservice(String colour,String size,String gender,String preference) {
		this.colour = colour;
		this.gender = gender;
		this.size = size;
		this.preference = preference;
	}
	
	public void csvReaderMethod(String filePath) {
        try {
        	
            FileReader fileReader = new FileReader(filePath);
            CSVParser parser = new CSVParserBuilder().withSeparator('|').build(); 
            CSVReader csvReader = new CSVReaderBuilder(fileReader).withCSVParser(parser).build(); 
            String[] line;
            while ((line = csvReader.readNext()) != null) {
            	if(line[2].equals(colour) && line[3].equals(gender) && line[4].equals(size)) {
            		list.add(line);
            	}
            } 

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	

	
	
	public void run(){
		
	
    	
    	File directoryPath = new File("C:\\Users\\karunyadav\\eclipse-workspace\\Assignment4\\src\\main\\resources");
        
    	/// directoryPath has the path where are CSV files are present
    	
    	
        File filesList[] = directoryPath.listFiles();
        for(File file : filesList) {
           
        	String filePath =  file.getAbsolutePath();
        	csvReaderMethod(filePath);
            
         }
    	
  
		
		if(list.size()==0) {
			System.out.println("No available T-Shirts are found according to user requierment !!!");
		}
		else {
			if(preference == "price") {
				Collections.sort(list,new userPrefrencePrice());  // sorting the result
			}
			else {
			    Collections.sort(list,new userPrefrenceRating());	// sorting the result
			}
			
		
			for(int i=0;i<list.size();i++) {
				for(int j = 0;j<list.get(i).length;j++) {
					System.out.printf("%s  ",list.get(i)[j]);
				}
				System.out.println();
			}
		
		}
	}
}	