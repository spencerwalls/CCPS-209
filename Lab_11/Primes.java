import java.util.*;
import java.lang.Math;

class Primes {
    
    private static List<Integer> al = new ArrayList<Integer>();
    private static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    public static boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        else if (n == 2) {
            return true;
        }
        else {
            for (int i = 2; i <= Math.sqrt(n); i += 2) {
                if (n % i == 0) {
                    return false;
                }
                if (i == 2) {
                    i--;
                }
            }
        }
        return true; 
    }
    
    private static void expandPrimes(int n) {
        int i = al.get(al.size() - 1);
        while (al.size() < (n + 1)) {
            if (i == 2) {
                i--;
            }
            if (isPrime(i + 2)) {
                al.add(i + 2);
            }
            i += 2;
        }
    }       
    
    public static int kthPrime(int k) {
        if (al.size() == 0) {
            al.add(2);
        }
        expandPrimes(k);
        return al.get(k);
    }
    
    public static List<Integer> factorize(int n) {
        List<Integer> list = new ArrayList<Integer>();
        int temp = n;
        int primeFactor = 0;
        if (map.containsKey(n)) {
            list.add(map.get(n));
            n /= map.get(n);
        }
        for (int i = 2; i <= n; i += 2) {
            while (n % i == 0) {
                list.add(i);
                n /= i;
            }
            primeFactor = i;
            if (i == 2) {
                i--;
            }
        }
        map.putIfAbsent(temp, primeFactor);
        Collections.sort(list);
        return list;
    }
}