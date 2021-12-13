package ua.edu.ucu.collections.immutable;

public final class ImmutableLinkedList implements ImmutableList {

    private Node head;
    private Node tail;

    public ImmutableLinkedList(Object[] elements) {
        Node previous = null;
        for (Object element : elements) {
            Node current = new Node();
            current.setValue(element);
            current.setPrevious(previous);

            if (previous == null) {
                this.head = current;
            } else {
                previous.setNext(current);
            }
            previous = current;
        }
        this.tail = previous;
    }

    public ImmutableLinkedList() {
        head = null;
        tail = null;
    }

    public boolean validateIndexInput(int index){
        if (index > size() || index < 0) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public boolean validateSize(){
        if (size() == 0) {
            throw new IndexOutOfBoundsException();
        }
        return true;
    }

    @Override
    public ImmutableList add(Object e) {
        return add(size(), e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        validateIndexInput(index);
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(size(), c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        validateIndexInput(index);

        Object[] newList = new Object[size() + c.length];

        int curIndx = 0;
        Node curNode = head;

        for (int i = 0; i < index; i++) {
            newList[curIndx] = curNode.getValue();
            curNode = curNode.getNext();
            curIndx++;
        }

        for (Object element: c) {
            newList[curIndx] = element;
            curIndx++;
        }

        while (curNode != null) {
            newList[curIndx] = curNode.getValue();
            curNode = curNode.getNext();
            curIndx++;
        }

        return new ImmutableLinkedList(newList);
    }

    @Override
    public Object get(int index) {
        validateIndexInput(index);

        Node curNode = getHead();

        for (int i = 0; i < index; i++) {
            curNode = curNode.getNext();
        }
        return curNode.getValue();
    }

    @Override
    public ImmutableList remove(int index) {
        validateIndexInput(index);

        Object [] newList = new Object[size() - 1];
        Node curNode = getHead();

        for (int i = 0; i < size() - 1; i++) {
            if (i == index) {
                curNode = curNode.getNext();
            }
            newList[i] = curNode.getValue();
            curNode = curNode.getNext();
        }
        return new ImmutableLinkedList(newList);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        validateIndexInput(index);

        Object[] newList = toArray();
        newList[index] = e;
        return new ImmutableLinkedList(newList);
    }

    @Override
    public int indexOf(Object e) {
        validateSize();

        int index = 0;
        Node curNode = getHead();

        while (curNode != null) {
            if (curNode.getValue() == e){
                return index;
            }
            curNode = curNode.getNext();
            index++;
        }

        return -1; //index == size()

    }

    @Override
    public int size() {
        int size = 0;

        Node curNode = getHead();

        while (curNode != null) {
            curNode = curNode.getNext();
            size++;
        }

        return size;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] newList = new Object[size()];
        Node curNode = getHead();

        int i = 0;
        while (curNode != null) {
            newList[i] = curNode.getValue();
            curNode = curNode.getNext();
            i++;
        }
        return newList;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) add(size(), e);
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }

    public Object getFirst() {
        validateSize();
        return this.head.getValue();
    }

    public Object getLast() {
        validateSize();
        return tail.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        validateSize();
        return (ImmutableLinkedList) remove(0);
    }

    public ImmutableLinkedList removeLast() {
        validateSize();
        return (ImmutableLinkedList) remove(size() - 1);
    }
}
