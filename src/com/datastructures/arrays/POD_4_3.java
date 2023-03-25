package com.datastructures.arrays;

import java.util.Scanner;
import java.util.Stack;

public class POD_4_3 {
    public boolean checkValidParantheses(String str){
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<str.length();i++){
            char chr=str.charAt(i);
            if(chr=='{' || chr=='(' || chr=='['){
                stack.push(chr);
            }
            if(chr=='}'|| chr==')' || chr==']'){
                if(stack.size()==0) return false;
                char peak=stack.peek();
                if(!((peak=='{' && chr=='}') || (peak=='[' && chr==']') || (peak=='(' && chr==')'))) return false;
                else stack.pop();
            }
        }
        if(stack.size()!=0) return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String str=scan.nextLine();
        POD_4_3 obj=new POD_4_3();
        System.out.println(obj.checkValidParantheses(str));
    }
}
