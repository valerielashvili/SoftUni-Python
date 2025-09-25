package p1_Paw_Inc;

import p1_Paw_Inc.core.AnimalCenterManager;
import p1_Paw_Inc.engines.Engine;
import p1_Paw_Inc.io.ConsoleInputReader;
import p1_Paw_Inc.io.InputParser;

public class Main {
    public static void main(String[] args) {
        ConsoleInputReader inputReader = new ConsoleInputReader();
        InputParser inputParser = new InputParser();
        AnimalCenterManager animalCenterManager = new AnimalCenterManager();
        Engine engine = new Engine(inputReader, inputParser, animalCenterManager);

        engine.run();
    }
}
