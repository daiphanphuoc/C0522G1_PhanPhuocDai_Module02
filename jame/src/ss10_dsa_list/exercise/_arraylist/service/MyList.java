package ss10_dsa_list.exercise._arraylist.service;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class MyList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable {

    /**
     * sức chứa mặc định của MyList
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * số lượng phần tử của MyList
     */
    private int size = 0;

    /**
     * Mảng chứa các phần tử
     */
    Object elementData[];

    /**
     * contructor không có tham số , khởi tạo mảng có sức chứa mặc định
     */
    public MyList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    /**
     * contructor có tham số, khởi tạo mảng  có sức chứa truyền vào
     */
    public MyList(int capacity) {
        if (capacity > 0) {
            elementData = new Object[capacity];
        } else if (capacity == 0) {
            elementData = new Object[DEFAULT_CAPACITY];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    capacity);
        }
    }

    public void trimToSize() {

    }

    /**
     * Phương thức tăng kích thước
     */
    private void ensureCapacity() {
        int newSize = elementData.length * 2;
        elementData = Arrays.copyOf(elementData, newSize);
    }

    /**
     * phương thức thêm vào cuối MyList 1 phần tử
     *
     * @return true
     */
    public boolean add(E e) {
        if (size == elementData.length) {
            ensureCapacity();
        }
        elementData[size++] = e;
        return true;
    }

    /**
     * phương thức thêm vào vị trí chỉ định MyList 1 phần tử
     */
    public void add(int index, E e) {

        if (size == elementData.length) {
            ensureCapacity();
        }

        if (size < index) {

            throw new IllegalArgumentException("index:" + index);

        } else if (size == index) {

            elementData[size++] = e;
        } else {

            for (int i = size; i > index; i--) {
                elementData[i] = elementData[i - 1];
            }

            elementData[index] = e;
            size++;
        }
    }

    /**
     * phương thức xóa MyList
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    /**
     * phương thức lấy giá trị tại vị trí chỉ định
     *
     * @return E
     */
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        }
        return (E) elementData[index];
    }


    /**
     * phương thức trả về số lượng phần tử
     *
     * @return size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @param element
     */
    public int indexOf(Object element) {
        if (element == null) {
            for (int i = 0; i < size; i++)
                if (elementData[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (element.equals(elementData[i]))
                    return i;
        }
        return -1;
    }

    /**
     * kiểm tra phần tử có trong MyList
     */
    public boolean contains(Object element) {
        return indexOf(element) >= 0;
    }

    public MyList<E> clone() {
        MyList<E> v = new MyList<E>();
        v.elementData = Arrays.copyOf(this.elementData, this.size);
        v.size = this.size;
        return v;
    }

    public E remove(int index) {
        if(index<0||index>=size){
            throw new IllegalArgumentException("Error index: "+index);
        }
        E element = (E)elementData[index];
        for(int i=index;i<size-1;i++){
            elementData[i]=elementData[i+1];
        }
        elementData[size-1]=null;
        return element;
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        return super.removeIf(filter);
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        List.super.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super E> c) {
        List.super.sort(c);
    }


    @Override
    public void forEach(Consumer<? super E> action) {
        super.forEach(action);
    }

    @Override
    public Spliterator<E> spliterator() {
        return List.super.spliterator();
    }

    @Override
    public Stream<E> stream() {
        return super.stream();
    }

    @Override
    public Stream<E> parallelStream() {
        return super.parallelStream();
    }
}
