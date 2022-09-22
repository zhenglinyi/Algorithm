package nb.leetcode;

public class _200 {
}
//深度优先遍历
class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int res=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //碰到1就加一
                if(grid[i][j]=='1'){
                    res++;
                    dfs(i,j,grid);
                }
            }
        }
        return res;

    }

    void dfs(int i,int j,char[][] grid){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length) return;

        if(grid[i][j]=='0') return;
        //遍历的时候改成0
        grid[i][j]='0';
        //就是上下左右遍历
        dfs(i-1,j,grid);
        dfs(i+1,j,grid);
        dfs(i,j-1,grid);
        dfs(i,j+1,grid);

    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        int res=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]=='1'&&!visited[i][j]){
                    res++;
                    dfs(i,j,grid,visited);
                }
            }
        }
        return res;

    }
    void dfs(int i,int j,char[][] grid,boolean[][] visited){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length) return;
        if(visited[i][j]) return;
        if(grid[i][j]=='0') return;
        visited[i][j]=true;
        dfs(i-1,j,grid,visited);
        dfs(i+1,j,grid,visited);
        dfs(i,j-1,grid,visited);
        dfs(i,j+1,grid,visited);

    }
}
