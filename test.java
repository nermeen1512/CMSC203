
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ManagementCompany mg1;
		mg1 = new ManagementCompany("myManagementCompany" , "55555" , 6);
		
		Property p1,p2;
		
		int x = mg1.addProperty("p1", "Rockvile ", 1700, "amr", 1, 1, 3, 3);
		int y = mg1.addProperty("p2", "City4", 1300, "shehap", 2, 2, 1, 1);
		
		
		System.out.println(x);
		System.out.println(y);
		
		System.out.println(mg1.toString());
	}

}
