package ua.edu.ucu.collections.immutableTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.collections.immutable.ImmutableArrayList;

public class ImmutableArrayListTest {

    ImmutableArrayList arrayList;

    @Before
    public void init() {
        arrayList = new ImmutableArrayList(new Object[]{0, 1, 2});
    }


    @Test
    public void testAdd() {
        Assert.assertArrayEquals(arrayList.add(1,3).toArray(), new Object[]{0, 3, 1, 2});
        Assert.assertArrayEquals(arrayList.add(4).toArray(), new Object[]{0, 1, 2, 4});
    }

    @Test
    public void addAll() {
        Assert.assertArrayEquals(arrayList.addAll(0, new Object[]{3, 4}).toArray(), new Object[]{3, 4, 0, 1, 2});

    }

    @Test
    public void get() {
        Assert.assertEquals(arrayList.get(1), 1);
    }

    @Test
    public void remove() {
        Assert.assertArrayEquals(arrayList.remove(1).toArray(), new Object[]{0, 2});
    }
    @Test
    public void set() {
        Assert.assertArrayEquals(arrayList.set(1, 4).toArray(), new Object[]{0, 4, 2});
    }


    @Test
    public void indexOf() {
        Assert.assertEquals(arrayList.indexOf(1), 1);
    }

    @Test
    public void size() {
        Assert.assertEquals(arrayList.size(), 3);
    }

    @Test
    public void clear() {
        Assert.assertEquals(arrayList.clear().size(), 0);
    }

    @Test
    public void isEmpty() {
        Assert.assertFalse(arrayList.isEmpty());
        ImmutableArrayList newList = (ImmutableArrayList) arrayList.clear();
        Assert.assertTrue(newList.isEmpty());
    }

    @Test
    public void toArray() {
        Assert.assertArrayEquals(arrayList.toArray(), new Object[]{0, 1, 2});
    }
}