import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility {

	public static boolean isValidPassword(String passwordString) throws LengthException, NoDigitException, NoUpperAlphaException, NoLowerAlphaException,InvalidSequenceException, NoSpecialCharacterException
	{
		
		boolean d = false;
		boolean u = false ;
		boolean l = false;
		boolean seq = false;
		boolean sp = false;
		
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(passwordString);
		
		if(passwordString.length() > 5) 
		{
			for(int i=0; i < passwordString.length(); i++) 
			{
				
				if(Character.isUpperCase(passwordString.charAt(i)))
				{
					u = true;
				}
				else if(Character.isLowerCase(passwordString.charAt(i))) 
				{
					l = true;  
				}
				else if(Character.isDigit(passwordString.charAt(i)))
				{
					d = true; 
				}
				else if(!(matcher.matches()))
				{
					sp = true; 
				}
			}
			
			if(u == false) 
			{
				throw new NoUpperAlphaException(); 
			}
			else if (l == false) 
			{ 
				throw new NoLowerAlphaException();
			}
			else if(d==false )
			{ 
				throw new NoDigitException();
			}
			else if ( sp == false)
			{
				throw new NoSpecialCharacterException(); 
			}
			
			for(int i = ' '; i <= '~'; i++) 
			{
				 String invalidseq = "" + String.valueOf((char)i) + String.valueOf((char)i) + String.valueOf((char)i); 
				if(passwordString.contains(invalidseq)) 
				{
					seq = true;
				}
			}
			if (seq == true)
			{
				throw new InvalidSequenceException();	
			}else 
				{
					return true; 
				}
		}else 
			{
				throw new LengthException();   
			}
	}
	//------------------------------------------------------------------------------------------------------------------------------Methods for each password requirement
	
	
	//------------------------------------------------------------------------------------------------------------Method for length
	public static boolean isValidPasswordTooShort(String passwordString)
	{
		if((passwordString.length()>=6))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	//------------------------------------------------------------------------------------------------------------Method for digit
	 public static boolean isValidPasswordNoDigit(String passwordString)
	{
		int x=0;
		for(int i=0;i< passwordString.length();i++)
		{
			if(Character.isDigit(passwordString.charAt(i)))
			{
				x++;
			}
		}
		if (x>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	//------------------------------------------------------------------------------------------------------------Method for  upper case
	 static boolean isValidPasswordNoUpperAlpha(String passwordString)
	{
		int x=0;
		for(int i=0;i< passwordString.length();i++)
		{
			if(Character.isUpperCase(passwordString.charAt(i)))
			{
				x++;
			}
		}
		if (x>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	//------------------------------------------------------------------------------------------------------------Method for  lower case
	 static boolean isValidPasswordNoLowerAlpha(String passwordString)
	{
		int x=0;
		for(int i=0;i< passwordString.length();i++)
		{
			if(Character.isLowerCase(passwordString.charAt(i)))
			{
				x++;
			}
		}
		if (x>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	//------------------------------------------------------------------------------------------------------------Method for  Invalid sequence
	 static boolean isValidPasswordInvalidSequence(String passwordString) 
	{
		 boolean y= false;
		
		for(int i=0;i< passwordString.length();i++)
		{
			if(passwordString.charAt(i)== passwordString.charAt(i+1))
			{
				if(passwordString.charAt(i+1)== passwordString.charAt(i+2))
				{
					y=true;
				}
			}
		}
		if (y)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	
	//------------------------------------------------------------------------------------------------------------Method for special char.
	 static boolean isValidPasswordNoSpecialCharacter(String passwordString) 
	{
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(passwordString);
		return (!matcher.matches());
	}
	
	
	
	//------------------------------------------------------------------------------------------------------------Method for Weak passwords
	public static boolean isWeakPassword(String passwordString) 
	{
	
		if(passwordString.length()>=6 && passwordString.length()<10)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	//------------------------------------------------------------------------------------------------------------Method for getting the InvalidPassword
	public static ArrayList<String> getInvalidPasswords ( ArrayList<String> passwords) throws LengthException, NoDigitException, NoUpperAlphaException, NoLowerAlphaException, InvalidSequenceException, NoSpecialCharacterException 
	{
		ArrayList <String> invalid = new ArrayList<String>();
		
		for(int i=0; i<= passwords.size(); i++)
		{
				try
				{
					isValidPassword(passwords.get(i));
				}
				catch(LengthException e)
				{
					invalid.add(passwords.get(i)+" "+ e.getMessage()+ "\n");
				}
				catch(NoUpperAlphaException e)
				{
					invalid.add(passwords.get(i)+" "+ e.getMessage()+ "\n");
				}
				catch(NoLowerAlphaException e)
				{
					invalid.add(passwords.get(i)+" "+ e.getMessage()+ "\n");
				}
				catch(NoDigitException e)
				{
					invalid.add(passwords.get(i)+" "+ e.getMessage()+ "\n");
				}
				catch(NoSpecialCharacterException e)
				{
					invalid.add(passwords.get(i)+" "+ e.getMessage()+ "\n");
				}
				catch(InvalidSequenceException e)
				{
					invalid.add(passwords.get(i)+" "+ e.getMessage()+ "\n");
				}
		}
	
		
		return invalid;
	}
}
