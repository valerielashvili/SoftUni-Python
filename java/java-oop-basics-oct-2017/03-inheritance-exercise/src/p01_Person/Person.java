package p01_Person;

class Person {
    private String name;
    private int age;

    Person(String name, int age) throws IllegalArgumentException {
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) throws IllegalArgumentException {
        if (name.length() < 3) {
            throw new IllegalArgumentException("Name's length should not be less than 3 symbols!");
        }
        this.name = name;
    }

    protected void setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Age must be positive!");
        }
        this.age = age;
    }

    private String getName() {
        return this.name;
    }

    private int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s, Age: %d", this.getName(), this.getAge()));

        return sb.toString();
    }
}
