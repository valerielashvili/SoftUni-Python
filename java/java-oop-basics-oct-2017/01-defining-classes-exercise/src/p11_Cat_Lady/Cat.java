package p11_Cat_Lady;

abstract class Cat {
    private String name;

    Cat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + this.name;
    }
}
