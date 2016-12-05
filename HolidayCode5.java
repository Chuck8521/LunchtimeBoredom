import java.util.*;
import java.security.*;

public class HolidayCode5 {

	public static void main(String[] args) {
		
		String input = "ojvtpuvg";
		String password = "";
		
		int number = 0;
		while(password.length() < 8){
			
			//Find the next hash.			
			String toHash = input + number;
			byte[] bytesOfMessage = toHash.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] theDigest = md.digest(bytesOfMessage);
			String hex = bytesToHex(theDigest);
			
			
			
			number++;
			
		}
		
		
	}
	
	final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
	public static String bytesToHex(byte[] bytes) {
    	char[] hexChars = new char[bytes.length * 2];
    	for ( int j = 0; j < bytes.length; j++ ) {
        	int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = hexArray[v >>> 4];
    	    hexChars[j * 2 + 1] = hexArray[v & 0x0F];
    	}
    return new String(hexChars);
	}

}

