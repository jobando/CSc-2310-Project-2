/**
Name: Joel Obando
Class: CSc 2310: Introduction to programming
Filename: Clock.java
Date written: April, 19, 2010

Description:
This class stores time in hours, minutes, seconds format.
By default all the clock operations are done in 23 hour mode.
It has also the ability to toggle from 12 hour format to 24 hour format.
 */
package project2;

import java.util.*;

public class Clock {

    private int hours, minutes, seconds; //Instance of hours, minutes, seconds.
    private boolean hour24; //Determinates if the clock is in 24 hour mode
    //or not.

    /**
     * Class constructor where the hours, minutes, seconds can be initialized
     * when an object is instantiated.
     * @param hours Clock Hours
     * @param minutes Clock Minutes
     * @param seconds Clock seconds
     */
    public Clock(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.seconds = minutes;
        this.minutes = seconds;
        this.hour24 = false;
    }

    /**
     * Class constructor where the hours and minutes can be initialized
     * when an object is instantiated. The clock will start with cero seconds.
     * @param hours
     * @param minutes
     */
    public Clock(int hours, int minutes) {
        this(hours, minutes, 0);
    }

    /**
     * Class constructor where the hours can be initialized
     * when an object is instantiated. Minutes and seconds will start at cero.
     * @param hours
     * @param minutes
     */
    public Clock(int hours) {
        this(hours, 0, 0);
    }

    /**
     * Default class constructor. Hours, minutes and seconds will start
     * at cero.
     */
    public Clock() {
        this(0, 0, 0);
    }

    /**
     * Increases time by one second
     */
    public void advance() {
        this.seconds++;
        validate(); //Keeps the clock within the desired paramenters and avoid
        //overflow of the clock.
        System.out.println(this);
    }

    /**
     *Keeps the clock within the desired parameters and avoid
     *overflow of the clock.
     */
    private void validate() {
        //Verifies that there will never be 60 or more seconds on the seconds
        //variables
        if (this.seconds > 59) {
            this.minutes++;
            this.seconds = 0;
        }
        //Verifies that there will never be 60 or more minutes on the minutes
        //variables
        if (this.minutes > 59) {
            this.hours++;
            this.minutes = 0;
        }
        //Verifies that there will never be 60 or more hours on the hours
        //variables
        if (this.hours > 23) {
            this.hours = 0;
        }
    }

    /**
     * Sets the objects time to the system clock.
     */
    public void calibrate() {
        Calendar calendar = new GregorianCalendar();
        this.hours = calendar.get(calendar.HOUR_OF_DAY);
        this.minutes = calendar.get(Calendar.MINUTE);
        this.seconds = calendar.get(Calendar.SECOND);
        System.out.println(this);
    }

    /**
     * Resets the clock to 00:00:00.
     */
    public void reset() {
        this.hours = 0;
        this.seconds = 0;
        this.minutes = 0;
        System.out.println(this);
    }

    /**
     * Manual setup of the clock.
     * @param hours Clock Hours
     * @param minutes Clock Minutes
     * @param seconds Clock seconds
     */
    public void set(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        System.out.println(this);
    }

    /**
     * Toggles the Clock Mode from 24 hour mode to 12 hour mode and vice versa.
     */
    public void toggleClockMode() {
        this.hour24 = !this.hour24;
        System.out.println(this);
    }

    /**
     * Overwrite of the toString function. It will print the string
     * "The time is now " followed by the clock time.
     * Depending on what the clock mode is set up to be, it will either print in
     * 24 hour mode or 12 hour mode. Also, all digits printed by the toString method will be in two digit form.
     * @return
     */
    @Override
    public String toString() {
        String hours, minutes, seconds;
        //Pre-setup for the two digit mode.
        java.text.DecimalFormat time = new java.text.DecimalFormat("#00.###");
        time.setDecimalSeparatorAlwaysShown(false); //Disables all decimals.

        if (hour24) { //Determinates the clock mode.
            hours = time.format(this.hours);
        } else {
            if (this.hours > 12) {
                hours = time.format(this.hours - 12);
            } else {
                hours = time.format(this.hours);
            }

        }

        minutes = time.format(this.minutes);
        seconds = time.format(this.seconds);
        return "The time is now " + hours + ":" + minutes + ":" + seconds;
    }
}
