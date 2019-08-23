Lab 1: Polynomial Data Type: Basics
JUnit: PolynomialTestOne.java

After learning the basics of Java language, we may proceed to designing our own data types as classes, and writing the operations on these data types as methods that the outside users of our data type can then call to get the job done.

In spirit of the Fraction example class, your task in this and the two following labs is to implement the class Polynomial whose objects represent polynomials of variable x with integer coefficients, and their basic mathematical operations. If your math skills on polynomials have gone a bit rusty since you last had to use them somewhere back in high school, check out the page "Polynomials" in the "College Algebra" section of "Paul's Online Math Notes", the best and still very concise online resource for college level algebra and calculus that your instructor knows of.

As is the good programming style unless there exist good reasons to do otherwise, this class will be intentionally designed to be immutable so that Polynomial objects cannot change their internal state after they have been constructed. Immutability has many advantages in programming, even though those advantages might not be fully evident yet. The public interface of Polynomial should consist of the following instance methods.

@Override public String toString() 

Implement this method as your very first step to return some kind of meaningful, human readable String representation of this instance of Polynomial. This method is not subject to testing by the JUnit testers, so you can freely choose for yourself the exact textual representation that you would like this method to produce. Having this method will become immensely useful for debugging all the remaining methods that you will write inside Polynomial class!

public Polynomial(int[] coefficients)

The constructor that receives as argument the array of coefficients that define the polynomial. For a polynomial of degree n, the array coefficients contains exactly n + 1 elements so that the coefficient of the term of order k is in the element coefficients[k]. For example, the polynomial 5x3 - 7x + 42 that will be used as an example in all of the following methods would be represented as the coefficient array {42, -7, 0, 5}.

Terms missing from inside the polynomial are represented by having a zero coefficient in that position. However, the coefficient of the highest term of every polynomial should always be nonzero, unless the polynomial itself is identically zero. If this constructor is given as argument a coefficient array whose highest terms are zeroes, it should simply ignore those zero coefficients. For example, if given the coefficient array {-1, 2, 0, 0, 0}, the resulting polynomial would have the degree of only one, as if that coefficient array had been {-1, 2} without those pesky leading zeros. 

To guarantee that the Polynomial class is immutable so that no outside code can ever change the internal state of an object after its construction (well, at least not without resorting to underhanded Java tricks such as reflection), the constructor should not assign only the reference to the coefficients array to the private field of coefficients, but it absolutely positively must create a separate but identical defensive copy of the argument array, and store that defensive copy instead. This technique ensures that the stored coefficients of the polynomial do not change if some outsider later changes the contents of the shared coefficients array that was passed as the constructor argument.

public int getDegree()

Returns the degree of this polynomial, that is, the exponent of its highest order term. For example, the previous polynomial has degree 3. Constant polynomials have a degree of zero.

public int getCoefficient(int k)

Returns the coefficient for the term of order k. For example, the term of order 3 of the previous polynomial equals 5, and the term of order 0 equals 42. This method should work correctly even when k is negative or greater than the actual degree of the polynomial, and simply return zero in such cases of nonexistent terms. (This policy will also make some methods of Lab 2 much easier to implement.)

public long evaluate(int x)

Evaluates the polynomial using the value x for the unknown symbolic variable of the polynomial. For example, when called with x = 2 for the previous example polynomial, this method would return 68. To keep this simple, your method does not have to worry about potential integer overflows, but can assume that the final and intermediate results of this computation will always stay within the range of the primitive data type long.

Lab 2: Polynomial Data Type: Arithmetic
JUnit: PolynomialTestTwo.java

The second lab continues with the Polynomial class from the first lab by adding new methods for polynomial arithmetic to its source code. (There is no inheritance or polymorphism taking place yet in this lab.) Since the class Polynomial is designed to be immutable, none of the following methods should modify the objects this or other in any way, but return the result of that arithmetic operation as a brand new Polynomial object created inside that method.

public Polynomial add(Polynomial other)

Creates and returns a new Polynomial object that represents the result of polynomial addition of the two polynomials this and other. This method should not modify this or other polynomial in any way. Make sure that just like with the constructor, the coefficient of the highest term of the result is nonzero, so that adding the two polynomials 5x10 - x2 + 3x and -5x10 + 7, each having a degree 10, produces the result -x2 + 3x + 7 that has a degree of only 2 instead of 10.

public Polynomial multiply(Polynomial other)

Creates and returns a new Polynomial object that represents the result of polynomial multiplication of two polynomials this and other. Polynomial multiplication works by multiplying all possible pairs of terms between the two polynomials and adding them together, combining terms of equal degree together into a single term.

Lab 4: Polynomial Data Type: Comparisons
JUnit: PolynomialTestThree.java

In this fourth lab, we continue modifying the source code for the Polynomial class from the first two labs to allow equality and ordering comparisons to take place between objects of that type. Modify the class definition so that this class implements Comparable<Polynomial>. Then write the following methods to implement the equality and ordering comparisons.

@Override public boolean equals(Object other)

Returns true if the other object is also a Polynomial of the exact same degree as this, and that the coefficients of this and other polynomial are pairwise equal. If the other object is anything else, this method should return false.

(To save you some time, you can actually implement this method after implementing the method compareTo below, since once that method is available, the logic of equality checking will be a trivial one-liner after the instanceof check.)

@Override public int hashCode()

Whenever you override the equals method in any subclass, you should also override the hashCode method to ensure that two objects that are considered equal by the equals method will also have equal integer hash codes. This method computes and returns the hash code of this polynomial, used to store and find this object inside some instance of HashSet<Polynomial>, or some other hash table based data structure.

You get to choose for yourself the hash function that you implement, but like all hash functions, the result should depend on the degree and all of the coefficients of your polynomial. The hash function absolutely must satisfy the contract that whenever p1.equals(p2) holds for two Polynomial objects, then also p1.hashCode() == p2.hashCode() holds for them.

Of course, since this entire problem is so common and it seems silly to force everyone to reinvent the same wheel again, these days you can use the method hash in the java.util.Objects utility class to compute a good hash value for your coefficients.

public int compareTo(Polynomial other)

Implements the ordering comparison between this and other polynomial, as required by the interface Comparable<Polynomial>, allowing the instances of Polynomial to be sorted or stored inside some instance of TreeSet<Polynomial>. This method returns +1 if this is greater than other, -1 if other is greater than this, and returns a 0 if both polynomials are equal in the sense of the equals method.

A total ordering relation between polynomials can be defined by many different possible rules. Here we shall use an ordering rule that says that any polynomial of a higher degree is automatically greater than any polynomial of a lower degree, regardless of their coefficients. For two polynomials whose degrees are equal, the result of the order comparison is determined by the highest-order term for which the coefficients of the polynomials differ, so that the polynomial with a larger such coefficient is considered to be greater in this ordering.

Be careful to ensure that this method ignores the leading zeros of high order terms if you have them inside your polynomial coefficient array, and that the ordering comparison criterion is precisely the one defined in the previous paragraph. Otherwise the automated tester will reject your code, even if your code happened to define some other perfectly legal ordering relation from the infinitely many possible ordering relations!
