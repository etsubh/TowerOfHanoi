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

import java.util.Observable;

// -------------------------------------------------------------------------
/**
 * This class handles solving the Tower of Hanoi puzzle. It keeps track of the
 * towers, number of disks, and uses recursion to move the disks to the correct
 * pole.
 * 
 * @author etsub
 * @version Oct 21, 2025
 */
public class HanoiSolver
    extends Observable
{
    private int numDisks;
    private Tower left;
    private Tower center;
    private Tower right;

    // ----------------------------------------------------------
    /**
     * Creates a new solver for a given number of disks. Sets up the three
     * towers (left, center, right).
     * 
     * @param numDisks
     *            the number of disks in the puzzle
     */
    public HanoiSolver(int numDisks)
    {
        this.numDisks = numDisks;
        left = new Tower(Position.LEFT);
        center = new Tower(Position.CENTER);
        right = new Tower(Position.RIGHT);
    }


    // ----------------------------------------------------------
    /**
     * Returns how many disks are in this puzzle
     * 
     * @return the number of disks
     */
    public int disks()
    {
        return numDisks;
    }


    // ----------------------------------------------------------
    /**
     * Returns the tower that matches a given position.
     * 
     * @param pos
     *            the position (LEFT, CENTER, RIGHT)
     * @return tower at that position
     */
    public Tower getTower(Position pos)
    {
        switch (pos)
        {
            case LEFT:
                return left;
            case CENTER:
                return center;
            case RIGHT:
                return right;
            default:
                return center;
        }
    }


    // ----------------------------------------------------------
    /**
     * Returns a string showing the current state of all three towers
     * 
     * @return string of tower contents
     */
    public String toString()
    {
        return left.toString() + center.toString() + right.toString();
    }


    /**
     * Moves one disk from one tower to another. Notifies observers that a move
     * happened.
     *
     * @param source
     *            the tower to move a disk from
     * @param destination
     *            the tower to move a disk to
     */
    private void move(Tower source, Tower destination)
    {
        Disk disk = source.pop();
        destination.push(disk);
        setChanged();
        notifyObservers(destination.position());
    }


    /**
     * Recursive method that solves the Tower of Hanoi puzzle. Moves disks
     * between towers using a helper tower.
     *
     * @param currentDisks
     *            number of disks to move
     * @param startPole
     *            starting tower
     * @param tempPole
     *            helper tower
     * @param endPole
     *            target tower
     */
    private void solveTowers(
        int currentDisks,
        Tower startPole,
        Tower tempPole,
        Tower endPole)
    {
        if (currentDisks == 1)
        {
            move(startPole, endPole);
        }
        else
        {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            move(startPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
    }


    /**
     * Solves the the positions
     */
    public void solve()
    {
        solveTowers(numDisks, left, center, right);
    }
}
