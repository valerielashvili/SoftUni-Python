package p_Avatar.monuments;

public abstract class Monument {
    private String name;

    Monument(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    public abstract int getAffinity();
}
