package p10_Family_Tree;

class Person {
    private String name;
    private String birthDate;

    Person(String name, String date) {
        this.name = name;
        this.birthDate = date;
    }

    String getName() {
        return this.name;
    }

    String getBirthDate() {
        return this.birthDate;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.birthDate);
    }
}
