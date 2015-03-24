/*
 * MyList by Eduardo Moreno -- 02/13/14
 * Description: This class is meant to mimic the ArrayList class in java. It
 * contains methods such as add(), get(), remove(), clear(), set(), size(),
 * capacity() and trimToSize() that manipulate the ArrayList.
 */
package mylist;

public class MyList<E> {

    private E[] list, listtemp, removed;
    private int size = 0;
    private int capacity;

    public MyList() {

        capacity = 10;
        list = (E[]) new Object[capacity];
        
    }

    public MyList(int capacity) {

        list = (E[]) new Object[capacity];

    }

    public void add(E item) {

        size += 1;

        if (capacity == size) {
            capacity += 10;
            listtemp = (E[]) new Object[capacity];

            for (int i = 0; i < size; i++) {
                listtemp[i] = list[i];
            }
            list = (E[]) new Object[capacity];

            for (int i = 0; i < capacity; i++) {
                list[i] = listtemp[i];
            }
        }

        for (int i = 0; i < capacity; i++) {
            if (list[i] == null) {
                {
                    list[i] = item;
                    i = capacity;
                }
            }
        }

    }

    public E get(int i) {

        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        return list[i];
    }

    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        
        removed = (E[]) new Object[1];
        boolean flag = false;
        listtemp = (E[]) new Object[size];

        for (int i = 0; i < size - 1; i++) {
            if (i != index) {
                if (!flag) {
                    listtemp[i] = list[i];
                }
                if (flag) {
                    listtemp[i] = list[i + 1];
                    removed[0] = list[i +1];
                }
            } else {
                listtemp[i] = list[i + 1];

                flag = true;
            }

        }

        for (int i = 0; i < size - 1; i++) {
            list[i] = listtemp[i];
        }


        size -= 1;
        
        return removed[0];

    }

    public void clear() {
        for (int i = 0; i < size; i++) {
                list[i] = null;
            }
        size = 0;
    }

    public E set(int index, E item) {

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        listtemp = (E[]) new Object[capacity];
        listtemp[0] = list[index];
        list[index] = item;
        return listtemp[0];
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public void trimToSize() {
        capacity = size;
    }

    @Override
    public String toString() {

        String imastring = "";

        for (int i = 0; i < size; i++) {
            imastring += " " + (String) list[i];
        }

        return imastring;
    }
    
    public static void main(String[] args) {
        
    }
}
