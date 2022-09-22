package nb.leetcode;

public class _1254 {
}

class Solution {
    public int closedIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        //先把边界的岛给淹了
        for (int i = 0; i < m; i++) {
            dfs(i,0,grid);
            dfs(i,n-1,grid);
        }
        for (int i = 0; i < n; i++) {
            dfs(0,i,grid);
            dfs(m-1,i,grid);
        }
        int res=0;
        //现在再开始统计
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==0){
                    res++;
                    dfs(i,j,grid);
                }
            }
        }
        return res;
    }
    void dfs(int i,int j,int[][] grid){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length) return;
        if(grid[i][j]==1) return;
        grid[i][j]=1;
        dfs(i-1,j,grid);
        dfs(i+1,j,grid);
        dfs(i,j+1,grid);
        dfs(i,j-1,grid);
    }
}