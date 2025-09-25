package p06_Animals;

class Kitten extends Cat {
    private static final String SOUND = "Miau";

    Kitten(String name, int age, String gender) {
        super(name, age, gender);
    }

    String produceSound() {
        return SOUND;
    }

    @Override
    protected void setGender(String gender) {
        if (!FEMALE_GENDER.equals(gender)) {
            throw new IllegalArgumentException(ErrorMessageConstants.INVALID_INPUT_MESSAGE);
        }
        super.setGender(gender);
    }
}
