package nb.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _208 {
}


public  class Trie{
    class TrieNode{
        Map<Character,TrieNode> sonMap;
        boolean idEnd;
        public TrieNode()
        {
            sonMap=new HashMap<>();
        }
    }
    TrieNode root;
    public Trie()
    {
        root=new TrieNode();
    }

    public void insert(String word) {
        TrieNode node=root;
        for(int i=0;i<word.length();i++)
        {
            char ch=word.charAt(i);
            if(!node.sonMap.containsKey(ch))//不存在插入
            {
                node.sonMap.put(ch,new TrieNode());
            }
            node=node.sonMap.get(ch);
        }
        node.idEnd=true;
    }

    public boolean search(String word) {
        TrieNode node=root;
        for(int i=0;i<word.length();i++)
        {
            char ch=word.charAt(i);
            if(!node.sonMap.containsKey(ch))
            {
                return false;
            }
            node=node.sonMap.get(ch);
        }
        return node.idEnd==true;//必须标记为true证明有该字符串
    }


    public boolean startsWith(String prefix) {
        TrieNode node=root;
        for(int i=0;i<prefix.length();i++)
        {
            char ch=prefix.charAt(i);
            if(!node.sonMap.containsKey(ch))
            {
                return false;
            }
            node=node.sonMap.get(ch);
        }
        return true;//执行到最后一步即可
    }
}