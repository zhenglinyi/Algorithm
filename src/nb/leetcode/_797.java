package nb.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _797 {
}
//labuladong
class Solution {
    int[][] graph;
    int n;
    List<List<Integer>> res= new LinkedList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph=graph;
        LinkedList<Integer> path=new LinkedList<>();
        n=graph.length;
        traverse(0,path);
        return res;

    }
    public void traverse(int s,LinkedList<Integer> path){
        path.add(s);
        if(s==n-1){
            res.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        for (int n : graph[s]) {
            traverse(n,path);
        }
        path.removeLast();
    }
}
