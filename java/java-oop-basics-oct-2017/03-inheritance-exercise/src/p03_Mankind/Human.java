package p03_Mankind;

class Human {
    private String firstName;
    private String lastName;

    Human(String firstName, String lastName) throws IllegalArgumentException {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    private String getFirstName() {
        return this.firstName;
    }

    private void setFirstName(String firstName) throws IllegalArgumentException {
        if (!Character.isUpperCase(firstName.charAt(0))) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        } else if (firstName.length() < 4) {
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }
        this.firstName = firstName;
    }

    private String getLastName() {
        return this.lastName;
    }

    protected void setLastName(String lastName) throws IllegalArgumentException {
        if (!Character.isUpperCase(firstName.charAt(0))) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        } else if (lastName.length() < 3) {
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
        }
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("First Name: ");
        sb.append(this.getFirstName())
                .append(System.lineSeparator())
                .append("Last Name: ").append(this.getLastName())
                .append(System.lineSeparator());

        return sb.toString();
    }
}
