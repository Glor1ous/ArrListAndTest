package org.example;

import java.util.Arrays;

public class ArrayListImplementation implements StringList {
    private static final int DEFAULT_CAPACITY = 10;
    private String[] elements;
    private int size;

    public ArrayListImplementation() {
        this.elements = new String[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public ArrayListImplementation(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Емкость должна быть положительным числом.");
        }
        this.elements = new String[initialCapacity];
        this.size = 0;
    }

    private void ensureCapacity(int minCapacity) {
        int currentCapacity = elements.length;
        if (minCapacity > currentCapacity) {
            int newCapacity = currentCapacity + (currentCapacity >> 1); // увеличение на 50%
            elements = Arrays.copyOf(elements, Math.max(newCapacity, minCapacity));
        }
    }

    @Override
    public String add(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Элемент не может быть null.");
        }
        ensureCapacity(size + 1);
        elements[size] = item;
        size++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (item == null) {
            throw new IllegalArgumentException("Элемент не может быть null.");
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс выходит за границы списка.");
        }
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (item == null) {
            throw new IllegalArgumentException("Элемент не может быть null.");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс выходит за границы списка.");
        }
        String oldValue = elements[index];
        elements[index] = item;
        return oldValue;
    }

    @Override
    public String remove(String item) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(item)) {
                return remove(i);
            }
        }
        throw new IllegalArgumentException("Элемент не найден в списке.");
    }

    @Override
    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс выходит за границы списка.");
        }
        String removedElement = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[size - 1] = null; // очищаем последний элемент
        size--;
        return removedElement;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс выходит за границы списка.");
        }
        return elements[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new IllegalArgumentException("Сравниваемый список не может быть null.");
        }
        if (otherList.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!elements[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(elements, size);
    }
}