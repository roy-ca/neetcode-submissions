class Pair {
    int first, second, steps;
    Pair(int first, int second, int steps) {
        this.first = first;
        this.second = second;
        this.steps = steps;
    }
}

class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] vis = new int[m][n];
        Queue<Pair> q = new LinkedList<>();

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 0){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }

        while(!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            int steps = q.peek().steps;

            q.remove();

            for(int i = 0; i < 4; i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && vis[newRow][newCol] == 0
                        && grid[newRow][newCol] == 2147483647) {
                            grid[newRow][newCol] = steps + 1;
                            vis[newRow][newCol] = 1;
                            q.add(new Pair(newRow, newCol, steps + 1));
                }
            }
        }
    }
}
