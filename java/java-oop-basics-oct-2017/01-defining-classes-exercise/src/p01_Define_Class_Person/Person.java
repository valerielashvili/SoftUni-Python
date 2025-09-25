package p01_Define_Class_Person;

class Person {
    private String name;
    private int age;

    Person() {

    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    int getAge() {
        return this.age;
    }

    void setName(String name) {
        this.name = name;
    }

    void setAge (int age) {
        this.age = age;
    }
}
