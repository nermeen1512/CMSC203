
public class InvalidSequenceException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public InvalidSequenceException()
	{
		super("The password cannot contain more than two of the same character in sequence");
	}
}
