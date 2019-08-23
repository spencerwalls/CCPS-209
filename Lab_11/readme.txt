Lab 11: Prime Numbers and Factorization
JUnit: PrimesTest.java

"All programming is an exercise in caching." (Terje Mathisen)

This lab tackles the classic and important problem of prime numbers, positive integers that are exactly divisible only by one and by themselves. Create a class Primes to contain the following three static methods to quickly produce and examine integers for their primality.

public static boolean isPrime(int n)

Checks whether the parameter integer n is a prime number. For this lab, it is sufficient to use the primality test algorithm that simply loops through all potential integer factors up to the square root of n and stops as soon as it finds one factor. (If an integer has any nontrivial factors, at least one of these factors has to be less than or equal to its square root, so it is pointless to look for any such factors past that point if you haven't already found some.)

public static int kthPrime(int k)

Find and return the k:th element (counting from zero, as usual in computer science) from the infinite sequence of all prime numbers 2, 3, 5, 7, 11, 13, 17, 19, 23, ... This method may assume that k is nonnegative.

public static List<Integer> factorize(int n)

Compute and return the list of prime factors of the positive integer n. The exact subtype of the returned List does not matter here, but the returned list must contain the prime factors of n in ascending sorted order, each prime factor listed exactly as many times as it appears in the product. For example, when called with the argument n = 220, this method would return some kind of List<Integer> object that prints out as [2, 2, 5, 11].

To make the previous methods maximally speedy and efficient, this entire exercise is all about caching and remembering the things that you have already found out so that you don't need to waste time finding out those same things later. As the famous space-time tradeoff principle of computer science informs us, you can sometimes make your program run faster by making it use more memory. Since these days we are blessed with ample memory to splurge around with, we are usually happy to accept this tradeoff.

This class should maintain a private instance of List<Integer> in which you store the sequence of the prime numbers that you have already generated, which then allows you to quickly look up and return the k:th prime number in the method kthPrime, and also to quickly iterate through the prime numbers up to the square root of n inside the method isPrime. You can use the example program primes.py from the instructor's Python version of CCPS 109 as a model of this idea. It would also be a good idea to write a private helper method expandPrimes that finds and appends new prime numbers to this list as needed by the isPrime and kthPrime methods.

To speed up the factorize method, you can use an instance of Map<Integer, Integer> that remembers, for each integer key n stored in it, some non-trivial factor of n that you have discovered earlier. If this map tells you that the integer n has a factor p, the prime factorization of n consists of p followed the prime factorization of n / p. (To save memory, you can impose a cutoff threshold so that prime factors that are less than that threshold are not stored in this map, since they would be quickly found with the factor searching loop anyway.)

To qualify for the two lab marks, the automated tester must successfully finish all three tests within one minute when run concurrently on instructor's Mac desktop bought in 2012. Speed is of the essence here. (Currently, the instructor's model solution takes about 7 seconds to complete the automated tester in that environment.)
