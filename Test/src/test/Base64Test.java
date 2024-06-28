package test;

import java.util.Base64;

public class Base64Test {
    public static void main(String[] args){
        
        String originalInput = "test input";
//        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
        String encodedString = 
        Base64.getEncoder().withoutPadding().encodeToString(originalInput.getBytes());
        
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);
        
        System.out.println("Original input: "+originalInput);
        System.out.println("Encode text: "+encodedString);
        System.out.println("Decode text: "+decodedString);
    }
}
