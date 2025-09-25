import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p04_JSON_Parse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String delimiters = "name:|age:|grades:|\"|,\\b|(\\[\\{)|(}])|(},\\{)";
        ArrayList<String> inputLine = new ArrayList<>(Arrays.asList(scanner.nextLine().split(delimiters)));

        inputLine = inputLine.stream().filter(e -> !e.isEmpty()).collect(Collectors.toCollection(ArrayList::new));

        ArrayList<Students> studentsData = new ArrayList<>();

        for (int i = 0; i < inputLine.size(); i+=3) {
            String name = inputLine.get(i);
            int age = Integer.parseInt(inputLine.get(i + 1));

            ArrayList<Integer> grades = Arrays.stream(inputLine.get(i + 2)
                    .split("[\\[, \\]]"))
                    .filter(e -> !e.isEmpty())
                    .map(Integer::parseInt)
                    .collect(Collectors.toCollection(ArrayList::new));

            Students student = new Students(name, age, grades);
            studentsData.add(student);
        }

        studentsData.forEach(e -> {
            System.out.printf("%s : ", e.getName());
            System.out.printf("%d -> ", e.getAge());
            if (e.getGrades().isEmpty()) {
                System.out.println("None");
            } else {
                System.out.println(e.getGrades().stream().map(Object::toString).collect(Collectors.joining(", ")));
            }
        });
    }
}

class Students {
    private String name;
    private int age;
    private ArrayList<Integer> grades;

    public Students(String name, int age, ArrayList<Integer> gradesArr) {
        this.name = name;
        this.age = age;
        this.grades = new ArrayList<>(gradesArr);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<Integer> getGrades() {
        return grades;
    }
}
