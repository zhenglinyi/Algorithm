package nb.leetcode;

/**
 * @author shkstart
 * @date 2020-11-14 23:53
 */
public class _331 {
    public static boolean isValidSerialization(String preorder) {
        //初始槽位
        int slot=1;
        for(String node:preorder.split(",")){
            //每个节点要占用一个槽位
            slot--;
            if(slot<0)return false;
            //不是空节点增加两个槽位
            if(node!="#")slot+=2;
        }
        return slot==0;
    }
    public static boolean isValidSerialization2(String preorder) {
        //初始槽位
        int slot=1;
        int l=preorder.length();
        for(int i=0;i<l;i++){
            //遇到","减少一个槽位
            if(preorder.charAt(i)==','){
                slot--;
                if(slot<0)
                    return false;
                //不是空节点增加两个槽位
                if(preorder.charAt(i-1)!='#')
                    slot+=2;
            }

        }
        //因为最后一位没有逗号
        slot=(preorder.charAt(l-1)=='#')?slot-1:slot+1;
        return slot==0;
    }

    public static void main(String[] args) {
        isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
    }
}
