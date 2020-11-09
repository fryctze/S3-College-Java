package Class.Teory.z_8;

/**
 * Double LinkedList non circular
 */
public class DLC {
    public Node head;
    public Node tail;

    public DLC() {
        head = null;
        tail = null;
    }

    public boolean isEmpty(){
        return head == null ? true : false;
    }

    /**
     * addFirst
     */
    public void addFirst(int data){
        Node newData = new Node(data);

        if (isEmpty()){
            newData.prev = newData;
            newData.next = newData;

            head = newData;
        } else {
            newData.next = head;
            Node helper = head.prev;
            newData.prev = helper;
            helper.next = newData;
            head.prev = newData;
            head = newData;
        }
    }

    /**
     * addLast
     */
    public void addLast(int data){
        Node newData = new Node(data);

        if (isEmpty()){
            newData.next = newData;
            newData.prev = newData;

            head = newData;
        } else {
            /*Node helper = head;
            while (helper.next != null) helper = helper.next;*/
            Node helper = head.prev;

            helper.next = newData;

            newData.prev = helper;
            newData.next = head;

            head.prev = newData;
        }
    }

    /**
     * removeFirst
     */
    public void removeFirst(){
        if (isEmpty()){
            System.out.println("Empty");
        } else if(head.next == head)
            head = null;
        else{
            Node helper = head.prev;
            head = head.next;
            head.prev = helper;
            helper.next = head;
        }
    }

    /**
     * removeLast
     */
    public void removeLast(){
        if (isEmpty()){
            System.out.println("Empty");
        } else if(head.next == head)
            head = null;
        else{
            /*while (helper.next.next != null) helper = helper.next;
            helper.next = null;*/

            Node helper = head.prev.prev;

            helper.next  = head;
            head.prev = helper;
        }
    }

    /**
     * Traversing
     */
    public void show(){
        if (!isEmpty()){
            Node helper = head;
            do {
                System.out.println(helper.data);
                helper = helper.next;
            }while (helper != head);
        }
    }

    public void showBackward(){
        if (!isEmpty()){
            /*Node helper = head;
            while (helper.next != null) helper = helper.next;
            while (helper != null){
                System.out.println(helper.data);
                helper = helper.prev;
            }*/
            Node helper = head.prev;
            do {
                System.out.println(helper.data);
                helper = helper.prev;
            }while (helper != head.prev);
        }
    }
}

