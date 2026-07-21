class Pair {
    int first, second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][] visited = new int[row][col];
        int count = 0;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == '1' && visited[i][j] == 0) {
                    bfs(i, j, grid, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(int row, int col, char[][] grid, int[][] visited) {
        visited[row][col] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));

        int n = grid.length;
        int m = grid[0].length;

        while(!q.isEmpty()) {
            int r = q.peek().first;
            int c = q.peek().second;
            q.remove();

            for(int delRow = -1; delRow <= 1; delRow++) {
                for(int delCol = -1; delCol <= 1; delCol++) {
                    if (Math.abs(delRow) == Math.abs(delCol)) continue;
                    int nRow = r + delRow;
                    int nCol = c + delCol;

                    if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == '1' && visited[nRow][nCol] == 0) {
                        visited[nRow][nCol] = 1;
                        q.add(new Pair(nRow, nCol));
                    }
                }
            }
        }
    }
}
