package com.example.nativeqry.service;

public class KthNodeFromEndOfLinkedList {

    static class Node {
        public int data;
        public Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static int findKthNodeFromLast(Node head, int k) {
        if (head == null) {
            return 0;
        }
        int kthNodeFromLast = findKthNodeFromLast(head.next, k) + 1;
        if (kthNodeFromLast == k) {
            System.out.println("kthNodeFromLast is " + head.data);
        }
        return kthNodeFromLast;
    }

    public static void main(String[] args) {
        Node n1 = new Node(8, null);
        Node n2 = new Node(7, n1);
        Node n3 = new Node(6, n2);
        Node n4 = new Node(5, n3);
        Node n5 = new Node(4, n4);
        Node n6 = new Node(3, n5);
        Node n7 = new Node(2, n6);
        Node n8 = new Node(1, n7);

        findKthNodeFromLast(n8, 3);
    }
}
