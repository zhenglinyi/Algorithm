package nb.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class _146 {
}

class LRUCache {

    int cap;
    LinkedHashMap<Integer,Integer> cache = new LinkedHashMap<>();
    public LRUCache(int capacity) {
        this.cap=capacity;
    }

    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        //将key变为最近使用
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            //修改key的值
            cache.put(key,value);
            //将key变为最近使用
            makeRecently(key);
            return;
        }

        if(cache.size()>=this.cap){
            //链表头部就是最久未使用的key
            //获取LinkedHashMap的第一个key，使用的是iterator()遍历的方式获得
            int oldestKey=cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        //添加新的key
        cache.put(key,value);
    }

    private void makeRecently(int key){
        int val=cache.get(key);
        //删除key，重新插入队尾
        cache.remove(key);
        cache.put(key,val);
    }
}

class LRUCache {

    int cap;
    LinkedHashMap<Integer,Integer> cache=new LinkedHashMap<>();
    public LRUCache(int capacity) {
        this.cap=capacity;
    }

    public int get(int key) {
        if(!cache.containsKey(key))
            return -1;
        makeRecent(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.put(key,value);
            makeRecent(key);
        }
        if(cache.size()==cap){
            int oldKey=cache.keySet().iterator().next();
            cache.remove(oldKey);
        }
        cache.put(key,value);
    }
    private void makeRecent(int key){
        int value=cache.get(key);
        cache.remove(key);
        cache.put(key,value);
    }
}

class LRUCache extends LinkedHashMap<Integer, Integer>{
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

public class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        }
        else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}




