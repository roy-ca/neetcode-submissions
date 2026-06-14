class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n != 1 ) {
            n = sumOfDigits(n);
            if(set.contains(n)) {
                return false;
            }
            else {
                set.add(n);
            }
        }
        return true;
    }

    int sumOfDigits(int n) {
        int sum = 0;
        while(n > 0) {
            int e = n % 10;
            sum = sum + e * e;
            n = n / 10;
        }
        return sum;
    }
}
