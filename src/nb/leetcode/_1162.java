package nb.leetcode;

import java.util.*;

public class _1162 {
}

class Solution {
    int n;
    int[][] grid;
    public int maxDistance(int[][] _grid) {
        grid=_grid;
        n=grid.length;
        int ans=-1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==0){
                    ans=Math.max(ans, bfs(i, j));
                }

            }
        }
        return ans;

    }

    // 单次 BFS：求解海洋位置 (x,y) 最近的陆地距离
    int bfs(int x, int y) {
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Deque<int[]> d = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        d.addLast(new int[]{x, y});
        map.put(x * n + y, 0);
        while (!d.isEmpty()) {
            int[] poll = d.pollFirst();
            int dx = poll[0], dy = poll[1];
            int step = map.get(dx * n + dy);
            if (grid[dx][dy] == 1) return step;
            for (int[] di : dirs) {
                int nx = dx + di[0], ny = dy + di[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                int key = nx * n + ny;
                if (map.containsKey(key)) continue;
                d.addLast(new int[]{nx, ny});
                map.put(key, step + 1);
            }
        }
        return -1;
    }
}

class Solution{
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    int n;
    int[][] grid;

    public int maxDistance(int[][] grid){
        this.n=grid.length;
        this.grid=grid;
        int ans=-1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==0)
                    ans=Math.max(ans,findNearestLand(i,j));
            }
        }
        return ans;

    }

    public int findNearestLand(int x,int y){
        boolean[][] vis=new boolean[n][n];
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{x,y,0});
        vis[x][y]=true;
        while(!queue.isEmpty()){
            int[] f=queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx=f[0]+dx[i];
                int ny=f[1]+dy[i];
                if(!(nx>=0&&nx<n&&ny>=0&&ny<n)){
                    continue;
                }
                if(!vis[nx][ny]){
                    if(grid[nx][ny]==1) return f[2]+1;
                    queue.offer(new int[]{nx,ny,f[2]+1});
                    vis[nx][ny]=true;
                }


            }
        }
        return -1;
    }
}

//多源BFS
class Solution{
    public int maxDistance(int[][] grid){
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        int n=grid.length;
        boolean[][] vis=new boolean[n][n];
        Queue<int[]> queue=new LinkedList<>();
        int ans=-1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1){
                    queue.offer(new int[]{i,j,0});
                    vis[i][j]=true;
                }
            }
        }
        while(!queue.isEmpty()){
            int[] f=queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx=f[0]+dx[i];
                int ny=f[1]+dy[i];
                if(!(nx>=0&&nx<n&&ny>=0&&ny<n&&grid[nx][ny]==0)){
                    continue;
                }
                if(!vis[nx][ny]){
                    ans=Math.max(ans,f[2]+1);
                    queue.offer(new int[]{nx,ny,f[2]+1});
                    vis[nx][ny]=true;
                }
            }

        }
        return ans;
    }


}
