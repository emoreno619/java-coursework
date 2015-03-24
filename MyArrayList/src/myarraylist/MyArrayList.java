/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myarraylist;

public class MyArrayList<E> {

    private E[] list, listtemp, removed;
    private int size = 0;
    private int capacity;

    public MyArrayList() {

        capacity = 10;
        list = (E[]) new Object[capacity];


    }

    public MyArrayList(int capacity) {

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

        MyArrayList<String> testList = new MyArrayList<>();

        System.out.println("Capacity: " + testList.capacity());
        System.out.println("Size: " + testList.size());
        System.out.println(testList.toString());

        testList.add("one");
        testList.add("two");
        testList.add("three");
        testList.add("four");
        testList.add("one");
        testList.add("two");
        testList.add("three");
        testList.add("four");
        testList.add("one");
        testList.add("two");
        testList.add("three");
//        testList.add("four");

        System.out.println("Capacity: " + testList.capacity());
        System.out.println("Size: " + testList.size());
        System.out.println(testList.toString());

        
        System.out.println(testList.remove(2) + " HERE");

        System.out.println("Capacity: " + testList.capacity());
        System.out.println("Size: " + testList.size());
        System.out.println(testList.toString());

        testList.trimToSize();

        System.out.println("Capacity: " + testList.capacity());
        System.out.println("Size: " + testList.size());
        System.out.println(testList.toString());

        testList.clear();

        System.out.println("Capacity: " + testList.capacity());
        System.out.println("Size: " + testList.size());
        System.out.println(testList.toString());

        testList.add("one");
        testList.add("two");
        testList.add("three");
        testList.add("four");

        System.out.println("Capacity: " + testList.capacity());
        System.out.println("Size: " + testList.size());
        System.out.println(testList.toString());

        System.out.println(testList.set(0, "HI"));
        
        System.out.println("Capacity: " + testList.capacity());
        System.out.println("Size: " + testList.size());
        System.out.println(testList.toString());
        

    }
}
