# TowerOfHanoi

This project builds a visual version of the classic Tower of Hanoi puzzle. Disks move between three towers following the rules of the game, and the solution is animated step by step using recursion.
The project focuses on implementing a custom stack and connecting backend logic to a live graphical display.

## What it does

- Solves the Tower of Hanoi puzzle using recursion
- Animates each move in a window
- Moves disks between three towers following game rules
- Uses a custom linked stack instead of built in structures
- Updates the display using an observer pattern
- Lets the user start the solution with a button

## Main Classes

- `HanoiSolver` handles the recursive logic and game state
- `Tower` extends a stack and enforces valid disk moves
- `LinkedStack` is a custom stack built with linked nodes
- `Disk` represents each movable piece in the puzzle
- `PuzzleWindow` displays and animates the solution
- `Position` defines tower locations
- `ProjectRunner` launches the program

## How to run

1. Open the project in Eclipse or your IDE
2. Add the CS2 Graph Window library
3. Make sure all files are in the `towerofhanoi` package
4. Run `ProjectRunner.java`
5. Click the Solve button to watch the puzzle run

## Why I made this

This project was built for a Virginia Tech CS course to practice recursion, stacks, and object oriented design. It helped me better understand how backend logic connects to a visual interface.

## Author

Etsub Habtewold
