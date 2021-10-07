package nb.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _151 {
}


class Solution {
    public String reverseWords(String s) {
        //除去开头和末尾的空白字符
        s=s.trim();
        //正则匹配连续的空白字符作为分割符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ",wordList);
    }

}


class Solution {
    public String reverseWords(String s) {
        StringBuilder sb=trimSpace(s);
        reverseString(sb,0,sb.length()-1);
        reverseEachWord(sb);
        return sb.toString();

    }
    public StringBuilder trimSpace(String s){
        StringBuilder res=new StringBuilder();
        int start=0;
        int end=s.length()-1;
        //删除前面的空格
        while(s.charAt(start)==' ') start++;
        //删除后面的空格
        while(s.charAt(end)==' ') end--;
        //删除中间的空格
        while(start<=end){
            if(s.charAt(start)!=' '||res.charAt(res.length()-1)!=' '){
                res.append(s.charAt(start));
            }
            start++;
        }
        return res;
    }

    public void reverseString(StringBuilder sb,int start,int end){
        while(start<end){
            char tmp=sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,tmp);
            start++;
            end--;
        }
    }

    public void reverseEachWord(StringBuilder sb){
        int start=0;
        int end=1;
        int length=sb.length();

        while(start<length){
            while(end<length&&sb.charAt(end)!=' ') end++;
            reverseString(sb,start,end-1);
            start=end+1;
            end=start+1;
        }


    }


}