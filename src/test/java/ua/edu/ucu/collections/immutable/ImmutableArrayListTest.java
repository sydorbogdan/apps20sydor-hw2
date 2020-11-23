package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    @Test
    public void testAdd() {
        ImmutableArrayList testList = new ImmutableArrayList();
        testList = testList.add(1);
        testList = testList.add(2);
        ImmutableArrayList cp = testList.add(3);
        assertArrayEquals(new Object[]{1, 2}, testList.toArray());
    }

    @Test
    public void testAddIndex() {
        ImmutableArrayList testList = new ImmutableArrayList();
        testList = testList.add(1);
        testList = testList.add(2);
        testList = testList.add(1, 3);
        testList = testList.add(1, 4);
        assertArrayEquals(new Object[]{1, 4, 3, 2}, testList.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddIndException() {
        ImmutableArrayList testList = new ImmutableArrayList();
        testList = testList.add(100, 3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddIndExceptionNeg() {
        ImmutableArrayList testList = new ImmutableArrayList();
        testList = testList.add(-100, 3);
    }

    @Test
    public void testAddAll() {
        ImmutableArrayList testList = new ImmutableArrayList();
        testList = testList.add(1);
        testList = testList.add(2);
        testList = testList.addAll(new Object[]{11, 22});
//        for (int i=0; i<testList.size(); i++){
//            System.out.println(testList.getData()[i]);
//        }
        assertArrayEquals(new Object[]{1, 2, 11, 22}, testList.toArray());
    }

    @Test
    public void testAddAllInd() {
        ImmutableArrayList testList = new ImmutableArrayList();
        testList = testList.add(1).addAll(0, new Object[]{11, 22})
                .addAll(1, new Object[]{55}).addAll(2, new Object[]{6, 7, 8});
//        for (int i=0; i<testList.size(); i++){
//            System.out.println(testList.getData()[i]);
//        }
        assertArrayEquals(new Object[]{11, 55, 6, 7, 8, 22, 1}, testList.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllIndException() {
        ImmutableArrayList testList = new ImmutableArrayList();
        testList = testList.addAll(1, new Object[]{11, 22});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllIndExceptionNeg() {
        ImmutableArrayList testList = new ImmutableArrayList();
        testList = testList.addAll(-10, new Object[]{11, 22});
    }

    @Test
    public void testGet() {
        ImmutableArrayList testList = new ImmutableArrayList();
        testList = testList.add(1).add(2).addAll(1, new Object[]{11, 22});
//        for (int i=0; i<testList.size(); i++){
//            System.out.println(testList.getData()[i]);
//        }
//        {1, 11, 22, 2}
        assertEquals(22, testList.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetException() {
        ImmutableArrayList testList = new ImmutableArrayList();
        testList.get(100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetExceptionNeg() {
        ImmutableArrayList testList = new ImmutableArrayList();
        testList.get(-100);
    }


    @Test
    public void testRemove() {
        ImmutableArrayList testList = new ImmutableArrayList();
        testList = testList.add(1).add(2).addAll(1, new Object[]{11, 22});
//        for (int i=0; i<testList.size(); i++){
//            System.out.println(testList.getData()[i]);
//        }
        testList = testList.remove(1);
//        {1, 11, 22, 2}
        assertEquals(new Object[]{1, 22, 2}, testList.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveException() {
        ImmutableArrayList testList = new ImmutableArrayList();
        testList.remove(100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveExceptionNeg() {
        ImmutableArrayList testList = new ImmutableArrayList();
        testList.remove(-100);
    }

    @Test
    public void testSet() {
        ImmutableArrayList testList = new ImmutableArrayList();
        testList = testList.add(1).add(2).addAll(1, new Object[]{11, 22});
        testList = testList.set(1, 50);
        assertEquals(new Object[]{1, 50, 22, 2}, testList.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetException() {
        ImmutableArrayList testList = new ImmutableArrayList();
        testList.set(100, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetExceptionNeg() {
        ImmutableArrayList testList = new ImmutableArrayList();
        testList.set(-100, 1);
    }

    @Test
    public void testIndexOf() {
        ImmutableArrayList testList = new ImmutableArrayList();
        testList = testList.add(1).add(2).addAll(1, new Object[]{11, 22});
        assertEquals(2, testList.indexOf(22));
        assertEquals(-1, testList.indexOf(100));

    }

    @Test
    public void testSize() {
        ImmutableArrayList testList = new ImmutableArrayList();
        testList = testList.add(1).add(2).addAll(1, new Object[]{11, 22});
        assertEquals(4, testList.size());
    }

    @Test
    public void testClear() {
        ImmutableArrayList testList = new ImmutableArrayList();
        testList = testList.add(1).add(2).addAll(1, new Object[]{11, 22});
        assertEquals(0, testList.clear().size());
    }

    @Test
    public void testIsEmpty() {
        ImmutableArrayList testList = new ImmutableArrayList();
        testList = testList.add(1).add(2).addAll(1, new Object[]{11, 22});
        assertEquals(true, testList.clear().isEmpty());
        assertEquals(false, testList.isEmpty());
    }

    @Test
    public void testToArray() {
        ImmutableArrayList testList = new ImmutableArrayList();
        assertArrayEquals(new Object[]{}, testList.toArray());
    }


}
