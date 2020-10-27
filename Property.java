
public class Property {
	// declaring the class fields
	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	public Plot plot;
	
	
	//the constructors
	//empty constructor
	public Property(){
		city="";
		owner= "";
		propertyName="";
		rentAmount=0.0;
		plot= new Plot(0,0,1,1);
	}
	// copy constructor
	public Property(Property p) {
		this.city= p.city;
		this.owner = p.owner;
		this.propertyName = p.propertyName;
		this.rentAmount = p.rentAmount;
		this.plot = p.plot;
	}
	//parameterized constructors
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.city = city;
		this.owner = owner;
		this.propertyName = propertyName;
		this.rentAmount = rentAmount;
		plot = new Plot(0,0,1,1);
	}
	public Property(String propertyName, String city, double rentAmount, String owner, int x,int y,int width, int depth) {
		this.city = city;
		this.owner = owner;
		this.propertyName = propertyName;
		this.rentAmount = rentAmount;
		plot= new Plot( x, y, width, depth);	
	}	
	
	
	
	
	//------------------------------------------------------------------the set methods
	public void setCity(String city1) {
		city = city1;
	}
	public void setOwner(String owner1) {
		owner = owner1;
	}
	public void setPropertyName(String propname) {
		propertyName = propname;
	}
	public void setRentAmount(double amount) {
		rentAmount = amount;
	}
	public Plot setPlot(int x, int y, int width, int depth) {
	    Plot p = new Plot(x,y,width,depth); 	
		return p;
	}

	
	
	
	//-------------------------------------------------------------------the get methods
	public String getCity() {
		return city;
	}
	public String getOwner() {
		return owner;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public double getRentAmount() {
		return rentAmount;
	}
	public Plot getPlot() {
		return plot;
	}
	
	
	//the toString method 
	public String toString() {
		String s = "Property Name: "+ propertyName + "\nLocated in "+ city+ "\nBelonging to: "+ owner+ "\nRent Amount: "+ rentAmount+"\n";
		
		return s;
	}
	
}
