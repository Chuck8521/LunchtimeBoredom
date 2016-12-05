import java.util.*;
import java.security.*;

public class HolidayCode5 {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		
		String input = "ojvtpuvg";
		String password = "";
		
		//System.out.println(input.indexOf("tpuv"));
		ArrayList<Character> truePassword = new ArrayList<Character>();
		for(int i = 0; i < 8; i++){
			truePassword.add(' ');
		}
		
		int number = 0;
		boolean solved = true;
		while(solved){
			
			//Find the next hash.			
			String toHash = input + number;
			byte[] bytesOfMessage = toHash.getBytes();
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] theDigest = md.digest(bytesOfMessage);
			String hex = bytesToHex(theDigest);
			
			//If hex starts with 5 zeros, the sixth digit is added to password
			//System.out.println(hex);
			
			//Now, sixth is position and seventh is character
			
			if(hex.indexOf("00000") == 0){
				
				char position = hex.charAt(5);
				if(position != 'A' && (position != 'B' && (position != 'C' && (position != 'D' && (position != 'E' && position != 'F'))))){
				
					int truePosition = Integer.parseInt(Character.toString(position));
					
					if(truePosition < 8){
						if(truePassword.get(truePosition) == ' '){
							truePassword.set(truePosition, hex.charAt(6));
							boolean done = true;
							for(int i = 0; i < 8; i++){
								if(truePassword.get(i) == ' '){
									done = false;
								}
							}
							if(done){
								System.out.println(truePassword.toString());
							}
						}
					}
					
				}
				
				
				//password += Character.toString(hex.charAt(5));
			}
			
			number++;
			if(number > 100000000){
				System.out.println("IT'S TOO FAR OVER 9000 STOPPPPPPPPP");
			}
		}
		
		System.out.println(password);
		
		
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
