import java.util.Random;

public class Array {
    private int[] arr;

    // Default constructor makes an array of 10 elements
    public Array() {
        this(10);
    }

    // Constructor takes the number of elements as a parameter
    // Generates 'elements' number of random integers to populate the array
    public Array(int elements) {
        this.arr = new int[elements];
        Random random = new Random();

        for (int i = 0; i < elements; i++) {
            this.arr[i] = random.nextInt(100);
        }
    }

    public void printArray() {
        System.out.println("PRINTING ARRAY -------------");
        for (int value : this.arr) {
            System.out.print(value + " ");
        }
        System.out.println("\nDONE PRINTING -------------");
    }


    // Rotates the array left by n places
    // Uses a temporary array to perform the rotation
    public void rotateLeft(int n) {
        if (n <= 0) return;
        int arrLength = this.arr.length;
        if (n >= arrLength) n %= arrLength;
        int[] tempArray = new int[n];

        // Step 1. Copy first n elements into temp array
        // Step 2. Adjust the length - d elements to the left
        // Step 3. Write the elements of the temp array back to the original array
        System.arraycopy(this.arr, 0, tempArray, 0, n);
        System.arraycopy(this.arr, n, this.arr, 0, arrLength - n);
        System.arraycopy(tempArray, 0, this.arr, arrLength - n, n);

        System.out.println("||--- Rotated the array left by " + n + " places");
    }


}
