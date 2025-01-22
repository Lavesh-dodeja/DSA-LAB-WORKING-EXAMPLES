public class SLL {

    private int size;
    SLL()
    {
        this.size=0;
    }

    class Node{
        int data;
        Node next ; 

        Node(int data)
        {
            this.data=data;
            this.next=null;
            size++;
        }
    }

    private Node head;
    public void Add(int data)
    {
        Node Newnode = new Node(data);
        if( head == null)
        {
            head = Newnode;
            return;
        }

        Node currentNode = head;
        while(currentNode.next != null)
        {
            currentNode = currentNode.next;
        }
        currentNode.next = Newnode ;
    }

    public void displayList()
    {
        if( head == null)
        {
           System.out.println("list is empty!");
            return;
        }

        Node currentNode = head;
        while(currentNode != null)
        {
            System.out.print(currentNode.data + " --> ");
            currentNode = currentNode.next;
        }
        System.out.print("null \n");
    }

    public SLL copyOfList()
    {
        SLL copiedList = new SLL();
        Node current = head;
        while (current != null) {
            copiedList.Add(current.data);
            current = current.next;
        }
        return copiedList;
    }



    // length of SLL
    public int getsize()
    {
        return size;
    }

    // print the middle node of singly linked list
    public void printMiddleNode()
    {
        if(head == null)
        {
            System.out.println("list is empty");
            return;
        }

        Node fast = head;
        Node slow = head;
        while(fast.next!=null && fast.next.next != null)
        {
            fast= fast.next.next;
            slow= slow.next;
        }

        System.out.println("your middle node of data is : "+slow.data);
        return;
    }

    // reverse the linked list
    public void reverseLinkedList()
    {
        if(head == null || head.next==null)
        {
            return;
        }

        Node prevNode = head;
        Node currentNode = head.next;
        while(currentNode != null)
        {
            Node nextNode = currentNode.next;

            currentNode.next = prevNode;

            // update
            prevNode = currentNode;
            currentNode = nextNode;
        }
        head.next=null;
        head=prevNode;
    }

    // delete complete list
    public void deleteList() {
        head = null;
        System.out.println("The list has been deleted.");
    }

    //Remove duplicates from a sorted SLL 
    public void removeDuplicates() {
        Node current = head;

        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next; 
            } else {
                current = current.next; 
            }
        }
    }

    //Merge two sorted SLL .
    public static SLL mergeLists(SLL list1, SLL list2) {
        SLL mergedList = new SLL();
        Node current1 = list1.head;
        Node current2 = list2.head;

        while (current1 != null && current2 != null) {
            if (current1.data <= current2.data) {
                mergedList.Add(current1.data);
                current1 = current1.next;
            } else {
                mergedList.Add(current2.data);
                current2 = current2.next;
            }
        }

        
        while (current1 != null) {
            mergedList.Add(current1.data);
            current1 = current1.next;
        }

        
        while (current2 != null) {
            mergedList.Add(current2.data);
            current2 = current2.next;
        }

        return mergedList;
    }



    public static void main(String[] args) {
        
        SLL sll = new SLL();
        sll.Add(1);
        sll.Add(1);
        sll.Add(2);
        sll.Add(3);
        sll.Add(4);
        sll.displayList();

        // length of SLL
        System.out.println("size of list : "+ sll.getsize());

        // print a middle node of the list
        sll.printMiddleNode();

        // reverse of the linked list
        System.out.println("\nafter reverse of the linked list");
        SLL copiedList = sll.copyOfList();
        copiedList.reverseLinkedList();
        copiedList.displayList();

        // Remove duplicates from a sorted SLL
        System.out.println("after removing duplicates in sorted list");
        sll.removeDuplicates();
        sll.displayList();

        // Merge two sorted SLL .
        SLL mergedList = mergeLists(sll, copiedList);
        mergedList.displayList();

        //delete all list
        sll.deleteList();
        copiedList.deleteList();
        mergedList.deleteList();


    }
}