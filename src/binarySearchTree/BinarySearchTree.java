package binarySearchTree;

import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T>
{
    protected Node root;
    protected int size = 0;

    public BinarySearchTree()
    {
        // do nothing
    }

    public boolean add(T element)
    {
        if (root == null)
        {
            root = new Node(element, null, null);
            size++;
            return true;
        }
        else
        {
            // search for the spot, if it's not taken
            boolean success = add(root, element);

            if (success)
            {
                size++;
            }
            return success;
        }
    }

    private boolean add(Node current, T element)
    {
        if (current.data.equals(element))
        {
            return false; // already in the tree
        }
        else
        {
            int compare = current.data.compareTo(element);

            if (compare < 0) // new element is larger
            {
                if (current.right == null)
                {
                    current.right = new Node(element, null, null);
                    return true;
                }
                else
                {
                    return add(current.right, element);
                }
            }
            else if (compare > 0) // new element is smaller
            {
                if (current.left == null)
                {
                    current.left = new Node(element, null, null);
                    return true;
                }
                else
                {
                    return add(current.left, element);
                }
            }
            else // compare == 0
            {
                return false; // already in the tree
            }
        }
    }

    public boolean contains(Object search)
    {
        return contains(root, (T) search);
    }

    private boolean contains(Node current, T element)
    {
        if (current == null)
        {
            return false;
        }
        else
        {
            int compare = current.data.compareTo(element);

            if (compare < 0) // new element is larger
            {
                return contains(current.right, element);
            }
            else if (compare > 0) // new element is smaller
            {
                return contains(current.left, element);
            }
            else // compare == 0
            {
                return true; // found it!
            }
        }
    }

    public void remove(T search)
    {
        //start searching at the root
        root = remove(root, search);
    }

    private Node remove(Node node, T search)
    {
        //element not found in tree
        if (node == null)
        {
            return null; //assign our parent pointer to this value
        }

        //compare against the current element
        int compare = node.data.compareTo(search);

        if (compare < 0) //search to the right
        {
            node.right = remove(node.right, search);
        }
        else if (compare > 0) //search to the left
        {
            node.left = remove(node.left, search);
        }
        else //we found it!
        {
            //case #1 - no children
            if (node.left == null && node.right == null)
            {
                return null;
            }
            //case #2 - one child
            else if (node.left == null)
            {
                return node.right;
            }
            else if (node.right == null)
            {
                return node.left;
            }
            //case #3 - two children
            else
            {
                //find the smallest element in the right subtree
                Node replacement = findMin(node.right);

                //replace the data in our removed node
                node.data = replacement.data;

                //recursively remove the smallest element in the right subtree
                node.right = remove(node.right, replacement.data);
            }
        }
        //this will allow our parent to assign a reference to this node
        return node;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void clear()
    {
        root = null;
        size = 0;

    }

    private Node findMin(Node search)
    {
        if (search.left == null)
        {
            return search;
        }
        return findMin(search.left);
    }

    private Node findMax(Node search)
    {
        if (search.right == null)
        {
            return search;
        }
        return findMax(search.right);
    }

    public void printTraversal(Traversal traversal)
    {
        switch (traversal)
        {
            case IN_ORDER:
                inOrder(root);
                System.out.println();
                break;
            case PRE_ORDER:
                preOrder(root);
                System.out.println();
                break;
            case POST_ORDER:
                postOrder(root);
                System.out.println();
                break;
            case BREADTH_FIRST:
                breadthFirst();
                break;
        }
    }

    private void breadthFirst()
    {
        Queue<Node> nodeQueue = new LinkedBlockingQueue<>();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty())
        {
            Node nextNode = nodeQueue.poll();
            System.out.print(nextNode.data + " ");

            if (nextNode.left != null)
            {
                nodeQueue.offer(nextNode.left);
            }

            if (nextNode.right != null)
            {
                nodeQueue.offer(nextNode.right);
            }
        }

        System.out.println();
    }

    private void inOrder(Node current)
    {
        if (current != null)
        {
            //print the element and recursively search for others
            inOrder(current.left);
            System.out.print(current.data + " ");
            inOrder(current.right);
        }
    }

    private void preOrder(Node current)
    {
        if (current != null)
        {
            //print the element and recursively search for others
            System.out.print(current.data + " ");
            preOrder(current.left);
            preOrder(current.right);
        }
    }

    private void postOrder(Node current)
    {
        if (current != null)
        {
            //print the element and recursively search for others
            postOrder(current.left);
            postOrder(current.right);
            System.out.print(current.data + " ");
        }
    }

    //return the sum from 1 to n
    public int sum(int n)
    {
        if (n == 0)
        {
            return 0;
        }
        else
        {
            return n + sum(n - 1);
        }
    }

    //calculate the total height of all nodes combined
    public int totalNodeHeight()
    {
        calculateAllNodeHeights();

        return totalNodeHeight(root);
    }

    private int totalNodeHeight(Node current)
    {
        if (current == null)
        {
            return 0;
        }

        return current.height + totalNodeHeight(current.left) +
                totalNodeHeight(current.right);
    }

    public int getTreeHeight()
    {
        //make sure our nodes have updated height values
        calculateAllNodeHeights();

        return root.height;
    }

    public void calculateAllNodeHeights()
    {
        calculateNodeHeight(root);
    }

    private int calculateNodeHeight(Node current)
    {
        if (current == null)
        {
            return -1;
        }
        else
        {
            int height = 1 + Math.max(calculateNodeHeight(current.left),
                    calculateNodeHeight(current.right));
            current.height = height;
            return height;
        }
    }


    //Calculate depth
    public void calculateDepths()
    {
        calculateDepth(root, 0);
    }

    private void calculateDepth(Node current, int depth)
    {
        if (current == null)
        {
            return;
        }
        else
        {
            //assign the current node's depth
            current.setDepth(depth);

            //look at child nodes, they are located in a different depth
            calculateDepth(current.left, depth + 1);
            calculateDepth(current.right, depth + 1);
        }
    }

    public int getTotalTreeDepth()
    {
        calculateDepths();
        return getTotalTreeDepth(root);
    }

    private int getTotalTreeDepth(Node current)
    {
        if (current == null)
        {
            return 0;
        }

        //Total depth is equal to the left tree plus right tree
        return current.depth + getTotalTreeDepth(current.left) + getTotalTreeDepth(current.right)
                ;//this will give the total
    }


    @Override
    public Iterator<T> iterator()
    {
        return new BSTIterator(root);
    }

    private class BSTIterator implements Iterator<T>
    {

        //create the stack structure we are going to use

        private Stack<Node> nodeStack;

        //local variable is named current
        public BSTIterator(Node current)
        {
            nodeStack = new Stack<>();
            diveLeft(current);

        }


        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext()
        {
            return false;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next()
        {
            //get the first child
            Node next = nodeStack.pop();

            //if there is a right child, dive to the left while adding nodes to the stack
            if (next.right != null)
            {
                Node current = next.right;
                diveLeft(current);

            }

            return null;
        }

        private void diveLeft(Node current)
        {
            //setup our first element to be returned
            while (current != null)
            {
                nodeStack.push(current);
                //This is the temporary local variable
                current = current.left;
            }
        }
    }

    // nested classes
    public class Node
    {
        private T data;
        private Node left;
        private Node right;

        //scratch fields
        private int height;
        private int depth;

        public Node(T data, Node left, Node right)
        {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public int getHeight()
        {
            return height;
        }

        public void setHeight(int height)
        {
            this.height = height;
        }

        public int getDepth()
        {
            return depth;
        }

        public void setDepth(int depth)
        {
            this.depth = depth;
        }

        public T getData()
        {
            return data;
        }

        public void setData(T data)
        {
            this.data = data;
        }

        public Node getLeft()
        {
            return left;
        }

        public void setLeft(Node left)
        {
            this.left = left;
        }

        public Node getRight()
        {
            return right;
        }

        public void setRight(Node right)
        {
            this.right = right;
        }

        @Override
        public String toString()
        {
            String leftString = (left == null) ? "null" : left.data.toString();
            String rightString = (right == null) ? "null" : right.data.toString();

            return leftString + " <-- " + data.toString() + " --> " + rightString;
        }
    }
}