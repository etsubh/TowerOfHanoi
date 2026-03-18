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

// -------------------------------------------------------------------------
/**
 * It sets up the number of disks, creates a HanoiSolver to handle the logic,
 * and opens a PuzzleWindow to display the game visually.
 * 
 * @author etsub
 * @version Oct 21, 2025
 */
public class ProjectRunner
{
    // ----------------------------------------------------------
    /**
     * The main method launches the Tower of Hanoi simulation. It allows a
     * command line argument to set the number of disks.
     * 
     * @param args
     *            optional argument for number of disks
     */
    public static void main(String[] args)
    {
        int disks = 5;

        if (args.length == 1)
        {
            disks = Integer.parseInt(args[0]);
        }

        HanoiSolver hanoi = new HanoiSolver(disks);
        PuzzleWindow window = new PuzzleWindow(hanoi);
    }
}
