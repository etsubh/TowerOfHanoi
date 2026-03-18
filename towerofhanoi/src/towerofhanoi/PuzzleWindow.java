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

import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * The main front-end work and the view for the Tower of Hanoi puzzle (Fall
 * 2024)
 *
 * @author Name
 * @version Date
 */
public class PuzzleWindow
    implements Observer
{

    private HanoiSolver game;
    private Shape left;
    private Shape center;
    private Shape right;
    private Window window;
    /**
     * A factor in which the width of the disks are multiplied by
     */
    public static final int WIDTH_FACTOR = 12;
    /**
     * The vertical gap between each disk on the tower
     */
    public static final int DISK_GAP = 2;
    /**
     * The height of each disk on the tower
     */
    public static final int DISK_HEIGHT = 15;

    /**
     * Creates a new PuzzleWindow view for a given HanoiSolver game
     *
     * @param g
     *            the game to create a view for
     */
    public PuzzleWindow(HanoiSolver g)
    {
        this.game = g;
        game.addObserver(this);

        window = new Window("Tower of Hanoi");
        window.setSize(800, 600);

        int poleHeight = 200;
        int poleY = (window.getGraphPanelHeight() / 2) - (poleHeight / 2);

        left = new Shape(
            (200 - 15 / 2),
            poleY,
            15,
            poleHeight,
            new Color(50, 50, 50));
        center = new Shape(
            ((window.getGraphPanelWidth() / 2) - 15 / 2),
            poleY,
            15,
            poleHeight,
            new Color(50, 50, 50));
        right = new Shape(
            ((window.getGraphPanelWidth() - 200) - 15 / 2),
            poleY,
            15,
            poleHeight,
            new Color(50, 50, 50));

        // Create disks from largest to smallest and add to left tower
        for (int width =
            (game.disks() + 1) * WIDTH_FACTOR; width > WIDTH_FACTOR; width -=
                WIDTH_FACTOR)
        {
            // Create a new disk with the calculated width
            Disk disk = new Disk(width);

            // Add the disk to the window
            window.addShape(disk);

            // Push the disk onto the left tower in the game
            game.getTower(Position.LEFT).push(disk);

            // Update the disk's position on the display
            moveDisk(Position.LEFT);
        }
        window.addShape(left);
        window.addShape(center);
        window.addShape(right);

        // Create and add the solve button
        Button solveButton = new Button("Solve");
        window.addButton(solveButton, WindowSide.SOUTH);
        solveButton.onClick(this, "clickedSolve");
    }


    private void moveDisk(Position position)
    {
        Disk currentDisk = game.getTower(position).peek();

        // Determine which pole shape corresponds to this position
        Shape currentPole;
        if (position == Position.LEFT)
        {
            currentPole = left;
        }
        else if (position == Position.CENTER)
        {
            currentPole = center;
        }
        else if (position == Position.RIGHT)
        {
            currentPole = right;
        }
        else
        {
            currentPole = center; // default
        }

        // Calculate the new X position (center the disk on the pole)
        int newX = currentPole.getX() + (currentPole.getWidth() / 2)
            - (currentDisk.getWidth() / 2);

        // Calculate the new Y position (stack disks from bottom up)
        int newY = currentPole.getY() + currentPole.getHeight()
            - (game.getTower(position).size() * (DISK_HEIGHT + DISK_GAP));

        // Move the disk to its new position
        currentDisk.moveTo(newX, newY);
    }


    /**
     * Updates the view whenever a disk is moved in the back-end
     *
     * @param o
     *            The observable that triggered the update
     * @param arg
     *            arguments sent by the game; should be a position
     */
    @Override
    public void update(Observable o, Object arg)
    {
        if (arg.getClass() == Position.class)
        {
            Position position = (Position)arg;
            moveDisk(position);
            sleep();
        }
    }


    /**
     * Runs when the Solve button is clicked, tells the puzzle to start solving
     *
     * @param button
     *            the button that was clicked
     */
    public void clickedSolve(Button button)
    {
        button.disable();
        new Thread() {
            public void run()
            {
                game.solve();
            }
        }.start();
    }


    private void sleep()
    {
        try
        {
            Thread.sleep(500);
        }
        catch (Exception e)
        {
            // idk
        }
    }
}
