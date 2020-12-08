	//----------------------------------------------------------------enum variables declaration
	enum TYPE {COFFEE, SMOOTHIE, ALCOHOL}
	enum SIZE{SMALL, MEDIUM , LARGE}

abstract class Beverage {
	//----------------------------------------------------------------enum variables declaration

	//----------------------------------------------------------------variables declaration
	  String bname;
	  TYPE btype;
	  SIZE bsize;
	final double BASE_PRICE = 2.0;
	final double SIZE_PRICE = 1.0;
	
	//----------------------------------------------------------------Class constructor
	public Beverage(String n, TYPE t, SIZE s) {
		bname= n;
		btype= t;
		bsize= s;
	}
	//----------------------------------------------------------------calcPrice method declaration
	public abstract double calcPrice();
	
	//----------------------------------------------------------------Overridding the toString method
	public String toString() {
		String s= "This:"+ bname +"beverage, Size is "+ bsize;
		return s;
	}
	//----------------------------------------------------------------overridding the equals method
	public boolean equals(Beverage b) {
		boolean eq = false;
		if(bname==b.bname && btype== b.btype && bsize == b.bsize) {
			eq=true;
		}
		return eq;
	}
	//----------------------------------------------------------------get name
	public String getBevName() {return bname;}
	//----------------------------------------------------------------get size
	public SIZE getSize() {return bsize;}
	//----------------------------------------------------------------get type
	public TYPE getType() {return btype;}
	//----------------------------------------------------------------set name
	public void getBevName(String n) { bname=n;}
	//----------------------------------------------------------------set size 
	public void setBsize(SIZE s) {bsize =s;}
	//----------------------------------------------------------------set type
	public void setBtype(TYPE t) {btype = t;}
}
