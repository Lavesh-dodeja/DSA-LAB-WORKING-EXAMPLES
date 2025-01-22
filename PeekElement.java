public class PeekElement{
    public static void main(String[] args) {
        int[] stack = {10, 20, 30, 40};
        int top = stack.length - 1;

        int peekValue = peek(stack, top);
        System.out.println("Top element: " + peekValue);
    }

    public static int peek(int[] stack, int top) {
        if (top >= 0) {
            return stack[top];
        }
        return -1;
    }
}
