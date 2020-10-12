
//this class contain many methods that will work on encrypting and decrypting a string
// author: Nermeen Saleh
public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	//Check if the string is within the allowable bounds
	public static boolean stringInBounds (String plainText) {
		boolean inbound = true;
		//loop to check on each char in the string
		for(int position=0 ; position< plainText.length(); position++) {
			if(!(plainText.charAt(position) >= LOWER_BOUND && plainText.charAt(position) <= UPPER_BOUND))
				{
					inbound= false;
					return inbound;
				}				
		}
		return inbound;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	//This method encrypt a given string according to Caesar Cipher using a given key
	public static String encryptCaesar(String plainText, int key) {
		String encryptedString="";
		//loop to encrypt each char in the string
		if (stringInBounds(plainText))
		{
		for(int position=0; position<plainText.length(); position++) {
			char c= plainText.charAt(position);
			//set asci variable to the asci value of the new char
			int asci= ((int)c + key);
			//make sure that the asci value is within the range, adjust if not
			while ( asci> UPPER_BOUND) {
				asci -= RANGE;
			}
			//Add the encrypted char to the srting 
			encryptedString += (char)asci;
		}
		}
		//return the encrypted string
		return encryptedString;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	//This method encrypt a given string according to Bellaso using a given string
	public static String encryptBellaso(String plainText, String bellasoStr) {
		String encryptedString="";
		if (stringInBounds(plainText))
		{
		//loop to encrypt each char in the string
		for(int position=0; position<plainText.length(); position++) {
		char c= plainText.charAt(position);
		//set asci variable to the asci value of the new char
		int asci = ((int)c+ (int)bellasoStr.charAt(position%bellasoStr.length()));
		//make sure that the asci value is within the range, adjust if not
		while ( asci> UPPER_BOUND) {
			asci -= RANGE;
		}
		//Add the encrypted char to the srting 
		encryptedString += (char)asci;
	}}
	//return the encrypted string
	return encryptedString;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	
	//This method decrypt a given encrypted string according to Caesar Cipher using a given key
	public static String decryptCaesar(String encryptedText, int key) {
		String decryptedString="";
		//loop to decrypt each char in the string
		for( int p=0; p< encryptedText.length();p++) {
			char c= encryptedText.charAt(p);
			//set asci variable to the asci value of the original char
			int asci = ((int) c- key);
			//make sure that the asci value is within the range, adjust if not
			while(asci> UPPER_BOUND) {
				asci += RANGE;
			}
			//Add the decrypted char to the srting 
			decryptedString += (char)asci;
		}
		//return the decrypted string
		return decryptedString;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	//This method decrypt a given encrypted string according to Bellaso using a given string
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		String decryptedString="";
		//loop to decrypt each char in the string
		for( int p=0; p< encryptedText.length();p++) {
		char c= encryptedText.charAt(p);
		//set asci variable to the asci value of the original char
		int asci = ((int)c- (int)bellasoStr.charAt(p%bellasoStr.length()));
		//make sure that the asci value is within the range, adjust if not
		while(asci< LOWER_BOUND) {
			asci += RANGE;
		}
		//Add the decrypted char to the srting 
		decryptedString += (char)asci;
		}
		//return the decrypted string
		return decryptedString; 
		}
}
