import java.util.Random;

public class Array {
    private int[] arr;

    // Default constructor makes an array of 10 elements
    public Array() { this(10); }

    // Constructor takes the number of elements as a parameter
    // Generates 'elements' number of random integers to populate the array
    public Array(int elements) {
        this.arr = new int[elements];
        Random random = new Random();

        for (int i = 0; i < elements; i++) {
            this.arr[i] = random.nextInt(100);
        }
    }

    // Getter method for receiving the internal array
    public int[] getArray() { return this.arr; }


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


    // Rotates the array left by n places
    // Uses the juggling algorithm to perform the rotation
    public void rotateLeftJuggle(int n) {
        if (n <= 0) return;
        int arrLength = this.arr.length;
        if ( n >= arrLength) n %= arrLength;

        // Step 1. Find the GCD of the array length and n
        // Step 2. Divide the array into 'GCD' number of sets
        // Step 3. Perform the n rotations for ith numbers of each set
        int gcd = Helpers.getGCD(arrLength, n);
        for (int i = 0; i < gcd; i++) {
            int beginningElement = arr[i];
            int currentIndex = i;
            int nextIndex;

            // Calculate the nextIndex
            // if nextIndex >= arrLength it means we need to circle around the array
            // if nextIndex == i, currentIndex is where the first element should be placed (break loop)
            // Else just shift the element and continue further
            while (true) {
                nextIndex = currentIndex + n;
                if (nextIndex >= arrLength) nextIndex -= arrLength;
                if (nextIndex == i) break;
                arr[currentIndex] = arr[nextIndex];
                currentIndex = nextIndex;
            }
            arr[currentIndex] = beginningElement;
        }
        System.out.println("||--- Rotated the array left by " + n + " places");
    }

    // Rotates the array left by n places
    // Uses array reversal (and reversal of subarrays) to perform rotation
    public void rotateLeftReversal(int n) {
        if (n <= 0) return;
        if (n >= this.arr.length) n %= this.arr.length;

        // Step 1. Reverse the first n elements of the array
        // Step 2. Reverse the remaining elements of the array
        // Step 3. Reverse the whole array
        Helpers.reverseArray(this.arr, 0, n-1);
        Helpers.reverseArray(this.arr, n);
        Helpers.reverseArray(this.arr);
    }
}
