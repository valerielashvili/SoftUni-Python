package p1_Paw_Inc.entities.animals;

public abstract class Animal {
    private String name;
    private int age;
    private boolean cleansed;
    private String adoptionCenterName;

    protected Animal(String name, int age) {
        this.name = name;
        this.age = age;
        this.cleansed = false;
    }

    public void setAdoptionCenterName(String adoptionCenterName) {
        this.adoptionCenterName = adoptionCenterName;
    }

    public String getName() {
        return this.name;
    }

    public boolean isCleansed() {
        return this.cleansed;
    }

    public String getAdoptionCenterName() {
        return this.adoptionCenterName;
    }

    public void cleanse() {
        this.cleansed = true;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
