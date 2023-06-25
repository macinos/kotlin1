package cz.training.kotlin;

import java.util.ArrayList;

public class HelloWorldJavaMain {
    public static void main(String[] args) {
        System.out.println("Hello world, Java is here!");
        HelloWorldMainKt.main(args);

        new ArrayList(CollectionsMainKt.getSomeList()).add("testJ");
    }
}
