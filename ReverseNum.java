public class ReverseNum {
    public static void main(String[] args) {
        int num = 12345;
        int[] stack = new int[10];
        int top = -1;

        while (num > 0) {
            stack[++top] = num % 10; 
            num /= 10;
        }

        int reversedNum = 0;
        int place = 1;
        while (top >= 0) {
            reversedNum += stack[top--] * place;
            place *= 10;
        }

        System.out.println(reversedNum);
    }
}


