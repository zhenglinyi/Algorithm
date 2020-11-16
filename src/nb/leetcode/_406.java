package nb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _406 {
    //1.
    /*public int[][] reconstructQueue(int[][] people) {
        //第一维升序，第二维降序
        Arrays.sort(people,new Comparator<int[]>(){
            //正数是增序
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]){
                    return o1[0]-o2[0];
                }else{
                    return o2[1]-o1[1];
                }
            }
        });
        //第二维是空位，按照空位把每一个people插入
        int n=people.length;
        int[][] result=new int[n][];
        for(int[] p:people){
            //插入当前people需要的空位
            int space=p[1]+1;
            for(int i=0;i<n;i++){
                //发现个空位，减一
                if(result[i]==null){
                    space--;
                    if(space==0){
                        result[i]=p;
                    }
                }

            }
        }
        return result;
    }*/

    //2.
    public int[][] reconstructQueue(int[][] people){
        //一维降序，二维增序
        Arrays.sort(people,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]){
                    return o2[0]-o1[0];
                }else{
                    return o1[1]-o2[1];
                }
            }
        });
        List<int[]> result=new ArrayList<int[]>();
        //在第几个位置插入，保证了有几个比他高的人在他前边
        for(int[] p:people){
            result.add(p[1],p);
        }
        return result.toArray(new int[result.size()][]);
    }
}
