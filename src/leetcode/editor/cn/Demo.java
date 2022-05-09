package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Demo {

    public static void main(String[] args) {

        Node head = new Node(1);
        Node left = new Node(2);
        Node right = new Node(3);
        Node leftLeft = new Node(4);
        Node leftRight = new Node(5);
        Node rightLeft = new Node(6);
        head.left = left;
        head.right = right;
        left.left = leftLeft;
        left.right = leftRight;
        right.left = rightLeft;

        Stack<Character> stack = new Stack<>();

        print(head);
        revert(head);
        System.out.println("===========");
        print(head);
        System.out.println("===========");
        revert(head);
        print(head);
        System.out.println("===========");

        StringBuilder sb = new StringBuilder("0123");
        sb.append(14%10);
        System.out.println(sb.reverse());

        System.out.println((char)48);
    }

    private static void print(Node head){
        if(head == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if(node == null){
                System.out.println("#");
                continue;
            }
            System.out.println(node.val);
            queue.add(node.left);
            queue.add(node.right);
        }
    }

    private static void revert(Node head){
        if(head == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            Node left = node.left;
            Node right = node.right;
            node.right = left;
            node.left = right;
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
    }


    static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
}


