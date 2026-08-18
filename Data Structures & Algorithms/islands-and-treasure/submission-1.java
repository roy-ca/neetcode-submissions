class Pair {
    int first, second, step;
    Pair(int first, int second, int step) {
        this.first = first;
        this.second = second;
        this.step = step;
    }
}

class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] vis = new int[m][n];
        Queue<Pair> queue = new LinkedList<>();

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    queue.add(new Pair(i, j, 0));
                }
            }
        }

        while(!queue.isEmpty()) {
            int first = queue.peek().first;
            int second = queue.peek().second;
            int step = queue.peek().step;

            queue.poll();

            for(int i = 0; i < 4; i++) {
                int newRow = first + delRow[i];
                int newCol = second + delCol[i];

                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n
                        && grid[newRow][newCol] == 2147483647 && vis[newRow][newCol] == 0) {
                            grid[newRow][newCol] = step + 1;
                            vis[newRow][newCol] = 1;
                            queue.add(new Pair(newRow, newCol, step + 1));
                }
            }
        }
    }
}
