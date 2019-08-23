Lab 0(B): Putting Details Together, Part I
JUnit: P2J2Test.java

Create a new class named P2J2 inside the very same BlueJ project as you placed your P2J1 class in the previous lab. Inside this new class P2J2, write the following four methods.

public static String removeDuplicates(String text)

Given a text string, create and return a new string that is otherwise the same but every run of equal consecutive characters has been turned into a single character. For example, given the arguments "Kokkarinen" and "aaaabbxxxxaaxa", this method would return "Kokarinen" and "abxaxa", respectively. Note that only the consecutive duplicate occurrences of the same character are eliminated, but the later occurrences of the same character remain in the result as long as there was some other character between these occurrences.

public static String uniqueCharacters(String text)

Given a text string, create and return a new string that contains each character only once, with the characters given in order in which they appear in the original string. For example, given the arguments "Kokkarinen" and "aaaabbxxxxaaxa", this method would return "Kokarine" and "abx", respectively.

You can solve this problem with two nested loops, the outer loop iterating through the positions of the text, and the inner loop iterating through all previous positions to look for a previous occurrence of that character. Or you can be much more efficient, and use a HashSet<Character> to remember which characters you have already seen, so that you can determine in O(1) time whether you append the next character into the result.

public static int countSafeSquaresRooks(int n, boolean[][] rooks)

Some number of rooks have been placed on some squares of a generalized n-by-n chessboard. The two-dimensional array rooks of boolean truth values tells you which squares contain a rook. (This array is guaranteed to be exactly n-by-n in size.) This method should count how many remaining squares are safe from these rooks, that is, do not contain any rooks in the same row or column, and return that count.

public static int recaman(int n)

Compute and return n:th term of the Recamán's sequence, as defined on Wolfram Mathworld, starting from the term a1 = 1. See the definition of this sequence on that page. For example, when called with n = 7, this method would return 20, and when called with n = 19, return 62. (More values are listed at OEIS sequence A005132.)

To make your function fast and efficient even when computing the sequence element for large values of n, you should use a sufficiently large boolean[] (size 10*n is certainly enough, and yet needs only 10 bits per each number) to keep track of which integer values are already part of the generated sequence, so that you can generate each element in constant time instead of having to loop through the entire previously generated sequence like some "Shlemiel".
