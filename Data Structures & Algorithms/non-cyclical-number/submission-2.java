class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visitedNum = new HashSet<>();
        while(n > 1) {
            if(visitedNum.contains(n)) {
                return false;
            }
            visitedNum.add(n);
            n = getDigitsSquare(n);
        }
        return true;
    }

    private int getDigitsSquare(int num) {
        int sum = 0;
        while(num > 0) {
            int e = num % 10;
            sum = sum + e * e;
            num = num / 10;
        }
        return sum;
    }
}
