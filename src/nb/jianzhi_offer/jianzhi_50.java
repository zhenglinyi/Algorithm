package nb.jianzhi_offer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author shkstart
 * @date 2021-07-20 22:33
 */
public class jianzhi_50 {

}

//哈希表
class Solution {
    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();//字符串转化为字符数组
        //如果没有这个键，插入true；有了说明不是一次，插入false
        for (char c : sc) {
            dic.put(c, !dic.containsKey(c));//
        }
        for (char c : sc) {
            if (dic.get(c))//只出现了一次是true
                return c;
        }
        return ' ';
    }

}

//有序哈希表
//在哈希表的基础上，有序哈希表中的键值对是 按照插入顺序排序 的。
// 基于此，可通过遍历有序哈希表，实现搜索首个 “数量为 1的字符”。

//Map是java中的接口，Map.Entry是Map的一个内部接口。
//Map提供了一些常用方法，如keySet()、entrySet()等方法。
//keySet()方法返回值是Map中key值的集合；
// entrySet()的返回值也是返回一个Set集合，此集合的类型为Map.Entry。
//Map.Entry是Map声明的一个内部接口，此接口为泛型，定义为Entry<K,V>。
// 它表示Map中的一个实体（一个key-value对）。接口中有getKey(),getValue方法。
class Solution {
    public char firstUniqChar(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();//字符串转化为字符数组
        //如果没有这个键，插入true；有了说明不是一次，插入false
        for (char c : sc) {
            dic.put(c, !dic.containsKey(c));//
        }
        for (Map.Entry<Character, Boolean> d : dic.entrySet()) {
            if (d.getValue())
                return d.getKey();
        }
        return ' ';
    }
}
