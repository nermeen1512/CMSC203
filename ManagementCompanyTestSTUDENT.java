

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	//student create a management company
	ManagementCompany mg1;
	Property p1,p2,p3,p4,p5,p6;
	
	@Before
	public void setUp() throws Exception {
		
		//student add three properties, with plots, to mgmt co
		p1 = new Property("p1", "Rockvile ", 1700, "amr", 1, 1, 1, 1);
		p2 = new Property("p2", "City4", 1300, "shehap", 3, 3, 1, 1);
		p3 = new Property("p3", "City5", 1800, "adam", 5, 5, 1, 1);
		
		mg1 = new ManagementCompany("myManagementCompany" , "55555" , 6);
		
		mg1.addProperty(p1);
		mg1.addProperty(p2);
		mg1.addProperty(p3);
	}

	@After
	public void tearDown() {
		//student set mgmt co to null  
		p1=p2=p3=p4=p5=p6=null;
		mg1 = null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
	//fail("STUDENT test not implemented yet");
		
		
		//student should add property with 4 args & default plot (0,0,1,1)
		p4 = new Property("p4", "Cairo", 1500, "ziad");
		//student should add property with 8 args
		p5 = new Property("p5", "Montgomery Village", 1600, "Nermeen", 4, 4, 1, 1);
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1	
		p6 = new Property("p6", "City6", 1600, "ali", 10, 10, 5, 5);
		
		mg1.addProperty(p4);
		mg1.addProperty(p5);
		mg1.addProperty(p6);
	}
 
	@Test
	public void testMaxRentProp() {
		//fail("STUDENT test not implemented yet");
		
		//student should test if maxRentProp contains the maximum rent of properties
		assertEquals(mg1.maxRentProp(),1800.0,0);
	}

	@Test
	public void testTotalRent() {
		//fail("STUDENT test not implemented yet");
		//student should test if totalRent returns the total rent of properties
		assertEquals(mg1.totalRent(),4800.0,0);
	}

 }
