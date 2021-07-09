package nb.jianzhi_offer;

import java.util.LinkedList;
import java.util.Queue;

public class jianzhi_13 {
}







//DFS+剪枝
class Solution {
    int m,n,k;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0,0,0,0);

    }
    public int dfs(int i,int j,int si,int sj){
        //越界，不满足k，已经访问
        if(i >= m || j >= n || si + sj > k || visited[i][j])
            return 0;
        visited[i][j] = true;
        int siNext = (i+1) % 10 != 0 ? si + 1 : si - 8;
        int sjNext = (j+1) % 10 != 0 ? sj + 1 : sj - 8;
        //只需要下、右遍历就能遍历全
        return 1 + dfs(i + 1,j,siNext,sj) + dfs(i,j + 1,si,sjNext);
    }
}

//BFS
class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[] {0,0,0,0});
        while(queue.size() > 0){
            int[] x = queue.poll();
            int i = x[0],j = x[1],si = x[2],sj = x[3];
            if(i >= m || j >= n || si + sj > k || visited[i][j])
                continue;
            visited[i][j] = true;
            int siNext = (i+1) % 10 != 0 ? si + 1 : si - 8;
            int sjNext = (j+1) % 10 != 0 ? sj + 1 : sj - 8;
            res++;
            queue.add(new int[] {i + 1,j,siNext,sj});
            queue.add(new int[] {i,j + 1,si,sjNext});
        }
        return res;
    }
}