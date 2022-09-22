package nb.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class _501 {
}


class Solution {
    List<Integer> res = new ArrayList<>();
    int maxCount = 0;
    int count = 0;
    TreeNode pre = null;

    public int[] findMode(TreeNode root) {
        find(root);
        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }

    public void find(TreeNode root) {
        if (root == null) return;
        //左
        find(root.left);
        //中
        int rootValue = root.val;
        if (pre == null || rootValue != pre.val) {
            count = 1;
        } else {
            count++;
        }
        if (count > maxCount) {
            res.clear();
            res.add(rootValue);
            maxCount = count;
        } else if (count == maxCount) {
            res.add(rootValue);
        }
        pre = root;
        //右
        find(root.right);


    }
}



//遍历以后统计
class Solution {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) return list.stream().mapToInt(Integer::intValue).toArray();
        // 获得频率 Map
        searchBST(root, map);
        List<Map.Entry<Integer, Integer>> mapList = map.entrySet().stream()
                .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                .collect(Collectors.toList());
        list.add(mapList.get(0).getKey());
        // 把频率最高的加入 list
        for (int i = 1; i < mapList.size(); i++) {
            if (mapList.get(i).getValue() == mapList.get(i - 1).getValue()) {
                list.add(mapList.get(i).getKey());
            } else {
                break;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    void searchBST(TreeNode curr, Map<Integer, Integer> map) {
        if (curr == null) return;
        map.put(curr.val, map.getOrDefault(curr.val, 0) + 1);
        searchBST(curr.left, map);
        searchBST(curr.right, map);
    }

}

//遍历以后统计
class Solution {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) return list.stream().mapToInt(Integer::intValue).toArray();
        // 获得频率 Map
        searchBST(root, map);
        //在上一个版本上写的阳间写法
        List<Map.Entry<Integer, Integer>> mapList = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            mapList.add(entry);
        }
        mapList.sort(((o1, o2) -> o2.getValue() - o1.getValue()));

        list.add(mapList.get(0).getKey());
        // 把频率最高的加入 list
        for (int i = 1; i < mapList.size(); i++) {
            if (mapList.get(i).getValue() == mapList.get(i - 1).getValue()) {
                list.add(mapList.get(i).getKey());
            } else {
                break;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    void searchBST(TreeNode curr, Map<Integer, Integer> map) {
        if (curr == null) return;
        map.put(curr.val, map.getOrDefault(curr.val, 0) + 1);
        searchBST(curr.left, map);
        searchBST(curr.right, map);
    }

}