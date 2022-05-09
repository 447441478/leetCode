package com.whale.demo;

import java.util.HashMap;

public class LruCache {
    class LRUCache {
        class Node{
            public Node pre;
            public Node next;
            public Integer key;
            public Integer value;
        }
        public HashMap<Integer, Node> map;
        public int capacity;
        public Node head;
        public Node tail;
        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>(capacity*4/3+1);
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
        }
        public int get(Node node) {
            if(node == null){
                return -1;
            }
            Node nPre = node.pre;
            if(nPre == head){
                return node.value;
            }
            Node nNext = node.next;

            Node hNext = head.next;

            head.next = node;

            node.pre = head;
            node.next = hNext;

            hNext.pre = node;
            if(hNext == node){
                hNext.next = nNext;
            }

            nNext.pre = nPre;
            nPre.next = nNext;

            return node.value;
        }

        public int get(int key) {
            if(capacity <= 0){
                return -1;
            }
            Node node = map.get(key);
            return get(node);
        }

        public void put(int key, int value) {
            if(capacity <= 0){
                return;
            }
            Node node = map.get(key);
            if(node != null){
                get(node);
                node.value = value;
                return;
            }
            node = new Node();
            node.key = key;
            node.value = value;

            Node hNext = head.next;

            head.next = node;

            node.pre = head;
            node.next = hNext;

            hNext.pre = node;

            if(map.size() == capacity){
                Node tPre = tail.pre;
                Node tPrePre = tPre.pre;
                tPrePre.next = tail;
                tail.pre = tPrePre;
                map.remove(tPre.key);
            }
            map.put(key, node);
        }
    }
    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */

    public static void main(String[] args) {
        new LruCache().run3();
    }
    private void run(){
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));;    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));;    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));;    // 返回 3
        System.out.println(lRUCache.get(4));;    // 返回 4
    }

    private void run2(){
        LRUCache lRUCache = new LRUCache(2);
        System.out.println(lRUCache.get(2));
        lRUCache.put(2, 6);
        System.out.println(lRUCache.get(1));
        lRUCache.put(1, 5);
        lRUCache.put(1, 2);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(2));
    }

    private void run3(){
        LRUCache lRUCache = new LRUCache(3);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        lRUCache.put(3, 3);
        lRUCache.put(4, 4);
        System.out.println(lRUCache.get(4));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(2));
        System.out.println(lRUCache.get(1));
        lRUCache.put(5, 5);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(2));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(4));
        System.out.println(lRUCache.get(5));
    }
}
