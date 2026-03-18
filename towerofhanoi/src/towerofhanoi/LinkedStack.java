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

import stack.StackInterface;
import java.util.EmptyStackException;

// -------------------------------------------------------------------------
/**
 * This class implements a basic stack using a linked structure. It supports
 * typical stack operations like push, pop, and peek.
 * 
 * @param <T>
 * @author etsub habtewold
 * @version Oct 21, 2025
 */
public class LinkedStack<T>
    implements StackInterface<T>
{
    private Node topNode;
    private int size;

    /**
     * Create a new LinkedStack object.
     */
    public LinkedStack()
    {
        topNode = null;
        size = 0;

    }


    /**
     * Adds a new entry to the top of the stack.
     * 
     * @param anEntry
     *            the item to add
     */
    @Override
    public void push(T anEntry)
    {
        Node newNode = new Node(anEntry, topNode);
        topNode = newNode;
        size++;
    }


    /**
     * Returns the current number of items in the stack.
     * 
     * @return the size of the stack
     */
    public int size()
    {
        return size;
    }


    /**
     * Checks if the stack is empty.
     * 
     * @return true if empty, false otherwise
     */
    @Override
    public boolean isEmpty()
    {

        return size == 0;
    }


    /**
     * Looks at the item on top of the stack without removing it.
     * 
     * @return the top item
     * @throws EmptyStackException
     *             if the stack is empty
     */
    @Override
    public T peek()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }

        return topNode.getData();
    }


    /**
     * Removes and returns the item from the top of the stack.
     * 
     * @return the item that was removed
     * @throws EmptyStackException
     *             if the stack is empty
     */
    @Override
    public T pop()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }

        T topData = topNode.getData();
        topNode = topNode.getNextNode();
        size--;
        return topData;
    }


    /**
     * Removes all entries from the stack.
     */
    @Override
    public void clear()
    {
        topNode = null;
        size = 0;
    }


    /**
     * Returns the string that is correct.
     * 
     * @return a string showing the stack contents
     */
    public String toString()
    {
        StringBuilder builder = new StringBuilder("[");

        Node current = topNode;
        while (current != null)
        {
            builder.append(current.getData());
            if (current.getNextNode() != null)
            {
                builder.append(", ");
            }
            current = current.getNextNode();
        }

        builder.append("]");
        return builder.toString();
    }

    private class Node
    {
        private T data;
        private Node nextNode;

        /**
         * Create a new Node object.
         * 
         * @param data
         *            the item to store
         */
        public Node(T data)
        {
            this.data = data;
            this.nextNode = null;
        }


        /**
         * Create a new Node object.
         * 
         * @param entry
         *            the item to store
         * @param node
         *            the next node in the stack
         */
        public Node(T entry, Node node)
        {
            this(entry);
            this.setNextNode(node);
        }


        /**
         * Gets the data from this node.
         * 
         * @return the data stored
         */
        public T getData()
        {
            return data;
        }


        /**
         * Sets up the next node
         * 
         * @param node
         *            the node to link to
         */
        public void setNextNode(Node node)
        {
            this.nextNode = node;
        }


        /**
         * Gets the upcoming next node
         * 
         * @return the next node
         */
        public Node getNextNode()
        {
            return nextNode;
        }
    }
}
