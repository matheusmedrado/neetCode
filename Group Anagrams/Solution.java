import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Solution{
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();

        for(String str: strs){
            char[] chArr = str.toCharArray();
            Arrays.sort(chArr);
            String key = new String(chArr);

            if(map.containsKey(key)){
                map.get(key).add(str);
            }

            else{
                List<String> strList = new ArrayList<>();
                strList.add(str);
                map.put(key, strList);
            }
        }

        result.addAll(map.values());
        return result;
        
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        String[] test1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Test 1: " + Arrays.toString(test1));
        List<List<String>> result1 = solution.groupAnagrams(test1);
        System.out.println("Result: " + result1);
        System.out.println();
        
        String[] test2 = {"", "b", "a", "ab", "ba"};
        System.out.println("Test 2: " + Arrays.toString(test2));
        List<List<String>> result2 = solution.groupAnagrams(test2);
        System.out.println("Result: " + result2);
        System.out.println();
        
        String[] test3 = {"abc", "bca", "cab", "xyz", "zyx", "yxz"};
        System.out.println("Test 3: " + Arrays.toString(test3));
        List<List<String>> result3 = solution.groupAnagrams(test3);
        System.out.println("Result: " + result3);
        System.out.println();
        
        String[] test4 = {"hello"};
        System.out.println("Test 4: " + Arrays.toString(test4));
        List<List<String>> result4 = solution.groupAnagrams(test4);
        System.out.println("Result: " + result4);
    }
}

