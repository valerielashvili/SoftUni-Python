package p06_Animals;

class Animal {
    static final String FEMALE_GENDER = "Female";
    static final String MALE_GENDER = "Male";
    private static final String SOUND = "Not implemented!";

    private String name;
    private int age;
    private String gender;

    Animal(String name, int age, String gender) throws IllegalArgumentException {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private void setName(String name) throws IllegalArgumentException {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessageConstants.INVALID_INPUT_MESSAGE);
        }
        this.name = name;
    }

    private void setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException(ErrorMessageConstants.INVALID_INPUT_MESSAGE);
        }
        this.age = age;
    }

    protected void setGender(String gender) throws IllegalArgumentException {
        if (!FEMALE_GENDER.equals(gender) && !MALE_GENDER.equals(gender)) {
            throw new IllegalArgumentException(ErrorMessageConstants.INVALID_INPUT_MESSAGE);
        }
        this.gender = gender;
    }

    String produceSound() {
        return SOUND;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append(System.lineSeparator())
                .append(String.format("%s %d %s", this.name, this.age, this.gender)).append(System.lineSeparator())
                .append(this.produceSound());

        return sb.toString();
    }
}
