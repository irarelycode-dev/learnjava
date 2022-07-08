package designpatterns.builder;

public class CDBuilder {
    public CdType buildSonyCD(){
        CdType cds=new CdType();
        cds.addItem(new Sony());
        return cds;
    }
    public CdType buildSamsungCD(){
        CdType cds=new CdType();
        cds.addItem(new Samsung());;
        return cds;
    }
}
