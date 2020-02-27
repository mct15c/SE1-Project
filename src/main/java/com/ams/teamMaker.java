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
    //private static String[][] personChoice;

    public boolean readFile() {

        String csvFile = "Test.csv";
        String line = "";
        String cvsSplitBy = ",";
        bucket_list = new ArrayList<Integer>();
        //personChoice = new String[1][];

        int numPerson = 1;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            
            while ((line = br.readLine()) != null) {

                // use comma as separator
                // doesn't need quotes around any of the things in the file
                // may cause type errors in the future
                String[] member = line.split(cvsSplitBy);

                

                System.out.print("Member "+numPerson+": "+member[0]+" [");
                if (member.length > 1){
                    System.out.print(member[1]);
                    for (int i = 2; i < member.length; i++) {
                        //personChoice.add(member[i]);
                        System.out.print(","+member[i]);
                    }
                }
                System.out.println("]");
                numPerson++;
            }
            
			totalNumPerson = numPerson-1;
			
			
			//creates bucket list//
			for (int i = 1; i < totalNumPerson + 1; i++) {
				bucket_list.add(i);
			}
			
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
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
