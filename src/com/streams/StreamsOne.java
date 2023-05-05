package com.streams;

import java.util.*;
import java.util.stream.*;

public class StreamsOne {
    static class Product{
        int id;
        String name;
        float price;
        public Product(int id,String name,float price){
            this.id=id;
            this.name=name;
            this.price=price;
        }

        @Override
        public String toString(){
            return this.getClass().getSimpleName()+"-{id:"+id+",name:"+name+",price:"+price+"}";
        }
    }

    public static void main(String[] args) {
        List<Product> productsList=new ArrayList<>();
        productsList.add(new Product(1,"product1",200));
        productsList.add(new Product(1,"product2",1200));
        productsList.add(new Product(1,"product3",2400));
        productsList.add(new Product(1,"product4",12000));
        productsList.add(new Product(1,"product5",100));
        productsList=productsList.stream().filter(p->p.price>300).collect(Collectors.toList());
        for(Product product:productsList){
            System.out.println(product);
        }
    }
}
