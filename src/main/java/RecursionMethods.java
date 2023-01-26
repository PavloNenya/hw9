import java.util.Scanner;


/**
 * Implemented tasks:
 * <p>1. Ackermann function
 * <p>2. Power of a number
 * <p>3. Stars triangle
 * <p>4. Multiply numbers
 * <p>5. Greatest common divisor of two numbers
 *
 * @author pavel
 * */
public class RecursionMethods {
    public static void main(String[] args) {
        System.out.println("Ackermann function: " + ackermann(2, 3));
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
    private static int multiply(int m, int n){
        if(n == 0 || m == 0) return 0;

        if(m < 0 && n < 0) {
            return m < n ?
                    -m + multiply(m, n+1):
                    -n + multiply(m+1, n);
        } else if(m > 0 && n < 0) {
            return m > -n ?
                    -m + multiply(m, n+1):
                    n + multiply(m-1, n);
        }
        else if(m < 0){
            return -m > n ?
                    m + multiply(m, n-1):
                    -n + multiply(m+1, n);
        }
        else if(m > n){
            return m + multiply(m, n-1);
        }

        return n + multiply(m-1, n);
    }

    /**
     * Returns a string with stars triangle with n height
     *
     * @param n the height of triangle
     * @return A string of stars
     */
    private static String stars(int n) {
        if(n < 1) return "";
        if(n == 1) return "*";
        return stars(n-1)+ "\n" + stars_helper(n, 0);
    }

    /**
     * Method-helper for stars(int n) that returns m number of stars
     *
     * @param m number of stars that need to be returned
     * @param n number of current stars that will be returned
     * @return String with m number of stars
     * */
    private static String stars_helper(int m, int n) {
        if(n >= m) return "";
        return "*" + stars_helper(m, n+1);
    }

    /**
     * Calculates m to the power of n
     *
     * @param m the base
     * @param n the number of times we want to multiply m by itself
     * @return The value of m to the power of n.
     */
    private static double pow(double m, int n) {
        if(n == 0) return 1;
        if(n < 0) {
            n = -n;
            m = 1.0/m;
        }
        return m * pow(m, n-1);
    }

    /**
     * Calculates the greatest common divisor of a and b
     *
     * @param a first number
     * @param b second number
     * @return gcd of two numbers
     * */
    private static int gcd(int a, int b) {
        if (a % b == 0)
            return b;
        if (b % a == 0)
            return a;
        if (a > b)
            return gcd(a%b, b);
        return gcd(a, b%a);
    }

    /**
     *
     * @param m the number of times to recurse
     * @param n the number of rows
     * @return The Ackermann function is a recursive function that is not primitive recursive. It is defined as follows:
     */
    private static int ackermann(int m, int n) {
        if(m < 0 || n < 0) return 0;
        if(m == 0) return n+1;
        if(n == 0) return ackermann(m-1, 1);
        return ackermann(m-1, ackermann(m, n-1));
    }


}

