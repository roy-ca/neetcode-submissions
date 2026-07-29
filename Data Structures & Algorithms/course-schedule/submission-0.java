class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] preq: prerequisites) {
            adjList.get(preq[1]).add(preq[0]);
        }

        //For directed graph, we need visited and path visited array are required

        int[] visited = new int[numCourses];
        int[] pathVis = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            if(visited[i] == 0) {
               if(dfs(i, adjList, visited, pathVis) == true)
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, List<List<Integer>> adjList, int[] vis, int[] pathVis) {
        vis[node] = 1;
        pathVis[node] = 1;

        for(int n: adjList.get(node)) {
            if(vis[n] == 0) {
                if(dfs(n, adjList, vis, pathVis) == true)
                    return true; 
            }
            else if(pathVis[n] == 1) {
                return true;
            }
        }
        pathVis[node] = 0;
        return false;
    }
}
