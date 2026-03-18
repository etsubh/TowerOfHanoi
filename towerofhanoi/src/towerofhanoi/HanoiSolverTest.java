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
 * Tests the HanoiSolver class to make sure the Towers of Hanoi logic works
 * correctly for different numbers of disks.
 * 
 * @author etsub
 * @version Oct 21, 2025
 */
public class HanoiSolverTest
    extends TestCase
{
    private HanoiSolver solver;
    private HanoiSolver solver3;
    private HanoiSolver solver5;

    /**
     * Sets up for the tests
     */
    public void setUp()
    {
        solver = new HanoiSolver(1);
        solver3 = new HanoiSolver(3);
        solver5 = new HanoiSolver(5);
    }


    // ----------------------------------------------------------
    /**
     * Makes sure the constructor correctly stores the number of disks.
     */
    public void testConstructor()
    {
        assertEquals(1, solver.disks());
        assertEquals(3, solver3.disks());
        assertEquals(5, solver5.disks());
    }


    /**
     * Checks that the disks() method returns the right count.
     */
    public void testDisks()
    {
        assertEquals(1, solver.disks());
        assertEquals(3, solver3.disks());
        assertEquals(5, solver5.disks());
    }


    /**
     * Tests getTower returns correct tower for LEFT position.
     */
    public void testGetTowerLeft()
    {
        Tower leftTower = solver.getTower(Position.LEFT);
        assertNotNull(leftTower);
        assertEquals(Position.LEFT, leftTower.position());
    }


    /**
     * Tests getTower returns correct tower for CENTER position.
     */
    public void testGetTowerCenter()
    {
        Tower centerTower = solver.getTower(Position.CENTER);
        assertNotNull(centerTower);
        assertEquals(Position.CENTER, centerTower.position());
    }


    /**
     * Tests getTower returns correct tower for RIGHT position.
     */
    public void testGetTowerRight()
    {
        Tower rightTower = solver.getTower(Position.RIGHT);
        assertNotNull(rightTower);
        assertEquals(Position.RIGHT, rightTower.position());
    }


    /**
     * Tests getTower returns center tower for DEFAULT position.
     */
    public void testGetTowerDefault()
    {
        Tower defaultTower = solver.getTower(Position.DEFAULT);
        assertNotNull(defaultTower);
        assertEquals(Position.CENTER, defaultTower.position());
    }


    /**
     * Tests toString with empty towers.
     */
    public void testToStringEmpty()
    {
        assertEquals("[][][]", solver.toString());
    }


    /**
     * Tests toString with disks on towers.
     */
    public void testToStringWithDisks()
    {
        Disk disk1 = new Disk(10);
        Disk disk2 = new Disk(20);
        Disk disk3 = new Disk(30);

        solver3.getTower(Position.LEFT).push(disk1);
        solver3.getTower(Position.CENTER).push(disk2);
        solver3.getTower(Position.RIGHT).push(disk3);

        assertEquals("[10][20][30]", solver3.toString());
    }


    /**
     * Tests toString with multiple disks on one tower.
     */
    public void testToStringMultipleDisks()
    {
        Disk disk1 = new Disk(15);
        Disk disk2 = new Disk(5);
        Disk disk3 = new Disk(25);

        solver3.getTower(Position.LEFT).push(disk1);
        solver3.getTower(Position.LEFT).push(disk2);
        solver3.getTower(Position.CENTER).push(disk3);

        assertEquals("[5, 15][25][]", solver3.toString());
    }


    /**
     * Tests solve with 1 disk.
     */
    public void testSolveOneDisk()
    {
        Disk disk = new Disk(10);
        solver.getTower(Position.LEFT).push(disk);

        assertEquals("[10][][]", solver.toString());

        solver.solve();

        assertEquals("[][][10]", solver.toString());
        assertTrue(solver.getTower(Position.LEFT).isEmpty());
        assertTrue(solver.getTower(Position.CENTER).isEmpty());
        assertEquals(1, solver.getTower(Position.RIGHT).size());
        assertEquals(disk, solver.getTower(Position.RIGHT).peek());
    }


    /**
     * Tests solve with 3 disks.
     */
    public void testSolveThreeDisks()
    {
        Disk small = new Disk(10);
        Disk medium = new Disk(20);
        Disk large = new Disk(30);

        solver3.getTower(Position.LEFT).push(large);
        solver3.getTower(Position.LEFT).push(medium);
        solver3.getTower(Position.LEFT).push(small);

        assertEquals("[10, 20, 30][][]", solver3.toString());

        solver3.solve();

        assertEquals("[][][10, 20, 30]", solver3.toString());
        assertTrue(solver3.getTower(Position.LEFT).isEmpty());
        assertTrue(solver3.getTower(Position.CENTER).isEmpty());
        assertEquals(3, solver3.getTower(Position.RIGHT).size());
    }


    /**
     * Tests solve with 5 disks.
     */
    public void testSolveFiveDisks()
    {
        Disk disk1 = new Disk(50);
        Disk disk2 = new Disk(40);
        Disk disk3 = new Disk(30);
        Disk disk4 = new Disk(20);
        Disk disk5 = new Disk(10);

        solver5.getTower(Position.LEFT).push(disk1);
        solver5.getTower(Position.LEFT).push(disk2);
        solver5.getTower(Position.LEFT).push(disk3);
        solver5.getTower(Position.LEFT).push(disk4);
        solver5.getTower(Position.LEFT).push(disk5);

        assertEquals(5, solver5.getTower(Position.LEFT).size());

        solver5.solve();

        assertTrue(solver5.getTower(Position.LEFT).isEmpty());
        assertTrue(solver5.getTower(Position.CENTER).isEmpty());
        assertEquals(5, solver5.getTower(Position.RIGHT).size());
        assertEquals(disk5, solver5.getTower(Position.RIGHT).peek());
    }


    /**
     * Tests that towers are independent objects.
     */
    public void testTowersAreIndependent()
    {
        Tower left = solver.getTower(Position.LEFT);
        Tower center = solver.getTower(Position.CENTER);
        Tower right = solver.getTower(Position.RIGHT);

        assertNotSame(left, center);
        assertNotSame(left, right);
        assertNotSame(center, right);
    }


    /**
     * Tests that getTower always returns the same tower object.
     */
    public void testGetTowerConsistency()
    {
        Tower left1 = solver.getTower(Position.LEFT);
        Tower left2 = solver.getTower(Position.LEFT);

        assertSame(left1, left2);
    }
}
