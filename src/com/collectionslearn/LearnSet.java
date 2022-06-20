//package com.collectionslearn;
//import java.util.Objects;
//import java.util.Set;
//import java.util.HashSet;
//
//class Student implements Comparable<T>{
//    String name;
//    int roll;
//    public Student(String name,int roll){
//        this.name=name;
//        this.roll=roll;
//    }
//    @Override
//    public String toString(){
//        return "Student{"+"name='"+this.name+"',"+"rollNo="+this.roll+"}";
//    }
//    @Override
//    public boolean equals(Object obj){
//        if(this==obj) return true;
//        if(obj==null || getClass()!=obj.getClass()) return false;
//        Student student=(Student) obj;
//        return this.roll==student.roll;
//    }
//    @Override
//    public int hashCode(){
//        return Objects.hash(this.roll);
//    }
//
//    public int compareTo(Student obj){
//        return 0;
//    }
//}
//
//public class LearnSet {
//    public static void main(String[] args) {
//        Set<Integer> set=new HashSet<>();
//        set.add(12);
//        set.add(13);
//        set.add(14);
//        set.add(34);
//        System.out.println(set);
//        set.remove(12);
//        System.out.println(set);
//        System.out.println(set.contains(101));
//        System.out.println(set.isEmpty());
//        System.out.println(set.size());
//        set.clear();
//        Set<Student> students=new HashSet<>();
//        students.add(new Student("vignesh",1001));
//        students.add(new Student("vignesh",1001));
//        System.out.println(students);
//    }
//}
