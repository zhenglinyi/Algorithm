package nb.leetcode;

public class _684 {
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        //因为节点的编号是从1开始的
        int[] parent=new int[n+1];
        for (int i = 1; i <= n ; i++) {
            parent[i]=i;
        }
        for (int i = 0; i < edges.length; i++) {
            //找祖先
            int p1=findParent(parent,edges[i][0]);
            int p2=findParent(parent,edges[i][1]);
            if(p1==p2){
                return edges[i];
            }else{
                //合并
                parent[p1]=p2;
            }
        }
        return new int[2];

    }
    public int findParent(int[] parent,int i){
        while(parent[i]!=i){
            i=parent[i];
        }
        return i;
    }
}
