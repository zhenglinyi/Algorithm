package nb.leetcode;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _210 {
}

//DFS
class Solution {
    boolean[] onPath;
    boolean[] visited;
    boolean hasCycle;
    List<Integer> res;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        onPath=new boolean[numCourses];
        visited=new boolean[numCourses];
        hasCycle=false;
        res=new LinkedList<>();
        List<Integer>[] graph=buildGraph(numCourses,prerequisites);
        for (int i = 0; i < numCourses; i++) {
            traverse(graph,i);
        }
        if(hasCycle){
            return new int[]{};
        }
        Collections.reverse(res);
        int[] result=new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i]=res.get(i);
        }
        return result;
    }
    //后序遍历的逆序就是拓扑排序
    void traverse(List<Integer>[] graph,int s){
        if(onPath[s]){
            hasCycle=true;
            return;
        }
        if(visited[s]){
            return;
        }
        visited[s]=true;
        onPath[s]=true;

        for (int n : graph[s]) {
            traverse(graph,n);
        }
        res.add(s);
        onPath[s]=false;

    }
    List<Integer>[] buildGraph(int numCourses, int[][] prerequisites){
        List<Integer>[] graph=new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i]=new LinkedList<>();
        }
        for (int[] prerequisite : prerequisites) {
            int from=prerequisite[1];
            int to=prerequisite[0];
            graph[from].add(to);
        }
        return graph;
    }
}
//BFS
class Solution {
    List<Integer> resList;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        resList=new LinkedList<>();
        List<Integer>[] graph = buildGraph(numCourses,prerequisites);
        int[] indegree=new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int to=prerequisite[0];
            indegree[to]++;
        }
        Deque<Integer> deque=new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(indegree[i]==0){
                deque.offer(i);
            }
        }
        int count=0;
        while(!deque.isEmpty()){
            int tmp=deque.poll();
            resList.add(tmp);
            count++;
            for (int n : graph[tmp]) {
                indegree[n]--;
                if(indegree[n]==0)
                    deque.offer(n);
            }
        }
        if(count!=numCourses)
            return new int[]{};
        int[] result=new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            result[i]=resList.get(i);
        }
        return result;

    }

    List<Integer>[] buildGraph(int numCourses, int[][] prerequisites){
        List<Integer>[] graph=new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i]=new LinkedList<>();
        }
        for (int[] prerequisite : prerequisites) {
            int from=prerequisite[1];
            int to=prerequisite[0];
            graph[from].add(to);
        }
        return graph;
    }
}
