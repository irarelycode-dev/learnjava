package com.examprep;

import java.util.Dictionary;
import java.util.Hashtable;

public class DictionaryHashTable {
    public static void main(String[] args) {
        Dictionary dict=new Hashtable();
        dict.put(2,"C");
        dict.put(2,"E");
        System.out.println(dict);
        System.out.println(dict.get(2));

        System.out.println("Vignesh".hashCode());
        System.out.println("Vignesh".hashCode());

        int hash=0;
        for(int i=0;i<7;i++){
            hash=31*hash+"Vignesh".charAt(i);
        }
        System.out.println(hash);

    }
}
