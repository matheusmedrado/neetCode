import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;

class Solution {
    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        
        for(String str : strs) {
            String encoded = Base64.getEncoder().encodeToString(str.getBytes());
            result.append(encoded);
            if(result.length() > encoded.length()) { // não é a primeira
                result.insert(result.length() - encoded.length(), ",");
            }
        }
        
        StringBuilder betterResult = new StringBuilder();
        for(String str : strs) {
            betterResult.append(str.length()).append("#").append(str);
        }
        
        return betterResult.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        
        int i = 0;
        while(i < str.length()) {
            int delimiterIndex = str.indexOf('#', i);
            
            int length = Integer.parseInt(str.substring(i, delimiterIndex));
            
            String originalString = str.substring(delimiterIndex + 1, delimiterIndex + 1 + length);
            result.add(originalString);
            
            i = delimiterIndex + 1 + length;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();

        //Here are some test cases to test the code
        
        // Test case 1: Normal strings
        List<String> strs1 = Arrays.asList("hello", "world");
        String encoded1 = solution.encode(strs1);
        List<String> decoded1 = solution.decode(encoded1);
        System.out.println("Test 1:");
        System.out.println("Original: " + strs1);
        System.out.println("Encoded: " + encoded1);
        System.out.println("Decoded: " + decoded1);
        System.out.println("Match: " + strs1.equals(decoded1));
        System.out.println();
        
        // Test case 2: Empty strings and special characters
        List<String> strs2 = Arrays.asList("", "a", "#", "hello#world");
        String encoded2 = solution.encode(strs2);
        List<String> decoded2 = solution.decode(encoded2);
        System.out.println("Test 2:");
        System.out.println("Original: " + strs2);
        System.out.println("Encoded: " + encoded2);
        System.out.println("Decoded: " + decoded2);
        System.out.println("Match: " + strs2.equals(decoded2));
        System.out.println();
        
        // Test case 3: Numbers as strings
        List<String> strs3 = Arrays.asList("123", "456", "789");
        String encoded3 = solution.encode(strs3);
        List<String> decoded3 = solution.decode(encoded3);
        System.out.println("Test 3:");
        System.out.println("Original: " + strs3);
        System.out.println("Encoded: " + encoded3);
        System.out.println("Decoded: " + decoded3);
        System.out.println("Match: " + strs3.equals(decoded3));
        System.out.println();
        
        // Test case 4: Single string
        List<String> strs4 = Arrays.asList("single");
        String encoded4 = solution.encode(strs4);
        List<String> decoded4 = solution.decode(encoded4);
        System.out.println("Test 4:");
        System.out.println("Original: " + strs4);
        System.out.println("Encoded: " + encoded4);
        System.out.println("Decoded: " + decoded4);
        System.out.println("Match: " + strs4.equals(decoded4));
        System.out.println();
        
        // Test case 5: Empty list
        List<String> strs5 = new ArrayList<>();
        String encoded5 = solution.encode(strs5);
        List<String> decoded5 = solution.decode(encoded5);
        System.out.println("Test 5:");
        System.out.println("Original: " + strs5);
        System.out.println("Encoded: " + encoded5);
        System.out.println("Decoded: " + decoded5);
        System.out.println("Match: " + strs5.equals(decoded5));
    }
}
