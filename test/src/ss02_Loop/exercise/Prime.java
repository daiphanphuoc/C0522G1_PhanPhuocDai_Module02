package ss02_Loop.exercise;

public class Prime {
    public static void main(String[] args) {
        System.out.println(" dãy  số nguyên tố nhỏ hơn 100; ");
        isPrimeThan100();

        System.out.println("\n 20 số nguyên tố: ");
        isPrime20();

    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void isPrimeThan100() {
        for (int i = 2; i < 100; i++) {
            if (isPrime(i)) {
                System.out.print(i + "\t");
            }

        }
    }

    public static void isPrime20() {
        int i = 2;
        int count = 0;
        while (true) {

            if (isPrime(i)) {
                count++;
                System.out.print(i + "\t");
            }

            i++;

            if (count == 20) {
                break;
            }

        }
    }
}
