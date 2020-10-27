
public class ManagementCompany {

	// declare the class fields
	private final int MAX_PROPERTY = 5;
	private double mgmFeePer;
	private String name; 
	private String taxID;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private Property[] properties= new Property [MAX_PROPERTY];
	private Plot plot;
	private int numberOfElements = 0;
	
	//----------------------------------------------------sets methods
	public void setName(String name) {
		this.name= name;
	}
	 public void setTaxID(String taxID) {
		 this.taxID= taxID;
	 }
	public void setMgmFeePer(double mgmFeePer) {
		this.mgmFeePer= mgmFeePer;
	}
	public void setPlot(Plot p) {
		this.plot= p;
	}
	//----------------------------------------------------gets methods
	public String getName() {
		return name;
	}
	public String getTaxID() {
		return taxID;
	}
	public double getMgmFeePer() {
		return mgmFeePer;
	}
	public Plot getPlot() {
		return plot;
	}
	
	//constructors
	//empty constructor
	public ManagementCompany() {
		name="";
		taxID="";
		plot= new Plot(0,0,10,10);
		properties[0] = new Property();
		properties[1] = new Property();
		properties[2] = new Property();
		properties[3] = new Property();
		properties[4] = new Property();
	}
	//parameterized constructors
	public ManagementCompany(String name, String taxID, double mgmFee ) {
		this.name= name;
		this.taxID= taxID;
		this.mgmFeePer = mgmFee/100;
		plot= new Plot(0,0,10,10);
		properties[0] = new Property();
		properties[1] = new Property();
		properties[2] = new Property();
		properties[3] = new Property();
		properties[4] = new Property();
	}
	public ManagementCompany(String name, String taxID, double mgmFee, int x,int y , int width, int depth) {
		this.name= name;
		this.taxID= taxID;
		this.mgmFeePer = mgmFee/100;
		plot= new Plot(x,y,width,depth);
		properties[0] = new Property();
		properties[1] = new Property();
		properties[2] = new Property();
		properties[3] = new Property();
		properties[4] = new Property();
	}
	//copy constructor
	public ManagementCompany(ManagementCompany mg1 ) {
		this.name= mg1.name;
		this.taxID= mg1.taxID;
		this.mgmFeePer = mg1.mgmFeePer;
		this.plot= mg1.plot;
	}
	
	public boolean NoOverlap(Property p1)
	{
		for(int i = 0; i < numberOfElements; i++)
		{
			if (!p1.plot.overlaps(properties[i].plot))
				return false;
		}		
		return true;
	}
	
	
	// ------------------------------------------------------the addProperty methods
	public int addProperty(Property property) {
		Property p1 = new Property(property);
		if(numberOfElements < 5)
		{
			if (this.plot.encompasses(p1.plot) && NoOverlap(p1))
			{	
				properties[numberOfElements] = p1;
				numberOfElements++;
				return numberOfElements-1;
			}
		}		
		
		return numberOfElements;
	}
	public int addProperty(String name, String city, double rent, String owner){
		Property p1= new Property(name, city, rent, owner);
		if(numberOfElements < 5)
		{
			if (this.plot.encompasses(p1.plot) && NoOverlap(p1))
			{	
				properties[numberOfElements] = p1;
				numberOfElements++;
				return numberOfElements-1;
			}
		}		
		
		return numberOfElements;
	}
	
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth){
		Property p1= new Property(name, city, rent, owner, x, y, width, depth);
		if(p1 == null)
		{
			return -2;	
		}
		if(!this.plot.encompasses(p1.plot)) 
		{
			return -3;
		}
		if(!NoOverlap(p1))
		{
			return -4;
		}
		if(numberOfElements < 5)
		{
			if (this.plot.encompasses(p1.plot) && NoOverlap(p1))
			{	
				properties[numberOfElements] = p1;
				numberOfElements++;
				return numberOfElements-1;
			}
			return numberOfElements;
		}				
		else
		{
			return -1;
		}
	}
	
	public String displayPropertAtIndex(int i) {
		return properties[i].toString();
	}
	
	 public int getMAX_PROPERTY() {
		 return MAX_PROPERTY;
	 }
	
	public double maxRentProp() {
		double maxrent=0;
		for(int i=0; i<properties.length; i++) {
			if(properties[i].getRentAmount() > maxrent) 
			{
				maxrent = properties[i].getRentAmount();
			}
		}
		return maxrent;
	}
	
	
	public int maxRentPropertyIndex() {
		double maxrent=0; int y=-1;
		for(int i=0; i<properties.length; i++) {
			if(properties[i].getRentAmount()>maxrent ) {
				maxrent = properties[i].getRentAmount();
				y= i;
			}
		}
		return y;
	 }
	
	public double totalManagementFee() {
		double tfee=0;
		for(int i=0; i< properties.length; i++) {
			tfee += (mgmFeePer* properties[i].getRentAmount());
		}
		return tfee;
	}
	public String toString() {
		String s="List of the properties for "+name+", taxID: "+taxID+"\n";
		for(int i=0; i< properties.length; i++) {
			s += properties[i].toString();
		}
		s += ("\n total management Fee: "+ this.totalManagementFee());
		return s;
	}
	public double totalRent() {
		double totalrent=0.0;
		for(int i=0; i<numberOfElements; i++) {
				totalrent += properties[i].getRentAmount();
		}
		return totalrent;
	}
}