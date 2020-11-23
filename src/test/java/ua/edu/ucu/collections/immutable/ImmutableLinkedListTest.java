package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    @Test
    public void testAdd()
    {
        ImmutableLinkedList testList = new ImmutableLinkedList();
        assertEquals("0", testList.add("0").toString());
        assertEquals("0,1,2", testList.add("0").add("1").add("2").toString());
    }

//    ImmutableList add(int index, Object e); //додає елемент до колекції за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції

    @Test
    public void testAddAtIndex() {
        ImmutableLinkedList testList = new ImmutableLinkedList();
        assertEquals("0", testList.add(0, "0").toString());
        assertEquals("0,9,1", testList.add(0, "0").add(1, "1").add(1, "9").toString());


    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddIndException() {
        ImmutableLinkedList testList = new ImmutableLinkedList();
        testList.add(100, "0");
    }

//    ImmutableList addAll(Object[] c); //додає масив елементів у кінець колекції

    @Test
    public void testAddAll() {
        ImmutableLinkedList testList = new ImmutableLinkedList();
        assertEquals("5,6", testList.addAll(new Object[]{5, 6}).toString());
    }

//    ImmutableList addAll(int index, Object[] c); // додає масив елементів починаючи з зазначеного індекса, та кидає виключну ситуацію, якщо індекс виходить за межі колекції
    @Test
    public void testAddAllInd() {
        ImmutableLinkedList testList = new ImmutableLinkedList();
        assertEquals("5,6", testList.addAll(0, new Object[]{5, 6}).toString());
        assertEquals("5,1,6", testList.addAll(0, new Object[]{5, 6}).addAll(1, new Object[]{1}).toString());

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllException() {
        ImmutableLinkedList testList = new ImmutableLinkedList();
        assertEquals("5,6", testList.addAll(1, new Object[]{5, 6}).toString());
    }

//    Object get(int index); //повертає елемент за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції

    @Test
    public void testGet() {
        ImmutableLinkedList testList = new ImmutableLinkedList();
        assertEquals("6", testList.addAll(new Object[]{5, 6}).get(1).toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetException() {
        ImmutableLinkedList testList = new ImmutableLinkedList();
        assertEquals("6", testList.addAll(new Object[]{5, 6}).get(100).toString());
    }

//    ImmutableList remove(int index); //видаляє елемент за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції

    @Test
    public void testRemove() {
        ImmutableLinkedList testList = new ImmutableLinkedList();
        assertEquals("6", testList.addAll(new Object[]{5, 6}).remove(0).toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveException() {
        ImmutableLinkedList testList = new ImmutableLinkedList();
        assertEquals("6", testList.addAll(new Object[]{5, 6}).remove(100).toString());
    }

//    ImmutableList set(int index, Object e); //змінює значення елементу за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції

    @Test
    public void testSet() {
        ImmutableLinkedList testList = new ImmutableLinkedList();
        assertEquals("5,99", testList.addAll(new Object[]{5, 6}).set(1, 99).toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetException() {
        ImmutableLinkedList testList = new ImmutableLinkedList();
        assertEquals("6", testList.addAll(new Object[]{5, 6}).set(100, 99).toString());
    }
//    int indexOf(Object e); //шукає індекс елемента (повертає індекс першого який знайшов, або -1 у випадку відсутності)

    @Test
    public void testIndexOfExist() {
        ImmutableLinkedList testList = new ImmutableLinkedList();
        assertEquals(0, testList.addAll(new Object[]{5, 6}).indexOf(5));
    }

    @Test
    public void testIndexOfNotExist() {
        ImmutableLinkedList testList = new ImmutableLinkedList();
        assertEquals(-1, testList.addAll(new Object[]{5, 6}).indexOf(99));
    }
//    int size(); //розмір колекції

    @Test
    public void testSize() {
        ImmutableLinkedList testList = new ImmutableLinkedList();
        assertEquals(2, testList.addAll(new Object[]{5, 6}).size());
    }
//    ImmutableList clear(); //очищує вміст колекції
    @Test
    public void testClear() {
        ImmutableLinkedList testList = new ImmutableLinkedList();
        assertEquals("", testList.addAll(new Object[]{5, 6}).clear().toString());
    }

//    boolean isEmpty(); //якщо у колеції нема елементів то повертає true

    @Test
    public void testIsEmpty() {
        ImmutableLinkedList testList = new ImmutableLinkedList();
        assertEquals(true, testList.addAll(new Object[]{5, 6}).clear().isEmpty());
    }
//    Object[] toArray(); //перетворює колекцію до масиву обєктів

    @Test
    public void testToArray() {
        ImmutableLinkedList testList = new ImmutableLinkedList();
        assertArrayEquals(new Object[]{5, 6}, testList.addAll(new Object[]{5, 6}).toArray());
    }

//    @Override
//    String toString(); //повертає рядок, де через кому відображаютсься елементи колекції
    @Test
    public void testToString() {
        ImmutableLinkedList testList = new ImmutableLinkedList();
        assertEquals("5,6", testList.addAll(new Object[]{5, 6}).toString());
    }

//    public ImmutableLinkedList addFirst(Object e)
    @Test
    public void testAddFirst() {
        ImmutableLinkedList testList = new ImmutableLinkedList();
        assertEquals("2,1", testList.addFirst(1).addFirst(2).toString());
    }

//    public ImmutableLinkedList addLast(Object e)
    @Test
    public void testAddLast() {
        ImmutableLinkedList testList = new ImmutableLinkedList();
        assertEquals("1,2", testList.addLast(1).addLast(2).toString());
    }


//    public Object getFirst()
    @Test
    public void testGetFirst() {
        ImmutableLinkedList testList = new ImmutableLinkedList();
        assertEquals("1", testList.addLast(1).getFirst().toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetFirstException() {
        ImmutableLinkedList testList = new ImmutableLinkedList();
        assertEquals("6", testList.getFirst());
    }
//    public Object getLast()

    @Test
    public void testGetLast() {
        ImmutableLinkedList testList = new ImmutableLinkedList();
        assertEquals("2", testList.addLast(1).addLast(2).getLast().toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetLastException() {
        ImmutableLinkedList testList = new ImmutableLinkedList();
        assertEquals("6", testList.getLast());
    }

//    public ImmutableLinkedList removeFirst()
    @Test
    public void testRemoveFirst() {
        ImmutableLinkedList testList = new ImmutableLinkedList();
        assertEquals("2", testList.add(1).add(2).removeFirst().toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveFirstException() {
        ImmutableLinkedList testList = new ImmutableLinkedList();
        assertEquals("6", testList.removeFirst());
    }

//    public ImmutableLinkedList removeLast() - видаляє останній елемент
    @Test
    public void testRemoveLast() {
        ImmutableLinkedList testList = new ImmutableLinkedList();
        assertEquals("1", testList.add(1).add(2).removeLast().toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveLastException() {
        ImmutableLinkedList testList = new ImmutableLinkedList();
        assertEquals("6", testList.removeLast());
    }
}


