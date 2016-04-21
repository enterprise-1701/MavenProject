package automationFramework.Utilities;
import java.util.Random;

public class RandomEmail {
	
	//Declaring constants
	private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMONOPQRSTUWXYZ1234567890";
	private static final int LENGTH = 15; 
	
	
	//Generating random string
	public String generateRandomString(){
		StringBuffer randStr = new StringBuffer();
		for(int i=0; i<LENGTH; i++){
			int number = getRandomNumber();
			char ch = CHAR_LIST.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();
	}
	
	//Private method to generate random number
	public int getRandomNumber(){
		int randomInt = 0;
		Random randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(CHAR_LIST.length());
		if(randomInt - 1 == -1){
			return randomInt;
		} else{
			return randomInt -1;
		}
	}

}
