package AdvancedConcepts;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyCustomAnnotation{
    int value();
}

public class Annotations{
    @MyCustomAnnotation(10)
    public void sayHello(){
        System.out.println("my custom annotation");
    }
    public static void main(String[] args) throws Exception {
        Annotations obj=new Annotations();
        Method methodVal=obj.getClass().getMethod("sayHello");
        System.out.println(methodVal.getAnnotation(MyCustomAnnotation.class).value());
    }
}

// annotations have a number of use cases:
// supress warnings for the compiler
//compile-time and deployment-time processing
//runtime processing
