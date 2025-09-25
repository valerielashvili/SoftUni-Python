import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p03_JSON_Stringify {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        ArrayList<Student> studentsData = new ArrayList<>();

        while (!"stringify".equals(inputLine)) {
            ArrayList<String> tokens = new ArrayList<>(Arrays.asList(inputLine.split("[ :\\->,]")));
            tokens = tokens.stream().filter(e -> !e.isEmpty()).collect(Collectors.toCollection(ArrayList::new));

            int parsedAge = Integer.parseInt(tokens.get(1));

            Integer[] parsedGrades = tokens
                    .stream()
                    .skip(2)
                    .map(Object::toString)
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);

            Student student = new Student(tokens.get(0), parsedAge, parsedGrades);
            studentsData.add(student);

            inputLine = scanner.nextLine();
        }

        String result = "";

        for (Student st : studentsData) {
            result += (String.format("{name:\"%s\",age:%d,grades:%s},", st.getName(), st.getAge(), st.getGrades()));
        }
        result = result.substring(0, result.length() - 1);

        System.out.printf("[%s]", result);
    }
}

class Student {
    private String name;
    private int age;
    private ArrayList<Integer> grades;

    public Student(String name, int age, Integer[] gradesArr) {
        this.name = name;
        this.age = age;
        this.grades = new ArrayList<>(Arrays.asList(gradesArr));
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
