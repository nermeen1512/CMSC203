
public class NoLowerAlphaException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public NoLowerAlphaException()
	{
		super("The password must contain at least one lowercase alphabetic character");
	}
	
}
