package com.ams;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.runner.Description;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class teamMakerTest
{
    teamMaker teams;

    @Rule
    public TestRule watcher =
    	new TestWatcher() {
    	    protected void starting(Description description) {
    		System.out.println("Starting test: " + description.getMethodName());
    	}
    };
    
    @Before
    public void initialize() {
		teams = new teamMaker();
    }

    @Test
    public void testReadFile() 
    {
    	boolean worked = teams.readFile();
       	assertEquals(true,worked);
    }

    @Test
    public void testTotalNumPerson(){
    	// have to read the file again because it goes out of scope 
    	// or something in the previous test for total number of people
    	boolean worked = teams.readFile();
    	int numPerson = teams.getTotalNumPerson();
    	assertEquals(true, worked);
    	assertEquals(7,numPerson);
    }

}









