import java.math.BigInteger;

public class App {

    public static boolean isMersennePrime(int power) {
        String number = "";
        for(int i = 0; i < power; i++) {
            number += "1";
        }
        BigInteger p = new BigInteger(number, 2);

        BigInteger a = new BigInteger("4");
        for(int i = 1; i < power-1; i++) {
            a = a.multiply(a).subtract(new BigInteger("2")).mod(p);
        }
        return a.equals(BigInteger.ZERO);
    }

    public static void main(String[] args) {
        // upper limit
        final int N = Integer.parseInt(args[0]);

        boolean[] isPrime = new boolean[N+1];
        
        // initially assume all numbers are prime
        for(int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        // for each number <= n,
        // check all possible ways to factor the numbers
        for(int factor = 2; factor * factor <= N; factor++) {
            // if the factor is prime
            if (isPrime[factor]) {
                // then all multiples of the factor are not
                for(int i = factor; factor*i <= N; i++) {
                    isPrime[factor*i] = false;
                }
            }
        }

        // loop over all numbers
        for(int i = 2; i <= N; i++) {
            // if they are prime
            if (isPrime[i]) {
                // and the corresponding meresnne number is prime
                if (isMersennePrime(i)) {
                    System.out.println(i);
                }
            }
        }

    }
}
