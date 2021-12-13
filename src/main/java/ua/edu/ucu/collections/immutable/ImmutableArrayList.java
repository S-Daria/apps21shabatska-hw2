package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public final class ImmutableArrayList implements ImmutableList {

    private Object[] list;

    public ImmutableArrayList(Object[] elements) {
        this.list = Arrays.copyOf(elements, elements.length);
    }

    public ImmutableArrayList() {
        this.list = new Object[0];
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
        for (int i = 0; i < index; i++) {
            newList[curIndx] = get(i);
            curIndx++;
        }

        for (Object element : c) {
            newList[curIndx] = element;
            curIndx++;
        }

        for (int i = index; i < size(); i++) {
            newList[curIndx] = get(i);
            curIndx++;
        }
        return new ImmutableArrayList(newList);
    }

    @Override
    public Object get(int index) {
        validateIndexInput(index);
        return this.list[index];
    }

    @Override
    public ImmutableList remove(int index) {
        validateIndexInput(index);

        Object[] newList = new Object[size() - 1];
        for (int i = 0; i < size() - 1; i++) {
            if (i >= index) {
                newList[i] = get(i + 1);
            }
            else {
                newList[i] = get(i);
            }
        }
        return new ImmutableArrayList(newList);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        validateIndexInput(index);

        Object[] newList = toArray();
        newList[index] = e;
        return new ImmutableArrayList(newList);
    }

    @Override
    public int indexOf(Object e) {
        validateSize();
        for (int i = 0; i < size(); i++) {
            if (get(i) == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.list.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.list, size());
    }
}
