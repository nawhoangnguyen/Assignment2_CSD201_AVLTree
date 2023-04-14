/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Queue.*;

/**
 *
 * @author USER
 */
class ArrayQueue {

    protected Object[] a;
    protected int max;
    protected int first, last;

    public ArrayQueue() {
        this(2);
    }

    public ArrayQueue(int max1) {
        max = max1;
        a = new Object[max];
        first = last = -1;
    }

    private boolean grow() {
        int i, j;
        int max1 = max + max / 2;
        Object[] a1 = new Object[max1];
        if (a1 == null) {
            return (false);
        }
        if (last >= first) {
            for (i = first; i <= last; i++) {
                a1[i - first] = a[i];
            }
        } else {
            for (i = first; i < max; i++) {
                a1[i - first] = a[i];
            }
            i = max - first;
            for (j = 0; j <= last; j++) {
                a1[i + j] = a[j];
            }
        }
        a = a1;
        first = 0;
        last = max - 1;
        max = max1;
        return (true);
    }

    public boolean isEmpty() {
        return (first == -1);
    }

    public boolean isFull() {
        return ((first == 0
                && last == max - 1) || first == last + 1);
    }

    void enqueue(Object x) {
        if (isFull() && !grow()) {
            return;
        }
        if (last > a.length) {
            System.out.println("Fail");
        }
        if (last == max - 1 || last == -1) {
            a[0] = x;
            last = 0;
            if (first == -1) {
                first = 0;
            }
        } else {
            a[++last] = x;
        }

    }

    Object front() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        return (a[first]);
    }

    void display() {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        System.out.println("Length:" + a.length);
    }

    public Object dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        Object x = a[first];
        if (first == last) // only one element
        {
            first = last = -1;
        } else if (first == max - 1) {
            first = 0;
        } else {
            first++;
        }
        return (x);
    }

}
