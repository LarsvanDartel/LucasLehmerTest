public class Primes {
    boolean[] isPrime;
    int curIdx = 2;
    final int N;
    public Primes(int n) {
        this.N = n;
        // initially assume all numbers are prime
        isPrime = new boolean[n+1];

        for(int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for(int factor = 2; factor * factor <= n; factor++) {
            if (isPrime[factor]) {
                for(int i = factor; factor*i <= n; i++) {
                    isPrime[factor*i] = false;
                }
            }
        }
    }

    public int getNextPrime() {
        if (curIdx > N) {
            return -1;
        }
        while(!isPrime[curIdx]) {
            curIdx++;
            if (curIdx > N) {
                return -1;
            }
        }
        return curIdx++;
    }
}
