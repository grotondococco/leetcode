
public class Solution896 {

    public boolean isMonotonic(int[] nums) {
        boolean crescent = false;
        boolean decrescent = false;
        boolean flat = true;
        if (nums.length == 1) return flat;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                crescent = true;
                flat = false;
                if (decrescent) return false;
            }
            if (nums[i - 1] > nums[i]) {
                decrescent = true;
                flat = false;
                if (crescent) return false;
            }
            if (i == nums.length - 1 && flat) return true;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{6, 5, 4, 4};
        System.out.println(new Solution896().isMonotonic(nums));
    }

}