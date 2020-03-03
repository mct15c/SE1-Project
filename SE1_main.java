// Program to check for command line arguments 
class  HappyTeams
{ 
    public static void main(String[] args) 
    { 
        // check if length of args array is 
        // greater than 0 
        if (args.length > 0) 
        { 
			boolean v_one = false;
			boolean v_two = false;
			boolean v_three = false;
			boolean v_four = false;
			
            System.out.println("The command line"+ 
                               " arguments are:"); 
  
            // iterating the args array and printing 
            // the command line arguments 
            for (String val:args){
				
				if(val == "-v"){
					if(args[val + 1] == "1"){
						v_one = true;
					}
					
					if(args[val + 1] == "2"){
						v_two = true;
					}
					
					if(args[val + 1] == "3"){
						v_three = true;
					}
					
					if(args[val + 1] == "4"){
						v_four = true;
					}
				}
				
				if(val == "-t"){
					int groupsize = args[val+1];
				}
				
				if(val == "-n"){
					int number_of_swaps = args[val+1];
				}
				
				if(val == "-l"){
					int number_of_swap_times = args[val+1];
				}
				
				if(val == "-r"){
					int sub_optimal = args[val+1];
				}
                System.out.println(val); 
			} 
        else
            System.out.println("No command line "+ 
                               "arguments found."); 
    } 
} 