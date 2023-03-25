package newfeatures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.List;

public class ImperativeDeclarative {
    public static void imperative(){
        int sum=0;
        for(int i=0;i<=100;i++){
            sum+=i;
        }
        System.out.println("Imperative approach:"+sum);
    }

    public static void declarative(){
        System.out.println(IntStream.rangeClosed(0,100).sum());
    }

    public static void imperativeTwo(){
        List<Integer> list= Arrays.asList(1,2,2,2,3,4,5,6,6,6,6,7);
        List<Integer> uniqueList=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(!uniqueList.contains(list.get(i))){
                uniqueList.add(list.get(i));
            }
        }
        System.out.println(uniqueList.toString());
    }

    public static void declarativeTwo(){
        List<Integer> list=Arrays.asList(1,2,2,2,3,4,5,5,6,6,7,8,8,9,9,9,9);
        List<Integer> uniqueList=list.stream().distinct().toList();
        System.out.println(uniqueList.toString());
    }

    public static void main(String[] args) {
        ImperativeDeclarative.imperative();
        ImperativeDeclarative.declarative();
        ImperativeDeclarative.imperativeTwo();
        ImperativeDeclarative.declarativeTwo();
    }
}
