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
 * Tests the Tower class to ensure it works properly.
 * 
 * @author etsub
 * @version Oct 21, 2025
 */
public class TowerTest
    extends TestCase
{
    private Tower leftTower;
    private Tower middleTower;
    private Tower rightTower;
    private Disk smallDisk;
    private Disk mediumDisk;
    private Disk largeDisk;

    /**
     * Sets up the test case
     */
    public void setUp()
    {
        leftTower = new Tower(Position.LEFT);
        middleTower = new Tower(Position.CENTER);
        rightTower = new Tower(Position.RIGHT);

        smallDisk = new Disk(10);
        mediumDisk = new Disk(20);
        largeDisk = new Disk(30);
    }


    /**
     * Tests the constructor creates tower with correct position.
     */
    public void testConstructor()
    {
        assertEquals(Position.LEFT, leftTower.position());
        assertEquals(Position.CENTER, middleTower.position());
        assertEquals(Position.RIGHT, rightTower.position());
        assertTrue(leftTower.isEmpty());
    }


    /**
     * Tests position method returns correct position.
     */
    public void testPosition()
    {
        assertEquals(Position.LEFT, leftTower.position());
        assertEquals(Position.CENTER, middleTower.position());
        assertEquals(Position.RIGHT, rightTower.position());
    }


    /**
     * Tests push on empty tower succeeds.
     */
    public void testPushOnEmptyTower()
    {
        leftTower.push(largeDisk);
        assertEquals(1, leftTower.size());
        assertEquals(largeDisk, leftTower.peek());
    }


    /**
     * Tests push with smaller disk on larger disk succeeds.
     */
    public void testPushSmallerOnLarger()
    {
        leftTower.push(largeDisk);
        leftTower.push(mediumDisk);
        leftTower.push(smallDisk);

        assertEquals(3, leftTower.size());
        assertEquals(smallDisk, leftTower.peek());
    }


    /**
     * Tests push with larger disk on smaller disk throws exception.
     */
    public void testPushLargerOnSmaller()
    {
        leftTower.push(smallDisk);

        Exception exception = null;
        try
        {
            leftTower.push(mediumDisk);
        }
        catch (IllegalStateException e)
        {
            exception = e;
        }

        assertNotNull(exception);
        assertTrue(exception instanceof IllegalStateException);
        assertEquals(1, leftTower.size());
    }


    /**
     * Tests push with equal sized disk throws exception.
     */
    public void testPushEqualSizedDisk()
    {
        Disk disk1 = new Disk(15);
        Disk disk2 = new Disk(15);

        leftTower.push(disk1);

        Exception exception = null;
        try
        {
            leftTower.push(disk2);
        }
        catch (IllegalStateException e)
        {
            exception = e;
        }

        assertNotNull(exception);
        assertTrue(exception instanceof IllegalStateException);
    }


    /**
     * Tests push with null disk throws IllegalArgumentException.
     */
    public void testPushNull()
    {
        Exception exception = null;
        try
        {
            leftTower.push(null);
        }
        catch (IllegalArgumentException e)
        {
            exception = e;
        }

        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);
    }


    /**
     * Tests multiple valid pushes in sequence.
     */
    public void testMultipleValidPushes()
    {
        leftTower.push(largeDisk);
        assertEquals(1, leftTower.size());

        leftTower.push(mediumDisk);
        assertEquals(2, leftTower.size());

        leftTower.push(smallDisk);
        assertEquals(3, leftTower.size());

        assertEquals(smallDisk, leftTower.peek());
    }


    /**
     * Tests pop after push works correctly.
     */
    public void testPushAndPop()
    {
        leftTower.push(largeDisk);
        leftTower.push(mediumDisk);

        Disk popped = leftTower.pop();
        assertEquals(mediumDisk, popped);
        assertEquals(1, leftTower.size());
        assertEquals(largeDisk, leftTower.peek());
    }


    /**
     * Tests tower inherits LinkedStack methods.
     */
    public void testInheritedMethods()
    {
        assertTrue(leftTower.isEmpty());

        leftTower.push(largeDisk);
        assertFalse(leftTower.isEmpty());

        leftTower.clear();
        assertTrue(leftTower.isEmpty());
        assertEquals(0, leftTower.size());
    }


    /**
     * Tests toString inherited from LinkedStack.
     */
    public void testToString()
    {
        assertEquals("[]", leftTower.toString());

        leftTower.push(largeDisk);
        leftTower.push(mediumDisk);
        leftTower.push(smallDisk);

        String expected = "[" + smallDisk.toString() + ", "
            + mediumDisk.toString() + ", " + largeDisk.toString() + "]";
        assertEquals(expected, leftTower.toString());
    }


    /**
     * Tests that after invalid push, tower state is unchanged.
     */
    public void testInvalidPushDoesNotModifyTower()
    {
        leftTower.push(smallDisk);
        int originalSize = leftTower.size();
        Disk originalTop = leftTower.peek();

        try
        {
            leftTower.push(mediumDisk);
        }
        catch (IllegalStateException e)
        {
            // Expected
        }

        assertEquals(originalSize, leftTower.size());
        assertEquals(originalTop, leftTower.peek());
    }
}
