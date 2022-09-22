package nb.leetcode;

public class _990 {
}
class Solution {
    public boolean equationsPossible(String[] equations) {
        UF uf=new UF(26);
        for (String equation : equations) {
            if(equation.charAt(1)=='='){
                int a=equation.charAt(0)-'a';
                int b=equation.charAt(3)-'a';
                uf.union(a,b);
            }
        }
        for (String equation : equations) {
            if(equation.charAt(1)=='!'){
                int a=equation.charAt(0)-'a';
                int b=equation.charAt(3)-'a';
                if(uf.connected(a,b))
                    return false;
            }
        }
        return true;
    }
    class UF{
        int count;
        int[] parent;
        UF(int n){
            parent=new int[n];
            for (int i = 0; i < n; i++) {
                parent[i]=i;
            }
        }
        void union(int p,int q){
            int parentP=find(p);
            int parentQ=find(q);
            if(parentP==parentQ) return;
            parent[parentP]=parentQ;
            count--;
        }
        boolean connected(int p,int q){
            return find(p)==find(q);
        }
        int find(int x){
            while(x!=parent[x]){
                parent[x]=parent[parent[x]];
                x=parent[x];
            }
            return x;
        }
        int count(){
            return count;
        }
    }
}
