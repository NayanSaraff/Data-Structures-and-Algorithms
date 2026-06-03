class Solution {
    public int search(int[] nums, int target) {
     int left = 0, right = nums.length-1;
    for(int i=0;i<nums.length;i++)
    {
        int mid = (left + right)/2;

        if (nums[mid] == target)
            return mid;
        else if(target > nums[mid])
            left = mid + 1;
        else
            right = mid - 1;
    } 
    return -1;  
}
}
