private int totalNumPerson = 0;
    private List<Integer> bucket_list = null;
    //private static String[][] personChoice;
    private ArrayList<String[]> preferences = null;

    public boolean readFile() {

        String csvFile = "Test.csv";
        String line = "";
        String cvsSplitBy = ",";
        bucket_list = new ArrayList<Integer>();
        //personChoice = new String[1][];
        preferences = new ArrayList<String[]>();

        int numPerson = 1;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
@@ -33,13 +33,12 @@ public boolean readFile() {
                // may cause type errors in the future
                String[] member = line.split(cvsSplitBy);


                preferences.add(member);

                System.out.print("Member "+numPerson+": "+member[0]+" [");
                if (member.length > 1){
                    System.out.print(member[1]);
                    for (int i = 2; i < member.length; i++) {
                        //personChoice.add(member[i]);
                        System.out.print(","+member[i]);
                    }
                }
@@ -48,13 +47,12 @@ public boolean readFile() {
            }

			totalNumPerson = numPerson-1;




			for (int i = 1; i < totalNumPerson + 1; i++) {
				bucket_list.add(i);
			}
			

            return true;

        } catch (IOException e) {
@@ -64,6 +62,52 @@ public boolean readFile() {

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

			int person = Integer.parseInt(bucket_list[c]); //bucket_list may already have ints, but still call it person

            for (int d = 0; d < groupsize; d++){
                //current d value will be swapped to the beginning, beginning value swapped to where
                //d was, and all values are checked with no skipping
				
				//test[person][1];
				
				int first = Integer.parseInt(test[person][0]);
				int current = Integer.parseInt(test[person][d]);
				
				//Maybe first and current do not need to be ints
				//first = test[person][0];
				//current = test[person][d];
				
                //test[person][d] = swapholder;
                //test[person][d] = test[person][0];
                //test[person][0] = swapholder;
				
				swapholder = current;
				current = first;
				first = swapholder;

                for(int e = 1; e < groupsize; e++){
                    if(test[c][e] == current){
                        happiness += groupsize - d;
                    }

                    if(happiness == 0){
                        zero_count += 1;
                    }
                }
				
				swapholder = first;
				first = current;
				current = swapholder;
            }


        }

    }

    public List getList() {
        return bucket_list;
    }