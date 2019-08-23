Lab 0(E): All Integers Great and Small

JUnit: P2J5Test.java

Since the methods in this lab are a bit more complicated, there are only two of them solve, unlike in the other transition labs. The Python integer type is unbounded and limited only by your available heap memory, and the Python virtual machine silently switches between different efficient representations for small and large integers, letting us think about the problem instead of the details of nitty gritty integer arithmetic, constantly worrying about overflow errors.

In Java, the java.math.BigInteger utility class lets you compute with similarly unlimited integers, but this being Java, the syntax is not as nice as the ordinary and natural syntax for primitive int type. For example, to add two such integers a and b, we need to say a.add(b) instead of a + b. Consult the rest of the methods of BigInteger from its API documentation as needed to solve the following problems.

public static List<BigInteger> fibonacciSum(BigInteger n)

Fibonacci numbers, that dusty and tired example of silly recursion in teaching introductory computer science, turn out to have more interesting combinatorial properties that make up good problems for us to solve. Relevantly for the current moment, any positive integer n can be broken down exactly one way as a sum of distinct Fibonacci numbers that add up to n, under the additional constraint that  no two consecutive Fibonacci numbers appear in this sum. (After all, if the sum contains two consecutive Fibonacci numbers Fi and Fi+1, these two can always be replaced by Fi+2 without affecting the total.)

The unique breakdown into Fibonacci numbers can be constructed with a greedy algorithm that simply finds the largest Fibonacci number f that is less than or equal to n. Add this f to the result list, and break down the rest of the number given by the expression n - f the same way. This method should create and return some kind of List<BigInteger> that contains the selected Fibonacci numbers in descending order. For example, when called with n = 1000000, this method would return a list that prints as [832040, 121393, 46368, 144, 55].

Your method must remain efficient even if n contains thousands of digits. To achieve this, maintain a list of Fibonacci numbers that you have generated so far initialized with

private static List<BigInteger> fibs = new ArrayList<>();
static { fibs.add(BigInteger.ONE); fibs.add(BigInteger.ONE); }

and then whenever the last Fibonacci number in this list is not big enough for your present needs, extend the list with the next Fibonacci number that you get by adding the last two known Fibonacci numbers. Keeping all your Fibonacci numbers that you have discovered so far in one sorted list allows you to do things such as using Collections.binarySearch to quickly determine if something is a Fibonacci number...

public static BigInteger sevenZero(int n)

Since seven is a famously lucky number in the Western culture, whereas zero is what nobody wants to be, let us look at those positive integers whose digits consist of some sequence of sevens, followed by some (possibly empty) sequence of zeros. For example, 0, 7, 77777, 7700000, 77777700, or 70000000000000000000000000000000000. Note that all sevens must be in one consecutive bunch, followed by all zeros in another consecutive bunch.

One of the examples of combinatorial thinking given in the excellent MIT online textbook "Mathematics for Computer Science" (PDF link to the updated 2018 version, for anybody who is interested in that sort of stuff) points out that for any positive integer n, there exists at least one positive integer thus constrained to sevens and zeroes that is divisible by n. This integer made of sevens and zeroes can get pretty humongous as n grows larger, but at least one such number must always exist for any integer n.

This method should find and return the smallest such integer that is divisible by the given n. The easiest way to do this would be to use two nested loops. The outer while-loop iterates through all possible lengths (that is, how many digits the number contains) of the number, and for each length, the inner for-loop iterates through all legal sequences of sevens followed by zeros of that total length. Keep going up until you find such number that is exactly divisible by n.

This process will always eventually terminate for any n, since such a number is always guaranteed to exist, although these numbers can easily become gargantuan. For example, for the argument value n = 12345, the resulting number consists of 822 copies of the digit seven followed by a single zero digit. To speed up the search, you can utilize an additional theorem given in the same book, that says that unless n is divisible by either 2 or 5, the sequence of sevens and zeros that is divisible by n is guaranteed to contain only sevens but no zeros. This ought to speed up your search by at least an order of magnitude for such easy values of n, since the quadratic number of possibilities is pruned down into a single linear branch 7, 77, 777, 7777, ....
