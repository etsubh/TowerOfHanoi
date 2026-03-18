// Project 3 Fall 2025
// Virginia Tech Honor Code Pledge:

//

// As a Hokie, I will conduct myself with honor and integrity at all times.

// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.

// -- etsub habtewold (etsubh)
// LLM Statement:

//

// During the preparation of this assignment, I, Etsub Habtewold used ChatGPT
// in the tower of hanoi project to better understand the UML and how the code
// is implemented.
// After using this tool, I reviewed and edited the content as needed to ensure
// its
// accuracy and take full responsibility for the content in relation to grading.
// I understand
// that I am responsible for being able to complete this work without the use of
// assistance.

package towerofhanoi;

import java.awt.Color;
import student.TestableRandom;
import cs2.Shape;

// -------------------------------------------------------------------------
/**
 * This class represents a single disk in the Tower of Hanoi game. Each disk has
 * a width, height, and a random color. Disks can be compared based on their
 * width to help enforce the puzzle rules.
 * 
 * @author etsub habtwold
 * @version Oct 21, 2025
 */
public class Disk
    extends Shape
    implements Comparable<Disk>
{
    // ----------------------------------------------------------
    /**
     * Create a new Disk object.
     * 
     * @param width
     *            the width
     */
    public Disk(int width)
    {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);

        TestableRandom random = new TestableRandom();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);

        Color randomColor = new Color(red, green, blue);
        this.setBackgroundColor(randomColor);
    }


    /**
     * Compares this disk to another disk based on width.
     * 
     * @param otherDisk
     *            the disk to compare to
     * @return negative if this disk is smaller, positive if larger, 0 if equal
     * @throws IllegalArgumentException
     *             if otherDisk is null
     */
    @Override
    public int compareTo(Disk otherDisk)
    {
        if (otherDisk == null)
        {
            throw new IllegalArgumentException("Cannot compare to null disk");
        }

        return this.getWidth() - otherDisk.getWidth();
    }


    /**
     * Returns a string representation of the disk showing its width.
     * 
     * @return the width of the disk as a string
     */
    public String toString()
    {
        return String.valueOf(this.getWidth());
    }


    /**
     * Checks if this disk is equal to another object. Two disks are equal if
     * they have the same width.
     * 
     * @param obj
     *            the object to compare to
     * @return true if the disks have the same width, false otherwise
     */
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }

        if (obj == null)
        {
            return false;
        }

        if (this.getClass() != obj.getClass())
        {
            return false;
        }

        Disk other = (Disk)obj;
        return this.getWidth() == other.getWidth();
    }
}
