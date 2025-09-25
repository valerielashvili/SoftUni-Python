package p03_Mankind;

class Worker extends Human {
    private double weekSalary;
    private double workHoursPerDay;

    Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) throws IllegalArgumentException {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    private double getWeekSalary() {
        return this.weekSalary;
    }

     private void setWeekSalary(double weekSalary) throws IllegalArgumentException {
        if (weekSalary <= 10) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    private double getWorkHoursPerDay() {
        return this.workHoursPerDay;
    }

    private void setWorkHoursPerDay(double workHoursPerDay) throws IllegalArgumentException {
        if (workHoursPerDay < 1 || workHoursPerDay > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    private double calculateMoneyEarnedByHour() {
        return this.weekSalary / (this.workHoursPerDay * 7);
    }

    @Override
    protected void setLastName(String lastName) throws IllegalArgumentException {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Week Salary: ");
        sb.append(String.format("%.2f", this.getWeekSalary()))
                .append(System.lineSeparator())
                .append("Hours per day: ").append(String.format("%.2f", this.getWorkHoursPerDay()))
                .append(System.lineSeparator())
                .append("Salary per hour: ").append(String.format("%.2f", this.calculateMoneyEarnedByHour()));

        return super.toString() + sb.toString();
    }
}
