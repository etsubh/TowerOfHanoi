// Project 3 Fall 2025
// Virginia Tech Honor Code Pledge:

//

// As a Hokie, I will conduct myself with honor and integrity at all times.

// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.

// -- etsub habtewold (etsubh)
// LLM Statement:

// I have not used any assistance for the assignment beyond course resources and
// staff.F
package towerofhanoi;

// -------------------------------------------------------------------------
/**
 * Uses the tower class to have the three towers to put the disks on.
 * 
 * @author etsub habtewold
 * @version Oct 21, 2025
 */
public class Tower
    extends LinkedStack<Disk>
{
    private Position position;

    // ----------------------------------------------------------
    /**
     * Creates a new Tower object.
     * 
     * @param position
     *            the place
     */
    public Tower(Position position)
    {
        super();
        this.position = position;
    }


    /**
     * Shows the three towers with the disks on them
     * 
     * @return position of the tower
     */
    public Position position()
    {
        return position;
    }


    /**
     * Adds a disk to the top of the tower, following the Tower of Hanoi rules a
     * larger disk cannot be placed on top of a smaller one.
     * 
     * @param disk
     *            the disk to place on this tower
     */
    public void push(Disk disk)
    {
        if (disk == null)
        {
            throw new IllegalArgumentException("Cannot push null disk");
        }

        if (isEmpty() || disk.compareTo(peek()) < 0)
        {
            super.push(disk);
        }
        else
        {
            throw new IllegalStateException(
                "Cannot place larger disk on smaller disk");
        }
    }
}
