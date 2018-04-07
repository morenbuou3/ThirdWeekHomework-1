package com.thoughtworks.collection;

public class SingleLinkImplement<T> implements SingleLink<T> {

    class Node {
        private T data;
        private Node next = null;

        public Node() {
            data = null;
        }

        public Node(T data) {
            this.data = data;
        }

    }

    private Node head;
    private Node rear;
    private int length;

    public SingleLinkImplement() {
        head = null;
        rear = null;
        length = 0;
    }

    @Override
    public T getHeaderData() {
        if (head != null) {
            return head.data;
        } else {
            return null;
        }
    }

    @Override
    public T getTailData() {
        if (rear != null) {
            return rear.data;
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public boolean deleteFirst() {
        if (head != null) {
            head = head.next;
            length--;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteLast() {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            head = rear = null;
            length--;
            return true;
        }
        if (head.next.next == null) {
            rear = head;
            length--;
            return true;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        rear = temp;
        length--;
        return true;
    }

    @Override
    public void addHeadPointer(T item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
            rear = newNode;
        } else {
            Node tmp = head;
            newNode.next = tmp;
            head = tmp;
        }
        length++;
    }

    @Override
    public void addTailPointer(T item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
        } else {
            Node tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = newNode;
        }
        rear = newNode;
        length++;
    }

    @Override
    public T getNode(int index) {
        if (index < 1 || index > this.length) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

}
