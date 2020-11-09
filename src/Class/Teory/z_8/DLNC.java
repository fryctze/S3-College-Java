package Class.Teory.z_8;

/**
 * Double LinkedList non circular
 */
public class DLNC {
    public Node head;

    public DLNC() {
        head = null;
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
            newData.prev = null;
            newData.next = null;

            head = newData;
        } else {
            newData.next = head;
            newData.prev = null;

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
            newData.prev = null;
            newData.next = null;

            head = newData;
        } else {
            Node helper = head;
            while (helper.next != null) helper = helper.next;
            newData.prev = helper;
            newData.next = null;

            helper.next = newData;
        }
    }

    /**
     * removeFirst
     */
    public void removeFirst(){
        if (isEmpty()){

        } else{
            head = head.next;
            head.prev = null;
        }
    }

    /**
     * removeLast
     */
    public void removeLast(){
        Node helper = head;
        if (isEmpty()){

        } else if(head.next == null)
            head = null;
        else{
            while (helper.next.next != null) helper = helper.next;
            helper.next = null;
        }
    }

    /**
     * Traversing
     */
    public void show(){
        if (!isEmpty()){
            Node helper = head;
            while (helper != null){
                System.out.println(helper.data);
                helper = helper.next;
            }
        }
    }

    public void showBackward(){
        if (!isEmpty()){
            Node helper = head;
            while (helper.next != null) helper = helper.next;
            while (helper != null){
                System.out.println(helper.data);
                helper = helper.prev;
            }
        }
    }
}
