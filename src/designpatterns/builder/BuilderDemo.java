package designpatterns.builder;

public class BuilderDemo {
    public static void main(String[] args) {
        CDBuilder cdBuilder=new CDBuilder();
        CdType cdType1=cdBuilder.buildSamsungCD();
        cdType1.showItem();
    }
}
