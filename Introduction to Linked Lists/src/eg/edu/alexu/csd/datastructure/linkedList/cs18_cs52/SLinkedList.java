package eg.edu.alexu.csd.datastructure.linkedList.cs18_cs52;

public class SLinkedList implements ILinkedList {

    static class Node {
        Object element;
        Node next;
    }
    private Node head, tail;
    private int size;
    SLinkedList(){
        head = tail = null;
        size = 0;
    }

    @Override
    public void add(int index, Object element) {
        Node newNode = new Node();
        newNode.element = element;
        Node tempHead = head;
        if (index == size()) {
            add(element);
        }else {
            for(int i =0 ; i < index -1 ; i++){
                tempHead=tempHead.next;
            }
            newNode.next = tempHead.next;
            tempHead.next = newNode;
            size++;
        }
    }

    @Override
    public void add(Object element) {
        Node newNode = new Node();
        newNode.element=element;
        if(isEmpty()) {
            head=tail=newNode;
            newNode.next = null;
        }else{
            newNode.next = null;
            tail.next = newNode;
            tail=newNode;
        }
        size++;
    }

    @Override
    public Object get(int index) {
        if(index >= size) {
            return null;
        }
        Node tempHead = head ;
        for(int i = 0 ; i < index ; i++) {
            tempHead = tempHead.next;
        }
        return tempHead.element;
    }

    @Override
    public void set(int index, Object element) {
        Node tempHead = head;
        for(int i = 0 ; i < index;i++){
            tempHead = tempHead.next;
        }
        tempHead.element = element;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return((head == null) && (tail == null));
    }

    @Override
    public void remove(int index) {
        if(isEmpty())
            throw new RuntimeException("The List is Empty");
        else if(index == size-1){
            Node tempHead = head;
            while(tempHead.next != tail){
                tempHead = tempHead.next;
            }
            tail = tempHead;
            tail.next = null;
        }else{
            Node Node1=head,Node2=head.next;
            for (int i=0;i<index-1;i++) {
                Node1=Node1.next;
                Node2=Node2.next;
            }
            Node2=Node2.next;
            Node1.next=Node2;
        }
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ILinkedList sublist(int fromIndex, int toIndex) {
        if(isEmpty())
            throw new RuntimeException("The List is Empty");
        else if((toIndex>size-1) || (fromIndex < 0))
            throw new RuntimeException("you have exceeded the boarder of the list");
        else {
            SLinkedList sublist = new SLinkedList();
            sublist.size =toIndex - fromIndex +1;
            Node temp = head;
            for(int i = 0 ;i < size ; i++){
                if(i == fromIndex)
                    sublist.head = temp;
                else if(i == toIndex){
                    sublist.tail = temp;
                    break;
                }
                temp = temp.next;
            }
            return sublist;
        }
    }

    @Override
    public boolean contains(Object o) {
        boolean judge = false;
        if(isEmpty())
            return judge;
        else{
            Node tempHead = head;
            for(int i = 0 ; i < size ; i++){
                if(tempHead.element == o) {
                    judge = true;
                    break;
                }
                tempHead = tempHead.next;
            }
            return judge;
        }
    }

    public int[][] ListToArray(SLinkedList sLinkedList) {
        int[][] arr = new int[sLinkedList.size()/2][2];
        for (int i=0; i<sLinkedList.size()/2; i++) {
            arr[i][0] = (int) sLinkedList.get(2*i);
            arr[i][1] = (int) sLinkedList.get(2*i+1);
        }
        return arr;
    }

    public Object[] listToArr(boolean IntArr2D) {
        if(IntArr2D){
            int[][] array = new int[size][];
            for (int i=0;i<size;i++)
                array[i] = (int[])get(i);
            return array;
        } else {
        }
        Object[] arr = new Object [size];
        for (int i=0;i<size;i++) {
            arr[i] = get(i);
        }
        return arr;
    }

}