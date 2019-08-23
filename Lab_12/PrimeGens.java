import java.util.*;

class PrimeGens {
    
    public static class TwinPrimes implements Iterator<Integer> {
        private int k = 0;
        public boolean hasNext() { return true; } 
        public Integer next() {
            while (true) {
                int p = Primes.kthPrime(k++);
                if (Primes.isPrime(p + 2)) {
                    return p;
                }
            }
        } 
    }
    
    public static class SafePrimes implements Iterator<Integer> {
        private int k = 0;
        public boolean hasNext() { return true; }
        public Integer next() {
            while (true) {
                int p = Primes.kthPrime(k++);
                int safePrime = 2 * p + 1;
                if (Primes.isPrime(safePrime)) {
                    return safePrime;
                }
            }
        }
    }
    
    public static class StrongPrimes implements Iterator<Integer> {
        private int k = 1;
        public boolean hasNext() { return true; }
        public Integer next() {
            while (true) {
                int p = Primes.kthPrime(k); 
                int mean = (Primes.kthPrime(k - 1) + Primes.kthPrime(k + 1)) / 2;
                k++;
                if (p > mean) {
                    return p;
                }
            }
        }
    }
}
