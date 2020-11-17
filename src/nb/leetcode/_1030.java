package nb.leetcode;

import java.util.*;

/**
 * @author shkstart
 * @date 2020-11-17 22:18
 */
public class _1030 {
    //1.
    /*public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] result=new int[R*C][];
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                result[i*C+j]=new int[]{i,j};
            }
        }
        Arrays.sort(result, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return (Math.abs(a[0] - r0) + Math.abs(a[1] - c0)) - (Math.abs(b[0] - r0) + Math.abs(b[1] - c0));

            }
        });
        return result;
    }*/

    //2.
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int maxDist=Math.max(r0,R-r0-1)+Math.max(c0,C-c0-1);
        List<List<int[]>> bucket=new ArrayList<>();
        for(int i=0;i<=maxDist;i++){
            bucket.add(new ArrayList<int[]>());
        }
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                int d=dist(i,r0,j,c0);
                bucket.get(d).add(new int[]{i,j});
            }
        }
        int index=0;
        int[][] result=new int[R*C][];
        for(int i=0;i<=maxDist;i++){
            for(int[] b:bucket.get(i)){
                result[index++]=b;
            }
        }
        return result;
    }
    public int dist(int r1,int r2,int c1,int c2){
        return Math.abs(r1-r2)+Math.abs(c1-c2);
    }

    /*public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        Map<Integer,List<int[]>> map = new HashMap<>();
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                int dist = Math.abs(i-r0)+Math.abs(j-c0);
                List<int[]> list = map.getOrDefault(dist, new ArrayList<int[]>());
                list.add(new int[] {i,j});
                map.put(dist, list);
            }
        }
        int k = 0;
        int[][] res = new int[R*C][];
        for(Integer i : map.keySet()) {
            for(int[] t : map.get(i)) {
                res[k++] = t;
            }
        }
        return res;
    }*/


}
