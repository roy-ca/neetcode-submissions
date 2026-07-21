class Pair {
    int first, second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int maxArea = 0;

        int[][] visited = new int[row][col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                int area = 0;
                if(grid[i][j] == 1 && visited[i][j] == 0) {
                   area = bfs(i, j, grid, visited);
                   maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int bfs(int row, int col, int[][] grid, int[][] visited) {
        int area = 1;
        visited[row][col] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));

        int n = grid.length;
        int m = grid[0].length;

        while(!q.isEmpty()) {
            int first = q.peek().first;
            int second = q.peek().second;

            q.remove();

            for(int delRow = -1; delRow <= 1; delRow++) {
               for(int delCol = -1; delCol <=1; delCol++) {
                    int nRow = first + delRow;
                    int nCol = second + delCol;

                    if (Math.abs(delRow) == Math.abs(delCol)) continue;

                    if(nRow >= 0 && nRow < n && nCol >=0 && nCol < m
                        && grid[nRow][nCol] == 1 && visited[nRow][nCol] == 0) {
                            visited[nRow][nCol] = 1;
                            q.add(new Pair(nRow, nCol));
                            area++;
                    }
                }
            }
        }
        return area;
    }
}
