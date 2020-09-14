import java.util.Scanner;

public class WiFiDiagnosis {
	public static void main(String[] args)
	{	Scanner keyboard = new Scanner(System.in);
	    String ans;
		System.out.println("If you have a problem with internet connectivity, this WiFi Diagnosis might work.");
		System.out.println();
		System.out.println("First step: reboot your computer");
		System.out.println("Are you able to connect with the internet? (yes or no)");
		ans= keyboard.next();

		if(ans.equalsIgnoreCase("yes"))
		{ System.out.println("Rebooting your computer seemed to work");
		}
		else
		{
			System.out.println("Second step: reboot your router");
			System.out.println("Are you able to connect with the internet? (yes or no)");
			ans= keyboard.next();
			if(ans.equalsIgnoreCase("yes"))
			{ System.out.println("Rebooting your router seemed to work");}
			else
			{
				System.out.println("Third step: make sure the cables to your router are plugged in firmly and your router is getting power");
				System.out.println("Now are you able to connect with the internet? (yes or no)");
				ans= keyboard.next();
				if(ans.equalsIgnoreCase("yes"))
				{ System.out.println("Checking the router's cables seemed to work");}
				else
				{
					System.out.println("Fourth step: move your computer closer to your router");
					System.out.println("Now are you able to connect with the internet? (yes or no)");
					ans= keyboard.next();
					if(ans.equalsIgnoreCase("yes"))
					{ System.out.println("Your distance now seemed to work");}
					else
					{
						System.out.println("Fifth step: contact your ISP");
						System.out.println("Make sure your ISP is hooked up to your router.");
					}
				}
			}
		
		}
		
	}
}
