package com.ams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class teamMaker {

    private int totalNumPerson = 0;

    public boolean readFile() {

        String csvFile = "src/main/java/com/ams/Test.csv";
        String line = "";
        String cvsSplitBy = ",";

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
                        System.out.print(","+member[i]);
                    }
                }
                System.out.println("]");
                numPerson++;
            }
            totalNumPerson = numPerson-1;
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    public int getTotalNumPerson() {
        return totalNumPerson;
    }

    public void clearTotalNumPerson() {
        totalNumPerson = 0;
    }

}