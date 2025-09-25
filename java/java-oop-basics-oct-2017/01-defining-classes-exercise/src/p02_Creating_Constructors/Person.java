package p02_Creating_Constructors;

class Person {
    private String name;
    private int age;

    Person() {
        this.name = "No name";
        this.age = 1;
    }

    Person(int age) {
        this.name = "No name";
        this.age = age;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }
}
