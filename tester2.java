package com.ams;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.lang.Math;

public class teamMaker {

    private int totalNumPerson = 0;
    private List<Integer> bucket_list = null;
    private ArrayList<String> bucket_list = null;
    private ArrayList<String[]> preferences = null;
    private ArrayList<String> teams = null;
    private int groupsize = 2;
    private int zero_count_main = 0;
    private int happiness_main = 0;

    public boolean readFile() {

        String csvFile = "Test.csv";
        String line = "";
        String cvsSplitBy = ",";
        bucket_list = new ArrayList<Integer>();
        bucket_list = new ArrayList<String>();
        teams = new ArrayList<String>();
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
                bucket_list.add(String.valueOf(numPerson));
                numPerson++;
            }

            teams = bucket_list;
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
        ArrayList<String[]> test = new ArrayList<String[]>(); //test contains the names and numbers of the csv
        int groupsize = 4;

        String individual_list[] = new String[7];
        String swapholder = "";
        ArrayList<String[]> csv_number_list = new ArrayList<String[]>();
        int happiness = 0;
        int zero_count = 0;

        //place the below variables in another loop, final product will be in a nested
        //for loop, outer compares one bucket list to another, inner counts happiness and
        //unhappiness. 
        int zero_count_main = 0;
        int happiness_main = 0;

        //unhappiness.
        int happiness_team = 0;
        int zero_count_team = 0;
        int zero_count_other = 0;
        int happiness_other = 0;

        int a = 0;

        ArrayList<String> current_team = new ArrayList<String>();

        int runtime = (int) Math.ceil((double) teams.size() / groupsize);
        System.out.println(runtime);

        for(int outer = 0; outer < runtime; outer++){
            //GRAB TEAM WE WANT TO CHECK NEXT
            for(int b = 0; b < groupsize && a != teams.size(); b++){
                current_team.add(teams.get(a).toString());
                a++;
            }

            //TO PRINT OUT current team
            for(int x = 0; x < current_team.size(); x++){
                System.out.println("current_team: "+current_team.get(x));
            }
            System.out.println("END OF ITERATION");

				for(int d = 0; d < groupsize; d++){
					String swapholder = "";
		
					//To keep track in my head on what's what
					//String current = current_team.get(d);
					//String first = current_team.get(0);
					//swapholder = current;
					//current = first;
					//first = swapholder;
					
					swapholder = current_team.get(d);
					current_team.get(d) = current_team.get(0);
					current_team.get(0) = swapholder;

					for (int e = 1; e < preferences.get(d).length()-1; e++){
						for(int f = 1; f < curret_team.length(); f++){

							if(preferences[current_team[d][e]] == current_team[f]){
								happiness_team += ((preferences.get(d).length()-1) - (e-1));
							}
						}


					}
					happiness_main += happiness_team;

					if(happiness_team == 0){
						zero_count_team += 1;
					}

					swapholder = current_team.get(0);
					current_team.get(0) = current_team.get(d);
					current_team.get(d) = swapholder;

				}

                zero_count_main += zero_count_team;

                happiness_team = 0;
                zero_count_team = 0;

            }

            //TO RESET current_team so you can grab next team
            current_team.clear();
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