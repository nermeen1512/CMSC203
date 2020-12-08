import java.util.ArrayList;
import java.util.Random;
enum DAY {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}


public class Order implements OrderInterface {

	//---------------------------------------------------------------------------------------------------------------------variables declaration
	int orderNo;
	int orderTime;
	DAY orderDay;
	Customer c;
	ArrayList<Beverage> list= new ArrayList<Beverage>();

	//---------------------------------------------------------------------------------------------------------------------set list	
	//---------------------------------------------------------------------------------------------------------------------get list
	
	
	//---------------------------------------------------------------------------------------------------------------------the class constructor 
	public Order(int t, DAY d,Customer c1) {
		orderTime=t;
		orderDay= d;
		c= c1;
		this.setOrderNo(generateRandom());
	}

	//-----------------------------------------------------------------------------------------------------------------method of random number generator
	public static int generateRandom() {
	    Random r = new Random();
	    int no= 10000 + r.nextInt(80001);
	    return no;
	}
	
	//----------------------------------------------------------------------------------------------------------------Override to the toString method
	public String toString() {
		String s=("Order Number is: "+ getOrderNo() +"\n Time is: "+getOrderTime()+", Day is: "+getOrderDay()+ "\n Customer name: "+ c.getName());
		for(int i=0; i < list.size();i++) {
			s += "\n"+list.get(i).toString();
		}
		s+= calcOrderTotal();
		return s;
	}

	//----------------------------------------------------------------------------------------------------------------Override to the CompareTo method
	public int compareTo(Order o1) {
		if(orderNo == o1.getOrderNo()) {
			return 0;
		}
		else if( orderNo < o1.orderNo) {
			return -1;
		}
		else {
			return 1;
		}
		
	}
	//---------------------------------------------------------------------------------------------------------------------get order number
	public int getOrderNo() {return orderNo;}
	
	//---------------------------------------------------------------------------------------------------------------------get order Time
	public int getOrderTime() {return orderTime;}
	
	//---------------------------------------------------------------------------------------------------------------------get order Day
	public DAY getOrderDay() {return orderDay;}
	
	//---------------------------------------------------------------------------------------------------------------------set order number
	public void setOrderNo(int i) {orderNo=i;}
	
	//---------------------------------------------------------------------------------------------------------------------set order Time
	public void setOrderTime(int i) {orderTime=i;}
	
	//---------------------------------------------------------------------------------------------------------------------set order Day
	public void setOrderTime(DAY d) {orderDay=d;}
	
	//---------------------------------------------------------------------------------------------------------------------get customer
	public Customer getCustomer() {return new Customer(c);}

	//---------------------------------------------------------------------------------------------------------------------set customer
	public void setCustomer(Customer c1) {c= c1;}

	//-------------------------------------------------------------------------------------------------------------Check if it's weekend
	@Override
	public boolean isWeekend() {
		boolean ans= false;
		if(orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY) {
			ans = true;
		}
		return ans;
	}
	
	//------------------------------------------------------------------------------------------------------------------------------get beverage
	@Override
	public Beverage getBeverage(int itemNo) {
		Beverage b= list.get(itemNo);
		return b;
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------Add Coffee
	@Override
	public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		Coffee c= new Coffee(bevName, size,extraShot, extraSyrup);
		list.add(c);
	}
	//-------------------------------------------------------------------------------------------------------------------------------Add Alcohol
	@Override
	public void addNewBeverage(String bevName, SIZE size) {

		Alcohol c= new Alcohol(bevName, size, false);
		list.add(c);
	}
	//------------------------------------------------------------------------------------------------------------------------------Add Smoothie
	@Override
	public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addPRotien) {
		Smoothie s= new Smoothie(bevName,size, numOfFruits, addPRotien);
		list.add(s);
	}

	//---------------------------------------------------------------------------------------------------------------------calculate the total price
	@Override
	public double calcOrderTotal() {
		double totalPrice=0.0;
		for(int i=0; i< list.size(); i++) {
			totalPrice += list.get(i).calcPrice();
			if(isWeekend() && list.get(i).getType() == TYPE.ALCOHOL) { totalPrice += 0.6;}
		}
		
		return totalPrice;
	}
	
	//----------------------------------------------------------------------------------------------------------find number of beverages of certain type 
	@Override
	public int findNumOfBeveType(TYPE type) {
		int num=0;
		for(int i=0; i<list.size();i++) {
			if (list.get(i).getType()== type) {
				num ++;
			}
		}
		return num;
	}
	//--------------------------------------------------------------------------------------------------------Find total items
	public int getTotalItems() {
		return list.size();
	}

}
