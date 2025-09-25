package p03_Animal_Farm;

class Chicken {
    private String name;
    private int age;

    Chicken(String name, int age) throws IllegalArgumentException {
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) throws IllegalArgumentException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) throws IllegalArgumentException {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    private String calculateProductPerDay() {
        String eggs;
        if (this.age <= 5) {
            eggs = "2";
        } else if (this.age <= 11) {
            eggs = "1";
        } else {
            eggs = "0.75";
        }
        return eggs;
    }

    String getProductPerDay() {
        return this.calculateProductPerDay();
    }

    String getName() {
        return this.name;
    }

    int getAge() {
        return this.age;
    }
}
