
public class NoUpperAlphaException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public NoUpperAlphaException()
	{
		super("The password must contain at least one uppercase alphabetic character");
	}
	
}
