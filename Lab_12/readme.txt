Lab 12: Interesting Prime Number Sequences
JUnit: PrimeGensTest.java

In Python, lazy sequences can be conveniently produced with generators, special functions that yield their results one element at the time and always continue their execution from the exact point where they left off in the previous call, instead of always starting their execution of the function body from the beginning the way ordinary functions do in both Python and Java. The Java language does not have generators, but the idea of lazy iteration over computationally generated infinite sequences is powerful and very much worth learning, and fits well into the Iterator<E> class hierarchy of Java Collection Framework.

This lab continues the previous lab by using its methods isPrime and kthPrime as helper methods to implement the required functionality of producing the subsequence of all prime numbers that satisfy some additional requirements. Create a class PrimeGens inside which you write no fields or methods whatsoever, but three public static nested classes. Each of these classes acts as an infinite iterator of integers that are not explicitly stored inside some collection, but are generated lazily by computational means whenever the next number is requested by the user code.

Each of these three nested classes should have the two basic methods defined in the interface Iterator<Integer>. The method public boolean hasNext() should always return true, since all these sequences are infinite for our purposes. (It is currently unknown whether the twin primes sequence really is infinite, but at least it is known to be long enough that we can treat it as being infinite within the limited range of four-byte integers.) The method public Integer next() generates the next element of that sequence on command.

First, to help you get started with the required three nested classes, below is a complete model implementation of one such class that produces all palindromic prime numbers, for you to use as a model. Your three classes have the same structure, but of course use different logic inside the method next to find and return the next prime number that has the desired properties.

public static class PalindromicPrimes implements Iterator<Integer> {
  private int k = 0; // Current position in the prime sequence
  public boolean hasNext() { return true; } // Infinite sequence       
  public Integer next() {
    while(true) {
      int p = Primes.kthPrime(k++);
      String digits = "" + p;
      if(digits.equals(new StringBuilder(digits).reverse().toString())) {
        return p;
      }
    }
  }        
}    

Having carefully studied that code until you understand and can explain what each line does, the three nested classes that you write inside class PrimeGens for you to write are as follows. (You can quickly and easily test your implementations with a simple main method that first creates an instance of the said iterator, and then uses a for-loop to print out the first couple of dozen elements produced by that iterator, with you comparing the said sequence to the correct initial sequences given below.)

public static class TwinPrimes implements Iterator<Integer>

Generates all first components of the pairs of twin primes, that is, prime numbers p for which the integer p + 2 is also a prime number. This sequence begins 3, 5, 11, 17, 29, 41, 59, 71, 101, 107, 137, 149, 179, 191, 197, 227, 239, 269, 281, 311, ...

public static class SafePrimes implements Iterator<Integer>

Generates all safe primes, that is, primes that can be expressed in the form 2*p+1 where p is a prime number. This sequence begins 5, 7, 11, 23, 47, 59, 83, 107, 167, 179, 227, 263, 347, 359, 383, 467, 479, 503, 563, 587, 719, 839, 863, ...

public static class StrongPrimes implements Iterator<Integer>

Generates all strong primes, that is, prime numbers p that are larger than the mathematical average of the previous and next prime numbers around p in the sequence of all prime numbers. This sequence begins 11, 17, 29, 37, 41, 59, 67, 71, 79, 97, 101, 107, 127, 137, 149, 163, 179, 191, 197, 223, 227, 239, 251, ...
