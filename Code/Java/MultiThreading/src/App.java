
public class App {
    public static void main(String[] args) {
        final int N = Integer.parseInt(args[0]);
        final int NUM_THREADS = Integer.parseInt(args[1]);

        Primes primes = new Primes(N);

        PrimeValidator[] validators = new PrimeValidator[NUM_THREADS];
        for(int i = 0; i < NUM_THREADS; i++) {
            validators[i] = new PrimeValidator(primes);
            validators[i].start();
        }
    }
}
