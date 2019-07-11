package com.clark.lu.demo.structure;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * created by LuChang
 * 2019/7/10 19:23
 */
public class LinkedBlockingQueueTest<T> {

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueueTest<String> queue = new LinkedBlockingQueueTest<>(2);
        Thread put = new Thread(() -> {
            try {
                int i = 0;
                while (true){
                    queue.put("hello " + i);
                    Thread.sleep(100);
                    i++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"put");
        Thread take = new Thread(() -> {
            try {
                while (true) {
                    queue.take();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"take");
        take.start();
        put.start();
    }

    private final ReentrantLock putLock = new ReentrantLock();

    private final Condition notFull = putLock.newCondition();

    private final ReentrantLock takeLock = new ReentrantLock();

    private final Condition notEmpty = takeLock.newCondition();

    private Node<T> head;

    private Node<T> tail;

    private final int capacity;

    private volatile AtomicInteger count = new AtomicInteger(0);

    class Node<T>{

        T item;

        Node<T> next;

        public Node(T item) {
            this.item = item;
        }
    }

    public LinkedBlockingQueueTest() {
        this(Integer.MAX_VALUE);
    }

    public LinkedBlockingQueueTest(int capacity) {
        this.capacity = capacity;
        this.head = this.tail = new Node<>(null);
    }

    public void put(T item) throws InterruptedException {
        putLock.lockInterruptibly();
        int c = -1;
        try {
            while (capacity == count.get()){
                notFull.await();
            }
            tail = tail.next = new Node<>(item);
            c = count.incrementAndGet();
            System.out.println("put " + item);
        }finally {
            putLock.unlock();
        }
        if (c > 0) {
            signalNotEmpty();
        }
    }

    public T take() throws InterruptedException {
        takeLock.lockInterruptibly();
        T result;
        int c = -1;
        try {
            while (count.get() == 0){
                notEmpty.await();
            }
            Node first = head.next;
            head.next = head;
            result = (T) first.item;
            first.item = null;
            head = first;
            c = count.decrementAndGet();
            System.out.println("take " + result);
        }finally {
            takeLock.unlock();
        }
        if (c < capacity) {
            signalNotFull();
        }
        return result;
    }

    private void signalNotFull(){
        putLock.lock();
        try {
            notFull.signal();
        }finally {
            putLock.unlock();
        }
    }

    private void signalNotEmpty(){
        takeLock.lock();
        try {
            notEmpty.signalAll();
        }finally {
            takeLock.unlock();
        }
    }
}
