package nb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class _1631 {
}

class Solution {
    int[][] dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    List<int[]> adj(int[][] matrix,int x,int y){
        int m=matrix.length;
        int n=matrix[0].length;
        List<int[]> neighbors=new ArrayList<>();
        for (int[] dir : dirs) {
            int nx=x+dir[0];
            int ny=y+dir[1];
            if(nx>=m||nx<0||ny>=n||ny<0)
                continue;
            neighbors.add(new int[]{nx,ny});
        }
        return neighbors;
    }
    class State{
        int x,y;
        int effortFromStart;
        State(int x,int y,int effortFromStart){
            this.x=x;
            this.y=y;
            this.effortFromStart=effortFromStart;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        int[][] efforTo=new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(efforTo[i], Integer.MAX_VALUE);
        }
        efforTo[0][0]=0;
        PriorityQueue<State> pq=new PriorityQueue<>((o1, o2) ->
                Integer.compare(o1.effortFromStart,o2.effortFromStart));
        pq.offer(new State(0,0,0));
        while(!pq.isEmpty()){
            State curState=pq.poll();
            int curX =curState.x;
            int curY=curState.y;
            int curEffortFromStart=curState.effortFromStart;
            if(curX==m-1&&curY==n-1){
                return curEffortFromStart;
            }
            for (int[] neighbor : adj(heights,curX,curY)) {
                int nextX=neighbor[0];
                int nextY=neighbor[1];
                int effortNextNode=Math.max(efforTo[curX][curY],
                        Math.abs(heights[nextX][nextY]-heights[curX][curY]));
                if(efforTo[nextX][nextY]>effortNextNode){
                    efforTo[nextX][nextY]=effortNextNode;
                    pq.offer(new State(nextX,nextY,effortNextNode));
                }
            }
        }
        return -1;



    }
}
