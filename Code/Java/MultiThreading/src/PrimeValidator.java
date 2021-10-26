import java.math.BigInteger;

public class PrimeValidator extends Thread {
    Primes primes;
    public PrimeValidator(Primes primes) {
        this.primes = primes;
    }
    public void run() {
        int p = primes.getNextPrime();
        do {
            this.validate(p);
            p = primes.getNextPrime();
        } while(p != -1);
    }

    public void validate(int power) {
        String number = "";
        for(int i = 0; i < power; i++) {
            number += "1";
        }
        BigInteger p = new BigInteger(number, 2);

        BigInteger a = new BigInteger("4");
        for(int i = 1; i < power-1; i++) {
            a = a.multiply(a).subtract(new BigInteger("2")).mod(p);
        }
        if (a.toString().equals("0")) {
            System.out.println(power);
        }
    }
}
