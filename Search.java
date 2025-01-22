public class Search{
    public static void main(String[] args) {
        int[] stack = {10, 20, 30, 40};
        int top = stack.length - 1;
        int element = 30;
        int position = -1;

        for (int i = top; i >= 0; i--) {
            if (stack[i] == element) {
                position = stack.length - i;
                break;
            }
        }

        System.out.println("Position: " + position);
    }
}

