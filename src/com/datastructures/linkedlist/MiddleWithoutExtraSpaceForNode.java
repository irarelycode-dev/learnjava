package com.datastructures.linkedlist;

public class MiddleWithoutExtraSpaceForNode extends FindMiddleNode {
    @Override
    public void findMiddleNode(Node head){
        if(head==null) return;
        int count=0;
        Node curr=head;
        Node middle=null;
        while(curr!=null){
            count++;
            if(count%2!=0){
                if(middle!=null) middle=middle.next;
                else middle=head;
            }
            curr=curr.next;
        }
        System.out.println(middle.key);
    }

    public static void main(String[] args) {
        GenerateList listObject=new GenerateList();
        MiddleWithoutExtraSpaceForNode obj=new MiddleWithoutExtraSpaceForNode();
        Node head=listObject.generateList(98);
        obj.findMiddleNode(head);
    }
}
