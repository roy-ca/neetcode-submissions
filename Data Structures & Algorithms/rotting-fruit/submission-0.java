class Pair {
    int first, second, time;

    public Pair(int first, int second, int time) {
        this.first = first;
        this.second = second;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][] visited = new int[row][col];

        Queue<Pair> q = new LinkedList<>();
        int freshOranges = 0;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = 2;
                }
                else if(grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,-1,0,1};
        int tm = 0;
        int c = 0;


        while(!q.isEmpty()) {
            int n = q.peek().first;
            int m = q.peek().second;
            int t = q.peek().time;

            tm = Math.max(tm, t);

            q.remove();

            for(int i = 0; i < 4; i++) {
                int nRow = n + delRow[i];
                int nCol = m + delCol[i];

                if(nRow >= 0 && nRow < row && nCol >= 0 && nCol < col 
                    && grid[nRow][nCol] == 1 && visited[nRow][nCol] == 0) {

                        q.add(new Pair(nRow, nCol, t+1));
                        visited[nRow][nCol] = 2;
                        c++;
                }
            }
        }
        if(c != freshOranges) {
            return -1;
        }
        return tm;
    }
}
