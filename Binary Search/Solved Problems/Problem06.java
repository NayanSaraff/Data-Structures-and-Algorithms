class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int left = 0,right = 0;

        for(int weight:weights)
        {
            left = Math.max(left,weight);
            right += weight;
        }

        int ans = right;

        while(left <= right)
        {
            int mid = left + (right-left)/2;

            int daysneeded = 1;
            int capacity = 0;

            for(int wgt:weights)
            {
                if(capacity + wgt <= mid)
                {
                    capacity += wgt;
                }
                else
                {
                    daysneeded++;
                    capacity = wgt;
                }
            }

            if(daysneeded <= days)
            {
                ans = mid;
                right = mid-1;
            }
            else
                left = mid + 1;
        }
        return ans;
    }
}
