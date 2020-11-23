package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList {

    private int capacity;
    private int size;
    private Object[] data;


    public ImmutableArrayList() {
        data = new Object[2];
        capacity = 2;
        size = -1;
    }

    public ImmutableArrayList(Object[] inpData, int inpSize) {
        data = inpData;
        capacity = inpData.length;
        size = inpSize;
    }


    public Object[] getData() {
        return data;
    }

    public void setData(Object[] inpData) {
        this.data = inpData;
    }

    public ImmutableArrayList cloneList() {
        return new ImmutableArrayList(Arrays.copyOf(
                this.getData(), this.capacity),
                this.size);
    }

    @Override
    public ImmutableArrayList add(Object e) {
        ImmutableArrayList cop = this.cloneList();
        if (cop.capacity == cop.size + 1) {
            cop.data = Arrays.copyOf(cop.data, 2 * cop.capacity);
            cop.capacity *= 2;
        }
        cop.data[cop.size + 1] = e;
        cop.size += 1;
        return cop;
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        if (0 <= index && index <= this.size) {
            ImmutableArrayList cop = this.cloneList();
            if (cop.capacity == cop.size + 1) {
                cop.setData(Arrays.copyOf(cop.getData(), 2 * cop.capacity));
                cop.capacity *= 2;
            }
            for (int i = index; i < cop.size + 1; i++) {
                cop = cop.setCurr(i + 1, this.data[i]);
            }
            cop.data[index] = e;
            cop.size++;
            return cop;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        ImmutableArrayList cop = this.cloneList();
        for (int i = 0; i < c.length; i++) {
            cop = cop.add(c[i]);
        }
        return cop;
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        if (0 <= index && index <= this.size) {
            ImmutableArrayList cop = this.cloneList();
            if (cop.capacity <= cop.size + 1 + c.length) {
                cop.setData(Arrays.copyOf(cop.getData(), 2 * cop.capacity));
                cop.capacity *= 2;
            }
            for (int i = index; i < cop.size + 1; i++) {
                cop.data[i + c.length] = this.data[i];
            }
            for (int i = 0; i < c.length; i++) {
                cop.data[index + i] = c[i];
                cop.size++;
            }
            return cop;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Object get(int index) {
        if (0 <= index && index <= this.size) {
            return this.data[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public ImmutableArrayList remove(int index) {
        ImmutableArrayList cop = this.cloneList();
        if (0 <= index && index <= this.size) {
            for (int i = index; i < cop.size() - 1; i++) {
                cop.data[i] = cop.data[i + 1];
            }
            cop.size--;
            return cop;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        ImmutableArrayList cop = this.cloneList();
        if (0 <= index && index <= this.size) {
            cop.data[index] = e;
            return cop;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public ImmutableArrayList setCurr(int index, Object e) {
        ImmutableArrayList cop = this.cloneList();
        cop.data[index] = e;
        return cop;
    }


    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i) == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.size + 1;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return this.size < 0;
    }

    @Override
    public Object[] toArray() {
        if (this.size == -1) {
            return new Object[]{};
        }
        Object[] cop = new Object[this.size + 1];
        for (int i = 0; i < cop.length; i++) {
            cop[i] = this.data[i];
        }
        return cop;
    }
}
