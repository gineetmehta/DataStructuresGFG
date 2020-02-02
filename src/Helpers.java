public class Helpers {
    public static int getGCD(int num1, int num2) {
        if (num2 == 0) return num1;
        return getGCD(num2, num1 % num2);
    }
}
