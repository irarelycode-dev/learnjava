package designpatterns.builder;
import java.util.ArrayList;
import java.util.List;

public class CdType {
    private List<Packing> items=new ArrayList<Packing>();
    public void addItem(Packing packs){
        items.add(packs);
    }
    public void showItem(){
        for(Packing packing:items){
            System.out.println(packing.pack());
            System.out.println(packing.price());
        }
    }
}
