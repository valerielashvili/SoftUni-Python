package p04_Shopping_Spree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Person {
    private String name;
    private double money;
    private List<Product> products;

    Person(String name, double money) throws IllegalArgumentException {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) throws IllegalArgumentException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) throws IllegalArgumentException {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    void addProduct(Product product) {
        this.products.add(product);
    }

    List<Product> getProducts() {
        return Collections.unmodifiableList(this.products);
    }

    String getName() {
        return this.name;
    }

    boolean hasMoney(Product product) {
        return this.money >= product.getCost();
    }

    void charge(double cost) {
        this.money -= cost;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.name,
                this.products.size() == 0 ? "%s - Nothing bought\n" :
        this.products.stream().map(Product::getName).collect(Collectors.joining(", ")));
    }
}
