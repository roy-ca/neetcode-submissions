class Solution {
    public boolean isValidSudoku(char[][] board) {
        //For Duplicate Check use hash set
        Set<String> set = new HashSet<>();

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char ch = board[i][j];

                if(ch == '.') {
                    continue;
                }

                String rowKey = "row" + i + ch;
                String columnKey = "column" + j + ch;
                String boxKey = "box" + (i/3) + (j/3) + ch;

                if(!set.add(rowKey) || !set.add(columnKey) || !set.add(boxKey)) {
                    return false;
                }
            }
        }
        return true;
    }
}
