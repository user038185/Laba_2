class Node {
    char elem;
    Node next;
}

public class Stack {
    Node head;

    Stack(Node head) {
        head = head;  // указатель на первый элемент
    }

    void Push(char el) {
        Node q = new Node();
        q.elem = el;
        q.next = head;
        head = q;
    }

    char Pop() {
        char res;
        Node q = new Node();
        res = head.elem;

        q = head;
        head = head.next;

        q = null;
        System.gc();

        return res;
    }

}