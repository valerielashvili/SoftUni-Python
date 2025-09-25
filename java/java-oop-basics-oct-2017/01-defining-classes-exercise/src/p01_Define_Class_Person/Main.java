package p01_Define_Class_Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Class person = Person.class;

        Field[] fields = person.getDeclaredFields();
        System.out.println(fields.length);

        // Optional task
        /*String input = reader.readLine();
        Random randomGenerator = new Random();
        int randomNum = randomGenerator.nextInt(100);
        Person somePerson = new Person(input, randomNum);
        System.out.println(somePerson.getAge());*/
    }
}
