package ua.edu.ucu.collections.immutableTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;


public class ImmutableLinkedListTest {

    ImmutableLinkedList linkedList;

    @Before
    public void init() {
        linkedList = new ImmutableLinkedList(new Object[]{0, 1, 2});
    }

    @Test
    public void testAdd() {
        Assert.assertArrayEquals(linkedList.add(1,3).toArray(), new Object[]{0, 3, 1, 2});
        Assert.assertArrayEquals(linkedList.add(4).toArray(), new Object[]{0, 1, 2, 4});
    }

    @Test
    public void addAll() {
        Assert.assertArrayEquals(linkedList.addAll(0,new Object[]{3, 4}).toArray(), new Object[]{3, 4, 0, 1, 2});
    }

    @Test
    public void get() {
        Assert.assertEquals(1,linkedList.get(1));
    }

    @Test
    public void remove() {
        Assert.assertArrayEquals(linkedList.remove(1).toArray(), new Object[]{0, 2});
    }

    @Test
    public void set() {
        Assert.assertArrayEquals(linkedList.set(1,3).toArray(), new Object[]{0, 3, 2});
    }

    @Test
    public void indexOf() {
        Assert.assertEquals(1,linkedList.indexOf(1));
        Assert.assertEquals(-1,linkedList.indexOf(3));
    }

    @Test
    public void size() {
        Assert.assertEquals(3, linkedList.size());
    }

    @Test
    public void clear() {
        Assert.assertEquals(0, linkedList.clear().size());
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(linkedList.clear().isEmpty());
        Assert.assertFalse(linkedList.isEmpty());
    }

    @Test
    public void toArray() {
        Assert.assertArrayEquals(linkedList.toArray(), new Object[]{0, 1, 2});
    }

    @Test
    public void addFirst() {
        Assert.assertEquals(-1,linkedList.addFirst(-1).getFirst());
    }

    @Test
    public void addLast() {
        Assert.assertEquals(3,linkedList.addLast(3).getLast());
    }

    @Test
    public void getHead() {
        Assert.assertEquals(0,linkedList.getHead().getValue());
    }

    @Test
    public void getTail() {
        Assert.assertEquals(2,linkedList.getTail().getValue());
    }

    @Test
    public void removeFirst() {
        Assert.assertEquals(1,linkedList.removeFirst().getFirst());
    }

    @Test
    public void removeLast() {
        Assert.assertEquals(1,linkedList.removeLast().getLast());
    }
}
