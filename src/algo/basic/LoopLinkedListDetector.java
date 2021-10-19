package algo.basic;

/*
 * Java class to represent linked list data structure.
 */
public class LoopLinkedListDetector {
    private Node head;

    public LoopLinkedListDetector()
    {
        this.head = new Node("head");
    }

    public Node head()
    {
        return head;
    }

    public void appendIntoTail(Node node)
    {
        Node current = head;

        //find last element of LinkedList i.e. tail
        while (current.next() != null)
        {
            current = current.next();
        }
        //appending new node to tail in LinkedList
        current.setNext(node);
    }

    /*
     * If singly LinkedList contains Cycle then following would be true
     * 1) slow and fast will point to same node i.e. they meet
     * On the other hand if fast will point to null or next node of
     * fast will point to null then LinkedList does not contains cycle.
     */
    public boolean isCyclic(){
        Node fast = head;
        Node slow = head;

        while(fast!= null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            //if fast and slow pointers are meeting then LinkedList is cyclic

            System.out.println("s = "+slow.data+" f = "+fast.data);
            if(fast == slow ){
                return true;
            }
        }
        return false;
    }
    public static class Node {
        private Node next;
        private String data;

        public Node(String data) {
            this.data = data;
        }

        public String data() { return data; }
        public void setData(String data) { this.data = data;}

        public Node next() { return next; }
        public void setNext(Node next) { this.next = next; }

        @Override
        public String toString() {
            return this.data;
        }
    }


    public static void main(String args[]) {

        //creating LinkedList with 5 elements including head
        LoopLinkedListDetector head = new LoopLinkedListDetector();
        LoopLinkedListDetector.Node one = new LoopLinkedListDetector.Node("101");
        LoopLinkedListDetector.Node two = new LoopLinkedListDetector.Node("102");
        LoopLinkedListDetector.Node three = new LoopLinkedListDetector.Node("103");
        head.appendIntoTail(one);
        head.appendIntoTail(two);
        head.appendIntoTail(three);
        three.next = three;
        if(head.isCyclic()){
            System.out.println("Linked List is cyclic as it contains cycles or loop");
        }else{
            System.out.println("LinkedList is not cyclic, no loop or cycle found");
        }

    }
}