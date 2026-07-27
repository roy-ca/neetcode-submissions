class Solution {
    public double myPow(double x, int n) {
       double ans = 1.0;
       int pow = n;
       n = Math.abs(n);
       

       while(n > 0) {
            if(n % 2 == 0) {
                x = x * x;
                n = n / 2;
            }
            else {
                ans = ans * x;
                n = n - 1;
            }
       }

       if(pow < 0) {
            return 1/ans;
       }
       return ans;
    }
}
