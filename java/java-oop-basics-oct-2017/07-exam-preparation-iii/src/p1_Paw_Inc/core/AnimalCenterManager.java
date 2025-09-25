package p1_Paw_Inc.core;

import p1_Paw_Inc.entities.animals.Animal;
import p1_Paw_Inc.entities.animals.Cat;
import p1_Paw_Inc.entities.animals.Dog;
import p1_Paw_Inc.entities.centers.AdoptionCenter;
import p1_Paw_Inc.entities.centers.CastrationCenter;
import p1_Paw_Inc.entities.centers.CleansingCenter;
import p1_Paw_Inc.factories.AnimalFactory;
import p1_Paw_Inc.factories.CenterFactory;

import java.util.*;
import java.util.stream.Collectors;

public class AnimalCenterManager {
    private Map<String, CleansingCenter> cleansingCenters;
    private Map<String, AdoptionCenter> adoptionCenters;
    private Map<String, CastrationCenter> castrationCenters;
    private List<Animal> cleansedAnimals;
    private List<Animal> castratedAnimals;
    private List<Animal> adoptedAnimals;

    public AnimalCenterManager() {
        this.cleansingCenters = new HashMap<>();
        this.adoptionCenters = new HashMap<>();
        this.castrationCenters = new HashMap<>();
        this.cleansedAnimals = new ArrayList<>();
        this.castratedAnimals = new ArrayList<>();
        this.adoptedAnimals = new ArrayList<>();
    }

    public void registerCleansingCenter(String name) {
        CleansingCenter cleansingCenter = CenterFactory.createCleansingCenter(name);
        this.cleansingCenters.putIfAbsent(name, cleansingCenter);
    }

    public void registerAdoptionCenter(String name) {
        AdoptionCenter adoptionCenter = CenterFactory.createAdoptionCenter(name);
        this.adoptionCenters.putIfAbsent(name, adoptionCenter);
    }

    public void registerCastrationCenter(String name) {
        CastrationCenter castrationCenter = CenterFactory.createCastrationCenter(name);
        this.castrationCenters.putIfAbsent(name, castrationCenter);
    }

    public void registerDog(String name, int age, int learnedCommands, String adoptionCenterName) {
        Dog dog = AnimalFactory.createDog(name, age, learnedCommands);
        dog.setAdoptionCenterName(adoptionCenterName);
        this.adoptionCenters.get(adoptionCenterName).register(dog);
    }

    public void registerCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName) {
        Cat cat = AnimalFactory.createCat(name, age, intelligenceCoefficient);
        cat.setAdoptionCenterName(adoptionCenterName);
        this.adoptionCenters.get(adoptionCenterName).register(cat);
    }

    public void sendForCleansing(String adoptionCenterName, String cleansingCenterName) {
        CleansingCenter cleansingCenter = this.cleansingCenters.get(cleansingCenterName);
        List<Animal> uncleansed = this.adoptionCenters.get(adoptionCenterName).sendForCleansing();
        cleansingCenter.registerUncleansedAnimals(uncleansed);
    }

    public void sendForCastration(String adoptionCenterName, String castrationCenterName ) {
        CastrationCenter castrationCenter = this.castrationCenters.get(castrationCenterName);
        List<Animal> readyForCastrationAnimals = this.adoptionCenters.get(adoptionCenterName).sendForCastration();
        castrationCenter.registerAnimalsReadyForCastration(readyForCastrationAnimals);
    }

    public void cleanse(String cleansingCenterName) {
        List<Animal> cleansed = this.cleansingCenters.get(cleansingCenterName).cleanse();
        cleansed.forEach(animal -> this.adoptionCenters.get(animal.getAdoptionCenterName()).receiveAnimals(animal));
        this.cleansedAnimals.addAll(cleansed);
    }

    public void castrate(String castrationCenterName) {
        List<Animal> castrated = this.castrationCenters.get(castrationCenterName).castrate();
        castrated.forEach(animal -> this.adoptionCenters.get(animal.getAdoptionCenterName()).receiveAnimals(animal));
        this.castratedAnimals.addAll(castrated);
    }

    public void adopt(String adoptionCenterName) {
        List<Animal> adopted = this.adoptionCenters.get(adoptionCenterName).adopt();
        this.adoptedAnimals.addAll(adopted);
    }

    public void printStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Paw Inc. Regular Castration Statistics")
                .append(System.lineSeparator())
                .append(String.format("Castration Centers: %d", this.castrationCenters.size()))
                .append(System.lineSeparator())
                .append(String.format("Castrated Animals: %s", sortedCastratedAnimals(this.castratedAnimals)))
                .append(System.lineSeparator())
                .append("Paw Incorporative Regular Statistics")
                .append(System.lineSeparator())
                .append(String.format("Adoption Centers: %d", this.adoptionCenters.size()))
                .append(System.lineSeparator())
                .append(String.format("Cleansing Centers: %d", this.cleansingCenters.size()))
                .append(System.lineSeparator())
                .append(String.format("Adopted Animals: %s", sortedAdoptedAnimals(this.adoptedAnimals)))
                .append(System.lineSeparator())
                .append(String.format("Cleansed Animals: %s", sortedCleansedAnimals(this.cleansedAnimals)))
                .append(System.lineSeparator())
                .append(String.format("Animals Awaiting Adoption: %s", amountOfAnimalsWaitingForAdoption(this.adoptionCenters)))
                .append(System.lineSeparator())
                .append(String.format("Animals Awaiting Cleansing: %s", amountOfAnimalsWaitingForCleansing(this.cleansingCenters)));

        System.out.println(sb);
    }

    private long amountOfAnimalsWaitingForCleansing(Map<String, CleansingCenter> cleansingCenters) {
        return cleansingCenters.values().stream().mapToInt(CleansingCenter::getCleansedAnimalsCount).sum();
    }

    private long amountOfAnimalsWaitingForAdoption(Map<String, AdoptionCenter> adoptionCenters) {
        return adoptionCenters.values().stream().mapToLong(AdoptionCenter::getAdoptedAnimalsCount).sum();
    }

    private String sortedCleansedAnimals(List<Animal> cleansedAnimals) {
        if (cleansedAnimals.size() > 0) {
            return cleansedAnimals.stream()
                    .sorted(Comparator.comparing(Animal::getName))
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));
        } else {
            return "None";
        }
    }

    private String sortedCastratedAnimals(List<Animal> castratedAnimals) {
        if (castratedAnimals.size() > 0) {
            return castratedAnimals.stream()
                    .sorted(Comparator.comparing(Animal::getName))
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));
        } else {
            return "None";
        }
    }

    private String sortedAdoptedAnimals(List<Animal> adoptedAnimals) {
        if (adoptedAnimals.size() > 0) {
            return adoptedAnimals.stream()
                    .sorted(Comparator.comparing(Animal::getName))
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));
        } else {
            return "None";
        }
    }

}
