package p1_Need_for_Speed.engines;

import p1_Need_for_Speed.core.CarManager;
import p1_Need_for_Speed.io.ConsoleInputReader;
import p1_Need_for_Speed.io.ConsoleOutputWriter;
import p1_Need_for_Speed.utilities.InputParser;

import java.util.List;

import static p1_Need_for_Speed.utilities.Constants.INPUT_TERMINATING_COMMAND;

public class Engine {
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;
    private CarManager carManager;

    public Engine(ConsoleInputReader inputReader, ConsoleOutputWriter outputWriter, InputParser inputParser, CarManager carManager) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.inputParser = inputParser;
        this.carManager = carManager;
    }

    public void run() {
        String inputLine = this.inputReader.readLine();

        while (!inputLine.equals(INPUT_TERMINATING_COMMAND)) {
            List<String> commandParams = this.inputParser.parseInput(inputLine);

            String result = this.dispatchCommand(commandParams);
            if (result != null) {
                this.outputWriter.writeLine(result);
            }

            inputLine = this.inputReader.readLine();
        }
    }

    private String dispatchCommand(List<String> commandParams) {
        String command = commandParams.remove(0);

        if ("register".equals(command)) {
            this.carManager.register(Integer.parseInt(commandParams.get(0)), commandParams.get(1), commandParams.get(2),
                    commandParams.get(3), Integer.parseInt(commandParams.get(4)), Integer.parseInt(commandParams.get(5)),
                    Integer.parseInt(commandParams.get(6)), Integer.parseInt(commandParams.get(7)),
                    Integer.parseInt(commandParams.get(8)));
            return null;
        } else if ("check".equals(command)) {
            return this.carManager.check(Integer.parseInt(commandParams.get(0)));
        } else if ("open".equals(command)) {
            if (commandParams.size() == 5) {
                this.carManager.open(Integer.parseInt(commandParams.get(0)), commandParams.get(1),
                        Integer.parseInt(commandParams.get(2)), commandParams.get(3), Integer.parseInt(commandParams.get(4)));
            } else if (commandParams.size() == 6) {
                this.carManager.open(Integer.parseInt(commandParams.get(0)), commandParams.get(1),
                        Integer.parseInt(commandParams.get(2)), commandParams.get(3),
                        Integer.parseInt(commandParams.get(4)), Integer.parseInt(commandParams.get(5)));
            }
            return null;
        } else if ("participate".equals(command)) {
            this.carManager.participate(Integer.parseInt(commandParams.get(0)), Integer.parseInt(commandParams.get(1)));
            return null;
        } else if ("start".equals(command)) {
            return this.carManager.start(Integer.parseInt(commandParams.get(0)));
        } else if ("park".equals(command)) {
            this.carManager.park(Integer.parseInt(commandParams.get(0)));
            return null;
        } else if ("unpark".equals(command)) {
            this.carManager.unpark(Integer.parseInt(commandParams.get(0)));
            return null;
        } else if ("tune".equals(command)) {
            this.carManager.tune(Integer.parseInt(commandParams.get(0)), commandParams.get(1));
            return null;
        }
        return null;
    }
}
