package linkedList;

public class LinkedListAlgorithms
{

    private Node head;
    private Node tail;

    public static void main(String[] args)
    {

        //instantiate our class
        LinkedListAlgorithms algorithms = new LinkedListAlgorithms();


        //assemble a linked list
        Node head = null;
        for (int i = 1; i <= 500; i++)
        {
            if (head == null)
            {
                head = algorithms.new Node(i,null);

            }
            else
            {
                head = algorithms.new Node(i,head);
            }
        }

        //!! weird notation for inner class

        Node fourth = algorithms.new Node(4, null);
        Node third = algorithms.new Node(3, fourth);
        Node second = algorithms.new Node(2, third);
        Node first = algorithms.new Node(1, second);


        //reverse it

        head = algorithms.reverse(first);

        //verify our results

        //save a copy of the head to keep track
        Node current = head;

        while (current != null)
        {
            //print the current element and move past it
            System.out.println(current.data);
            current = current.next;
        }


    }

    public Node reverse(Node head)
    {

        //precondition checkers
        if (head == null)
        {
            return null;
        } else if (head == null) //one element
        {
            return head;
        }

        //step #1 - Point a temporary variable to the head to keep a reference
        Node newListHead = head;

        //step #2 - Save the element after the head to a new variable
        Node saveNextNode = head.next;

        //Step #3 = Reverse the next pointer for newListHead
        newListHead.next = null;

        while (saveNextNode.next != null)
        {
            //Step #4 = Move our pointers along
            head = saveNextNode;
            saveNextNode = saveNextNode.next;

            //move
            head.next = newListHead;
            newListHead = head;
        }

        //get the last element outside of the loop because
        saveNextNode.next = newListHead;
        head = saveNextNode;

        return head;


    }

    private class Node
    {
        private int data;
        private Node next;

        public Node(int data, Node next)
        {
            this.data = data;
            this.next = next;

        }

    }
}
