// Project 3 Fall 2025
// Virginia Tech Honor Code Pledge:

//

// As a Hokie, I will conduct myself with honor and integrity at all times.

// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.

// -- etsub habtewold (etsubh)
// LLM Statement:

// I have not used any assistance for the assignment beyond course resources and
// staff.
package towerofhanoi;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * This class tests the Disk class to make sure all of its methods work as
 * expected.
 * 
 * @author etsub
 * @version Oct 22, 2025
 */
public class DiskTest
    extends TestCase
{
    private Disk disk1;
    private Disk disk2;
    private Disk disk3;

    /**
     * Sets up test fixtures before each test method.
     */
    public void setUp()
    {
        disk1 = new Disk(10);
        disk2 = new Disk(20);
        disk3 = new Disk(10);
    }


    /**
     * Tests the constructor creates a disk with correct width.
     */
    public void testConstructor()
    {
        assertEquals(10, disk1.getWidth());
        assertEquals(PuzzleWindow.DISK_HEIGHT, disk1.getHeight());
        assertNotNull(disk1.getBackgroundColor());
    }


    /**
     * Tests compareTo method with smaller disk.
     */
    public void testCompareToSmaller()
    {
        assertTrue(disk1.compareTo(disk2) < 0);
    }


    /**
     * Tests compareTo method with larger disk.
     */
    public void testCompareToLarger()
    {
        assertTrue(disk2.compareTo(disk1) > 0);
    }


    /**
     * Tests compareTo method with equal disk.
     */
    public void testCompareToEqual()
    {
        assertEquals(0, disk1.compareTo(disk3));
    }


    /**
     * Tests compareTo throws exception for null parameter.
     */
    public void testCompareToNull()
    {
        Exception exception = null;
        try
        {
            disk1.compareTo(null);
        }
        catch (IllegalArgumentException e)
        {
            exception = e;
        }
        assertNotNull(exception);
    }


    /**
     * Tests toString method returns width as string.
     */
    public void testToString()
    {
        assertEquals("10", disk1.toString());
        assertEquals("20", disk2.toString());
    }


    /**
     * Tests equals method with same disk.
     */
    public void testEqualsSameDisk()
    {
        assertTrue(disk1.equals(disk1));
    }


    /**
     * Tests equals method with equal disk.
     */
    public void testEqualsEqualDisk()
    {
        assertTrue(disk1.equals(disk3));
        assertTrue(disk3.equals(disk1));
    }


    /**
     * Tests equals method with different disk.
     */
    public void testEqualsDifferentDisk()
    {
        assertFalse(disk1.equals(disk2));
        assertFalse(disk2.equals(disk1));
    }


    /**
     * Tests equals method with null.
     */
    public void testEqualsNull()
    {
        assertFalse(disk1.equals(null));
    }


    /**
     * Tests equals method with different class object.
     */
    public void testEqualsDifferentClass()
    {
        String notADisk = "not a disk";
        assertFalse(disk1.equals(notADisk));
    }
}
