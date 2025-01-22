public class Getminium{
    public static void main(String[] args) {
        CustomQueue queue = new CustomQueue();
        queue.enqueue(8);
        queue.enqueue(3);
        queue.enqueue(9);
        queue.enqueue(1);
        queue.enqueue(4);

        int minValue = getMinimum(queue);
        System.out.println("Minimum value in the queue: " + minValue);
    }

    public static int getMinimum(CustomQueue queue) {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        int min = Integer.MAX_VALUE;
        int size = queue.size();
        
        for (int i = 0; i < size; i++) {
            int value = queue.dequeue();
            if (value < min) {
                min = value;
            }
            queue.enqueue(value);
        }

        return min;
    }
}

