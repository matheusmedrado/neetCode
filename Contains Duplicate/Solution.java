import java.util.Arrays;
public class Solution {
    public boolean hasDuplicate(int[] nums) {

        if(nums==null){
            return false;
        }

        Arrays.sort(nums);
        int size = nums.length;
        for(int i = 0; i < size - 1; i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {1, 2, 3, 1};
        int[] nums3 = null;
        int[] nums4 = {};

        System.out.println(solution.hasDuplicate(nums1));
        System.out.println(solution.hasDuplicate(nums2));
        System.out.println(solution.hasDuplicate(nums3));
        System.out.println(solution.hasDuplicate(nums4));
    }
}
