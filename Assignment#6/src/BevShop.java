import java.util.ArrayList;
import java.util.Random;

public class BevShop implements BevShopInterfce {

	//---------------------------------------------------------------------------------------------------------------------variables declaration
	int noOfAlcohol;
	final int MAX_NO_ALCOHOL =3;
	ArrayList<Order> orderList = new ArrayList<Order>();
	final int MIN_AGE = 21;
	Order current;
	String s;

	//--------------------------------------------------------------------------------------------------------------------------override to toString method
	public String toString() {
		s = s + this.totalMonthlySale();
	    return s;
	}
	
	
	//---------------------------------------------------------------------------------------------------------------------Check on time validity
	@Override
	public boolean validTime(int time) {
		boolean valid =false;
		if(time >=8 && time <=23) {
			valid= true;
		}
		return valid;
	}
	//---------------------------------------------------------------------------------------------------------------------Check on Alcohol validity
	@Override
	public boolean eligibleForMore() {
		boolean valid=false;
		if(noOfAlcohol< 3) {
			valid=true;
		}
		return valid;
	}

	//---------------------------------------------------------------------------------------------------------------------Check on age validity
	@Override
	public boolean validAge(int age) {
		boolean valid=false;
		if(age>21) {
			valid=true;
		}
		return valid;
	}
	
	// to make the order number 
	public static int generateRandom() {
	    Random r = new Random();
	    int no= 10000 + r.nextInt(80001);
	    return no;
	}

	//---------------------------------------------------------------------------------------------------------------------Making new order
	@Override
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		Customer c1= new Customer(customerName, customerAge);
		current = new Order(time, day, c1);
		orderList.add(current);
		noOfAlcohol = 0;
		s = s + customerName + current.getOrderNo();
	}
	
	
	//---------------------------------------------------------------------------------------------------------------------add new coffee to order
	@Override
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		current.addNewBeverage(bevName, size, extraShot, extraSyrup);
		s = s + bevName + size;
	}

	//---------------------------------------------------------------------------------------------------------------------add new Alcohol to order
	@Override
	public void processAlcoholOrder(String bevName, SIZE size) {
		if(noOfAlcohol < 3)
		{
			current.addNewBeverage(bevName, size);
			s = s + bevName + size;
			noOfAlcohol++;
		}
	}

	//---------------------------------------------------------------------------------------------------------------------add new smoothie  to order
	@Override
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
		current.addNewBeverage(bevName, size, numOfFruits, addProtien);
		s = s + bevName + size;
	}

	//--------------------------------------------------------------------------------------------------------------------------find location of order
	@Override
	public int findOrder(int orderNo) {
		int out = 0;
		for(int i=0; i< orderList.size(); i++) {
			if(orderList.get(i).getOrderNo()==orderNo) {
				out = i;
			}
		}
		return out;
	}
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public double totalOrderPrice(int orderNo) {
		double out = 0.0;
		for(int i=0; i< orderList.size(); i++) 
		{
			if(orderList.get(i).getOrderNo()==orderNo) 
			{
				out = orderList.get(i).calcOrderTotal();
			}
		}
		return out;
	}

	@Override
	public double totalMonthlySale() {
		double out = 0.0;
		for(int i=0; i< orderList.size(); i++) 
		{
			out += orderList.get(i).calcOrderTotal();
		}
		return out;
	}

	@Override
	public void sortOrders() {
		 /*int startScan, index, minIndex, minValue;
		 for (startScan = 0; startScan < (orderList.size()-1) ; startScan++)
		  {
			 minIndex = startScan;
			 minValue = orderList.get(startScan).getOrderNo();
			 for(index= startScan+1; index< orderList.size(); index++)
			 {
				 if(orderList.get(index).getOrderNo()< minValue)
				 {
					 minValue = orderList.get(index).getOrderNo();
					 minIndex = index;
				 }
			 }
			 orderList.set(minIndex,orderList.get(startScan));
			 orderList.set(startScan, orderList.get(index));
		  }*/
		
		for (int i = 0; i < orderList.size(); i++) {
            int pos = i;
            for (int j = i; j < orderList.size(); j++) {
                if (orderList.get(j).getOrderNo() < orderList.get(pos).getOrderNo())
                    pos = j;
            }
            orderList.set(pos, orderList.get(i));
            orderList.set(i, orderList.get(pos));
        }
		
	}

	@Override
	public Order getOrderAtIndex(int index) {
		
		return orderList.get(index);
	}
	
	public Order getCurrentOrder()
	{
		return current;
	}
	
	public int getNumOfAlcoholDrink()
	{
		return noOfAlcohol;
	}
	
	public int totalNumOfMonthlyOrders()
	{
		return orderList.size();
	}
	
	public boolean isMaxFruit(int i)
	{
		if(i <= MAX_FRUIT)
		{
			return true;
		}
		return false;	
	}
	
	public int getMaxOrderForAlcohol()
	{
		return MAX_NO_ALCOHOL;
	}
	
	public int getMinAgeForAlcohol()
	{
		return MIN_AGE;
	}
}
