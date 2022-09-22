package nb.leetcode;

import java.util.*;

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
        reverseWord(sb);
        return sb.toString();
    }
    StringBuilder trimSpace(String s){
        StringBuilder sb=new StringBuilder();
        int start=0;
        int end=s.length()-1;
        while(s.charAt(start)==' ')
            start++;
        while(s.charAt(end)==' ')
            end--;
        while(start<=end){
            if(s.charAt(start)!=' '||sb.charAt(sb.length()-1)==' ')
                sb.append(s.charAt(start));
            start++;
        }
        return sb;

    }
    void reverseString(StringBuilder sb,int start,int end){
        while(start<end){
            char tmp=sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,tmp);
            start++;
            end--;
        }

    }
    void reverseWord(StringBuilder sb){
        int start=0;
        int end=0;
        while(end<sb.length()){
            while(end<sb.length()&&sb.charAt(end)!=' '){
                end++;
            }
            reverseString(sb,start,end);
            start=end+1;
            end=end+1;
        }

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

//用双端队列记录的方法
class Solution {
    public String reverseWords(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        Deque<String> d = new ArrayDeque<String>();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if ((word.length() != 0) && (c == ' ')) {
                // 将单词 push 到队列的头部
                d.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            ++left;
        }
        d.offerFirst(word.toString());

        return String.join(" ", d);
    }
}

