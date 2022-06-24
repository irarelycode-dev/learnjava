package com.company;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Annotation;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@interface MyAnnotation{
    int value() default 0;
}

@Repeatable(MyRepeatedAnnos.class)
@interface Words{
    String word() default "Hello";
    int value() default 0;
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyRepeatedAnnos{
    Words[] value();
}

class BaseCheck{
    public void display(){
        System.out.println("base display");
    }
}

public class Annotations extends BaseCheck {
    @Override
    public void display(){
        System.out.println("method display has been overriden");
    }
    public static void main(String[] args) {
        BaseCheck object=new BaseCheck();
    }
    public @MyAnnotation int returnValue(){
        return 0;
    }
}
//Annotations start with @
//annoatations do not change the action of a compiled program
//annotations help to associate metadata to the program elements-variables,constructors,methods,classes
//annotations are not pure comments as they change the program is treated

//categories:
//1. marker annotations-> only purpose is to mark a decalration. They do not have a member or data.Their presence alone is sufficient.@Override is an example of marker annotation.
//2. single value annotations->> consists of a single member and a value is enough to show it's presence->>> @Annotation("test")
//3. full annoations->>> consists of multiple members,values as a pairs->>>>> @Annotation(name="vignesh",age=25)
//4, Type annotations->>>> these can be applied to any place where a type is being used. We can annotate return type of a method. These are declared with @Target annotation

//custom annotations are created using @interface element