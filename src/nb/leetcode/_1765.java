package nb.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _1765 {
}
class Solution {
    public int[][] highestPeak(int[][] isWater) {
        //用于上下左右移动
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        int m=isWater.length;
        int n=isWater[0].length;
        //结果数组
        int[][] ans=new int[m][n];
        //标记是否访问数组
        boolean[][] vis=new boolean[m][n];
        //用于BFS的队列
        Queue<int[]> queue=new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //把所有水的入队
                if(isWater[i][j]==1)
                    queue.offer(new int[]{i,j});
                //根据是不是水初始化结果数组
                ans[i][j]=isWater[i][j]==1?0:-1;
            }
        }
        //BFS
        while (!queue.isEmpty()){
            int[] f=queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx=f[0]+dx[i];
                int ny=f[1]+dy[i];
                //边界判断
                if(!(nx>=0&&nx<m&&ny>=0&&ny<n&&isWater[nx][ny]!=1))
                    continue;
                //没有访问过
                if(!vis[nx][ny]){
                    vis[nx][ny]=true;
                    //修改结果数组
                    ans[nx][ny]=ans[f[0]][f[1]]+1;
                    //节点入队
                    queue.offer(new int[]{nx,ny});
                }
            }
        }
        return ans;
    }
}
