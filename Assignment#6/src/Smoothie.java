

public class Smoothie extends Beverage{

	//----------------------------------------------------------------variables declaration
	int noOfFruits;
	boolean proteinPowder;
	final double PP_COST=1.5;
	final double AF_COST= 0.5;

	//----------------------------------------------------------------the class constractor
	public Smoothie(String n, SIZE s, int i, boolean pp){
		super(n, TYPE.SMOOTHIE, s);
		noOfFruits = i;
		proteinPowder = pp;
	}

	//----------------------------------------------------------------override to toString method
	public String toString() {
		String s=( "Smoothie beverage: "+super.getBevName() + ", Size: "+ super.getSize() +", Protien Poweder: "+ proteinPowder + ", Number of fruits: "+ getNumOfFruits() + ",Price "+calcPrice());
		return s;
	}
    //----------------------------------------------------------------override to equals method
	public boolean equals(Smoothie s) {
		boolean eq = false;
		if(super.equals(s) && noOfFruits == s.noOfFruits && proteinPowder== s.proteinPowder) {
			eq=true;
		}
		return eq;
	}
	 //----------------------------------------------------------------override calcPrice
		public double calcPrice() {
			double price= super.BASE_PRICE + ((noOfFruits)*AF_COST);
			if(proteinPowder==true) {
				price+= PP_COST;
			}
			if(super.getSize()==SIZE.MEDIUM){ 
				price += super.SIZE_PRICE;
			}
			else if (super.getSize()== SIZE.LARGE){
				price = price + (2*super.SIZE_PRICE) ;
			}
			return price;
		}
	    //----------------------------------------------------------------get number of fruits
		public int getNumOfFruits() {return noOfFruits;}
	    //----------------------------------------------------------------get Protein Powder
		public boolean getAddProtien() {return proteinPowder;}
	    //----------------------------------------------------------------set Protein Powder
		public void setProteinPowder(boolean b) {proteinPowder =b;}
	    //----------------------------------------------------------------set number of fruits
		public void setNoOfFruits(int i) {noOfFruits =i;}
		//---------------------------------------------------------------get base price
		public double getBasePrice() { return 2.0;}
}
