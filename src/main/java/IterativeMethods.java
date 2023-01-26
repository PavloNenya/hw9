import java.util.Scanner;

/**
 * Implemented tasks:
 * <p>1. Power of a number
 * <p>2. Stars triangle
 * <p>3. Multiply numbers
 * <p>4. Greatest common divisor of two numbers
 *
 * @author pavel
 * */
public class IterativeMethods {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Number in power of: " );
        System.out.println(pow(sc.nextInt(),sc.nextInt()));
        System.out.println("Enter number of stars: ");
        System.out.println(stars(sc.nextInt()));
        System.out.println("Enter numbers you want to multiply: " );
        System.out.println(multiply(sc.nextInt(), sc.nextInt()));
        System.out.println("Greater common divisor of numbers: " );
        System.out.println(gcd(sc.nextInt(), sc.nextInt()));
    }

    /**
     * Method multiplies m by n with recursion sum of <b>m</b> number of <b>ns</b> or <b>n</b> number of <b>ms</b>
     * Also calculates optimal way to multiply numbers, for example for multiplying 2 by 1000 it's easier to add 1000
     * two times instead of adding 2 thousand times.
     *
     * @param m the first number
     * @param n the number of times to multiply m by itself
     * @return The product of m and n.
     */
    private static int multiply(int m, int n) {
        if(n == 0 || m == 0) return 0;
        if(n > m) {
            var tmp = n;
            n = m;
            m = tmp;
        }
        int result = 0;
        while(n != 0) {
            result += m;
            n--;
        }
        return result;
    }

    /**
     * Returns a string with stars triangle with n height
     *
     * @param n the height of triangle
     * @return A string of stars
     */
    private static String stars(int n) {
        String result = "";
        for(int i = 0; i < n; i++) {
            int j = i;
            while(j >= 0) {
                result += '*';
                j--;
            }
            if(i!=n-1)result += '\n';
        }

        return result;
    }

    /**
     * Calculates the greatest common divisor of a and b
     *
     * @param a first number
     * @param b second number
     * @return gcd of two numbers
     * */
    private static int gcd(int a, int b) {
        if(a < b) {
            int tmp = b;
            b = a;
            a = tmp;
        }
        for(int i = a; i > 0; i--) {
            if(a%i==0 && b%i==0) {
                return i;
            }
        }
        return 1;
    }

    /**
     * Calculates m to the power of n
     *
     * @param m the base
     * @param n the number of times we want to multiply m by itself
     * @return The value of m to the power of n.
     */
    private static double pow(double m, int n) {
        double result = 1;
        while(n!=0) {
            result*=m;
            n--;
        }
        return result;
    }

}
