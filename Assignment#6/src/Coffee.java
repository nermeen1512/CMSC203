
public class Coffee extends Beverage{

	//----------------------------------------------------------------variables declaration
	boolean extraShot;
	boolean extraSyrup;
	final double EXTRA_COST= 0.5;
	
	//----------------------------------------------------------------the class constractor
	public Coffee(String n, SIZE s, boolean shot, boolean syrup) {
		super(n, TYPE.COFFEE, s);
		extraShot = shot;
		extraSyrup = syrup;
	}
	//----------------------------------------------------------------override to toString method
	public String toString() {
		String s=( "Coffee beverage: "+super.getBevName() + ", Size: "+ super.getSize() +", Extra shot: "+ extraShot + ", Extra Syrup: "+ extraSyrup+ "The price is: "+calcPrice());
		return s;
	}
    //----------------------------------------------------------------override to equals method
	public boolean equals(Coffee c) {
		boolean eq = false;
		if(super.equals(c) && extraShot == c.extraShot && extraSyrup== c.extraSyrup) {
			eq=true;
		}
		return eq;
	}
    //----------------------------------------------------------------override calcPrice
	public double calcPrice() {
		double price= super.BASE_PRICE;
		if(extraShot==true) {
			price+= EXTRA_COST;
		}
		if(extraSyrup==true) {
			price += EXTRA_COST;
		}
		if(super.getSize()==SIZE.MEDIUM){ 
			price += super.SIZE_PRICE;
		}
		else if (super.getSize()== SIZE.LARGE){
			price = price + (2*super.SIZE_PRICE) ;
		}
		return price;
	}
    //----------------------------------------------------------------get extraShot
	public boolean getExtraShot() {return extraShot;}
    //----------------------------------------------------------------get extraSyrup
	public boolean getExtraSyrup() {return extraSyrup;}
    //----------------------------------------------------------------set extraShot
	public void setExtraShot(boolean b) { extraShot=b;}
    //----------------------------------------------------------------set extraSyrup
	public void setExtraSyrup(boolean b) { extraSyrup=b;}
	//---------------------------------------------------------------get base price
	public double getBasePrice() { return 2.0;}
}
