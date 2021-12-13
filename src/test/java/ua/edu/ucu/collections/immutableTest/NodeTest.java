package ua.edu.ucu.collections.immutableTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.collections.immutable.Node;


public class NodeTest {
    Node node0;
    Node node1;

    @Before
    public void setUp() {
        node0 = new Node();
        node0.setValue(0);
        node1 = new Node();
        node1.setValue(1);
        node0.setNext(node1);
        node1.setPrevious(node0);
    }

    @Test
    public void testToString() {
        Assert.assertEquals(node0.toString(), "0");
    }

    @Test
    public void getPrevious() {
        Assert.assertEquals(node1.getPrevious(), node0);
    }

    @Test
    public void getValue() {
        Assert.assertEquals(node0.getValue(), 0);
    }

    @Test
    public void setValue() {
        node0.setValue(10);
        Assert.assertEquals(node0.getValue(), 10);
    }

    @Test
    public void getNext() {
        Assert.assertEquals(node0.getNext(), node1);
    }

}