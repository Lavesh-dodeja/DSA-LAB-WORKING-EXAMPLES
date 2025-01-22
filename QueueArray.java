public class QueueArray {
        private int[] arr;
        private int front;  
        private int rear; 
        private int size; 
        private int count;  
    
        QueueArray(int size) {
            this.size = size;
            arr = new int[size];
            front = 0;
            rear = -1;
            count = 0;
        }
    
        public void enqueue(int element) {
            if (isFull()) {
                System.out.println("Queue is full. Cannot enqueue element: " + element);
                return;
            }
            rear = (rear + 1) % size; 
            arr[rear] = element;
            count++;
        }
    
    
        public int dequeue() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue is empty! Cannot dequeue.");
            }
            int element = arr[front];
            front = (front + 1) % size; 
            count--;
            return element;
        }
    
    
        public boolean isFull() {
            return count == size;
        }
    
    
        public boolean isEmpty() {
            return count == 0;
        }
    
        
        public int Size() {
            return count;
        }
    
    public static void main(String[] args) {
        QueueArray queueArray = new QueueArray(5);
    
        // Enqueue elements
        queueArray.enqueue(1);
        queueArray.enqueue(2);
        queueArray.enqueue(3);
        queueArray.enqueue(4);

        System.out.println("Size of queue after enqueue operations: " + queueArray.Size());

    
        while (!queueArray.isEmpty()) {
            System.out.println(queueArray.dequeue());
        }

        System.out.println("\nSize of queue after dequeue operations: " + queueArray.Size());

    }
}
