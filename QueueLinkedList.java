public class QueueLinkedList {

    private Node front;
    private Node rear; 
    private int size;   

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }


    QueueLinkedList() {
        front = null;
        rear = null;
        size = 0;
    }


    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = rear = newNode; 
        } else {
            rear.next = newNode;
            rear = newNode;       
        }
        size++;
    }


    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty! Cannot dequeue.");
        }
        int data = front.data; 
        front = front.next;     
        if (front == null) {    
            rear = null;
        }
        size--;
        return data;
    }


    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty! Cannot peek.");
        }
        return front.data;
    }


    public boolean isEmpty() {
        return front == null;
    }


    public int Size() {
        return size;
    }


    public void display() {
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    
    public static void main(String[] args) {
        QueueLinkedList queue = new QueueLinkedList();


        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.println("Queue after enqueue operations:");
        queue.display(); 

        System.out.println("Front element (peek): " + queue.peek());

    
        while (!queue.isEmpty()) {
            System.out.println("Dequeued element: " + queue.dequeue());
        }

        System.out.println("\nQueue size after dequeue operations: " + queue.Size());
    }
}
