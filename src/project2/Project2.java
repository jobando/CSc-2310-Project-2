/**
Name: Joel Obando
Class: CSc 2310: Introduction to programming
Filename: Project2.java
Date written: April, 19, 2010

Description:
This is class has the main method that executes the testing of the clock class.
 */
package project2;

public class Project2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Clock firstClock = new Clock();
        TestClock.startTest(firstClock); // Starts the test on the object
                                         //firstClock
    }
}
