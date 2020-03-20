package eg.edu.alexu.csd.datastructure.linkedList.cs18_cs52;

public class DLinkedList implements ILinkedList {

    static class Node {
        Object element;
        Node next, prev;
    }
    private Node head, tail;
    private int size;
    DLinkedList(){
        head = tail = null;
        size = 0;
    }

    @Override
    public void add(int index, Object element) {
        Node nodeNew =new Node();
        nodeNew.element=element;
        Node dNode =head;
        if (index == size()) {
            add(element);
        }else {
            for (int i=0;i<index-1;i++) {
                dNode = dNode.next;
            }
            nodeNew.next= dNode.next;
            dNode.next.prev= nodeNew;
            dNode.next= nodeNew;
            nodeNew.prev= dNode;
            size++;
        }
    }

    @Override
    public void add(Object element) {
        Node nodeNew = new Node();
        nodeNew.element = element;
        if (size == 0) {
            nodeNew.prev = null;
            nodeNew.next = null;
            head = tail = nodeNew;
        }else {
            nodeNew.next = null;
            tail.next = nodeNew;
            nodeNew.prev = tail;
            tail = nodeNew;
        }
        size++;
    }

    @Override
    public Object get(int index) {
        Node node = head;
        for (int i=0; i<index; i++) {
            node = node.next;
        }
        return node.element;
    }

    @Override
    public void set(int index, Object element) {
        Node node = head;
        for (int i=0; i<index; i++) {
            node = node.next;
        }
        node.element = element;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void remove(int index) {
        if (size == 0) {
            throw new RuntimeException("The list is already empty.");
        }else {
            if (index == 0) {
                head = head.next;
            }else if (index == size-1) {
                Node node = head;
                while (node.next != tail) {
                    node = node.next;
                }
                tail = node;
                tail.next = null;
            }else {
                Node node = head;
                Node nodeTemp = head.next;
                for (int i=0; i<index-1; i++) {
                    node = node.next;
                    nodeTemp = nodeTemp.next;
                }
                node.next = nodeTemp.next;
                nodeTemp.next.prev = node;
            }
            size--;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ILinkedList sublist(int fromIndex, int toIndex) {
        if (size == 0) {
            throw new RuntimeException("The list is empty.");
        }else if (toIndex>size-1 || fromIndex<0) {
            throw new RuntimeException("the border of the list you need exceeds the base one");
        }else {
            DLinkedList sublist = new DLinkedList();
            sublist.size = toIndex-fromIndex+1;
            Node node = head;
            for (int i=0; i<size; i++) {
                if (i == fromIndex) {
                    sublist.head = node;
                }else if (i == toIndex) {
                    sublist.tail = node;
                }
                node = node.next;
            }
            return sublist;
        }
    }

    @Override
    public boolean contains(Object o) {
        if (size == 0) {
            return false;
        }else {
            boolean flag = false;
            Node node = head;
            for (int i=0; i<size; i++) {
                if (node.element == o) {
                    flag = true;
                    break;
                }
                node = node.next;
            }
            return flag;
        }
    }
}