package p09_Google;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Person {
    private static final String DEFAULT_COMPANY_NAME = "";
    private static final String DEFAULT_DEPARTMENT_NAME = "";
    private static final double DEFAULT_SALARY = 0.0;

    private String name;
    private String company;
    private String department;
    private double salary;
    private List<Pokemon> pokemonList;
    private List<Parent> parents;
    private List<Child> children;
    private Car car;

    Person(String name) {
        this.name = name;
        this.company = DEFAULT_COMPANY_NAME;
        this.department = DEFAULT_DEPARTMENT_NAME;
        this.salary = DEFAULT_SALARY;
        this.pokemonList = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.car = null;
    }

    String getName() {
        return this.name;
    }

    void setCompany(String company) {
        this.company = company;
    }

    void setDepartment(String department) {
        this.department = department;
    }

    void setSalary(double salary) {
        this.salary = salary;
    }

    void addPokemon(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }

    void addParent(Parent parent) {
        this.parents.add(parent);
    }

    void addChild(Child child) {
        this.children.add(child);
    }

    void setCar(Car car) {
        this.car = car;
    }

    void print() {
        System.out.println(this.name);
        if (!this.company.equals("")) {
            System.out.printf("Company:\n%s %s %.2f\n", this.company, this.department, this.salary);
        } else {
            System.out.println("Company:");
        }
        if(car != null) {
            System.out.printf("Car:\n%s\n", car);
        } else {
            System.out.println("Car:");
        }
        if (pokemonList.size() != 0) {
            System.out.println("Pokemon:");
            System.out.println(this.pokemonList.stream().map(Object::toString).collect(Collectors.joining("\n")));
        } else {
            System.out.println("Pokemon:");
        }
        if (parents.size() != 0) {
            System.out.println("Parents:");
            System.out.println(this.parents.stream().map(Object::toString).collect(Collectors.joining("\n")));
        } else {
            System.out.println("Parents:");
        }
        if (children.size() != 0) {
            System.out.println("Children:");
            System.out.println(this.children.stream().map(Object::toString).collect(Collectors.joining("\n")));
        } else {
            System.out.println("Children:");
        }
    }
}
