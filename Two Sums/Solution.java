import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> complements = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            Integer complementIndex = complements.get(nums[i]);
            if(complementIndex != null){
                int[] newNums = new int[]{i, complementIndex};
                Arrays.sort(newNums);
                return newNums;
            }
            complements.put(target - nums[i], i);
        }

        return nums;
    }


    public static void main(String[] args){
        Solution solver = new Solution();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solver.twoSum(nums, target);
        System.out.println("Result: [" + result[0] + ", " + result[1] + "]");
    }
}


