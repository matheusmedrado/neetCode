import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length() || s == null || t == null){
            return false;
        }

        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();

        Arrays.sort(charsS);
        Arrays.sort(charsT);
        
        return Arrays.equals(charsS, charsT);

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s1 = "anagram", t1 = "nagaram";
        String s2 = "rat", t2 = "car";
        System.out.println("Test 1: " + sol.isAnagram(s1, t1)); // true
        System.out.println("Test 2: " + sol.isAnagram(s2, t2)); // false
    }
}

