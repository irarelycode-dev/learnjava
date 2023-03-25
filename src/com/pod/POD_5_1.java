package com.pod;

import java.util.*;
import java.util.regex.*;

public class POD_5_1 {
    public static void findLanguages(String[] train,String[] sentence){
        Map<String,String> hm=new HashMap<>();
        for(int i=0;i<train.length;i++) {
            String[] lanVocab = train[i].split(" ");
            for (int j = 1; j < lanVocab.length; j++) {
                String vocab=lanVocab[j].toLowerCase();
                if (!hm.containsKey(vocab)) {
                    hm.put(vocab, lanVocab[0]);
                }
            }
        }

        for(int i=0;i<sentence.length;i++){
            String[] s=sentence[i].split(" ");
            int len=s.length;
            for(int j=0;j<len;j++){
                String vocab=s[j].toLowerCase();
                Pattern special = Pattern.compile ("[0123456789!@#$%&*()_+=|.;'\"<>?{,}\\[\\]~-]");
                Matcher hasSpecial=special.matcher(vocab);
                if(hasSpecial.find()){
                    vocab=vocab.replaceAll("[0123456789!@#$%&*()_+=|.;'\"<>?{,}\\[\\]~-]","");
                }
                if(hm.containsKey(vocab)){
                    System.out.println(hm.get(vocab));
                    j=len;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        scan.nextLine();
        String[] vocab=new String[n];
        ArrayList<String> al=new ArrayList<>();
        for(int i=0;i<n;i++){
            vocab[i]=scan.nextLine();
        }
        scan.nextLine();
        while(scan.hasNextLine()){
            String word=scan.nextLine();
            if(word.length()==0) break;
            al.add(word);
        }
        String[] sentence=al.toArray(new String[al.size()]);
        findLanguages(vocab,sentence);
    }
}
