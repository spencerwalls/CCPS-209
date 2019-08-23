Lab 0(D): Lists of Integers
JUnit: P2J4Test.java

The fourth transition lab from Python to Java contains four more interesting problems take from the graded labs of the instructor's Python course. The four static methods to write here now deal with List<Integer> of Java (remember to import java.util.* at the top of the source code for your class) whose behaviour and operations are essentially the same as those of ordinary Python lists when used to contain only integers, except with a more annoying syntax.

public static List<Integer> runningMedianOfThree(List<Integer> items)

Create and return a new List<Integer> instance (of any subtype of List of your choice) whose first two elements are the same as that of original items, after which each element equals the median of the three elements in the original list ending in that position.  For example, when called with a list that prints out as [5, 2, 9, 1, 7, 4, 6, 3, 8], this method would return an object of type List<Integer> that prints out as [5, 2, 5, 2, 7, 4, 6, 4, 6].

public static int firstMissingPositive(List<Integer> items)

Given a list whose each element is guaranteed to be a positive integer, find and return the first positive integer missing from this list. For example, given a list that prints out as [7, 5, 2, 3, 10, 2, 9999999, 4, 6, 3, 1, 9, 2], this method should return 8. Given either the list [], [6, 2, 12345678] or [42] as an argument, this method should return 1.

public static void sortByElementFrequency(List<Integer> items)

Sort the elements of the given list in decreasing order of frequency, that is, how many times each element appears in this list. If two elements appear in the parameter list the same number of times, those elements should end up in ascending order of values, the same way as we do in ordinary sorting of list of integers. For example, given a list object that prints out as [4, 99999, 2, 2, 99999, 4, 4, 4], after calling this method that list object would print out as [4, 4, 4, 4, 2, 2, 99999, 99999].

As in all computer programming, you should allow the language and its standard library do your work for you instead of rolling your own logic. The method Collections.sort can be given a Comparator<Integer> strategy object that compares two integers for their ordering. A good idea might be to start by building a local counter map of type Map<Integer, Integer> that you use to keep track of how many times each value appears in the list. Next, define a local class that implements Comparator<Integer> and performs integer order comparisons by consulting this map for the frequency counts of those elements and returns the answer from that, reverting to ordinary integer order comparison in the case where the frequencies are equal.

public static List<Integer> factorFactorial(int n)

Compute and return the list of prime factors of the factorial of n (that is, the product of all positive integers up to n), with those prime factors sorted in ascending order and with each factor appearing in this list exactly as many times as it would appear in the prime factorization of that factorial. For example, when called with n = 10, this method would create and return a list that prints out as [2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 5, 5, 7]. (Multiplying all those little prime numbers together would produce the result of 3628800, which equals the product of the first ten positive integers.)

The factorial function n! grows exponentially, and for n > 11 its values would no longer fit inside the range of the int type of Java. Since this method must be able to work for values of n that are in the thousands, you cannot first compute the factorial of n and only then start breaking the resulting behemoth down to its prime factors. Instead, you need to build up the list of prime factors as you go, by appending the prime factors of the integer that you are currently multiplying into the factorial, and then sorting this entire list in the end before returning it.
