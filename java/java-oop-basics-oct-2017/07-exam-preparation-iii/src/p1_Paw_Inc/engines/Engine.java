package p1_Paw_Inc.engines;

import p1_Paw_Inc.core.AnimalCenterManager;
import p1_Paw_Inc.io.ConsoleInputReader;
import p1_Paw_Inc.io.InputParser;

import java.util.List;

public class Engine {
    private ConsoleInputReader inputReader;
    private InputParser inputParser;
    private AnimalCenterManager animalCenterManager;

    public Engine(ConsoleInputReader inputReader, InputParser inputParser, AnimalCenterManager animalCenterManager) {
        this.inputReader = inputReader;
        this.inputParser = inputParser;
        this.animalCenterManager = animalCenterManager;
    }

    public void run() {
        String inputLine = this.inputReader.readLine();

        while (!"Paw Paw Pawah".equals(inputLine)) {
            List<String> tokens = this.inputParser.parseInput(inputLine);

            this.dispatchCommand(tokens);

            inputLine = this.inputReader.readLine();
        }

        this.animalCenterManager.printStatistics();
    }

    private void dispatchCommand(List<String> tokens) {
        String command = tokens.remove(0);

        if ("RegisterCleansingCenter".equals(command)) {
            this.animalCenterManager.registerCleansingCenter(tokens.get(0));
        } else if ("RegisterAdoptionCenter".equals(command)) {
            this.animalCenterManager.registerAdoptionCenter(tokens.get(0));
        } else if ("RegisterCastrationCenter".equals(command)) {
            this.animalCenterManager.registerCastrationCenter(tokens.get(0));
        } else if ("RegisterDog".equals(command)) {
            this.animalCenterManager.registerDog(tokens.get(0), Integer.parseInt(tokens.get(1)), Integer.parseInt(tokens.get(2)),
                    tokens.get(3));
        } else if ("RegisterCat".equals(command)) {
            this.animalCenterManager.registerCat(tokens.get(0), Integer.parseInt(tokens.get(1)), Integer.parseInt(tokens.get(2)),
                    tokens.get(3));
        } else if ("SendForCleansing".equals(command)) {
            this.animalCenterManager.sendForCleansing(tokens.get(0), tokens.get(1));
        }  else if ("SendForCastration".equals(command)) {
            this.animalCenterManager.sendForCastration(tokens.get(0), tokens.get(1));
        } else if ("Cleanse".equals(command)) {
            this.animalCenterManager.cleanse(tokens.get(0));
        }  else if ("Castrate".equals(command)) {
            this.animalCenterManager.castrate(tokens.get(0));
        } else if ("Adopt".equals(command)) {
            this.animalCenterManager.adopt(tokens.get(0));
        }
    }
}
