# Implementing-list-using-Linked-Nodes
Implement a specific kind of list using linked nodes.

Project Description
You are given an interface for a type of list. The list works like this:
     entries can only be added to and removed from the beginning or end of the list
     entries can be accessed in any position
     entries begin at index 0
Write a class that implements this interface. The class uses linked nodes to implement the list.

Your class must compile and have the following implemented methods. Follow the API
descriptions from the interface file and the additional characteristics listed below. You can choose
whether or not to include a constructor.
- addFront(T)
- addBack(T)
- removeFront()
- removeBack()
- contains(T)
- indexOf(T)
- lastIndexOf(T)
- getEntry(int)
- display()
     see the tester program for the format of the output
     the output should list the contents plus the value of head and tail (when the list is not
          empty)
- clear()
- isEmpty()
- size()
- Style and Efficiency
     Use a head and tail reference.
     Do not use additional instance data variables other than head and tail.
     Ensure that methods are O(1) or O(n).
     Your class should follow Java coding conventions and best practices.
     Follow naming conventions for variables, classes, and methods.
     Reduce duplicated code.
     
Given the interface that you will implement. There is also provided a shell file for your
class and a tester file that displays the expected output of using your list class.
