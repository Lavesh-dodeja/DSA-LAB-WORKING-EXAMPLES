import java.util.Stack;
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CustomQueue {
    Node front;
    Node rear;

    CustomQueue() {
        this.front = this.rear = null;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (this.rear == null) {
            this.front = this.rear = newNode;
            return;
        }
        this.rear.next = newNode;
        this.rear = newNode;
    }

    public int dequeue() {
        if (this.front == null) {
            throw new IllegalStateException("Queue is empty");
        }
        int data = this.front.data;
        this.front = this.front.next;
        if (this.front == null) {
            this.rear = null;
        }
        return data;
    }

    public boolean isEmpty() {
        return this.front == null;
    }

    public int size() {
        int count = 0;
        Node temp = front;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void display() {
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class ReverseKElment{
    public static void main(String[] args) {
        CustomQueue queue = new CustomQueue();
        for (int i = 1; i <= 10; i++) {
            queue.enqueue(i);
        }

        int k = 5;
        reverseFirstK(queue, k);

        queue.display();
    }

    public static void reverseFirstK(CustomQueue queue, int k) {
        if (queue.isEmpty() || k <= 0 || k > queue.size()) {
            return;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            stack.push(queue.dequeue());
        }

        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }

        int remainingSize = queue.size() - k;
        for (int i = 0; i < remainingSize; i++) {
            queue.enqueue(queue.dequeue());
        }
    }
}
