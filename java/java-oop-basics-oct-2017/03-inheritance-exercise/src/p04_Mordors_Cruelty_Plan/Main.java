package p04_Mordors_Cruelty_Plan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] foods = reader.readLine().split("\\s+");

        Hero gandalf = new Hero();
        Arrays.stream(foods).forEach(gandalf::eatFood);
        gandalf.setMood();

        System.out.println(gandalf.getHappinessPoints());
        System.out.println(gandalf.getMood());
    }
}
