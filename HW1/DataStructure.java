package HW1;
// zohar simhon id- 211301460

import java.util.Arrays;
import java.util.Random;

/**
 * Represents a singly data structure.
 *
 * @param <T> the type of elements stored in the data structure **/
public class DataStructure<T> {

    /**
     * Default constructor for the HW1.DataStructure class.
     */
    int capacity=5;
    T[] items;
    int size;
    public DataStructure() {
        // Initialize any necessary variables
        this.size = 0;
        this.items = (T[]) new Object[capacity];
    }

    /**
     * Inserts a new node in the index location of the data structure.
     * This should be done in O(n) operations.
     *
     * @param data  the data to be inserted
     * @param index the index the item should be inserted at.
     *              we assume that the index that was given is true
     */
    public void add(T data, int index) {
        if(index < 0 || index > size) throw new IndexOutOfBoundsException("out of bounds index");
        if(size == items.length) resizeItems();

        for(int i =size-1; i>=index  ;i--)
            items[i+1]= items[i];
        items[index] = data;
        size++;
    }


    /**
     * Inserts a new node at the end of the data structure.
     *
     * @param data the data to be inserted
     */
    public void addToEnd(T data) {
        if(size == items.length){
            resizeItems();
        }

        items[size] = data;
        size++;
    }
    public void resizeItems(){
        int newCapacity = capacity * 2;
        items = Arrays.copyOf(items, newCapacity);
        capacity = newCapacity;
    }

    /**
     * Deletes a node with the given data from the data structure.
     * This should be done in O(n) operations.
     *
     * @param data the data to be deleted
     */
    public void delete(T data) {

        for(int i =0; i< size; i++){
            if(items[i].equals(data)){
                for (int j = i; j < size-1; j++)
                    items[j] =items[j+1];
                items[size-1]= null;
                size--;
                return;
            }
        }
    }

    /**
     * Searches for a node with the given data in the data structure.
     * This should be done in O(n) operations.
     *
     * @param data the data to be searched
     * @return true if the data is found, false otherwise
     */
    public boolean contains(T data) {
        for(int i = 0; i < size; i++){
            if(items[i].equals(data)) return true;
        }
        return false;
    }


    /**
     * Gets the size of the data structure.
     *
     * @return the number of elements in the data structure
     */
    public int size() {
        return size;
    }


    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return items[index];
    }

    /**
     * Sets the element at the specified index with the given value.
     *
     * @param index the index at which to set the value
     * @param value the value to set at the specified index
     */
    public void set(int index, T value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        items[index] = value;
    }



    /**
     * Return the string value of the elements in
     * a data structure from beginning to end,
     * separated by commas
     */
    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            result += items[i];
            if (i < size - 1) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }
}
