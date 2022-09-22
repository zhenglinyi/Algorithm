package nb.leetcode;

import java.util.PriorityQueue;

public class _695 {
}

class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int m=grid.length;
        int n=grid[0].length;
        int res=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1){
                    res=Math.max(res,dfs(grid,i,j));
                }
            }
        }
        return res;

    }

    int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return 0;
        if (grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        return dfs(grid, i - 1, j)
                + dfs(grid, i + 1, j)
                + dfs(grid, i, j - 1)
                + dfs(grid, i, j + 1)
                + 1;

    }
}
