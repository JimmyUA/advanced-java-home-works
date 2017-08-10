package com.sergey.prykhodko.homework10.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Test {

    private static final class Nested{
        public String testString = "Test string";
        private int a = 7;
        protected long b =8;

        public Nested(){}

        public Nested(int a){
            this.a = a;
        }
        public Nested(int a, long b){
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public long getB() {
            return b;
        }

        public void setA(int a) {
            this.a = a;
        }

        public static void main(String[] args) {
            final Class<?> cls = Nested.class;

            System.out.println("Class name " + cls.getSimpleName());

            System.out.println("Modifiers:");

            int mods = cls.getModifiers();
            if (Modifier.isFinal(mods)){
                System.out.println("final");
            }
            if (Modifier.isAbstract(mods)){
                System.out.println("abstract");
            }
            if (Modifier.isPrivate(mods)){
                System.out.println("private");
            }

            System.out.println("Public fields:");

            Field[] fields = cls.getFields();

            for (Field field : fields
                 ) {
                Class<?> fieldType = field.getType();
                System.out.println("\tName " + field.getName());
                System.out.println("\tType " + fieldType.getTypeName());
            }

            System.out.println("All fields:");

            fields = cls.getDeclaredFields();

            for (Field field : fields
                    ) {
                Class<?> fieldType = field.getType();
                System.out.println("\tName " + field.getName());
                System.out.println("\tType " + fieldType.getTypeName());
            }

            System.out.println("Constructors:");

            Constructor<?>[] constructors = cls.getConstructors();

            for (Constructor<?> constructor : constructors
                 ) {
                Class<?> constr =
            }

        }
    }
}
