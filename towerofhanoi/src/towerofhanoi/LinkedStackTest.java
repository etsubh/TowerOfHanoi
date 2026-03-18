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

import java.util.EmptyStackException;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 * This class tests the LinkedStack class to make sure all stack operations work
 * as expected.
 * 
 * @author etsub habtewold
 * @version Oct 22, 2025
 */
public class LinkedStackTest
    extends TestCase
{
    // ----------------------------------------------------------
    /**
     * Tests that peek works correctly.
     */
    public void testPeek()
    {
        LinkedStack<String> stack = new LinkedStack<String>();
        stack.push("hello");
        assertEquals("hello", stack.peek());
        assertEquals(1, stack.size());
    }


    /**
     * Tests pop works correctly.
     */
    public void testPop()
    {
        LinkedStack<String> stack = new LinkedStack<String>();
        stack.push("hello");
        assertEquals("hello", stack.pop());
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
    }


    /**
     * Tests peek throws exception on empty stack.
     */
    public void testPeekEmpty()
    {
        LinkedStack<String> stack = new LinkedStack<String>();
        Exception exception = null;
        try
        {
            stack.peek();
        }
        catch (EmptyStackException e)
        {
            exception = e;
        }
        assertNotNull(exception);
    }


    /**
     * Tests pop throws exception on empty stack.
     */
    public void testPopEmpty()
    {
        LinkedStack<String> stack = new LinkedStack<String>();
        Exception exception = null;
        try
        {
            stack.pop();
        }
        catch (EmptyStackException e)
        {
            exception = e;
        }
        assertNotNull(exception);
    }


    /**
     * Tests clear removes all entries.
     */
    public void testClear()
    {
        LinkedStack<String> stack = new LinkedStack<String>();
        stack.push("first");
        stack.push("second");
        stack.clear();
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
    }


    /**
     * Tests toString returns correct format.
     */
    public void testToString()
    {
        LinkedStack<String> stack = new LinkedStack<String>();
        assertEquals("[]", stack.toString());

        stack.push("A");
        assertEquals("[A]", stack.toString());

        stack.push("B");
        assertEquals("[B, A]", stack.toString());
    }
}
