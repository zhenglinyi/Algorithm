package nb.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _207 {
}
//DFS
//visited是记录整体遍历的，onPath是记录某次遍历的
class Solution {
    //记录一次递归堆栈中的节点
    boolean[] onPath;
    //记录遍历过的节点
    boolean[] visited;
    //记录图中是否有环
    boolean hasCycle=false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        onPath=new boolean[numCourses];
        visited=new boolean[numCourses];
        List<Integer>[] graph=buildGraph(numCourses,prerequisites);
        for (int i = 0; i < numCourses; i++) {
            traverse(graph,i);
        }
        return !hasCycle;

    }
    void traverse(List<Integer>[] graph,int s){
        //本次遍历路径有环
        if(onPath[s]){
            hasCycle=true;
            return;
        }
        //访问过此节点，也返回
        if(visited[s]){
            return;
        }
        visited[s]=true;
        onPath[s]=true;
        for (int n : graph[s]) {
            traverse(graph,n);
        }
        onPath[s]=false;
    }
    //构建邻接表的格式的图
    List<Integer>[] buildGraph(int numCourses,int[][] prerequisites){
        List<Integer>[] res=new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = new LinkedList<>();
        }
        for (int[] prerequisite : prerequisites) {
            int from=prerequisite[1];
            int to=prerequisite[0];
            res[from].add(to);
        }
        return res;
    }
}
//BFS
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
            count++;
            for (int n : graph[tmp]) {
                indegree[n]--;
                if(indegree[n]==0)
                    deque.offer(n);
            }
                    
        }
        return count==numCourses;
    }
    //构建邻接表的格式的图
    List<Integer>[] buildGraph(int numCourses,int[][] prerequisites){
        List<Integer>[] res=new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = new LinkedList<>();
        }
        for (int[] prerequisite : prerequisites) {
            int from=prerequisite[1];
            int to=prerequisite[0];
            res[from].add(to);
        }
        return res;
    }
}
