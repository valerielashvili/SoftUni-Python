package p06_Animals;

class Tomcat extends Cat {
    private static final String SOUND = "Give me one million b***h";

    Tomcat(String name, int age, String gender) {
        super(name, age, gender);
    }

    String produceSound() {
        return SOUND;
    }

    @Override
    protected void setGender(String gender) {
        if (!MALE_GENDER.equals(gender)) {
            throw new IllegalArgumentException(ErrorMessageConstants.INVALID_INPUT_MESSAGE);
        }
        super.setGender(gender);
    }
}
