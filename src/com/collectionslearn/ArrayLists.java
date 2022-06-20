package com.collectionslearn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static java.lang.System.out;

public class ArrayLists {
    public static void main(String[] args) {
        List<String> students=new ArrayList<>();
        List<Integer> numbers=new ArrayList<>();
        List<Integer> integers=new ArrayList<>();
        //size=n->>n+n/2+1 if size is to be updated
        //default size is 10
        students.add("vignesh");
        out.println(students);
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        out.println(numbers);
        integers.add(100);
        integers.add(200);
        numbers.addAll(integers);
        out.println(numbers);
        out.println(numbers.get(0));
        numbers.remove(0);
        out.println(numbers);
        numbers.remove(Integer.valueOf(30));
        out.println(numbers);
        numbers.remove(Integer.valueOf(100));
        out.println(numbers);
        numbers.set(0,1234);
        out.println(numbers);
        out.println(numbers.contains(1234));
        out.println(numbers.size());
        for (Integer number : numbers) {
            out.println(number);
        }
        Iterator<Integer> itr=numbers.iterator();
        while(itr.hasNext()){
            out.println("iterator:"+itr.next());
        }
        numbers.clear();
        out.println(numbers);
    }
}

// list.contains()
//list.add()
//list.addAll()
//list.remove(integer),list.remove(T data)
//list.clear()
//list.set(index,value)
//list.get(index)
//list.iterator()