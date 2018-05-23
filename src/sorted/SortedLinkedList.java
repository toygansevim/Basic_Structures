package sorted;

public class SortedLinkedList
{
    private Node head;

    public SortedLinkedList()
    {
        //do sth
    }

    //add an element if not present in the list,
    //in the ordered position (ascending)
    public void add(int element)
    {
        //empty
        if (head == null)
        {
            //create a new element there are none
            head = new Node(element);

        } else if (element < head.data)
        {
            head = new Node(element, head);
        } else if (element == head.data)
        {
            return; //No dublicates are allowed
        } else


        {
            Node current = head;

            //search as long as there is a next element
            while (current.next != null)
            {
                //is this the correct spot
                if (current.next.data > element) //is the next pointer's data bigger than the
                // element comparing?
                {
                    Node tempHolder = new Node(element, current.next);
                    current.next = tempHolder;

                    //finish the while
                    return;
                } else if (current.next.data == element)
                {
                    return;

                }

                //check for the next element
                current = current.next;
            }

            current.next = new Node(element);
        }
    }


    public void print()
    {
        Node current = head;

        while (current != null)
        {
            System.out.println(current.data);
            current = current.next;
        }
    }

    private class Node
    {
        private int data;
        private Node next;

        public Node(int data)
        {
            this.data = data;


        }


        public Node(int data, Node next)
        {
            this.data = data;
            this.next = next;
        }

    }
}
