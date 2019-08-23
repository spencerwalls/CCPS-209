import java.util.*;
import java.math.BigInteger;

class P2J5 {
    
    private static List<BigInteger> fibs = new ArrayList<BigInteger>();
    static { fibs.add(BigInteger.ONE); fibs.add(BigInteger.ONE); }

    public static List<BigInteger> fibonacciSum(BigInteger n) {
        List<BigInteger> fibSum = new ArrayList<BigInteger>();
        if (Collections.binarySearch(fibs, n) >= 0) {
            fibSum.add(n);
            return fibSum;            
        }
        else {
            BigInteger lastElement = fibs.get(fibs.size() - 1);
            while (n.compareTo(lastElement) > 0) {
                fibs.add(lastElement.add(fibs.get(fibs.size() - 2)));
                lastElement = fibs.get(fibs.size() - 1);
            }
            if (n == lastElement) {
                fibSum.add(n);
                return fibSum;
            }
            else {
                BigInteger zero = BigInteger.ZERO;
                BigInteger f = lastElement;
                int i = fibs.size() - 1;
                while (!n.equals(zero)) {
                    while (n.compareTo(f) < 0) {
                        f = fibs.get(i);
                        i--;
                    }
                    fibSum.add(f);
                    n = n.subtract(f);
                    i = fibs.lastIndexOf(f) - 1;               
                }
            }
        }
        return fibSum;
    }
        
    public static BigInteger sevenZero(int n) {
        BigInteger sevenZeroBigInt = BigInteger.ONE;
        BigInteger zero = BigInteger.ZERO;
        BigInteger nBigInt = BigInteger.valueOf(n);
        BigInteger lengthBigInt = BigInteger.ZERO;
        int lengthInt = 1;
        boolean numberFound = false;        
        while (!numberFound) {
            StringBuilder sevenZeroString = new StringBuilder("7");
            for (int i = 1; i < lengthInt; i++) {
                sevenZeroString.append("0");
            }
            String s = sevenZeroString.toString();
            sevenZeroBigInt = new BigInteger(s); 
            if (sevenZeroBigInt.mod(nBigInt).equals(zero)) {
                numberFound = true;
                return sevenZeroBigInt;
            }
            for (int i = 1; i < lengthInt; i++) {    
                sevenZeroString.replace(i, i + 1, "7");
                s = sevenZeroString.toString();
                sevenZeroBigInt = new BigInteger(s); 
                if (sevenZeroBigInt.mod(nBigInt).equals(zero)) {
                    numberFound = true;
                    return sevenZeroBigInt;
                }
            }
            lengthInt++;
        }
        return sevenZeroBigInt;
    }
}