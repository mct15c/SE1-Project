package com.ams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class teamMaker {

    private int totalNumPerson = 0;
    private List<Integer> bucket_list = null;
    private ArrayList<String[]> preferences = null;

    public boolean readFile() {

        String csvFile = "Test.csv";
        String line = "";
        String cvsSplitBy = ",";
        bucket_list = new ArrayList<Integer>();
        preferences = new ArrayList<String[]>();

        int numPerson = 1;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            
            while ((line = br.readLine()) != null) {

                // use comma as separator
                // doesn't need quotes around any of the things in the file
                // may cause type errors in the future
                String[] member = line.split(cvsSplitBy);

                preferences.add(member);

                System.out.print("Member "+numPerson+": "+member[0]+" [");
                if (member.length > 1){
                    System.out.print(member[1]);
                    for (int i = 2; i < member.length; i++) {
                        System.out.print(","+member[i]);
                    }
                }
                System.out.println("]");
                numPerson++;
            }
            
			totalNumPerson = numPerson-1;

			
			for (int i = 1; i < totalNumPerson + 1; i++) {
				bucket_list.add(i);
			}

            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    public void happy_Checker() {
        ArrayList<String> group = new ArrayList<String>();
        ArrayList<String> test = [] //test contains the names and numbers of the csv
        int groupsize = 4;
        
        //place the below variables in another loop, final product will be in a nested
        //for loop, outer compares one bucket list to another, inner counts happiness and
        //unhappiness. 
        int zero_count_main = 0;
        int happiness_main = 0;
        
        int zero_count_other = 0;
        int happiness_other = 0;
        
        
        //Outer for loop will iterate over each bucket if possible and is set up to do so, if not possible individual values
        for (int c = 0; c < bucket_list.size(); c++) { //We must account for uneven teams (2 teams of 3 with 1 team of 2)
        
            for (int d = 0; d < individual_list.size(); d++){
                //current d value will be swapped to the beginning, beginning value swapped to where
                //d was, and all values are checked with no skipping
                individual_list[d] = swapholder;
                individual_list[d] = individual_list[0];
                individual_list[0] = swapholder;
                
                for(int e = 0; e < csv_number_list.size(); e++){
                    if(test[c][e] == individual_list[d]){
                        happiness += groupsize - d;
                    }
                    
                    if(happiness == 0){
                        zero_count += 1;
                    }
                }
                
                individual_list[0] = swapholder;
                individual_list[d] = individual_list[0];
                individual_list[d] = swapholder;
                
            }


        }

    }

    public List getList() {
        return bucket_list;
    }

    public boolean randomizer(List<Integer> bucket_list) {
        if (bucket_list == null) {
            return false;
        }
        Collections.shuffle(bucket_list);
        System.out.println("Bucket List "+bucket_list);
        return true;
    }

    public int getTotalNumPerson() {
        return totalNumPerson;
    }

    public void clearTotalNumPerson() {
        totalNumPerson = 0;
    }

}
