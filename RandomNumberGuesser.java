import java.util.Scanner;


	/*
	 * Class: CMSC203 
	 * Instructor: G.Grinberg
	 * Description: An application that recieve a guess and display if the guess of the random number generated
	 * Due: 9/27/2020
	 * I pledge that I have completed the programming assignment independently.
	   I have not copied the code from a student or any source.
	   I have not given my code to any student.
	   Print your Name here: Nermeen Saleh
	*/
public class RandomNumberGuesser {
	
 public static void main(String[] args) 
 {	 
	 Scanner keyboard = new Scanner(System.in);
	 String s;	 	
	 System.out.println("===========================================");
	 System.out.println("Welcome to the Random Number Guesser Game!");
	 System.out.println("===========================================");
	 do
	 {
		 // Create an instance of RNG class and reset count to 0
		 RNG rng = new RNG();
		 rng.resetCount();
		 
		 // nextGuess is used to track the value of the user's guess
		 int nextGuess=0;
		 
		 // lowGuess & highGuess will be used to maintain low and high limits
		 int lowGuess = 1;
		 int highGuess = 100;
		 
		 // Call rand to create a new random number between 1 & 100
		 int randNum = rng.rand();
		 
		 // guessRight is a bool used to check if user guessed the right number
		 boolean guessRight = false;
		 
		 System.out.println("Enter your first guess");
		 
		 //While loop will be executed as long as guess is not right
		 while(!guessRight)
		 {	
			 //Get user's guess
			 nextGuess= keyboard.nextInt();
			 
			 //check if the user's guess is equal to the randomly generated number
			 if(nextGuess == randNum)
			 {
				 System.out.println("Number of guesses is " + rng.getCount());
				 System.out.println("Congratulations, you guessed correctly");
				 //set bool guessRight to true to get out of the while loop
				 guessRight = true;
				 continue;
			 }
			 
			 // Check if the user's guess is inside the low-high range
			 if(rng.inputValidation(nextGuess, lowGuess, highGuess))
			 {
				 //Check if user's guess is lower/higher than the randomly generated number
				 if(nextGuess < randNum)
				 {
					 // if lower then set the low limit to the user's guess and continue to check again
					 lowGuess = nextGuess;
					 System.out.println("Number of guesses is " + rng.getCount());
					 System.out.println("Your guess is too low");
					 System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
					 continue;
				 }
				 else
				 {
					 // if higher then set the high limit to the user's guess and continue to check again
					 highGuess = nextGuess;
					 System.out.println("Number of guesses is " + rng.getCount());
					 System.out.println("Your guess is too high");
					 System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
					 continue;
				 }
			 }
			 else
			 {
				 //if user's input is outside of low-high range then decrement the guess count
				 rng.decrementCount();
				 continue;
			 }
			 
		 }
		 
		 //Ask user if they want to play again
		 System.out.println("Try again? (yes or no)");
		 s= keyboard.next();	 
			 
	 } while(s.equalsIgnoreCase("yes"));
	 
	 System.out.println("Thanks for playing...");
	 System.out.println("Programmed by: Nermeen Saleh");	 
 }

}
