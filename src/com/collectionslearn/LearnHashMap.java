import java.util.Scanner;

public class LearnHashMap {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        java.util.HashMap<Character,Integer> hm=new java.util.HashMap<Character,Integer>();
        for(int i=0;i<a.length();i++){
            Character chr=Character.toLowerCase(a.charAt(i));
            if(!hm.containsKey(chr)) hm.put(chr,1);
            else hm.put(chr, hm.get(chr)+1);
        }
        System.out.println(hm);
        for(int i=0;i<b.length();i++){
            Character chr=Character.toLowerCase(b.charAt(i));
            if(hm.containsKey(chr)){
                if(hm.get(chr)>1) hm.put(chr,hm.get(chr)-1);
                else hm.remove(chr);
            }
        }
        if(hm.size()==0) return true;
        return false;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
