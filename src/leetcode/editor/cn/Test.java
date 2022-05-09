package leetcode.editor.cn;

import java.util.*;

public class Test {

    static {
        i = 1;
    }
    static int i = 2;

    /**
     * 返回重复次数最多的前N个data
     * <p>注意: 输入可能有异常数据,程序需要具备容错性,不能出现异常或导致系统crash的情况
     * <p>注意: 答题内容不能超过getTopN方法体
     */
    public static<T> List<T> getTopN(Node<T> header, int n) {
        if(header == null){
            return new ArrayList<>();
        }
        Map<T/*val*/, Integer/*count*/> map = new HashMap<>();
        while (header != null){
            map.put(header.val, map.getOrDefault(header.val, 0)+1);
            header = header.next;
        }
        PriorityQueue<ValWarp<T>> pq = new PriorityQueue<>(n, (o1,o2)->o2.count-o1.count);
        map.forEach((val,count)->{
            pq.add(new ValWarp(val, count));
        });
        List<T> ans = new ArrayList<>(pq.size());
        while (!pq.isEmpty() && ans.size() < n){
            ans.add(pq.poll().val);
        }
        return ans;
    }

    static class ValWarp<T>{
        T val;
        int count;

        public ValWarp(T val, int count) {
            this.val = val;
            this.count = count;
        }
    }



    public static void main(String[] args) throws CloneNotSupportedException {
        Node node = new Node(null);
        Node node1 = new Node(null);
        Node node2 = new Node(1);
        Node node3 = new Node(1);
        Node node4 = new Node(1);
        Node node5 = new Node(2);
        Node node6 = new Node(3);
        Node node7 = new Node(4);
        Node node8 = new Node(4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        List topN = getTopN(node, 10);
        topN.forEach(System.out::println);

       /* HashMap<Object, Integer> map = new HashMap<>();
        map.put(null, 1);
        System.out.println(map);

        Node node = new Node(1);
        node.str = "111";
        node.i = new Integer(3);

        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Node clone = node.clone();
        //node.val = 2;
        node.str = "123";
        System.out.println(node);
        System.out.println(clone);
        print(node);
        System.out.println("==============");
        int[] arr = {1,2,3,4,5};
        boolean[] use ={true,true,true,true,true};
        System.out.println(binarySearch(arr,1));
        System.out.println(binarySearch(arr,3));
        System.out.println(binarySearch(arr,5));
        System.out.println(binarySearch(arr,7));*/
    }

    public static int binarySearch(int[] arr, int target){
        if(arr == null){
            return -1;
        }
        int left = 0, right=arr.length-1;
        int ans = -1;
        while (left <= right){
            int mid = (right-left)/2 + left;
            if(arr[mid] < target){
                left = mid+1;
            }else if(arr[mid] > target){
                right = mid-1;
            }else{
                return mid;
            }
        }
        return ans;
    }
    public static void print(Node node){
        if(node == null){
            return;
        }
        print(node.next);
        System.out.println(node.val);
    }

    public static void print2(Node node){
        Node next = null;
        Node pre = null;
        while (node != null){
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        node = pre;
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
class Node<T> implements Cloneable{
    T val;
    Node next;
    String str;
    Integer i;

    public Node(T val) {
        this.val = val;
    }

    public Node clone() throws CloneNotSupportedException {
        return (Node) super.clone();
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                ", str='" + str + '\'' +
                ", i=" + i +
                '}';
    }
}
