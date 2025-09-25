package p1_Need_for_Speed;

import p1_Need_for_Speed.core.CarManager;
import p1_Need_for_Speed.engines.Engine;
import p1_Need_for_Speed.io.ConsoleInputReader;
import p1_Need_for_Speed.io.ConsoleOutputWriter;
import p1_Need_for_Speed.utilities.InputParser;

public class Main {
    public static void main(String[] args) {
        ConsoleInputReader consoleInputReader = new ConsoleInputReader();
        ConsoleOutputWriter consoleOutputWriter = new ConsoleOutputWriter();
        InputParser inputParser = new InputParser();
        CarManager carManager = new CarManager();
        Engine engine = new Engine(consoleInputReader, consoleOutputWriter, inputParser, carManager);

        engine.run();
    }
}
