package nb.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class _743 {
}


class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph=new LinkedList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] time : times) {
            int from=time[0];
            int to=time[1];
            int weight=time[2];
            graph[from].add(new int[]{to,weight});
        }
        int[] dist=dijkstra(graph,k);
        int res=0;
        for (int i = 1; i < dist.length; i++) {
            if(dist[i]==Integer.MAX_VALUE)
                return -1;
            res=Math.max(dist[i],res);
        }
        return res;


    }
//    class State{
//        int id;
//        int distFromStart;
//        State(int id,int distFromStart){
//            this.id=id;
//            this.distFromStart=distFromStart;
//        }
//    }
    int[] dijkstra(List<int[]>[] graph,int start){
        int[] dist=new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start]=0;

        PriorityQueue<State> pq=new PriorityQueue<Solution.State>((o1, o2) ->
                Integer.compare(o1.distFromStart, o2.distFromStart));
        pq.offer(new State(start,0));
        while(!pq.isEmpty()){
            State state=pq.poll();
            int curID=state.id;
            int curDistFromStart=state.distFromStart;
            if(dist[curID]<curDistFromStart){
                continue;
            }
            for (int[] neighbor : graph[curID]) {
                int nextID=neighbor[0];
                int weight=neighbor[1];
                int distToNext=dist[curID]+weight;
                if(dist[nextID]>distToNext){
                    dist[nextID]=distToNext;
                    pq.offer(new State(nextID,distToNext));
                }
            }
        }
        return dist;
    }
}