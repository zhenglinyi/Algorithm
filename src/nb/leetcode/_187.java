package nb.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author shkstart
 * @date 2020-11-12 23:00
 */
public class _187 {
    public List<String> findRepeatedDnaSequences(String s) {
        int L=10;
        HashSet<String> allSub = new HashSet<>();
        HashSet<String> outSub = new HashSet<>();
        for(int start=0;start<s.length()-L+1;start++){
            String tempSub=s.substring(start,start+L);
            if(allSub.contains(tempSub)){
                outSub.add(tempSub);
            }
            allSub.add(tempSub);

        }
        return new ArrayList<String>(outSub);
    }

}
