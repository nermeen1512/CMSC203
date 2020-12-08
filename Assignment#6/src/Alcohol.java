
public class Alcohol extends Beverage{

	//----------------------------------------------------------------variables declaration
	boolean offeredWE;
	final double WEDRINK_COST = 0.6; 
	
	//----------------------------------------------------------------the class constractor
	public Alcohol(String n, SIZE s, boolean o){
		super(n, TYPE.ALCOHOL, s);
		offeredWE = o;
	}
	//----------------------------------------------------------------override to toString method
	public String toString() {
		String s=( "Smoothie beverage: "+super.getBevName() + ", Size: "+ super.getSize() +", Offered in hte weekend: "+ offeredWE + ",Price "+calcPrice());
		return s;
	}
    //----------------------------------------------------------------override to equals method
	public boolean equals(Alcohol a) {
		boolean eq = false;
		if(super.equals(a) && offeredWE== a.offeredWE) {
			eq=true;
		}
		return eq;
	}
	//----------------------------------------------------------------override calcPrice
	public double calcPrice() {
		double price= super.BASE_PRICE;
		if(offeredWE==true) {
			price+= WEDRINK_COST;
		}
		if(super.getSize()==SIZE.MEDIUM){ 
			price += super.SIZE_PRICE;
		}
		else if (super.getSize()== SIZE.LARGE){
			price = price + (2*super.SIZE_PRICE) ;
		}
		//check on  weekend
		return price;
	}
	 //----------------------------------------------------------------get offeredWE
	public boolean getOfferedWE() {return offeredWE;}
	 //----------------------------------------------------------------set Protein Powder
	public void setOfferedWE(boolean b) {offeredWE =b;}
	//---------------------------------------------------------------get base price
	public double getBasePrice() { return 2.0;}
}
