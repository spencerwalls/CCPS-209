Lab 0(C): Putting Details Together, Part II
JUnit: P2J3Test.java

One last batch of transitional problems taken from the instructor's Python graded labs. Only three methods to write this time, though. The automated tester for these labs uses the warandpeace.txt text file, so make sure that this text file has been properly copied into your course labs project folder. This text file does not show up in the BlueJ project screen, even though it is part of the project directory.

public static void reverseAscendingSubarrays(int[] items)

Rearrange the elements of the given an array of integers in place (that is, do not create and return a new array) so that the elements of every maximal strictly ascending subarray are reversed. For example, given the array { 5, 7, 10, 4, 2, 7, 8, 1, 3 } (the colours here indicate the ascending subarrays and are not actually part of the argument), after executing this method, the elements of the array would be { 10, 7, 5, 4, 8, 7, 2, 3, 1 }.  Given the array { 5, 4, 3, 2, 1 }, it would become { 5, 4, 3, 2, 1 } since each element by itself is a maximal ascending subarray of length one.

public static String pancakeScramble(String text)

This nifty little problem is taken from the excellent Wolfram Challenges problem site where you can see examples of what the result should be for various arguments. Given a text string, construct a new string by reversing its first two characters, then reversing the first three characters of that, and so on, until the last round where you reverse your entire current string.

This problem is an exercise in Java string manipulation. For some mysterious reason, the Java String type does not come with a reverse method. The canonical way to reverse a Java string str is to first convert it to mutable StringBuilder, reverse its contents, and convert the result back to an immutable string, that is,

str = new StringBuilder(str).reverse().toString();

A bit convoluted, but does what is needed.

public static String reverseVowels(String text)

Given a text string, create and return a new string of same length where all vowels have been reversed, and all other characters are kept as they were. For simplicity, in this problem only the characters aeiouAEIOU are considered vowels, and y is never a vowel. For example, given the text string "computer science", this method would return the new string "cempetir sceunco".

Furthermore, to make this problem more interesting and the result look prettier, this method must maintain the capitalization of vowels based on the vowel character that was originally in the position that each new vowel character is moved into. For example, "Ilkka Markus" should become "Ulkka Markis" instead of "ulkka MarkIs". Use the handy utility methods in the Character wrapper class to determine whether some particular character is upper- or lowercase, and to convert some character to upper- or lowercase as needed.
