package com.ds.practice.test.tree;

public class DoubleLinkedList {

    private int size;
    private Node head, tail;

    public DoubleLinkedList() {
        this.size = 0;
        head = tail = null;
    }

    class Node {
        Node pre, next;
        Object data;

        Node(Object data) {
            pre = next = null;
            this.data = data;
        }

        @Override
        public String toString() {
            return String.valueOf(this.data);
        }
    }

    public int size() {
        return size;
    }

    public Object get(int idx) {
        return getNode(idx).data;
    }

    private Node getNode(int idx) {
        Node x;
        if (idx < size / 2) { // 찾으려는 위치가 크기의 절반 미만 일때
            x = head; // 앞쪽부터 탐색
            for (int i = 0; i < idx; ++i) {
                x = x.next;
            }
        } else { // 찾으려는 위치가 크기의 절반 이상 일때
            x = tail; // 뒤쪽부터 탐색
            for (int i = size - 1; i > idx; --i) {
                x = x.pre;
            }
        }
        return x;
    }

    public void push(Object obj) { // 가장 앞에 추가
        Node n = new Node(obj);

        n.next = head; // 새 노드의 다음을 head로 (가장 앞이라는 뜻)
        n.pre = null; // 새 노드의 이전을 null로 (가장 앞이라는 뜻)

        if (head != null) { // head에 값이 있으면 (list에 값이 존재했으면)
            head.pre = n; // 기존 노드 앞에 n 이 있음을 명시
            n.next = head; // 새 노드 뒤에 head가 있음을 명시
        }
        head = n; // head를 n으로 변경
        size++; // 사이즈 증가
        if (head.next == null) { // head 뒤에 아무것도 없으면
            tail = head; // tail과 head는 동일
        }
    }

    public void append(Object obj) { // 가장 뒤에 추가
        Node n = new Node(obj);

        if (head == null) { // head가 없으면 push로 실행
            push(obj);
            return;
        }

        tail.next = n; // tail의 다음노드로 새 노드 추가
        n.next = null; // 새 노드의 다음을 null로 (가장 뒤라는 뜻)
        n.pre = tail; // 새 노드의 이전 노드는 tail
        tail = n; // tail을 새 노드로 변경
        size++;
    }

    public void insertAt(Object obj, int idx) {
        if (idx == 0) {
            push(obj);
            return;
        }

        Node preNode = getNode(idx - 1); // 넣으려는 위치 직전의 노드
        Node nxtNode = preNode.next; // 넣으려는 위치 다음의 노드

        if (nxtNode == null) { // 다음 노드가 없을 경우
            append(obj); // 마지막에 넣는 경우임으로 append
            return;
        }

        Node n = new Node(obj);

        preNode.next = n; // 이전 노드 뒤 새노드 추가
        n.pre = preNode; // 새노드 앞 이전노드 저장

        nxtNode.pre = n; // 다음 노드 앞 새노드 추가
        n.next = nxtNode; // 새노드 뒤 다음노드 저장

        size++;
    }

    public Object removeAt(int idx) {
        Object result;
        if (idx == 0) {
            result = head.data;
            head = head.next;
            size--;
            return result;
        }
        if (idx == size - 1) {
            result = tail.data;
            tail = tail.pre;
            size--;
            return result;
        }

        Node curNode = getNode(idx);
        curNode.pre.next = curNode.next;
        curNode.next.pre = curNode.pre;

        result = curNode.data;
        curNode = null;
        size--;
        return result;
    }

}
