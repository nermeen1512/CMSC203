
public class Customer {

	//----------------------------------------------------------------variables declaration
	String name;
	int age;

	//----------------------------------------------------------------the class constructor
	public Customer(String n, int a) {
		name=n;
		age=a;
	}
	//----------------------------------------------------------------the copy constructor
	public Customer(Customer c) {
		name= c.name;
		age = c.age;
	}
	//----------------------------------------------------------------override to toString
	public String toString() {
		String s=("Customer's name is: "+name +" ,age is: "+age);
		return s;
	}
	//----------------------------------------------------------------get name
	public String getName() {return name;}
	//----------------------------------------------------------------get age
	public int getAge() {return age;}
	//----------------------------------------------------------------set name
	public void setName(String n) {name= n;}
	//----------------------------------------------------------------set age
	public void setAge(int i) {age=i;}
}
