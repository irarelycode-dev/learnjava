package com.datastructures;
import java.util.Iterator;
import static java.lang.System.out;

class Array<T> implements Iterable<T>{
    private T[] arr;
    private int len=0;  //length user thinks
    private int capacity=0;  //Actual array size
    public Array(){this(16);}
    public Array(int capacity){
        if(capacity<0) throw new IllegalArgumentException("Illegal capacity:"+capacity);
        this.capacity=capacity;
        arr=(T[])new Object[capacity];
    }
    public int size(){
        return len;
    }
    public boolean isEmpty(){
        return size()==0;
    }
    public T get(int index){
        return arr[index];
    }
    public void set(int index,T elem){
        arr[index]=elem;
    }
    public void clear(){
        for(int i=0;i<capacity;i++){
            arr[i]=null;
        }
        len=0;
    }
    public void add(T elem){
        if(len+1>=capacity){
            if(capacity==0) capacity=1;
            else capacity*=2;
            T[] new_array=(T[]) new Object[capacity];
            for(int i=0;i<len;i++){
                new_array[i]=arr[i];
            }
            arr=new_array;
        }
        arr[len++]=elem;
    }
    public T removeAt(int index){
        if(index>=len||index<0) throw new IndexOutOfBoundsException();
        T data=arr[index];
        T[] new_array=(T[])new Object[capacity];
        for(int i=0,j=0;i<len;i++,j++){
            if(i==index) j--;
            else new_array[j]=arr[i];
        }
        arr=new_array;
        capacity=--len;
        return data;
    }
    public boolean remove(Object obj){
        for(int i=0;i<len;i++){
            if(arr[i].equals(obj)){
                T data=removeAt(i);
                return true;
            }
        }
        return false;
    }
    public int indexOf(Object obj){
        for(int i=0;i<len;i++){
            if(arr[i].equals(obj)){
                return i;
            }
        }
        return -1;
    }
    public boolean contains(Object obj){
        return indexOf(obj)!=-1;
    }
    @Override public Iterator<T> iterator(){
        return new Iterator<T>() {
            int index=0;
            @Override
            public boolean hasNext() {
                return index<len;
            }

            @Override
            public T next() {
                return arr[index++];
            }
        };
    }
    @Override public String toString(){
        if(len==0) return "[]";
        else{
            StringBuilder sb=new StringBuilder(len).append("[");
            for(int i=0;i<len-1;i++){
                sb.append(arr[i]).append(", ");
            }
            return sb.append(arr[len-1]).append("]").toString();
        }
    }
}

public class StaticArrays {
    public static void main(String[] args) {
        Array<Integer> arr=new Array<Integer>();
        arr.add(new Integer(10));
        out.println("test");
        out.println(arr.toString());
    }
}


// static arrays
//storing and accessing sequential data
//temporarily store objects
//used by IO routines as buffers
//lookup table and inverse lookup tables
//can be used to return multiple values from a function
//used in dynamic programming to cache answers of subproblems
//complexity of static vs dynamic arrays :
/*
* access  o(1) o(1)
* search o(n) o(n)
* insertion N/A o(n)
* appending N/A o(1)
* deletion N/A o(n)
* */