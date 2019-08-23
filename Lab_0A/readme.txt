Lab 0(A): Arrays and Arithmetic
JUnit: P2J1Test.java

The first three transition labs 0(A), 0(B) and 0(C) help you translate your existing Python knowledge into equivalent Java knowledge in both your brain and fingertips. You may already be familiar with these problems from the same instructor's CCPS 109 course, both the new Python version and the old Java version, but even if you are not, these problems are self-contained and can be solved by anybody aspiring to learn Java from either Java or some other language background. Each transition lab consists of four static methods for you to write, so there is no object oriented thinking involved yet. All four methods must pass the entire JUnit test suite to receive the two points for that lab. There are no partial marks given.

Inside your fresh new BlueJ project, create the first class that must be named exactly P2J1. Erase the nonsense template that BlueJ fills inside the class body in its misguided effort to "help" you, and in its place, write the following four methods.

public static long fallingPower(int n, int k)

Python has the integer exponentiation operator ** conveniently built in the language, whereas Java unfortunately does not have that operator. (In both languages, the caret character ^ denotes bitwise exclusive or that has nothing to do with exponentiation.)

However, in the related operation of falling power that is useful in many combinatorial formulas and denoted syntactically by underlining the exponent, each term that gets multiplied into the product is always one less than the previous term. For example, the falling power 83 would be computed as 8 * 7 * 6 = 336. Similarly, the falling power 105 would equal 10 * 9 * 8 * 7 * 6 = 30240. Nothing important changes if the base n is negative. For example, the falling power (-4)5 is computed the exact same way as -4 * -5 * -6 * -7 * -8  = -6720.

This method should compute and return the falling power nk where n can be any integer, and k can be any nonnegative integer. (Analogous to ordinary powers, n0 = 1 for any n.) The automated tester is designed so that your method does not need to worry about potential integer overflow as long as you perform computations using long type of 64-bit integers.

public static int[] everyOther(int[] arr)

Given an integer array arr, create and return a new array that contains precisely the elements in the even-numbered positions in the array arr. Make sure that your method works correctly for arrays of both odd and even lengths, and for arrays that contain zero or only one element. The length of the result array that you return must be exactly right so that there are no extra zeros at the end of the array.

public static int[][] createZigZag(int rows, int cols, int start)

This method creates and returns a new two-dimensional integer array, which in Java is really just a one-dimensional array whose elements are one-dimensional arrays of type int[]. The returned array must have the correct number of rows that each have exactly cols columns. This array must contain the numbers start, start + 1, ..., start + (rows * cols - 1) in its rows in order, except that the elements in each odd-numbered row must be listed in descending order.

For example, when called with rows = 4, cols = 5 and start = 4, this method should create and return the two-dimensional array whose contents are

4	5	6	7	8
13	12	11	10	9
14	15	16	17	18
23	22	21	20	19

when displayed in the traditional matrix form that is more readable for humans than the more realistic form of a one-dimensional array whose elements are one-dimensional arrays of rows.

public static int countInversions(int[] arr)

Inside an array a, an inversion is a pair of positions i and j inside the array that satisfy simultaneously both i < j and a[i] > a[j]. In combinatorics, the inversion count inside an array is a rough measure how "out of order" that array is. If an array is sorted in ascending order, it has zero inversions, whereas an n-element array sorted in reverse order has n(n-1)/2 inversions, the largest number possible. This method should count the inversions inside the given array arr, and return that count. (As you should always do when writing methods that operate on arrays, make sure that your method works correctly for arrays of any length, including the important special cases of zero and one.)

Once you have written all four methods, you can download and add the above JUnit test class P2J1Test.java to be placed separately inside the same BlueJ project. In the BlueJ project display window, the JUnit test classes show up as green boxes, as opposed to the usual yellow box like the ordinary classes. The JUnit test class cannot be compiled until your class contains all four methods exactly as they are specified. If you want to test one method without having to first write also the other three, you can implement the other three methods as one-liners with some placeholder return statement that returns zero or some other convenient dummy value. These methods will of course fail their respective tests, but having them around allows the tester to compile for you to test the one method that you have properly written. Once that is done, move on to replace the placeholder body of the next method with its actual body.

Once successfully compiled, you can right-click the JUnit test class to run either any one test, or all tests at once. The methods that receive a green checkmark have passed the tester and are complete. A red mark means that your method returned a wrong answer at some point, whereas a black mark means that your method crashed at some point and threw an exception.

Because these JUnit test methods, as implemented by your instructor, work by calling your method with a large number of pseudo-randomly generated test cases, and compute a checksum of the results returned by your method to be compared to the checksum produced by the instructor's private model answer, it is impossible to point out precisely which particular test cases are different and failing for your method. You should therefore write your own small test cases to find the errors in your code.
