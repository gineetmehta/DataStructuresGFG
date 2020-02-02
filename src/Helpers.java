public class Helpers {
    public static int getGCD(int num1, int num2) {
        if (num2 == 0) return num1;
        return getGCD(num2, num1 % num2);
    }

    public static void printArray(int[] arr) {
        System.out.println("PRINTING ARRAY -------------");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println("\nDONE PRINTING -------------");
    }

    // Overloaded method, reverses the whole array
    public static void reverseArray(int[] arr) {
        int length = arr.length;
        Helpers.reverseArray(arr, 0, length-1);
    }

    // Overloaded method, reverses from the given startPos to the end
    public static void reverseArray(int[] arr, int startPos) {
        int length = arr.length;
        Helpers.reverseArray(arr, startPos, length-1);
    }

    public static void reverseArray(int[] arr, int startPos, int endPos) {
        if (startPos >= endPos) {
            System.out.println("Invalid! startPos " + startPos + " is greater than endPos " + endPos);
            return;
        }

        int temp;
        while (startPos < endPos) {
            temp = arr[startPos];
            arr[startPos] = arr[endPos];
            arr[endPos] = temp;
            startPos++;
            endPos--;
        }
    }
}
