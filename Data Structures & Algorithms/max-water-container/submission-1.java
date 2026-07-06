class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int l = 0;
        int r = heights.length - 1;

        while(l < r) {
            int height = Math.min(heights[l], heights[r]);
            int width = r - l;

            int area = height * width;

            maxArea = Math.max(area, maxArea);

            if(heights[l] < heights[r]) {
                l++;
            }
            else {
                r--;
            }
        }
        return maxArea;
    }
}
