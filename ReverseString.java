public class ReverseString {
    public static void main(String[] args) {
        String str = "lavesh";
        char[] stack = new char[str.length()];
        int top = -1;

        for (char c : str.toCharArray()) {
            stack[++top] = c;
        }

        StringBuilder reversed = new StringBuilder();
        while (top >= 0) {
            reversed.append(stack[top--]);
        }

        System.out.println(reversed.toString());
    }
}
