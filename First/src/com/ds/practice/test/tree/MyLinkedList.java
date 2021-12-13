package com.ds.practice.test.tree;

public class MyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public MyLinkedList(Node n) {
        this.head = n;
        this.tail = n;
        this.size = 1;
    }

    @Override
    public String toString() {
        return "LinkedList [" + head + "] size=" + size;
    }

    private Node getNode(int idx) {
        Node x = head;
        for (int i = 0; i < idx; ++i){
            x = x.getNext();
        }
        return x;
    }

    public void addFirst(Object obj) {
        Node newNode = new Node(obj);

        newNode.setNext(head);  // head가 가리키던 것을 추가한 노드 다음으로
        head = newNode;         // 현재 노드를 head로
        size++;
        if (head.getNext() == null)
            tail = head;
    }

    public void addLast(Object obj){
        Node newNode = new Node(obj);

        if (size == 0) {
            addFirst(obj);
            return ;
        }

        tail.setNext(newNode);      // 마지막 노드의 다음에 새로운 노드 추가
        tail = newNode;             // 마지막 노드를 새로운 노드로 변경
        size++;
    }

    public void add(Object obj, int idx) {
        if (idx == 0){
            addFirst(obj);
            return ;
        } else if (idx == size -1){
            addLast(obj);
            return;
        }

        Node tmp1 = getNode(idx-1);        // 입력 할 위치 바로 앞의 노드
        Node tmp2 = getNode(idx);          // idx위치의 노드

        Node newNode = new Node(obj);
        tmp1.setNext(newNode);
        newNode.setNext(tmp2);
        size++;

    }

    public Object removeFirst() {
        Object returnData = head.getData();
        head = head.getNext();
        size--;
        return returnData;
    }

    public Object remove(int idx) {
        if (idx == 0)
            return removeFirst();
        
        Node tmp = getNode(idx-1);          // 삭제 앞 노드 조회
        Node toDeleted = tmp.getNext();     // 삭제노드 지정
        tmp.setNext(toDeleted.getNext());   // 삭제노드 뒤의 노드를 삭제 앞 노드 다음으로 연결

        Object returnObject = toDeleted.getData();
        if (toDeleted == tail)
            tail = tmp;

        toDeleted = null;
        size--;
        return returnObject;            
    }

    public int size() {
        return size;
    }

    public Object get(int idx) {
        return getNode(idx).getData();
    }
}
