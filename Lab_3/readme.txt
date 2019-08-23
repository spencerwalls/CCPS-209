Lab 3: Extending an Existing Class
JUnit: AccessCountArrayListTest.java

In the third lab, you get to practice using class inheritance to create your own custom subclass versions of existing classes in Java with new functionality that did not exist in the original superclass. Your third task in this course is to use inheritance to create your own custom subclass AccessCountArrayList<E> that extends the good old workhorse ArrayList<E> from the Java Collection Framework. This subclass should maintain in an internal data field int count of how many times the methods get and set have been called. (The same int counter keeps the simultaneous count for both of these methods together.)

You should override the inherited get and set methods so that both of these methods first increment the access counter, and only then call the superclass version of that same method (use the prefix super in the method call to make this happen), returning whatever result that superclass version returned. In addition to these overridden methods inherited from the superclass, your class should define the following two brand new methods:

public int getAccessCount()

Returns the current count of how many times the get and set methods have been called for this object.

public void resetCount()

Resets the access count field of this object back to zero.
